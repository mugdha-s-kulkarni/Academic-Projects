/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.Organization.PlowTruckOrganization;
import Business.UserAccount.UserAccount;
import UserInterface.PlowTruckRole.PlowTruckWorkAreaJPanel;
import javax.swing.JPanel;

/**
 *
 * @author Mugdha
 */
public class PlowTruckRole extends Role {

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise,Network network, EcoSystem business) {
        return new PlowTruckWorkAreaJPanel(userProcessContainer, account, (PlowTruckOrganization) organization, enterprise);
    }  
}
