/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project5;

import java.io.IOException;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

/**
 *
 * @author mugdha
 */
public class Project5 {

    /**
     * @param args the command line arguments
     */
    private static final String INPUT_PATH = "/mugdha/listings";
    private static final String OUTPUT_PATH = "/mugdha/output5";
    public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException {
       
        Configuration conf = new Configuration();
      
        Job job = Job.getInstance(conf, "word count");
        job.setJarByClass(Project5.class);
        job.setMapperClass(LastReviewMapper.class);
       
        LastReviewPartitioner.setMinLastAccessDateYear(job, 2010);        
        job.setNumReduceTasks(7);
        job.setOutputKeyClass(IntWritable.class);
        job.setOutputValueClass(IntWritable.class);
        FileInputFormat.addInputPath(job, new Path(INPUT_PATH));
        FileOutputFormat.setOutputPath(job, new Path(OUTPUT_PATH));
        job.waitForCompletion(true);
        
    }
    
}
