/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project3;

import java.io.IOException;
import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

/**
 *
 * @author mugdha
 */
public class NeighbourhoodRentMapper extends Mapper<Object, Text, Text, MinMaxTuple> {

    private Text area= new Text();
    private Integer min;
    private Integer max;
    
   
    private MinMaxTuple outPut= new MinMaxTuple();
	
    public void map(Object key, Text value, Context context
                    ) throws IOException, InterruptedException {
      
    	String[] campaignFields= value.toString().split(",");
		
		area.set(campaignFields[11]);
		min=Integer.parseInt(campaignFields[19]);
		max=Integer.parseInt(campaignFields[19]);
		
		if (area == null || min == null || max== null) {
			return;
		}	
                outPut.setMinDuration(min);
                outPut.setMaxDuration(max);
                context.write(area,outPut);
	 }
   
}
