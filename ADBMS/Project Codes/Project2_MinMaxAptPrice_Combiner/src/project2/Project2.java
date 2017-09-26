/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project2;

import java.io.IOException;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

/**
 *
 * @author mugdha
 */
public class Project2 {

    /**
     * @param args the command line arguments
     */
    private static final String input = "/mugdha/calendar";
    private static final String output= "/mugdha/output2";
    
    public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException {
        // TODO code application logic here
    Configuration conf = new Configuration();
    Job job = Job.getInstance(conf, "word count");
    job.setJarByClass(Project2.class);
    job.setMapperClass(MinMaxPriceMapper.class);
    job.setReducerClass(MinMaxPriceReducer.class);
    job.setOutputKeyClass(Text.class);
    job.setOutputValueClass(MinMaxAptPrice.class);
    FileInputFormat.addInputPath(job, new Path(input));
    FileOutputFormat.setOutputPath(job, new Path(output));
    System.exit(job.waitForCompletion(true) ? 0 : 1);
    }
    
}
