package Start;

import Server.Server_Connect;
import java.util.Arrays;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class Login_APP_Server extends javax.swing.JFrame {

    String USER = "ADMIN";
    char[] PASSWORD ={'1'};

    String userInput;
    char passwordInput[];
    
    JFrame controllingPassword ;
    
    public Login_APP_Server() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnLogin = new javax.swing.JButton();
        txtUser = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("LOGIN");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 255, 255));
        jLabel1.setText("     LOGIN");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(145, 0, 95, 31));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(101, 37, 299, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Start/server.jpg"))); // NOI18N
        jLabel2.setText("USER :");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 123, 40));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Start/KeyStroke.png"))); // NOI18N
        jLabel3.setText("PASSWORD :");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 147, 40));

        btnLogin.setBackground(new java.awt.Color(0, 102, 255));
        btnLogin.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Start/loginicon.jpg"))); // NOI18N
        btnLogin.setText("Login");
        btnLogin.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        getContentPane().add(btnLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 230, 119, 31));

        txtUser.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        getContentPane().add(txtUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 90, 229, 40));

        txtPassword.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        getContentPane().add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 170, 230, 40));
        getContentPane().add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 400, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Start/BackGroun.jpg"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 300));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        userInput = txtUser.getText();
        passwordInput = txtPassword.getPassword();
           
            if(isPasswordCorrect(passwordInput,PASSWORD) && userInput.equals(USER))
           {
        
            JOptionPane.showMessageDialog(controllingPassword,"Login successfully.","Successfull",JOptionPane.INFORMATION_MESSAGE);
            
            Server_Connect server_connect = new Server_Connect();
            server_connect.setVisible(true);
            this.dispose();
            
            
            }
            else 
           {
               
            JOptionPane.showMessageDialog(controllingPassword,"Invalid password or name  user     .","FAIL",JOptionPane.ERROR_MESSAGE);
             
           }
    }//GEN-LAST:event_btnLoginActionPerformed

   public  static boolean isPasswordCorrect(char[] passwordInput,char[] PASSWORD)
    {
        boolean isCorrect = true;
        if(passwordInput.length!= PASSWORD.length)
        {
            return false ;
        }
        else 
        {
              isCorrect = Arrays.equals(passwordInput,PASSWORD);
              
              return isCorrect ;
        }
    }
   
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login_APP_Server().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}
