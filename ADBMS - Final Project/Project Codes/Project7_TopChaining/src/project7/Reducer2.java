/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project7;

import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;
import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

/**
 *
 * @author mugdha
 */
public class Reducer2 {

    public static class FloatSumReducer2
            extends Reducer<FloatWritable, Text, FloatWritable, Text> {

        String listingId;
        Float rating;

        public void reduce(FloatWritable key, Iterable<Text> values,
                Context context
        ) throws IOException, InterruptedException {
           

            TreeMap<Float, Text> countMap = new TreeMap<>();
            for (Text value : values) {

                listingId = value.toString().split("\t")[0];

                rating = Float.parseFloat(value.toString().split("\t")[1]);

                countMap.put(rating, new Text(listingId));

                if (countMap.size() > 50) {
                    countMap.remove(countMap.firstKey());
                }
            }

            for (Map.Entry<Float, Text> entry : countMap.descendingMap().entrySet()) {
                Text value = entry.getValue();

                context.write(new FloatWritable(entry.getKey()), new Text(value));
            }

            for (Text t : countMap.descendingMap().values()) {

                String listingId = t.toString().split("\t")[0];

            }
        }

    }

}
