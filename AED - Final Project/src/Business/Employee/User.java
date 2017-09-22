/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Employee;

import Business.TravelCard.TravelCard;
import Business.TravelCard.TravelCardHistory;

/**
 *
 * @author Mugdha
 */
public class User extends Employee{
    
    private String address;
    private double phoneNo;
    private String emailId;
    
    private TravelCardHistory history;
 

    
    public User(){
       history = new TravelCardHistory();                
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }
    
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(double phoneNo) {
        this.phoneNo = phoneNo;
    }

    public TravelCardHistory getHistory() {
        return history;
    }
    
    public int getNumberOfCards(){
        
        int size = history.getHistory().size();
        return size;
    }   
    
    public int getOrderTotal(){
        int total = 0;
        for(TravelCard tc : history.getHistory()){
            total = total+ tc.getAmount();
        }
        return total;
    }

}

