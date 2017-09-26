/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.CleaningRole;
import Business.Role.Role;
import Business.SnowPlow.PlowTruckDirectory;
import Business.Streets.StreetDirectory;
import java.util.ArrayList;

/**
 *
 * @author Mugdha
 */
public class CleaningOrganization extends Organization {

    private PlowTruckDirectory plowTruckDirectory;
    
    public CleaningOrganization() {
        super(Organization.Type.Cleaning.getValue());
        plowTruckDirectory = new PlowTruckDirectory();

    }

    public PlowTruckDirectory getPlowTruckDirectory() {
        return plowTruckDirectory;
    }
    

    @Override
           
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new CleaningRole());
        return roles;
    }
}

