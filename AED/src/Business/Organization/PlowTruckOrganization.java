/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import static Business.Organization.Organization.Type.PlowTruck;
import Business.Role.PlowTruckRole;
import Business.Role.Role;
import Business.SnowPlow.PlowTruck;
import Business.SnowPlow.PlowTruckDirectory;
import UserInterface.PlowTruckRole.PlowTruckWorkAreaJPanel;
import java.util.ArrayList;

/**
 *
 * @author Mugdha
 */
public class PlowTruckOrganization extends Organization {

    private PlowTruckDirectory plowTruckDirectory;
    public PlowTruckOrganization() {
        super(Organization.Type.PlowTruck.getValue());
        plowTruckDirectory = new PlowTruckDirectory();
    }


    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new PlowTruckRole());
        return roles;
    }
    
}
