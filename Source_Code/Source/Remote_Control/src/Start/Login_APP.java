
package Start;

import Client.Client_Login;
import java.util.Arrays;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Login_APP extends javax.swing.JFrame {
    
    String USER = "ADMIN";
    char[] PASSWORD ={'1'};

    String userInput;
    char passwordInput[];
    
    JFrame controllingPassword = new JFrame();
    
    
    public Login_APP() {
        initComponents();
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnLogin = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtUser = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnLogin.setBackground(new java.awt.Color(51, 102, 255));
        btnLogin.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnLogin.setForeground(new java.awt.Color(255, 255, 255));
        btnLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Start/loginicon.jpg"))); // NOI18N
        btnLogin.setText("LOG IN");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        getContentPane().add(btnLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 180, -1, -1));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Start/server.jpg"))); // NOI18N
        jLabel1.setText("USER :");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 71, 101, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Start/KeyStroke.png"))); // NOI18N
        jLabel2.setText("PASSWORD :");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, -1, -1));

        jLabel3.setBackground(new java.awt.Color(204, 204, 204));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 255, 255));
        jLabel3.setText("     LOGIN");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(148, 6, 88, -1));

        txtUser.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        getContentPane().add(txtUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(195, 77, 180, -1));

        txtPassword.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        getContentPane().add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(195, 130, 180, -1));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 31, 419, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Start/backgorundLogin.jpg"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 420, 260));

        getAccessibleContext().setAccessibleName("Login");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        
        userInput = txtUser.getText();
        passwordInput = txtPassword.getPassword();
           
            if(isPasswordCorrect(passwordInput,PASSWORD) && userInput.equals(USER))
           {
        
            JOptionPane.showMessageDialog(controllingPassword,"Login successfully.","Successfull",JOptionPane.INFORMATION_MESSAGE);
            
            Client_Login Login = new Client_Login();
            Login.setVisible(true);
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
                new Login_APP().setVisible(true);
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
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}
