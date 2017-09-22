/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project7;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
import project7.Mapper1.TokenizerMapper1;
import project7.Mapper2.TokenizerMapper2;
import project7.Reducer1.FloatSumReducer1;
import project7.Reducer2.FloatSumReducer2;

/**
 *
 * @author mugdha
 */
public class Project7 {

    /**
     * @param args the command line arguments
     */
    private static final String input = "/mugdha/listings";
    private static final String middle = "/mugdha/output_middle";
    private static final String output = "/mugdha/output7";

    public static void main(String[] args) throws Exception {
        Configuration conf = new Configuration();
        FileSystem fs = FileSystem.get(conf);
        Job job = new Job(conf, "Job1");
        job.setJarByClass(Project7.class);

        job.setMapperClass(TokenizerMapper1.class);
        job.setReducerClass(FloatSumReducer1.class);

        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(FloatWritable.class);

        job.setInputFormatClass(TextInputFormat.class);
        job.setOutputFormatClass(TextOutputFormat.class);

        TextInputFormat.addInputPath(job, new Path(input));
        TextOutputFormat.setOutputPath(job, new Path(middle));

        job.waitForCompletion(true);

        /*
         * Job 2
         */
        Job job2 = new Job(conf, "Job 2");
        job2.setJarByClass(Project7.class);

        job2.setMapperClass(TokenizerMapper2.class);
        job2.setReducerClass(FloatSumReducer2.class);

        job2.setOutputKeyClass(FloatWritable.class);
        job2.setOutputValueClass(Text.class);

        job2.setInputFormatClass(TextInputFormat.class);
        job2.setOutputFormatClass(TextOutputFormat.class);

        TextInputFormat.addInputPath(job2, new Path(middle));
        TextOutputFormat.setOutputPath(job2, new Path(output));

        job2.waitForCompletion(true);

    }

}
