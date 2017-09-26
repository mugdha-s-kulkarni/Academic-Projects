package UserInterface;

import Business.DequeueTimer;
import Business.EnqueueTimer;
import Business.HttpRequest;
import Business.Queue;
import java.awt.CardLayout;
import java.util.ArrayList;
import java.util.Timer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Mugdha
 */
public class StartProcessJPanel extends javax.swing.JPanel {

    public int time;
    public JPanel userProcessContainer;
    public Queue servletQueue;
    ArrayList<HttpRequest> requestList;
    int lower;
    int upper;
    int totalReq=0;

    public StartProcessJPanel(Queue sq, int t, JPanel upc, int l, int u) {
        initComponents();
        this.servletQueue = sq;
        this.time = t;
        this.userProcessContainer = upc;
        this.lower = l;
        this.upper = u;
        requestList = new ArrayList<>();
        btnAnalysis.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnStart = new javax.swing.JButton();
        btnAnalysis = new javax.swing.JButton();
        lblMsg = new javax.swing.JLabel();

        btnStart.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnStart.setText("Start Process");
        btnStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartActionPerformed(evt);
            }
        });

        btnAnalysis.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnAnalysis.setText("Show Analysis");
        btnAnalysis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnalysisActionPerformed(evt);
            }
        });

        lblMsg.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblMsg, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(200, 200, 200)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnAnalysis, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnStart, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(227, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(lblMsg, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnStart, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(btnAnalysis, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(162, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartActionPerformed

        Timer t2 = new Timer();
        t2.schedule(new DequeueTimer(t2, time, servletQueue, requestList, lower, upper), 0, 1000);

        Timer t1 = new Timer();
        t1.scheduleAtFixedRate(new EnqueueTimer(t1, time, servletQueue,totalReq), 0, 1000);

        try {
            Thread.sleep(time * 1000);
            btnAnalysis.setEnabled(true);
            lblMsg.setText("Requests Processed");
        } catch (InterruptedException ex) {
            Logger.getLogger(StartProcessJPanel.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnStartActionPerformed

    private void btnAnalysisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnalysisActionPerformed

        long total = 0;
        String avg = null;
        long max = Integer.MIN_VALUE;
        int size = requestList.size();

        for (HttpRequest req : requestList) {
            if (req.getWaitingTime() > max) {
                max = req.getWaitingTime();
            }
        }

        for (HttpRequest req : requestList) {
            total = total + req.getWaitingTime();
        }

        try {
            avg = String.valueOf(total / size);   
        } catch (Exception e) {
          JOptionPane.showMessageDialog(null, "Error!", "Error", JOptionPane.ERROR_MESSAGE);

        }             
        
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        StatisticsJPanel sjp = new StatisticsJPanel(avg, max, size, this.totalReq);
        userProcessContainer.add("Start Process", sjp);
        layout.next(userProcessContainer);

    }//GEN-LAST:event_btnAnalysisActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnalysis;
    private javax.swing.JButton btnStart;
    private javax.swing.JLabel lblMsg;
    // End of variables declaration//GEN-END:variables
}
