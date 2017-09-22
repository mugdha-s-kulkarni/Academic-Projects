/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assgnmt3_part4_seqff;

import java.io.IOException;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.SequenceFileOutputFormat;

/**
 *
 * @author shreyaj007
 */
public class Assgnmt3_Part4_SeqFF {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException {
        // TODO code application logic here
        
            Configuration conf = new Configuration() {};
    Job job = new Job(conf);
    job.setJobName("Convert Text");
    job.setJarByClass(Mapper.class);

    job.setMapperClass(Mapper.class);
    job.setReducerClass(Reducer.class);

    // increase if you need sorting or a special number of files
    job.setNumReduceTasks(0);

    job.setOutputKeyClass(LongWritable.class);
    job.setOutputValueClass(Text.class);

    job.setOutputFormatClass(SequenceFileOutputFormat.class);
    job.setInputFormatClass(TextInputFormat.class);

    TextInputFormat.addInputPath(job, new Path(args[0]));
    SequenceFileOutputFormat.setOutputPath(job, new Path(args[1]));

        
        // submit and wait for completion
    job.waitForCompletion(true);
        
        
        
    }
    
}
