/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project5;

import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

/**
 *
 * @author mugdha
 */
public class LastReviewMapper extends Mapper<Object, Text, IntWritable, IntWritable> {

    
    IntWritable outKey = new IntWritable();

    protected void map(Object key, Text value, Context context) throws IOException, InterruptedException {

        int id = Integer.parseInt(value.toString().split(",")[0]);
        String lastReview = value.toString().split(",")[21];
       
        if (lastReview.equals("0")) {
           
        }
        else{
            String y = lastReview.split("/")[2];
          
            int year = Integer.parseInt(y);

            context.write(new IntWritable(year), new IntWritable(id));
        }
    }
}
