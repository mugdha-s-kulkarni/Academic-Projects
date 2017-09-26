package project9;



import java.io.IOException;
import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.mapreduce.Reducer;


/**
 *
 * @author mugdha
 */
public class RatioReducer extends Reducer<LongWritable, FloatWritable, LongWritable, FloatWritable>{

    @Override
    protected void reduce(LongWritable key, Iterable<FloatWritable> values, Context context) throws IOException, InterruptedException {
        for(FloatWritable val : values){
          context.write(key, val);  
        }
        
    }
    
}
