/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project9;

import java.io.IOException;
import java.util.ArrayList;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.MultipleInputs;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
import org.apache.hadoop.util.Tool;

/**
 *
 * @author mugdha
 */
public class Project8 extends Configured implements Tool {

    public static class ListingJoinMapper extends Mapper<Object, Text, Text, Text> {

        private Text keyOut = new Text();
        private Text valueOut = new Text();

        public void map(Object key, Text value, Context context) throws IOException, InterruptedException {

            String[] separatedInput = value.toString().split(",");

            String listingId = separatedInput[0];
            if (listingId == null) {
                return;
            }

            keyOut.set(listingId);

            valueOut.set("L" + value.toString());
            context.write(keyOut, valueOut);
        }
    }

    public static class ReviewJoinMapper extends Mapper<Object, Text, Text, Text> {

        private Text keyOut = new Text();
        private Text valueOut = new Text();

        public void map(Object key, Text value, Context context) throws IOException, InterruptedException {
            String[] separatedInput = value.toString().split(",");

            String listingId = separatedInput[0];

            if (listingId == null) {
                return;
            }

            keyOut.set(listingId);

            valueOut.set("R" + value.toString());
            context.write(keyOut, valueOut);
        }
    }

    public static class ListingReviewJoinReducer extends Reducer<Text, Text, Text, Text> {

        //private static final Text EMPTY_TEXT = new Text("");
        private Text tmp = new Text();
        private ArrayList<Text> listings = new ArrayList<>();
        private ArrayList<Text> reviews = new ArrayList<>();
        private String joinType = null;

        public void setup(Context context) {

            joinType = context.getConfiguration().get("join.type");
        }

        public void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {

            listings.clear();
            reviews.clear();

            while (values.iterator().hasNext()) {
                tmp = values.iterator().next();

                if (Character.toString((char) tmp.charAt(0)).equals("L")) {

                    listings.add(new Text(tmp.toString().substring(1)));
                }
                if (Character.toString((char) tmp.charAt(0)).equals("R")) {

                    reviews.add(new Text(tmp.toString().substring(1)));
                }

            }

           // System.out.println(reviews.size());
            performJoin(context);
        }

        private void performJoin(Context context) throws IOException, InterruptedException {

            if (joinType.equalsIgnoreCase("inner")) {

                if (!listings.isEmpty() && !reviews.isEmpty()) {
                   
                    for (Text A : listings) {

                        for (Text B : reviews) {

                            context.write(A, B);
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        System.exit(new Project8().run(args));
    }

    public int run(String[] args) throws Exception {
        Configuration conf = new Configuration();
	Job job = new Job(conf, "LabReduceSideJoin");
        job.setJarByClass(Project8.class);

        MultipleInputs.addInputPath(job, new Path("/mugdha/reviews"), TextInputFormat.class, ListingJoinMapper.class); //"/home/mayur/NetBeansProjects/labReduceSideJoin/src/input1"
        MultipleInputs.addInputPath(job, new Path("/mugdha/listings"), TextInputFormat.class, ReviewJoinMapper.class);//"/Users/austingnanarajnoah/Documents/workspace-sts/ReduceSideJoin/src/main/java/input2"
        job.getConfiguration().set("join.type", "inner");
        job.setReducerClass(ListingReviewJoinReducer.class);

        job.setOutputFormatClass(TextOutputFormat.class);
        TextOutputFormat.setOutputPath(job, new Path("/mugdha/output8")); 
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(Text.class);

        return job.waitForCompletion(true) ? 0 : 2;
    }

}
