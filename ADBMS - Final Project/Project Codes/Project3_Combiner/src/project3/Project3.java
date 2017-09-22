/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project3;

import java.io.IOException;
import java.sql.Timestamp;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

/**
 *
 * @author mugdha
 */
public class Project3 {

    /**
     * @param args the command line arguments
     */
    private static final String input = "/mugdha/listings";
    private static final String output= "/mugdha/output3_combiner";
    
    public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException {
        // TODO code application logic here
        
//        Timestamp timestamp1 = new Timestamp(System.currentTimeMillis());
//        System.out.println("Start time: "+timestamp1);
        Configuration conf = new Configuration();
        Job job = Job.getInstance(conf, "word count");
        job.setJarByClass(Project3.class);
        job.setMapperClass(NeighbourhoodRentMapper.class);
        job.setCombinerClass(NeighbourhoodRentCombiner.class);
        job.setReducerClass(NeighbourhoodRentReducer.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(MinMaxTuple.class);
        FileInputFormat.addInputPath(job, new Path(input));
        FileOutputFormat.setOutputPath(job, new Path(output));
        
        
        System.exit(job.waitForCompletion(true) ? 0 : 1);
    }

}
