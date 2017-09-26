/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project5;

import org.apache.hadoop.conf.Configurable;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Partitioner;

/**
 *
 * @author mugdha
 */
public class LastReviewPartitioner extends Partitioner<IntWritable, IntWritable> implements Configurable{

    public static final String lastAccess = "last.access";
    private Configuration conf = null;
    private int minLastAccessDateYear = 0;
    
    @Override
    public int getPartition(IntWritable key, IntWritable value, int i) {
        return key.get() - minLastAccessDateYear;
    }
    
    public Configuration getConf(){
        return conf;
    }
    
    public void setConf(Configuration conf){
        this.conf = conf;
        minLastAccessDateYear = conf.getInt(lastAccess, 0);
        
    }

    public static void setMinLastAccessDateYear(Job job, int minLastAccessDateYear) {
        job.getConfiguration().setInt(lastAccess, minLastAccessDateYear);
    }
    
    
    
}
