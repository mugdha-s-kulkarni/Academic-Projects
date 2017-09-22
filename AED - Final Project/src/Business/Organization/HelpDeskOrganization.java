/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.HelpDeskRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author Mugdha
 */
public class HelpDeskOrganization extends Organization {

    public HelpDeskOrganization() {
        super(Organization.Type.HelpDesk.getValue());
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new HelpDeskRole());
        return roles;
    }

}
