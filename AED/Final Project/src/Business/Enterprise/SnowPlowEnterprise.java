/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author Mugdha
 */
public class SnowPlowEnterprise extends Enterprise {

    public SnowPlowEnterprise(String name) {
        super(name, EnterpriseType.SnowPlow);
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        return null;
    }
    
}
