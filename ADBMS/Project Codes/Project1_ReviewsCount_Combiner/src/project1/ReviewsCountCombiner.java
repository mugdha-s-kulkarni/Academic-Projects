/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project1;

import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.mapreduce.Reducer;

/**
 *
 * @author mugdha
 */
public class ReviewsCountCombiner extends Reducer<LongWritable,IntWritable,LongWritable,IntWritable> {

    private IntWritable result = new IntWritable();
    
    protected void reduce(LongWritable key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
        int counter =0;
      for (IntWritable val : values) {
       
        counter++;
      }
      result.set(counter);
      context.write(key,result);
    }
  
    
}
