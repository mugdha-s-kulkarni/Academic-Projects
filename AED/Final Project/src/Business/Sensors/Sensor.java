/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Sensors;

import Business.Measurements.MeasurementHistory;

/**
 *
 * @author Mugdha
 */
public class Sensor {
   private String area; 
   private int id;
   private static int count =1;
   
   private MeasurementHistory meaurementHistory;
   
   public Sensor(){
        id = count;
        count++;
        meaurementHistory = new MeasurementHistory();
   }

    public MeasurementHistory getMeaurementHistory() {
        return meaurementHistory;
    }
  

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Sensor.count = count;
    }
 
    @Override
    public String toString(){
        return area;
    }    
   
}
