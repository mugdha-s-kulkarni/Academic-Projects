/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project1;

import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

/**
 *
 * @author mugdha
 */
public class ReviewsCountMapper extends Mapper<Object, Text, LongWritable, IntWritable> {  
    
    private long listingId;
     
    protected void map(Object key, Text value, Context context) throws IOException, InterruptedException {
     
        String txt = value.toString().split(",")[0];
        
        listingId = Long.parseLong(txt);
      
        context.write(new LongWritable(listingId),new IntWritable(1));
    }
    
}
