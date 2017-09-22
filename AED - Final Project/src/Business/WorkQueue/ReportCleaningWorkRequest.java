/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.Sensors.Sensor;
import Business.Streets.Street;
import java.util.Date;

/**
 *
 * @author Mugdha
 */
public class ReportCleaningWorkRequest extends WorkRequest {
    private String result;
    private Street street;
    private Sensor sensor;
    private int PlowTruckID;
    private String plowTruckName;
    private int snowHeight;
    private Date date;
    private String status;
    
    public ReportCleaningWorkRequest(){
        street = new Street();
        sensor = new Sensor();
    }
    public String getResult() {
        return result;
    }
     
    public void setResult(String result) {
        this.result = result;
    }

    public Street getStreet() {
        return street;
    }

    public void setStreet(Street street) {
        this.street = street;
    }

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }

    public int getSnowHeight() {
        return snowHeight;
    }

    public void setSnowHeight(int snowHeight) {
        this.snowHeight = snowHeight;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getPlowTruckID() {
        return PlowTruckID;
    }

    public void setPlowTruckID(int PlowTruckID) {
        this.PlowTruckID = PlowTruckID;
    }

    public String getPlowTruckName() {
        return plowTruckName;
    }

    public void setPlowTruckName(String plowTruckName) {
        this.plowTruckName = plowTruckName;
    }

    
        
    @Override
    public String toString(){
        return street.getName();
    }
}
