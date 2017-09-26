/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;


import Business.Role.Role;
import Business.Role.SnowPlowRole;
import Business.Streets.StreetDirectory;

import java.util.ArrayList;

/**
 *
 * @author Mugdha
 */
public class SnowPlowOrganization extends Organization{

    private StreetDirectory streetDirectory;
    
   
    public SnowPlowOrganization() {
        
        super(Organization.Type.SnowPlow.getValue());
        streetDirectory = new StreetDirectory();        
    }    
    
    public StreetDirectory getStreetDirectory() {
        return streetDirectory;
    }
   
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new SnowPlowRole());
        return roles;
    }
    
}
