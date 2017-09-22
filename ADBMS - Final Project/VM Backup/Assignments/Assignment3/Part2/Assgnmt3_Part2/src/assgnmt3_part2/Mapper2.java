/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assgnmt3_part2;

import java.io.IOException;
import java.util.TreeMap;
import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

/**
 *
 * @author shreyaj007
 */
public class Mapper2 {

    public static class TokenizerMapper2
            extends Mapper<Object, Text, FloatWritable, Text> {

        static TreeMap<Float, Text> countMap = new TreeMap<Float, Text>();
        
        private float fl = (float) 1.0;
        FloatWritable one = new FloatWritable(fl);

        public void map(Object key, Text value, Context context
        ) throws IOException, InterruptedException {

            context.write(one, value);

        }

        @Override
        protected void cleanup(Context context) throws IOException, InterruptedException {
            for (Text val : countMap.values()) {
                context.write(one, val);
            }
        }
    }

}
