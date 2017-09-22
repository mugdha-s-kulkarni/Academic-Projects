/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project3;

import java.io.IOException;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

/**
 *
 * @author mugdha
 */
public class NeighbourhoodRentReducer extends Reducer<Text, MinMaxTuple, Text, MinMaxTuple> {

  
    public void reduce(Text key, Iterable<MinMaxTuple> values, Context context) throws IOException, InterruptedException {

        for (MinMaxTuple val : values) {
            context.write(key, val);
        }
    }       

}
