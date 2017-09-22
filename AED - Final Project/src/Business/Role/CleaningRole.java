/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.CleaningOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import UserInterface.CleaningRole.CleaningWorkAreaJPanel;
import javax.swing.JPanel;

/**
 *
 * @author Mugdha
 */
public class CleaningRole extends Role {

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise,Network network, EcoSystem business) {
      return new CleaningWorkAreaJPanel( userProcessContainer, account, (CleaningOrganization) organization, enterprise) ;   

    }
    
}
