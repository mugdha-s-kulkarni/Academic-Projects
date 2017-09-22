/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Sensors;


import java.util.ArrayList;

/**
 *
 * @author Mugdha
 */
public class SensorDirectory {
   
    private ArrayList<Sensor> sensorList;
  
  public SensorDirectory(){
      sensorList = new ArrayList<>();
  }

    public ArrayList<Sensor> getSensorList() {
        return sensorList;
    }

    public Sensor createAndAddSensor(){
        Sensor sensor = new Sensor();
        sensorList.add(sensor);
        return sensor;
    }     
}
