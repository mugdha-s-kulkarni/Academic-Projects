/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project2;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.Date;
import org.apache.hadoop.io.Writable;

/**
 *
 * @author mugdha
 */
public class MinMaxAptPrice implements Writable {

    private Integer maxPrice;
    private Integer minPrice;

    public Integer getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(Integer maxPrice) {
        this.maxPrice = maxPrice;
    }

    public Integer getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(Integer minPrice) {
        this.minPrice = minPrice;
    }

    @Override
    public void write(DataOutput d) throws IOException {
        d.writeInt(maxPrice);
        d.writeInt(minPrice);
    }

    @Override
    public void readFields(DataInput di) throws IOException {
        minPrice = di.readInt();
        maxPrice = di.readInt();
    }

    @Override
    public String toString() {
        return "maxPrice=" + maxPrice + ", minPrice=" + minPrice;
    }

}
