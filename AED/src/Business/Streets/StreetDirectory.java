/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Streets;

import java.util.ArrayList;

/**
 *
 * @author Mugdha
 */
public class StreetDirectory {
  private ArrayList<Street> streetList;
  
  public StreetDirectory(){
      streetList = new ArrayList<>();
  }

    public ArrayList<Street> getStreetList() {
        return streetList;
    }

    public Street createAndAddStreet(String name){
        Street street = new Street();
        street.setName(name);
        streetList.add(street);
        return street;
    }   
}
