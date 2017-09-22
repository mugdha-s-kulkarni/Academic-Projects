/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Measurements;

import java.util.Date;

/**
 *
 * @author Mugdha
 */
public class Measurement {
    private int snowHeight;
    private Date sensedDate;
    private String status = "Unreported";

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    public int getSnowHeight() {
        return snowHeight;
    }

    public void setSnowHeight(int snowHeight) {
        this.snowHeight = snowHeight;
    }

    public Date getSensedDate() {
        return sensedDate;
    }

    public void setSensedDate(Date sensedDate) {
        this.sensedDate = sensedDate;
    }
}
