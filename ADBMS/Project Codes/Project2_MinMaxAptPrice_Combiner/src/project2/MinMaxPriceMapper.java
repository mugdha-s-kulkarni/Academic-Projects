/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project2;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

/**
 *
 * @author mugdha
 */
public class MinMaxPriceMapper extends Mapper<Object, Text, Text, MinMaxAptPrice> {

  
    private Text area = new Text();
    private Integer min;
    private Integer max;
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    private MinMaxAptPrice outPut = new MinMaxAptPrice();

    public void map(Object key, Text value, Context context
    ) throws IOException, InterruptedException {

        try {
            String[] campaignFields = value.toString().split(",");

            area.set(campaignFields[0]);
            min = Integer.parseInt(campaignFields[3]);
            max = Integer.parseInt(campaignFields[3]);
            char avail = value.toString().split(",")[2].charAt(0);
            Date date = sdf.parse(campaignFields[1]);

            if (area == null || min == null || max == null) {
                return;
            }
            outPut.setMinPrice(min);
            outPut.setMaxPrice(max);
//            outPut.setMinDate(date);
//            outPut.setMaxDate(date);
            if (avail == 't') {
                context.write(area, outPut);
            }
        } catch (ParseException ex) {
            Logger.getLogger(MinMaxPriceMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
