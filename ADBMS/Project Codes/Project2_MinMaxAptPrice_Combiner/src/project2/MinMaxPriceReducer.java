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

    @Override
    protected void reduce(Text key, Iterable<MinMaxAptPrice> values, Context context) throws IOException, InterruptedException {

        for (MinMaxAptPrice val : values) {
            context.write(key, val);

        }
    }
}
