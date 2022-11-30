
package Start;

import Client.Client_Login;


public class Start_Remote_Control extends javax.swing.JFrame {

    
    public Start_Remote_Control() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        btnServer = new javax.swing.JButton();
        btnClient = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Start/BackGroun.jpg"))); // NOI18N

        jLabel6.setText("jLabel6");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Start/BackGroun.jpg"))); // NOI18N

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Start/BackGroun.jpg"))); // NOI18N

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Start/BackGroun.jpg"))); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Remote Control");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 102, 102));
        jLabel1.setText("WELCOME TO REMOTE CONTROL");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, 260, 40));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 390, 0));

        btnServer.setBackground(new java.awt.Color(204, 204, 204));
        btnServer.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnServer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Start/server.jpg"))); // NOI18N
        btnServer.setText(" SERVER");
        btnServer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnServerActionPerformed(evt);
            }
        });
        getContentPane().add(btnServer, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 150, 57));

        btnClient.setBackground(new java.awt.Color(204, 204, 204));
        btnClient.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnClient.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Start/logoClient.png"))); // NOI18N
        btnClient.setText("CLIENT");
        btnClient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClientActionPerformed(evt);
            }
        });
        getContentPane().add(btnClient, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 150, 166, -1));
        btnClient.getAccessibleContext().setAccessibleName("");

        getContentPane().add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 400, 10));
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, -1, 70));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(153, 255, 255));
        jLabel9.setText("            FIT@HCMUS.EDU");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 220, 20));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Start/BackGroun.jpg"))); // NOI18N
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 250));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnClientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClientActionPerformed
       
       Login_APP loginApp = new Login_APP();
       loginApp.setVisible(true);
       this.dispose();
       
    }//GEN-LAST:event_btnClientActionPerformed

    private void btnServerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnServerActionPerformed
        Login_APP_Server loginApp = new Login_APP_Server();
       loginApp.setVisible(true);
       this.dispose();
    }//GEN-LAST:event_btnServerActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new Start_Remote_Control().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClient;
    private javax.swing.JButton btnServer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    // End of variables declaration//GEN-END:variables
}
