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
public class MinMaxPriceCombiner extends Reducer<Text, MinMaxAptPrice, Text, MinMaxAptPrice> {

    private MinMaxAptPrice result = new MinMaxAptPrice();

    @Override
    protected void reduce(Text key, Iterable<MinMaxAptPrice> values, Context context) throws IOException, InterruptedException {

        //result.setMinDate(null);
        //result.setMaxDate(null);
        result.setMinPrice(null);
        result.setMaxPrice(null);

        for (MinMaxAptPrice val : values) {

            if (result.getMinPrice() == null || val.getMinPrice().compareTo(result.getMinPrice()) < 0) {
                result.setMinPrice(val.getMinPrice());// result.setMinDate(val.getMinDate());
            }           
            result.setMaxPrice(val.getMaxPrice());
       
        }
        context.write(key, result);
    }
}
