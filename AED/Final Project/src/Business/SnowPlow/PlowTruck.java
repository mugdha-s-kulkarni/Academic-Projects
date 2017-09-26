/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.SnowPlow;

/**
 *
 * @author Mugdha
 */
public class PlowTruck {
    
    private static int count;
    private int truckID;
    private String name;
    private String status;

    public PlowTruck(){
        count++;
        truckID = count;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTruckId() {
        return truckID;
    }

    public void setTruckId(int truckID) {
        this.truckID = truckID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    @Override
    public String toString(){
        return name;
    }
}
