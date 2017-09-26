/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assgnmt3_part4_kv;

import java.io.IOException;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.KeyValueTextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

/**
 *
 * @author shreyaj007
 */
public class Assgnmt3_Part4_KV {

    
    
       public static class TokenizerMapper
       extends Mapper<Object, Text, Text, Text>{

    private final static Text one = new Text();
    private Text word = new Text();
    private Text value;
    private Text key1;
    public void map(Text key, Text value, Context context
                    ) throws IOException, InterruptedException {
        key1 = (Text)key;
        
     // StringTokenizer itr = new StringTokenizer(value.toString());
      //while (itr.hasMoreTokens()) {
   // word.set(wordCount);
        //word.set(itr.nextToken());
        
        System.out.println("key "+key);
        System.out.println("value "+value);
        context.write(key, value);
    //}
    }
  }
    
    
     public static class WordCountReducer
       extends Reducer<Text,Text,Text,Text> {
    private Text result = new Text();

    public void reduce(Text key, Iterable<Text> values,
                       Context context
                       ) throws IOException, InterruptedException {
      int sum = 0;
      for (Text val : values) {
        sum +=1;
      }
      result.set(String.valueOf(sum));
      context.write(key, result);
    }
  }
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException {
        // TODO code application logic here
        
          Configuration conf=new Configuration();
          conf.set("mapreduce.input.keyvaluelinerecordreader.key.value.separator", "\t");
  Job job=new Job(conf,"kv");
  job.setJarByClass(Assgnmt3_Part4_KV.class);
  job.setMapperClass(TokenizerMapper.class);
  job.setReducerClass(WordCountReducer.class);
  job.setInputFormatClass(KeyValueTextInputFormat.class);
  job.setMapOutputKeyClass(Text.class);
  job.setMapOutputValueClass(Text.class);
 // Path outputPath=new Path(output);
  KeyValueTextInputFormat.addInputPath(job,new Path(args[0]));
  FileOutputFormat.setOutputPath(job,new Path(args[1]));
  //outputPath.getFileSystem(conf).delete(outputPath,true);
  job.waitForCompletion(true);
        
    }
    
}
