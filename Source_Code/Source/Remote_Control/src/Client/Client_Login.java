
package Client;

import java.net.Socket;
import javax.swing.*;
import java.io.*;

public class Client_Login extends javax.swing.JFrame {
    
    Socket socket = null; 
    
    String HostIP ;
    String Port ;
    JFrame frame = new JFrame();
   
    public Client_Login() {
        initComponents();
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtHostIP = new javax.swing.JTextField();
        txtPort = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btnConnect = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

        jLabel6.setText("jLabel6");

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Client/BackGroun.jpg"))); // NOI18N
        jLabel4.setText("LOGIN");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Remote Control - Client");
        setBackground(new java.awt.Color(255, 51, 51));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 0));
        jLabel1.setText("              CONNECT TO SERVER");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, 360, 50));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 53, 394, 14));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Client/server.jpg"))); // NOI18N
        jLabel2.setText("   HOST IP :");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, 50));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Client/Porticon.png"))); // NOI18N
        jLabel3.setText("    PORT :");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 120, 40));

        txtHostIP.setBackground(new java.awt.Color(204, 204, 204));
        txtHostIP.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        getContentPane().add(txtHostIP, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, 243, 41));

        txtPort.setBackground(new java.awt.Color(204, 204, 204));
        txtPort.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        getContentPane().add(txtPort, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, 240, 46));
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, -1, -1));

        btnConnect.setBackground(new java.awt.Color(204, 204, 204));
        btnConnect.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnConnect.setForeground(new java.awt.Color(51, 51, 255));
        btnConnect.setText("CONNECT");
        btnConnect.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnConnect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConnectActionPerformed(evt);
            }
        });
        getContentPane().add(btnConnect, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 200, 140, 30));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Client/BackGroun.jpg"))); // NOI18N
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 410, 260));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnConnectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConnectActionPerformed
        
        HostIP = txtHostIP.getText();
        Port =txtPort.getText();
        
        if (HostIP.isEmpty())
        {
         JOptionPane.showMessageDialog(frame,"HOST IP is invalid.","ERROR",JOptionPane.ERROR_MESSAGE);
        }
        
        else if (Port.isEmpty())
        {
         JOptionPane.showMessageDialog(frame,"Port is invalid.","ERROR",JOptionPane.ERROR_MESSAGE);   
        }
        
        else 
        {
            try {
                
                int port =Integer.parseInt(Port);
                
                
                
                Client_FunctionBoard functionBoard = new Client_FunctionBoard(HostIP,Port);
                
                functionBoard.setVisible(true);
                
                this.dispose();
                
                
              JOptionPane.showMessageDialog(frame,"Connecting to Server successfully.","SUCESSFULL",JOptionPane.INFORMATION_MESSAGE);
                
            }catch (IOException ex) {
                
               JOptionPane.showMessageDialog(frame,"Connected Failed.","FAIL",JOptionPane.WARNING_MESSAGE);
            }
 
            
        }
    }//GEN-LAST:event_btnConnectActionPerformed

    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Client_Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConnect;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField txtHostIP;
    private javax.swing.JTextField txtPort;
    // End of variables declaration//GEN-END:variables
}
