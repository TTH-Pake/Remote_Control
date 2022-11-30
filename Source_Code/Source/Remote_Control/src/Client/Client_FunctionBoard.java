
package Client;

import java.net.Socket;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Client_FunctionBoard extends javax.swing.JFrame {

    String HOSTIP;
    String PORT ;
    Socket sending = null ;
    DataInputStream dataInput = null;
    DataOutputStream dataOutput = null;
    
    Process process = null;
    Screen_Shot screen = null;
    AppRunning app = null;
    Keystroke keystroke = null;

    public Client_FunctionBoard() {
        this.sending = null;
        initComponents();
    }

    public Client_FunctionBoard(String HOSTIP, String PORT) throws IOException {
 
        initComponents();
        this.HOSTIP = HOSTIP;
        this.PORT = PORT;
        
        txtHost.setText(HOSTIP);
        txtPort.setText(PORT);
        
        int port = Integer.parseInt(PORT);
        sending = new Socket(HOSTIP,port);
        dataInput = new DataInputStream(sending.getInputStream());
        dataOutput = new DataOutputStream(sending.getOutputStream());
        
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        btnProcess = new javax.swing.JButton();
        btnAppRunning = new javax.swing.JButton();
        btnScreenShot = new javax.swing.JButton();
        btnKeyStroke = new javax.swing.JButton();
        btnShutDown = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtHost = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtPort = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        jLabel3.setText("jLabel3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Remote Control - Client");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(102, 204, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 204, 204));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Client/Setting.png"))); // NOI18N
        jLabel1.setText("FUNCTION");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 60, -1, 50));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 56, 572, -1));

        btnProcess.setBackground(new java.awt.Color(204, 204, 204));
        btnProcess.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnProcess.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Client/AppProcess.png"))); // NOI18N
        btnProcess.setText("Processing Running");
        btnProcess.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnProcess.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnProcess.setDisabledIcon(null);
        btnProcess.setDisabledSelectedIcon(null);
        btnProcess.setMaximumSize(new java.awt.Dimension(100, 34));
        btnProcess.setMinimumSize(new java.awt.Dimension(100, 34));
        btnProcess.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProcessActionPerformed(evt);
            }
        });
        getContentPane().add(btnProcess, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 150, 47));

        btnAppRunning.setBackground(new java.awt.Color(204, 204, 204));
        btnAppRunning.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnAppRunning.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Client/Application.png"))); // NOI18N
        btnAppRunning.setText("App Running");
        btnAppRunning.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnAppRunning.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnAppRunning.setDisabledIcon(null);
        btnAppRunning.setDisabledSelectedIcon(null);
        btnAppRunning.setMaximumSize(new java.awt.Dimension(100, 34));
        btnAppRunning.setMinimumSize(new java.awt.Dimension(100, 34));
        btnAppRunning.setPreferredSize(new java.awt.Dimension(148, 34));
        btnAppRunning.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAppRunningActionPerformed(evt);
            }
        });
        getContentPane().add(btnAppRunning, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 130, 150, 47));

        btnScreenShot.setBackground(new java.awt.Color(204, 204, 204));
        btnScreenShot.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnScreenShot.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Client/screenshot.jpg"))); // NOI18N
        btnScreenShot.setText("Screen Shot");
        btnScreenShot.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnScreenShot.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnScreenShot.setDisabledIcon(null);
        btnScreenShot.setDisabledSelectedIcon(null);
        btnScreenShot.setPreferredSize(new java.awt.Dimension(148, 34));
        btnScreenShot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnScreenShotActionPerformed(evt);
            }
        });
        getContentPane().add(btnScreenShot, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 130, 150, 47));

        btnKeyStroke.setBackground(new java.awt.Color(204, 204, 204));
        btnKeyStroke.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnKeyStroke.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Client/KeyStroke.png"))); // NOI18N
        btnKeyStroke.setText("Key Stroke");
        btnKeyStroke.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnKeyStroke.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnKeyStroke.setDisabledIcon(null);
        btnKeyStroke.setDisabledSelectedIcon(null);
        btnKeyStroke.setMaximumSize(new java.awt.Dimension(100, 34));
        btnKeyStroke.setMinimumSize(new java.awt.Dimension(100, 34));
        btnKeyStroke.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKeyStrokeActionPerformed(evt);
            }
        });
        getContentPane().add(btnKeyStroke, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 150, 47));

        btnShutDown.setBackground(new java.awt.Color(204, 204, 204));
        btnShutDown.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnShutDown.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Client/Shutdown.png"))); // NOI18N
        btnShutDown.setText("Shut Down");
        btnShutDown.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnShutDown.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnShutDown.setDisabledIcon(null);
        btnShutDown.setDisabledSelectedIcon(null);
        btnShutDown.setMaximumSize(new java.awt.Dimension(100, 34));
        btnShutDown.setMinimumSize(new java.awt.Dimension(100, 34));
        btnShutDown.setPreferredSize(new java.awt.Dimension(148, 34));
        btnShutDown.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShutDownActionPerformed(evt);
            }
        });
        getContentPane().add(btnShutDown, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 230, 150, 47));

        btnExit.setBackground(new java.awt.Color(204, 204, 204));
        btnExit.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Client/Shutdown.png"))); // NOI18N
        btnExit.setText("Exit");
        btnExit.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnExit.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnExit.setDisabledIcon(null);
        btnExit.setDisabledSelectedIcon(null);
        btnExit.setMaximumSize(new java.awt.Dimension(100, 34));
        btnExit.setMinimumSize(new java.awt.Dimension(100, 34));
        btnExit.setPreferredSize(new java.awt.Dimension(148, 34));
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });
        getContentPane().add(btnExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 230, 150, 47));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 255, 255));
        jLabel4.setText("HOST :");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 40, -1));

        txtHost.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtHost.setForeground(new java.awt.Color(255, 51, 51));
        getContentPane().add(txtHost, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 160, 30));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(153, 255, 255));
        jLabel5.setText("PORT :");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 20, 50, -1));

        txtPort.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtPort.setForeground(new java.awt.Color(255, 51, 51));
        getContentPane().add(txtPort, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 10, 90, 30));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Client/BackGroun.jpg"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 560, 310));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnShutDownActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShutDownActionPerformed
       
        try {
             
            String request = "SHUT DOWN";
            dataOutput.writeUTF(request);
            dataOutput.flush();
            
        } catch (IOException ex) {
            Logger.getLogger(Client_FunctionBoard.class.getName()).log(Level.SEVERE, null, ex);
        }   
        
        
       
    }//GEN-LAST:event_btnShutDownActionPerformed

    private void btnProcessActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProcessActionPerformed
         
        try {
            
            if (process != null && process.isVisible())
            {                  
                return;                
            }            
            
            dataOutput.writeUTF("PROCESS");
            dataOutput.flush();
            process = new Process(this, true, sending); 
            process.setLocationRelativeTo(null);
            process.setVisible(true);
            
        } catch (IOException ex) {
            Logger.getLogger(Client_FunctionBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
         
    }//GEN-LAST:event_btnProcessActionPerformed

    private void btnScreenShotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnScreenShotActionPerformed
       
            
            screen = new Screen_Shot(HOSTIP,sending);
            screen.setVisible(true);
            
            
        
    }//GEN-LAST:event_btnScreenShotActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        try {
            dataOutput.writeUTF("EXIT");
            dataOutput.flush();
            System.exit(0);
        } catch (IOException ex) {
            Logger.getLogger(Client_FunctionBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnExitActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        try {
            dataOutput.writeUTF("EXIT");
            dataOutput.flush();
        } catch (IOException ex) {
            Logger.getLogger(Client_FunctionBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formWindowClosing

    private void btnAppRunningActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAppRunningActionPerformed
        try {
            if (app != null && app.isVisible())
            {                  
                return;                
            }            
            dataOutput.writeUTF("AppRunning");
            dataOutput.flush();
            app = new AppRunning(this, true, sending); 
            app.setLocationRelativeTo(null);
            app.setVisible(true);
            
        } catch (IOException ex) {
            Logger.getLogger(Client_FunctionBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAppRunningActionPerformed

    private void btnKeyStrokeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKeyStrokeActionPerformed
         try {
           if (keystroke != null && keystroke.isVisible())
           {                  
               return;                
           }        
           
           String request = "KEY STROKES";
           dataOutput.writeUTF(request);
           dataOutput.flush();
           
           keystroke = new Keystroke(sending);
           keystroke.setLocationRelativeTo(null);
           keystroke.setVisible(true);
           
           
        } catch (IOException ex) {
            Logger.getLogger(Client_FunctionBoard.class.getName()).log(Level.SEVERE, null, ex);
        }         
    }//GEN-LAST:event_btnKeyStrokeActionPerformed

   
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(() -> {
            new Client_FunctionBoard().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAppRunning;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnKeyStroke;
    private javax.swing.JButton btnProcess;
    private javax.swing.JButton btnScreenShot;
    private javax.swing.JButton btnShutDown;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField txtHost;
    private javax.swing.JTextField txtPort;
    // End of variables declaration//GEN-END:variables
}
