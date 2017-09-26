/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Measurements;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Mugdha
 */
public class MeasurementHistory {
   private ArrayList<Measurement> measurementList;
   
   public MeasurementHistory(){
       measurementList = new ArrayList<>();
   }

    public ArrayList<Measurement> getMeasurementList() {
        return measurementList;
    }

    public Measurement createAndAddMeasurement(int sh, Date d){
        Measurement measurement = new Measurement();
        measurement.setSnowHeight(sh);
        measurement.setSensedDate(d);
        measurement.setStatus("Unreported");
        measurementList.add(measurement);
        return measurement;
    }    
    
    
}
