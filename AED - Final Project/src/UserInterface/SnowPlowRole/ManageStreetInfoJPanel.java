/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.SnowPlowRole;

import Business.Enterprise.Enterprise;
import Business.Organization.SnowPlowOrganization;
import Business.Streets.Street;
import Business.UserAccount.UserAccount;
import Business.Validations.MyNameVerifier;
import Business.Validations.MyStringVerifier;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Mugdha
 */
public class ManageStreetInfoJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ManageStreetInfoJPanel
     */
    private JPanel userProcessContainer;
    private UserAccount userAccount;
    private SnowPlowOrganization organization;
    private Enterprise enterprise;

    public ManageStreetInfoJPanel(JPanel userProcessContainer, UserAccount account, SnowPlowOrganization organization, Enterprise enterprise) {
        initComponents();

        this.userProcessContainer = userProcessContainer;
        this.userAccount = account;
        this.organization = organization;
        this.enterprise = enterprise;

        MyNameVerifier myNameVerifier = new MyNameVerifier();
        txtStreetName.setInputVerifier(myNameVerifier);

        populateTable();

    }

    public void populateTable() {
        DefaultTableModel model = (DefaultTableModel) tblStreet.getModel();

        model.setRowCount(0);

        for (Street street : organization.getStreetDirectory().getStreetList()) {
            Object[] row = new Object[2];
            row[0] = street.getId();
            row[1] = street.getName();
            model.addRow(row);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jSeparator1 = new javax.swing.JSeparator();
        txtStreetName = new javax.swing.JTextField();
        lblStreet = new javax.swing.JLabel();
        btnAddStreet = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblStreet = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));
        setEnabled(false);

        jDesktopPane1.setBackground(new java.awt.Color(255, 255, 255));
        jDesktopPane1.setEnabled(false);

        txtStreetName.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtStreetName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStreetNameActionPerformed(evt);
            }
        });

        lblStreet.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lblStreet.setText("Street Name");

        btnAddStreet.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btnAddStreet.setText("Add Street");
        btnAddStreet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddStreetActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel2.setText("         Street Details");

        btnBack.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnBack.setIcon(new javax.swing.ImageIcon("C:\\Users\\Mugdha\\Documents\\NetBeansProjects\\Final Project\\src\\UserInterface\\Back.png")); // NOI18N
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        tblStreet.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        tblStreet.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Street Name"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblStreet);

        jDesktopPane1.setLayer(jSeparator1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(txtStreetName, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(lblStreet, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(btnAddStreet, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(btnBack, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(329, 329, 329)
                        .addComponent(lblStreet, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtStreetName, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnAddStreet, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGap(369, 369, 369)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 556, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGap(542, 542, 542)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(449, Short.MAX_VALUE))
        );

        jDesktopPane1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnAddStreet, txtStreetName});

        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtStreetName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblStreet)
                            .addComponent(btnAddStreet)))
                    .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(72, 72, 72)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(200, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jDesktopPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddStreetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddStreetActionPerformed
        // TODO add your handling code here:
        try {
            
        } catch (Exception e) {
        }
        String name = txtStreetName.getText();
        int count = 0;

        if(txtStreetName.getText().isEmpty()){
         JOptionPane.showMessageDialog(null, "Fields can't be emptys", "Error", JOptionPane.ERROR_MESSAGE);
  
        }
        else if (organization.getStreetDirectory().getStreetList().isEmpty()) {
            organization.getStreetDirectory().createAndAddStreet(name);

            JOptionPane.showMessageDialog(null, "Street Information successfully added!", "Information", JOptionPane.INFORMATION_MESSAGE);
            txtStreetName.setText(null);

            populateTable();
            txtStreetName.setText("");
        } else {
            try {

                for (Street s : organization.getStreetDirectory().getStreetList()) {
                    if (s.getName().equalsIgnoreCase(name)) {
                        count++;
                    }
                }
                if (count == 0) {

                    organization.getStreetDirectory().createAndAddStreet(name);

                    JOptionPane.showMessageDialog(null, "Street Information successfully added!", "Information", JOptionPane.INFORMATION_MESSAGE);
                    txtStreetName.setText(null);

                    populateTable();
                    txtStreetName.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, "Street name already exists", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (Exception e) {

            }
        }
    }//GEN-LAST:event_btnAddStreetActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed

    private void txtStreetNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStreetNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStreetNameActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddStreet;
    private javax.swing.JButton btnBack;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblStreet;
    private javax.swing.JTable tblStreet;
    private javax.swing.JTextField txtStreetName;
    // End of variables declaration//GEN-END:variables
}
