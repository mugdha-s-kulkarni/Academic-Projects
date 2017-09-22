/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mfif;

import java.io.BufferedReader;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.mapred.FileInputFormat;
import org.apache.hadoop.mapred.FileOutputFormat;
import org.apache.hadoop.mapred.InputSplit;
import org.apache.hadoop.mapred.JobClient;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.MultiFileInputFormat;
import org.apache.hadoop.mapred.MultiFileSplit;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.RecordReader;
import org.apache.hadoop.mapred.Reporter;
import org.apache.hadoop.mapred.lib.LongSumReducer;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

public class MFIF extends Configured implements Tool {

   public static class WordOffset implements WritableComparable {

    private long offset;
    private String fileName;

    public void readFields(DataInput in) throws IOException {
      this.offset = in.readLong();
      this.fileName = Text.readString(in);
    }

    public void write(DataOutput out) throws IOException {
      out.writeLong(offset);
      Text.writeString(out, fileName);
    }

    public int compareTo(Object o) {
      WordOffset that = (WordOffset)o;

      int f = this.fileName.compareTo(that.fileName);
      if(f == 0) {
        return (int)Math.signum((double)(this.offset - that.offset));
      }
      return f;
    }
    @Override
    public boolean equals(Object obj) {
      if(obj instanceof WordOffset)
        return this.compareTo(obj) == 0;
      return false;
    }
    @Override
    public int hashCode() {
      assert false : "hashCode not designed";
      return 42; //an arbitrary constant
    }
  }



  public static class MyInputFormat
    extends MultiFileInputFormat<WordOffset, Text>  {

    @Override
    public RecordReader<WordOffset,Text> getRecordReader(InputSplit split
        , JobConf job, Reporter reporter) throws IOException {
      return new MultiFileLineRecordReader(job, (MultiFileSplit)split);
    }
  }

 
  public static class MultiFileLineRecordReader
    implements RecordReader<WordOffset, Text> {

    private MultiFileSplit split;
    private long offset; //total offset read so far;
    private long totLength;
    private FileSystem fs;
    private int count = 0;
    private Path[] paths;
   
    private FSDataInputStream currentStream;
    private BufferedReader currentReader;
   
    public MultiFileLineRecordReader(Configuration conf, MultiFileSplit split)
      throws IOException {
     
      this.split = split;
      fs = FileSystem.get(conf);
      this.paths = split.getPaths();
      this.totLength = split.getLength();
      this.offset = 0;
  
      Path file = paths[count];
      currentStream = fs.open(file);
      currentReader = new BufferedReader(new InputStreamReader(currentStream));
    }

    public void close() throws IOException { }

    public long getPos() throws IOException {
      long currentOffset = currentStream == null ? 0 : currentStream.getPos();
      return offset + currentOffset;
    }

    public float getProgress() throws IOException {
      return ((float)getPos()) / totLength;
    }

    public boolean next(WordOffset key, Text value) throws IOException {
      if(count >= split.getNumPaths())
        return false;

  
      String line;
      do {
        line = currentReader.readLine();
        if(line == null) {
         
          currentReader.close();
          offset += split.getLength(count);
         
          if(++count >= split.getNumPaths())
            return false;
         
          Path file = paths[count];
          currentStream = fs.open(file);
          currentReader=new BufferedReader(new InputStreamReader(currentStream));
          key.fileName = file.getName();
        }
      } while(line == null);
    
      key.offset = currentStream.getPos();
      value.set(line);
     
      return true;
    }

    public WordOffset createKey() {
      WordOffset wo = new WordOffset();
      wo.fileName = paths[0].toString();
      return wo;
    }

    public Text createValue() {
      return new Text();
    }
  }

 
  public static class MapClass extends MapReduceBase
    implements Mapper<WordOffset, Text, Text, LongWritable> {

    private final static LongWritable one = new LongWritable(1);
    private Text word = new Text();
   
    public void map(WordOffset key, Text value,
        OutputCollector<Text, LongWritable> output, Reporter reporter)
        throws IOException {
     
      String line = value.toString();
      StringTokenizer itr = new StringTokenizer(line);
      while (itr.hasMoreTokens()) {
        word.set(itr.nextToken());
        output.collect(word, one);
      }
    }
  }
 
 
  private void printUsage() {
    System.out.println("Usage : multifilewc <input_dir> <output>" );
  }

  public int run(String[] args) throws Exception {

    if(args.length < 2) {
      printUsage();
      return 1;
    }

   
    Configuration conf = new Configuration();
    JobConf job = new JobConf(conf, MFIF.class);
   
    job.setJarByClass(MFIF.class);
    job.setJobName("MultiFileWordCount");

    job.setInputFormat(MyInputFormat.class);
   
  
    job.setOutputKeyClass(Text.class);
  
    job.setOutputValueClass(LongWritable.class);
    job.setMapperClass(MapClass.class);
  
    job.setCombinerClass(LongSumReducer.class);
    job.setReducerClass(LongSumReducer.class);

    FileInputFormat.addInputPaths(job, args[0]);
    FileOutputFormat.setOutputPath(job, new Path(args[1]));

    JobClient.runJob(job);
   
    return 0;
  }

  public static void main(String[] args) throws Exception {
    int ret = ToolRunner.run(new MFIF(), args);
    System.exit(ret);
  }
   
}