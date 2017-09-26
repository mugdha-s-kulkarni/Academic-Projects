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
import org.apache.hadoop.mapreduce.Mapper;

/**
 *
 * @author shreyaj007
 */
public class Mapper1 {
    
      static  Map<Text,Float> countMap = new HashMap<Text,Float>();
    public static class TokenizerMapper1
       extends Mapper<Object, Text, Text, FloatWritable>{

    private String movieId;
    private float rating;

    public void map(Object key, Text value, Context context
                    ) throws IOException, InterruptedException {
      
      movieId = value.toString().split("::")[1];
      rating = Float.parseFloat(value.toString().split("::")[2]);
      context.write(new Text(movieId), new FloatWritable(rating));
    }
  }
    
    
}
