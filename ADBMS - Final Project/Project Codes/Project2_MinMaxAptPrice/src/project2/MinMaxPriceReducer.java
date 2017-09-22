/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project2;

import java.io.IOException;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

/**
 *
 * @author mugdha
 */
public class MinMaxPriceReducer extends Reducer<Text, MinMaxAptPrice, Text, MinMaxAptPrice> {

    private MinMaxAptPrice result = new MinMaxAptPrice();

    @Override
    protected void reduce(Text key, Iterable<MinMaxAptPrice> values, Context context) throws IOException, InterruptedException {

        //result.setMinDate(null);
        //result.setMaxDate(null);
        result.setMinPrice(null);
        result.setMaxPrice(null);

        for (MinMaxAptPrice val : values) {

            if (result.getMinPrice() == null || val.getMinPrice().compareTo(result.getMinPrice()) < 0) {
                result.setMinPrice(val.getMinPrice());
               // result.setMinDate(val.getMinDate());
            }            // get min bonus                       if (resultRow.getMaxDuration()==null || maxduration.compareTo(resultRow.getMaxDuration())>0) {
            result.setMaxPrice(val.getMaxPrice());
           // result.setMaxDate(val.getMaxDate());
        }
        context.write(key, result);
    }
}
