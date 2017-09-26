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
    
      static  Map<Text,FloatWritable> countMap = new HashMap<Text,FloatWritable>();
    public static class TokenizerMapper1
       extends Mapper<Object, Text, Text, FloatWritable>{

    private String listingId;
    private int rating;

    public void map(Object key, Text value, Context context
                    ) throws IOException, InterruptedException {
      
      listingId = value.toString().split(",")[79];
      rating = Integer.parseInt(value.toString().split(",")[79]);
      context.write(new Text(listingId), new FloatWritable(rating));
    }
  }
    
    
}
