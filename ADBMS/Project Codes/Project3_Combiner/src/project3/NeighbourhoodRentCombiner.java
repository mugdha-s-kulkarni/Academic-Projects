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
public class NeighbourhoodRentCombiner extends Reducer<Text, MinMaxTuple, Text, MinMaxTuple> {

    private MinMaxTuple resultRow = new MinMaxTuple();

    public void reduce(Text key, Iterable<MinMaxTuple> values,
            Context context
    ) throws IOException, InterruptedException {
        Integer minduration = 0;
        Integer maxduration = 0;

        resultRow.setMinDuration(null);
        resultRow.setMaxDuration(null);

        for (MinMaxTuple val : values) {

            minduration = val.getMinDuration();
            maxduration = val.getMaxDuration();
    	  // get min score 

            if (resultRow.getMinDuration() == null || minduration.compareTo(resultRow.getMinDuration()) < 0) {
                resultRow.setMinDuration(minduration);
            }            // get min bonus                       if (resultRow.getMaxDuration()==null || maxduration.compareTo(resultRow.getMaxDuration())>0) {
            resultRow.setMaxDuration(maxduration);
        }
         context.write (key, resultRow);
    }
   
}

