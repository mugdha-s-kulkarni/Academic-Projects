/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assgnmt3_part1;

import java.io.IOException;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

/**
 *
 * @author shreyaj007
 */
public class Assgnmt3_Part1 {

    /**
     * @param args the command line arguments
     */
    
    
    
    public static void main(String[] args) throws Exception{
        
             long startTime = System.currentTimeMillis();
        
        Configuration conf = new Configuration();
        FileSystem hdfs = FileSystem.get(conf);
        FileSystem local = FileSystem.getLocal(conf);
        
        Path inputDir = new Path(args[0]);
        Path outputDir = new Path(args[1]);
        
        try{
            
            FileStatus[] inputFiles = local.listStatus(inputDir);
            FSDataOutputStream out = hdfs.create(outputDir);
            
            for (int i=0; i<inputFiles.length; i++)
            {
                System.out.println(inputFiles[i].getPath().getName());
                FSDataInputStream in = local.open(inputFiles[i].getPath());
                byte buffer[] = new byte[256];
                int bytesRead =0;
                while((bytesRead = in.read(buffer))>0)
                {
                    out.write(buffer,0, bytesRead);
                }  
                
                
            }
            out.close();
            
        }
        catch(IOException e)

        {
            e.printStackTrace();
        }
                
        
        
        
       

    //System.exit(job.waitForCompletion(true) ? 0 : 1);
        
        
        
        
        
        
           long endTime   = System.currentTimeMillis();
long totalTime = endTime - startTime;
System.out.println("part1_assgnmt3 "+totalTime);
        
        
        
    }
    
}
