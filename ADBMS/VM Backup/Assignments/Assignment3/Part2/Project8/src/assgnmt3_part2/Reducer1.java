/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assgnmt3_part2;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

/**
 *
 * @author shreyaj007
 */
public class Reducer1 {

    static Map<Text, Float> countMap = new HashMap<Text, Float>();

    public static class FloatSumReducer1
            extends Reducer<Text, FloatWritable, Text, FloatWritable> {

        private FloatWritable result = new FloatWritable();

        public void reduce(Text key, Iterable<FloatWritable> values,
                Context context
        ) throws IOException, InterruptedException {
            float sum = (float) 0.0;
            int counter = 0;
            for (FloatWritable val : values) {
                sum += val.get();
                counter++;
            }
            float avgRate = sum / counter;
            result.set(avgRate);
            countMap.put(key, avgRate);
            context.write(key, result);
        }

    }

}
