/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project3;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import org.apache.hadoop.io.Writable;

/**
 *
 * @author mugdha
 */
public class MinMaxTuple implements Writable {

    Integer minRent;
    Integer maxRent;

   
    public MinMaxTuple() {
        minRent = 0;
        maxRent = 0;
    }

    void setMinDuration(Integer duration) {
        this.minRent = duration;
    }

    void setMaxDuration(Integer duration) {
        this.maxRent = duration;
    }

    Integer getMinDuration() {
        return minRent;
    }

    Integer getMaxDuration() {
        return maxRent;
    }

    @Override
    public void write(DataOutput out) throws IOException {
        out.writeInt(minRent);
        out.writeInt(maxRent);
    }

    @Override
    public void readFields(DataInput in) throws IOException {
        minRent = new Integer(in.readInt());
        maxRent = new Integer(in.readInt());
    }

    public String toString() {
        return minRent + "\t" + maxRent;
    }
   
}
