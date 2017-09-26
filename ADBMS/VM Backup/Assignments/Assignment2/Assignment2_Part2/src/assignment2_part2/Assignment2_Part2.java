/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2_part2;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.*;
import java.util.Map.Entry;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

/**
 *
 * @author shruti
 */
public class Assignment2_Part2 {

  static  Map<Text,Float> countMap = new HashMap<Text,Float>();
    public static class TokenizerMapper
       extends Mapper<Object, Text, Text, FloatWritable>{

    private String movieId;
    private float rating;

    public void map(Object key, Text value, Context context
                    ) throws IOException, InterruptedException {
      
      movieId = value.toString().split("::")[1];
      rating = Float.parseFloat(value.toString().split("::")[2]);
      context.write(new Text(movieId), new FloatWritable(rating));
    }
  }

  public static class FloatSumReducer
       extends Reducer<Text,FloatWritable,Text,FloatWritable> {
     private FloatWritable result = new FloatWritable();
    public void reduce(Text key, Iterable<FloatWritable> values,
                       Context context
                       ) throws IOException, InterruptedException {
      float sum = (float) 0.0;
      int counter =0;
      for (FloatWritable val : values) {
        sum += val.get();
        counter++;
      }
      float avgRate = sum/counter;
      result.set(avgRate);
      countMap.put(key, avgRate);
      context.write(key,result);
    }

  
  }
  
  public static void main(String[] args) throws Exception {
    Configuration conf = new Configuration();
    Job job = Job.getInstance(conf, "word count");
    job.setJarByClass(Assignment2_Part2.class);
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
    

