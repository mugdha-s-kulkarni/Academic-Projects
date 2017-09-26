package project4;

import com.google.common.base.Charsets;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnel;
import com.google.common.hash.Sink;
import org.apache.hadoop.io.IntWritable;

public class Project4 extends Configured implements Tool {

   

    public static class BloomFilterMapper extends Mapper<Object, Text, IntWritable, IntWritable> {

        Funnel<Filter> p = new Funnel<Filter>() {
            @Override
            public void funnel(Filter mc, Sink into) {

                into.putString(mc.c, Charsets.UTF_8);

            }
        };
        private BloomFilter<Filter> filterList = BloomFilter.create(p, 500, 0.1);

        @Override
        public void setup(Mapper.Context context) throws IOException, InterruptedException {

            Filter p1 = new Filter("nice");
            Filter p2 = new Filter("cool");
            Filter p3 = new Filter("good");
            Filter p4 = new Filter("great");
            Filter p5 = new Filter("pleasant");
            Filter p6 = new Filter("excellent");
            Filter p7 = new Filter("comfortable");
            Filter p8 = new Filter("beautiful");
            Filter p9 = new Filter("perfect");
            Filter p10 = new Filter("friendly");

            ArrayList<Filter> catList = new ArrayList<>();
            catList.add(p1);
            catList.add(p2);
            catList.add(p3);
            catList.add(p4);
            catList.add(p5);
            catList.add(p6);
            catList.add(p7);
            catList.add(p8);
            catList.add(p9);
            catList.add(p10);

            for (Filter pr : catList) {
                filterList.put(pr);
            }
        }

        @Override
        public void map(Object key, Text value, Mapper.Context context) throws IOException, InterruptedException {

            String values[] = value.toString().split(",");
            String id = values[0];
            int listingId = Integer.parseInt(id);
            
            int count = 0;
            String val[] = values[5].split(" ");
            for (String val1 : val) {                
                Filter mc = new Filter(val1.trim());
                if (filterList.mightContain(mc)) {
                    count++;
                 }
               }
            if(count > 0){
               context.write(new IntWritable(listingId), new IntWritable(1)); 
            }

        }
    }

    public static void main(String[] args) throws Exception {
        int res = ToolRunner.run(new Configuration(), new Project4(), args);
        System.exit(res);
    }

    private static final String input = "/mugdha/reviews";
    private static final String output = "/mugdha/output4";

    @Override
    public int run(String[] args) throws Exception {
        Configuration conf = new Configuration();
        Job job = Job.getInstance(conf, "Bloom Filter");
        job.setJarByClass(Project4.class);
        job.setMapperClass(BloomFilterMapper.class);
        job.setReducerClass(BloomFilterDistinctReducer.class);
        job.setOutputKeyClass(IntWritable.class);
        job.setOutputValueClass(IntWritable.class);
        FileInputFormat.addInputPath(job, new Path(input));
        FileOutputFormat.setOutputPath(job, new Path(output));
        boolean success = job.waitForCompletion(true);
        System.out.println(success);
        return success ? 0 : 1;
    }
}
