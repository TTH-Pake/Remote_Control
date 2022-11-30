package Server;

import java.awt.AWTException;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class Server_Connect extends javax.swing.JFrame {

    ServerSocket server = null;
    DataInputStream dataInput = null;
    DataOutputStream dataOutput = null;
    JFrame frame = new JFrame();
    Socket sending = null;
    String HOSTIP;
    public Server_Connect() {
        initComponents();

    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtPort = new javax.swing.JTextField();
        btnCreate = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtHost = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Server/backgorundLogin.jpg"))); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Remote Control_Sever");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Server/logoClient.png"))); // NOI18N
        jLabel1.setText("     PORT :");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 130, 37));

        txtPort.setBackground(new java.awt.Color(204, 204, 204));
        txtPort.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        getContentPane().add(txtPort, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 130, 200, 40));

        btnCreate.setBackground(new java.awt.Color(51, 153, 255));
        btnCreate.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnCreate.setText("CREATE");
        btnCreate.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });
        getContentPane().add(btnCreate, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 200, 80, 30));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(153, 255, 255));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Server/Application.png"))); // NOI18N
        jLabel4.setText("  HOST IP :");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 140, 50));

        txtHost.setBackground(new java.awt.Color(204, 204, 204));
        txtHost.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        getContentPane().add(txtHost, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 70, 200, 40));

        jLabel5.setBackground(new java.awt.Color(204, 204, 204));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("CREATE PORT");
        jLabel5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, 260, 50));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Server/BG_Pro.jpg"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 450, 270));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
        
        String PORT = txtPort.getText();
        HOSTIP = txtHost.getText();
        if (PORT.isEmpty())
        {
         JOptionPane.showMessageDialog(frame,"Port is invalid.","ERROR",JOptionPane.ERROR_MESSAGE);   
        }
        else{
            
            try {
                int port = Integer.parseInt(PORT);
                server  = new ServerSocket(port);
                sending = server.accept();
                //this.hide();
                while(true){
                
                
                dataInput = new DataInputStream(sending.getInputStream());
                dataOutput = new DataOutputStream(sending.getOutputStream());
                
                String request = dataInput.readUTF();
                
                Run_Function(request);
                }
                
            } catch (IOException ex) {
                Logger.getLogger(Server_Connect.class.getName()).log(Level.SEVERE, null, ex);
            } catch (AWTException ex) {
                Logger.getLogger(Server_Connect.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
            
        
    }//GEN-LAST:event_btnCreateActionPerformed

    public void Run_Function(String request) throws IOException, AWTException
    {
        if(request.equals("SHUT DOWN"))
                {
                    ActiveServer active_server = new ActiveServer(HOSTIP,sending);
                    
                    int confirm = JOptionPane.showConfirmDialog(this,"Do you want shut down your PC ? ","Comfirm",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
                    
                    if(confirm == JOptionPane.YES_OPTION)
                    {
                        active_server.shutdown();
                    }
                    
                }
        if(request.equals("PROCESS"))
                    {
                        ActiveServer active_server = new ActiveServer(HOSTIP,sending);
                        active_server.process();
                    }
        if(request.equals("AppRunning"))
                    {
                        ActiveServer active_server = new ActiveServer(sending);
                        
                        active_server.apprunning();
                    }
        if(request.equals("SCREEN SHOT"))
                    {
            try {
                
                ActiveServer active_server = new ActiveServer(HOSTIP,sending);
                active_server.ScreenShot();
                
                } catch (InterruptedException ex) {
                Logger.getLogger(Server_Connect.class.getName()).log(Level.SEVERE, null, ex);
                                                   }
                          
                  }
        if(request.equals("KEY STROKES"))
                    {
                        ActiveServer active_server = new ActiveServer(sending);
                        active_server.keystrokes();
                    }
        if(request.equals("EXIT"))
                    {
                        ActiveServer active_server = new ActiveServer(HOSTIP,sending);
                        active_server.exit();
                    }
      
    }
    
    public static void main(String args[]) {
      
        java.awt.EventQueue.invokeLater(new RunnableImpl());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCreate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField txtHost;
    private javax.swing.JTextField txtPort;
    // End of variables declaration//GEN-END:variables

    private static class RunnableImpl implements Runnable {

        public RunnableImpl() {
        }

        @Override
        public void run() {
            new Server_Connect().setVisible(true);
        }
    }
}
