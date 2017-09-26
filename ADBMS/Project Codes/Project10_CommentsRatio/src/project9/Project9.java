/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project9;

import java.io.IOException;
import java.util.ArrayList;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.MultipleInputs;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;

/**
 *
 * @author mugdha
 */
public class Project9 {

    public static class TotalJoinMapper extends org.apache.hadoop.mapreduce.Mapper<Object, Text, Text, Text> {

        private Text keyOut = new Text();
        private Text valueOut = new Text();

        public void map(Object key, Text value, Context context) throws IOException, InterruptedException {

            String[] separatedInput = value.toString().split("\t");

            String listingId = separatedInput[0];
            if (listingId == null) {
                return;
            }

            keyOut.set(listingId);

            valueOut.set("T" + value.toString());
            context.write(keyOut, valueOut);
        }
    }

    public static class HotJoinMapper extends org.apache.hadoop.mapreduce.Mapper<Object, Text, Text, Text> {

        private Text keyOut = new Text();
        private Text valueOut = new Text();

        public void map(Object key, Text value, Context context) throws IOException, InterruptedException {
            String[] separatedInput = value.toString().split("\t");

            String listingId = separatedInput[0];

            if (listingId == null) {
                return;
            }

            keyOut.set(listingId);

            valueOut.set("P" + value.toString());
            context.write(keyOut, valueOut);
        }
    }

    public static class JoinReducer extends Reducer<Text, Text, Text, Text> {

      
        private Text tmp = new Text();
        private ArrayList<Text> total = new ArrayList<>();
        private ArrayList<Text> positive = new ArrayList<>();
        private String joinType = null;

        public void setup(Context context) {

            joinType = context.getConfiguration().get("join.type");
        }

        public void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {

            total.clear();
            positive.clear();

            while (values.iterator().hasNext()) {
                tmp = values.iterator().next();

                if (Character.toString((char) tmp.charAt(0)).equals("T")) {

                    total.add(new Text(tmp.toString().substring(1)));
                }
                if (Character.toString((char) tmp.charAt(0)).equals("P")) {

                    positive.add(new Text(tmp.toString().substring(1)));
                }

            }

            System.out.println(positive.size());
            executeJoinLogic(context);
        }

        private void executeJoinLogic(Reducer.Context context) throws IOException, InterruptedException {

            if (joinType.equalsIgnoreCase("inner")) {

                if (!total.isEmpty() && !positive.isEmpty()) {
                    System.out.println("here");
                    for (Text A : total) {

                        for (Text B : positive) {

                            context.write(A, B);
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        System.exit(new Project9().run(args));
    }

    public int run(String[] args) throws Exception {
        Configuration conf = new Configuration();
        Job job = new Job(conf, "LabReduceSideJoin");
        job.setJarByClass(Project9.class);

        MultipleInputs.addInputPath(job, new Path("/mugdha/p1out"), TextInputFormat.class, TotalJoinMapper.class); //"/home/mayur/NetBeansProjects/labReduceSideJoin/src/input1"
        MultipleInputs.addInputPath(job, new Path("/mugdha/p4out"), TextInputFormat.class, HotJoinMapper.class);//"/Users/austingnanarajnoah/Documents/workspace-sts/ReduceSideJoin/src/main/java/input2"
        job.getConfiguration().set("join.type", "inner");
        job.setReducerClass(JoinReducer.class);

        job.setOutputFormatClass(TextOutputFormat.class);
        TextOutputFormat.setOutputPath(job, new Path("/mugdha/output9_part")); 
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(Text.class);

        job.waitForCompletion(true);

        Job job2 = new Job(conf, "Job 2");
        job2.setJarByClass(Project9.class);

        job2.setMapperClass(RatioMapper.class);
        job2.setReducerClass(RatioReducer.class);

        job2.setOutputKeyClass(LongWritable.class);
        job2.setOutputValueClass(FloatWritable.class);

        job2.setInputFormatClass(TextInputFormat.class);
        job2.setOutputFormatClass(TextOutputFormat.class);

        TextInputFormat.addInputPath(job2, new Path("/mugdha/output9_part"));
        TextOutputFormat.setOutputPath(job2, new Path("/mugdha/output9"));

        return job2.waitForCompletion(true) ? 0 : 2;

    }

 }
