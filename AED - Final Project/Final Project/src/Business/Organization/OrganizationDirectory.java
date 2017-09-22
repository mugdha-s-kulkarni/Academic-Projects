/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import java.util.ArrayList;

/**
 *
 * @author Mugdha
 */
public class OrganizationDirectory {
  private ArrayList<Organization> organizationList;

    public OrganizationDirectory() {
        organizationList = new ArrayList<>();
    }

    public ArrayList<Organization> getOrganizationList() {
        return organizationList;
    }
    
    public Organization createOrganization(Organization.Type type){
        Organization organization = null;
        if (type.getValue().equals(Organization.Type.User.getValue())){
            organization = new UserOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Organization.Type.SnowPlow.getValue())){
            organization = new SnowPlowOrganization();
            organizationList.add(organization);
        }
         else if (type.getValue().equals(Organization.Type.Cleaning.getValue())){
            organization = new CleaningOrganization();
            organizationList.add(organization);
        }
         else if (type.getValue().equals(Organization.Type.PlowTruck.getValue())){
            organization = new PlowTruckOrganization();
            organizationList.add(organization);
        }
         else if (type.getValue().equals(Organization.Type.HelpDesk.getValue())){
            organization = new HelpDeskOrganization();
            organizationList.add(organization);
        }
        
        return organization;
    }  
}

