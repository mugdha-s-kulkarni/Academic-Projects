package assgnmt3_part2;


import assgnmt3_part2.Mapper1.TokenizerMapper1;
import assgnmt3_part2.Mapper2.TokenizerMapper2;
import assgnmt3_part2.Reducer1.FloatSumReducer1;
import assgnmt3_part2.Reducer2.FloatSumReducer2;
import java.io.IOException;
import java.util.*;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

public class Assgnmt3_Part2 {

    /*
    public static class TokenizerMapper
       extends Mapper<Object, Text, FloatWritable, Text>{

    static  TreeMap<Float,Text> countMap = new TreeMap<Float,Text>();
    private String movieId;
    private float rating;
    private Text one = new Text();
    
    public void map(Object key, Text value, Context context
                    ) throws IOException, InterruptedException {
      
        
      
      movieId = value.toString().split("/t")[0];
       String sanitizedString = value.toString().replaceAll("\\s", ","); 
      rating = Float.parseFloat(sanitizedString.split("/t")[1]);
      countMap.put(rating, value);
      if(countMap.size()> 25){
          countMap.remove(countMap.firstKey());
      }
     // context.write(new Text(movieId), new FloatWritable(rating));
    }
    
    @Override
    protected void cleanup(Context context) throws IOException, InterruptedException{
        for(Text val: countMap.values()){
            FloatWritable var = new FloatWritable();
            float var1 =1;
            var.set(var1);
            
            
            context.write(var,val);
        }
    }
  }

  public static class FloatSumReducer
       extends Reducer<FloatWritable,Text,FloatWritable,Text> {
     
    public void reduce(NullWritable key, Iterable<Text> values,
                       Context context
                       ) throws IOException, InterruptedException {
      TreeMap<Float,Text> countMap = new TreeMap<Float, Text>();
      for(Text value : values){
          String movieId = value.toString().split("::")[1];
          Float rating = Float.parseFloat(value.toString().split("::")[2]);
          countMap.put(rating, value);
          if(countMap.size()> 25){
          countMap.remove(countMap.firstKey());
          }
      }
      
      for(Text t : countMap.descendingMap().values()){
          String movieId = t.toString().split("::")[1];
          Float rating = Float.parseFloat(t.toString().split("::")[2]);
          context.write(new FloatWritable(rating),new Text(movieId));
         //context.write(NullWritable.get(),t);
      }
    }

   
  }*/
  
    
       private static final String OUTPUT_PATH = "/pooja/Output_Average";

    public int run(String[] args) throws Exception {
        /*
   * Job 1
         */
        Configuration conf = new Configuration();
        FileSystem fs = FileSystem.get(conf);
        Job job = new Job(conf, "Job1");
        job.setJarByClass(Assgnmt3_Part2.class);

        job.setMapperClass(TokenizerMapper1.class);
        job.setReducerClass(FloatSumReducer1.class);

        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(FloatWritable.class);

        job.setInputFormatClass(TextInputFormat.class);
        job.setOutputFormatClass(TextOutputFormat.class);

        TextInputFormat.addInputPath(job, new Path(args[0]));
        TextOutputFormat.setOutputPath(job, new Path(OUTPUT_PATH));

        job.waitForCompletion(true);

        /*
   * Job 2
         */
        Job job2 = new Job(conf, "Job 2");
        job2.setJarByClass(Assgnmt3_Part2.class);

        job2.setMapperClass(TokenizerMapper2.class);
        job2.setReducerClass(FloatSumReducer2.class);

        job2.setOutputKeyClass(FloatWritable.class);
        job2.setOutputValueClass(Text.class);

        job2.setInputFormatClass(TextInputFormat.class);
        job2.setOutputFormatClass(TextOutputFormat.class);

        TextInputFormat.addInputPath(job2, new Path(OUTPUT_PATH));
        TextOutputFormat.setOutputPath(job2, new Path(args[1]));

        return job2.waitForCompletion(true) ? 0 : 1;
    }
      
    
    
    
    
    
    
  public static void main(String[] args) throws Exception {
   /* Configuration conf = new Configuration();
    Job job = Job.getInstance(conf, "word count");
    job.setJarByClass(Assgnmt3_Part2.class);
    
    
    
    job.setMapperClass(TokenizerMapper2.class);
    job.setReducerClass(FloatSumReducer2.class);
    job.setOutputKeyClass(FloatWritable.class);
    job.setOutputValueClass(Text.class);
    FileInputFormat.addInputPath(job,new Path(args[0]));
    FileOutputFormat.setOutputPath(job, new Path(args[1]));
    System.exit(job.waitForCompletion(true) ? 0 : 1);
    */
      
     
      
      
         if (args.length != 2) {
            System.err.println("Enter valid number of arguments <Inputdirectory>  <Outputlocation>");
            System.exit(0);
        }
        ToolRunner.run(new Configuration(), (Tool) new Assgnmt3_Part2(), args);
      
  }
  
}
