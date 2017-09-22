/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assgnmt3_part4_nline;

import java.io.IOException;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.NLineInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;


/**
 *
 * @author shreyaj007
 */
public class Assgnmt3_Part4_Nline {

        public static class NLineMapper extends Mapper<LongWritable, Text, Text, Text>{
        @Override
        public void map(LongWritable key, Text value,Context context) throws IOException, InterruptedException{
            String a = value.toString();
            String[] b = a.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
            
            if (!(b[0].equals("Name")))
                context.write(new Text(b[0]), new Text(b[2]));
        }
    }

    public static class NLineReducer extends Reducer<Text, Text, Text, Text>{
        @Override
        public void reduce(Text key, Iterable<Text> value, Context context) throws IOException, InterruptedException{
            for (Text values : value){
                context.write(key, values);
            }
        }
    }
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException {
        // TODO code application logic here
        
         Configuration conf = new Configuration();
        conf.setInt(NLineInputFormat.LINES_PER_MAP, 10);
        
        Job job = new Job(conf,"NLine Input Format");
        job.setJarByClass(Assgnmt3_Part4_Nline.class);

        job.setMapperClass(NLineMapper.class);
        job.setReducerClass(NLineReducer.class);
        job.setInputFormatClass(NLineInputFormat.class);
        
        FileInputFormat.addInputPath(job, new Path(args[0]));
        FileOutputFormat.setOutputPath(job, new Path(args[1]));
        
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(Text.class);
        
        job.waitForCompletion(true);
        
        
    }
    
}
