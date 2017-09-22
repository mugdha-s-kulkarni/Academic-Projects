/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project6;

import java.io.IOException;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.lib.output.MultipleOutputs;

/**
 *
 * @author mugdha
 */
public class BedRoomBins extends Mapper<Object, Text, Text, NullWritable> {

    private MultipleOutputs<Text, NullWritable> mulOutput = null;

    @Override
    protected void setup(Context context) throws IOException, InterruptedException {
      mulOutput = new MultipleOutputs(context);
    }
    
    @Override
    protected void map(Object key, Text value, Context context) throws IOException, InterruptedException {
        
        String bedroom = value.toString().split(",")[17];
        
        if(bedroom.equals("1")){
            mulOutput.write("bins", value, NullWritable.get(), "1 BHK");
        }
        if(bedroom.equals("2")){
            mulOutput.write("bins", value, NullWritable.get(), "2 BHK");
        }
        if(bedroom.equals("3")){
            mulOutput.write("bins", value, NullWritable.get(), "3 BHK");
        }
        if(bedroom.equals("0")){
        }
        else{
           mulOutput.write("bins", value, NullWritable.get(), "Bunglow"); 
        }
    }

    @Override
    protected void cleanup(Context context) throws IOException, InterruptedException {
        mulOutput.close(); 
    }    
    
}
