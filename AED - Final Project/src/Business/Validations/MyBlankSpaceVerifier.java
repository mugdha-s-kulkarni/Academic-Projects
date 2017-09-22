/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Validations;

import java.awt.Color;
import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Mugdha
 */
public class MyBlankSpaceVerifier extends InputVerifier {

     @Override
    public boolean verify(JComponent input) {
        String text = ((JTextField) input).getText();
       
        if (text.length() > 0) {
            if (text.toLowerCase().startsWith(" ") || text.length() == 0) {     //|| text.matches(pattern) != true
                input.setBackground(Color.red);
                JOptionPane.showMessageDialog(input, "Please enter valid string. Special characters are not allowed", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            } else {
                input.setBackground(Color.white);
                return true;
            }
        }
        else
        {
            input.setBackground(Color.red);
            return false;
        }
    }
    
}
