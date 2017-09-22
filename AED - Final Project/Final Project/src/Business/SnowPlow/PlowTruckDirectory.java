/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.SnowPlow;

import java.util.ArrayList;

/**
 *
 * @author Mugdha
 */
public class PlowTruckDirectory {
   
    private ArrayList<PlowTruck> plowTruckList;
    
    public PlowTruckDirectory(){
        plowTruckList = new ArrayList<>();
    }

    public ArrayList<PlowTruck> getPlowTruckList() {
        return plowTruckList;
    }
    
     public PlowTruck createAndAddPlowTruck(String name){
        PlowTruck plowTruck = new PlowTruck();
        plowTruck.setName(name);
        plowTruckList.add(plowTruck);
        return plowTruck;
    } 
}
