package UserInterface;

import Business.Queue;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class DeclareTimeJPanel extends javax.swing.JPanel {

    public Queue servletQueue;
    public JPanel userProcessContainer;
    int lower;
    int upper;

    public DeclareTimeJPanel(Queue sq, JPanel upc) {
        initComponents();
        this.servletQueue = sq;
        this.userProcessContainer = upc;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        time = new javax.swing.JLabel();
        txtTime = new javax.swing.JTextField();
        btnSubmit = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtLower = new javax.swing.JTextField();
        txtUpper = new javax.swing.JTextField();
        lblLower = new javax.swing.JLabel();
        lblUpper = new javax.swing.JLabel();

        time.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        time.setText("Enter 'n' (time): ");

        txtTime.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N

        btnSubmit.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnSubmit.setText("Submit");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setText("Dequeue Limit");

        txtLower.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        txtLower.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLowerActionPerformed(evt);
            }
        });

        txtUpper.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N

        lblLower.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblLower.setText("Lower");

        lblUpper.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblUpper.setText("Upper");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(138, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(time))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtTime)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtLower, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(51, 51, 51)
                                        .addComponent(txtUpper, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(110, 110, 110))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblLower)
                        .addGap(68, 68, 68)
                        .addComponent(lblUpper)
                        .addGap(120, 120, 120))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(156, 156, 156)
                        .addComponent(lblUpper))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(time)
                            .addComponent(txtTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addComponent(lblLower)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtLower, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtUpper, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))))
                .addGap(31, 31, 31)
                .addComponent(btnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(162, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        // TODO add your handling code here:   
        
        lower = Integer.parseInt(txtLower.getText());
        upper = Integer.parseInt(txtUpper.getText());

        if (txtTime.getText().matches("")||txtLower.getText().matches("")||lblUpper.getText().matches("")) {
            JOptionPane.showMessageDialog(null, "Please enter a valid details!", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            int time = Integer.parseInt(txtTime.getText());
            if ((time <= 0) || (lower <= 0) || (upper <= 0) || (upper == time)) {
                JOptionPane.showMessageDialog(null, "Wrong numbers entered!", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                CardLayout layout = (CardLayout) userProcessContainer.getLayout();
                StartProcessJPanel spjp = new StartProcessJPanel(servletQueue, time, userProcessContainer, lower, upper);
                userProcessContainer.add("Start Process", spjp);
                layout.next(userProcessContainer);
            }
        }
    }//GEN-LAST:event_btnSubmitActionPerformed

    private void txtLowerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLowerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLowerActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSubmit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblLower;
    private javax.swing.JLabel lblUpper;
    private javax.swing.JLabel time;
    private javax.swing.JTextField txtLower;
    private javax.swing.JTextField txtTime;
    private javax.swing.JTextField txtUpper;
    // End of variables declaration//GEN-END:variables
}
