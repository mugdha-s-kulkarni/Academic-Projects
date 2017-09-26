/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assgnmt3_part2;

import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

/**
 *
 * @author shreyaj007
 */
public class Reducer2 {
    
    public static class FloatSumReducer2
       extends Reducer<FloatWritable,Text,FloatWritable,Text> {
      String movieId;
        Float rating;
    public void reduce(FloatWritable key, Iterable<Text> values,
                       Context context
                       ) throws IOException, InterruptedException {
         System.out.println("value ------------------------------------");
       
      TreeMap<Float,Text> countMap = new TreeMap<Float, Text>();
      for(Text value : values){
          
          movieId = value.toString().split("\t")[0];
        
          rating = Float.parseFloat(value.toString().split("\t")[1]);
         
          
          countMap.put(rating, new Text(movieId));
          
          if(countMap.size()> 25){
          countMap.remove(countMap.firstKey());
          }
      }
      
     for (Map.Entry<Float,Text> entry : countMap.descendingMap().entrySet()) {
        Text value = entry.getValue();
        System.out.println("vvhhgcv    "+ entry.getKey());
        context.write(new FloatWritable(entry.getKey()),new Text(value));
   }
     
   
      
      for(Text t : countMap.descendingMap().values()){
        
          String movieId = t.toString().split("\t")[0];
          
                
      }
    }

   
  }
    
    
}
