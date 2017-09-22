package project9;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.io.IOException;
import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

/**
 *
 * @author mugdha
 */
public class RatioMapper extends Mapper<Object, Text, LongWritable, FloatWritable> {

    private long listingId;
    @Override
    protected void map(Object key, Text value, Context context) throws IOException, InterruptedException {
        String txt = value.toString().split("\t")[0];
        String total= value.toString().split("\t")[1];
        String hot= value.toString().split("\t")[3];
        float t = Float.parseFloat(total);
        float h = Float.parseFloat(hot);
        
        listingId = Long.parseLong(txt);
        
        float ratio = (h*100)/t;
      
        context.write(new LongWritable(listingId),new FloatWritable(ratio));
    }
    
}
