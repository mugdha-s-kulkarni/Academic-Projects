/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.SnowPlowRole;

import Business.Employee.User;
import Business.Enterprise.Enterprise;
import Business.Measurements.Measurement;
import Business.Organization.CleaningOrganization;
import Business.Organization.Organization;
import Business.Organization.SnowPlowOrganization;
import Business.Sensors.Sensor;
import Business.Streets.Street;
import Business.UserAccount.UserAccount;
import Business.Validations.MyBlankSpaceVerifier;
import Business.Validations.MyNameVerifier;
import Business.WorkQueue.ReportCleaningWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Mugdha
 */
public class ReportCleaningJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ReportCleaningJPanel
     */
    private JPanel userProcessContainer;
    private UserAccount userAccount;
    private SnowPlowOrganization organization;
    private Enterprise enterprise;

    public ReportCleaningJPanel(JPanel userProcessContainer, UserAccount account, SnowPlowOrganization organization, Enterprise enterprise) {
        initComponents();

        this.userProcessContainer = userProcessContainer;
        this.userAccount = account;
        this.organization = organization;
        this.enterprise = enterprise;

        MyNameVerifier myNameVerifier = new MyNameVerifier();
        txtMessage.setInputVerifier(myNameVerifier);

        MyBlankSpaceVerifier mbv = new MyBlankSpaceVerifier();
        txtMessage.setInputVerifier(mbv);

        populateSensorDetailsTable();
        populateReportingTable();

    }

    public void populateSensorDetailsTable() {
        tblSensorDetails.removeAll();
        DefaultTableModel model = (DefaultTableModel) tblSensorDetails.getModel();
        model.setRowCount(0);
        int h = 0;

        for (Street street : organization.getStreetDirectory().getStreetList()) {
            for (Sensor sensor : street.getSensorDirectory().getSensorList()) {
                for (Measurement m : sensor.getMeaurementHistory().getMeasurementList()) {

                    Object[] row = new Object[5];
                    row[0] = street;
                    row[1] = sensor;
                    row[2] = m.getSnowHeight();
                    h = m.getSnowHeight();

                    row[3] = m.getSensedDate();

                    row[4] = m.getStatus();
                    model.addRow(row);
                }
            }
        }
    }

    public void populateReportingTable() {
        DefaultTableModel model = (DefaultTableModel) tblReporting.getModel();

        model.setRowCount(0);
        for (WorkRequest request : organization.getWorkQueue().getWorkRequestList()) {
            Object[] row = new Object[6];

            row[0] = ((ReportCleaningWorkRequest) request).getStreet();
            row[1] = ((ReportCleaningWorkRequest) request).getSensor();
            row[2] = ((ReportCleaningWorkRequest) request).getSnowHeight();
            row[3] = ((ReportCleaningWorkRequest) request).getDate();

            String status = ((ReportCleaningWorkRequest) request).getStatus();
            row[4] = status == null ? "Waiting" : status;

            if (request.getSender().getEmployee() instanceof User) {
                row[5] = request.getMessage() + "-User Request";
            } else {
                row[5] = request.getMessage() + "-ISP Request";
            }
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
        lblMsg = new javax.swing.JLabel();
        btnReport = new javax.swing.JButton();
        txtMessage = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSensorDetails = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblReporting = new javax.swing.JTable();
        btnBack = new javax.swing.JButton();

        jDesktopPane1.setBackground(new java.awt.Color(255, 255, 255));
        jDesktopPane1.setEnabled(false);

        lblMsg.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lblMsg.setText("Message:");

        btnReport.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnReport.setText("Report Cleaning ");
        btnReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReportActionPerformed(evt);
            }
        });

        txtMessage.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        txtMessage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMessageActionPerformed(evt);
            }
        });

        tblSensorDetails.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        tblSensorDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Street", "Sensor Area", "Snow Height", "Sensed Time", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblSensorDetails);

        tblReporting.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        tblReporting.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Street", "Sensor Area", "Snow Height", "Sensed Time", "Status", "Message"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblReporting);

        btnBack.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnBack.setIcon(new javax.swing.ImageIcon("C:\\Users\\Mugdha\\Documents\\NetBeansProjects\\Final Project\\src\\UserInterface\\Back.png")); // NOI18N
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        jDesktopPane1.setLayer(lblMsg, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(btnReport, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(txtMessage, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jScrollPane2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(btnBack, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGap(133, 133, 133)
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGap(234, 234, 234)
                        .addComponent(lblMsg)
                        .addGap(18, 18, 18)
                        .addComponent(txtMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnReport, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(193, Short.MAX_VALUE))
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMsg)
                    .addComponent(txtMessage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReport))
                .addGap(56, 56, 56)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(78, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jDesktopPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jDesktopPane1)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportActionPerformed

        try {
            
        
        int selectedRow = tblSensorDetails.getSelectedRow();
        Street selectedStreet;
        Sensor selectedSensor;
        int sh;
        Date date;
        String status;

        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Select a row", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        } else {
            selectedStreet = (Street) tblSensorDetails.getValueAt(selectedRow, 0);
            selectedSensor = (Sensor) tblSensorDetails.getValueAt(selectedRow, 1);
            sh = (int) tblSensorDetails.getValueAt(selectedRow, 2);
            date = (Date) tblSensorDetails.getValueAt(selectedRow, 3);
            status = (String) tblSensorDetails.getValueAt(selectedRow, 4);
            tblSensorDetails.setValueAt("Reported", selectedRow, 4);
        }
        int count = 0;
        for (WorkRequest req : organization.getWorkQueue().getWorkRequestList()) {
            ReportCleaningWorkRequest r1 = (ReportCleaningWorkRequest) req;
            if (r1.getStreet().equals(selectedStreet) && r1.getSensor().equals(selectedSensor) && r1.getDate().equals(date)) {
                count++;
            }
        }

        if (count == 0) {
            ReportCleaningWorkRequest request = new ReportCleaningWorkRequest();

            request.setStreet(selectedStreet);
            request.setSensor(selectedSensor);
            request.setSnowHeight(sh);
            request.setDate(date);
            request.setStatus(status);

            String message = txtMessage.getText();
            request.setMessage(message);

            request.setSender(userAccount);
            request.setStatus("Sent");

            Organization org = null;
            for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
                if (organization instanceof CleaningOrganization) {
                    org = organization;
                    break;
                }
            }
            if (message.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Message can't be empty", "Error", JOptionPane.ERROR_MESSAGE);
            } else if (org != null && !message.isEmpty()) {

                int reply = JOptionPane.showConfirmDialog(null, "Is this the latest sensed temperature?", "Question", JOptionPane.YES_NO_OPTION);
                if (reply == JOptionPane.YES_OPTION) {
                    org.getWorkQueue().getWorkRequestList().add(request);
                    organization.getWorkQueue().getWorkRequestList().add(request);
                    JOptionPane.showMessageDialog(null, "Reported successfully!", "Information", JOptionPane.INFORMATION_MESSAGE);
                    populateReportingTable();

                    txtMessage.setText("");
                }
                int c = 0;

                for (Street street : organization.getStreetDirectory().getStreetList()) {
                    for (Sensor sensor : street.getSensorDirectory().getSensorList()) {
                        for (Measurement m : sensor.getMeaurementHistory().getMeasurementList()) {

                            if (request.getStreet().equals(street) && request.getSensor().equals(sensor) && request.getDate().equals(m.getSensedDate())) {
                                c++;
                            }

                            if (c == 0) {
                                m.setStatus("Reported");
                            } else {
                                m.setStatus("Sensed");
                            }
                        }
                    }
                }

            }
        } else {
            JOptionPane.showMessageDialog(null, "This request has already been reported");
        }
        } catch (Exception e) {
        }


    }//GEN-LAST:event_btnReportActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed

    private void txtMessageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMessageActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMessageActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnReport;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblMsg;
    private javax.swing.JTable tblReporting;
    private javax.swing.JTable tblSensorDetails;
    private javax.swing.JTextField txtMessage;
    // End of variables declaration//GEN-END:variables
}
