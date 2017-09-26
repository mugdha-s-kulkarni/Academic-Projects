/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.TravelCard;

import java.util.Date;

/**
 *
 * @author Mugdha
 */
public class TravelCard {
 private static int Id;
 private String vehicleName;
 private String name;
 private int amount;
 private String duration;
 private Date startDate;
 private Date endDate;
 
 
  public enum Type{
        Gold("Gold"), Silver("Silver"), Regular("Regular");
        private String value;
        
        private Type(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }
  
 
    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
  
  public static int getId() {
        return Id;
    }

    public static void setId(int Id) {
        TravelCard.Id = Id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

  
    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
 
    
    @Override
    public String toString(){
        return vehicleName;
    }
  
}
