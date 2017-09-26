/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2_part1;

import java.io.IOException;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;


public class Assignment2_Part1 {

public static class TokenizerMapper
       extends Mapper<Object, Text, Text, FloatWritable>{

    
    private Text stock = new Text();
    private String stock_name;
    private float stock_price_high;
    
    public void map(Object key, Text value, Context context
                    ) throws IOException, InterruptedException {
      stock_name= value.toString().split(",")[1];
      try{
      stock_price_high = Float.parseFloat(value.toString().split(",")[4]);
      stock.set(stock_name);
      context.write(stock, new FloatWritable(stock_price_high));
      }
      
      catch(NumberFormatException e)
      {
          
          
      }
        
      
    }
  }

  public static class FloatSumReducer
       extends Reducer<Text,FloatWritable,Text,FloatWritable> {
   private FloatWritable result = new FloatWritable();


    public void reduce(Text key, Iterable<FloatWritable> values,
                       Context context
                       ) throws IOException, InterruptedException {
      float sum =(float) 0.0;
      int counter=0;
        float average= (float) 0.0;
      for (FloatWritable val : values) {
        sum += val.get();
        counter++;
      }
      
      average= sum/counter;
      result.set(average);
     context.write(key, result);
    }
  }

  public static void main(String[] args) throws Exception {
    Configuration conf = new Configuration();
    Job job = Job.getInstance(conf, "word count");
    job.setJarByClass(Assignment2_Part1.class);
    job.setMapperClass(TokenizerMapper.class);
    job.setCombinerClass(FloatSumReducer.class);
    job.setReducerClass(FloatSumReducer.class);
    job.setOutputKeyClass(Text.class);
    job.setOutputValueClass(FloatWritable.class);
    FileInputFormat.addInputPath(job, new Path(args[0]));
    FileOutputFormat.setOutputPath(job, new Path(args[1]));
    System.exit(job.waitForCompletion(true) ? 0 : 1);
  }
}
