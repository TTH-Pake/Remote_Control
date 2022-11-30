
package Client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JOptionPane;


public class EndApp extends javax.swing.JDialog{

   Socket sending = null;
    DataOutputStream dataOutput = null;
    DataInputStream dataInput = null;
    public EndApp(JDialog owner, boolean modal, Socket socket) throws IOException{
        super(owner, modal);
        sending = socket;
        dataOutput = new DataOutputStream(sending.getOutputStream());
        dataInput = new DataInputStream(sending.getInputStream());
        initComponents();
    }

    private EndApp() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtID = new javax.swing.JTextField();
        btnEndtask = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtID.setBackground(new java.awt.Color(204, 204, 204));
        txtID.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtID.setText("Input ID :");
        getContentPane().add(txtID, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 30, 190, 30));

        btnEndtask.setBackground(new java.awt.Color(204, 204, 204));
        btnEndtask.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnEndtask.setForeground(new java.awt.Color(102, 102, 255));
        btnEndtask.setText("End App");
        btnEndtask.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEndtaskActionPerformed(evt);
            }
        });
        getContentPane().add(btnEndtask, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 30, -1, 30));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 255, 255));
        jLabel2.setText("  KILL APP ");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 0, 80, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Client/BG_Pro.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 330, 80));

        pack();
    }// </editor-fold>//GEN-END:initComponents

      public boolean isNumeric(final CharSequence cs) {
        if (cs.isEmpty()) {
            return false;
        }
        final int sz = cs.length();
        for (int i = 0; i < sz; i++) {
            if (!Character.isDigit(cs.charAt(i))) {
                return false;
            }
        }
        return true;
    }
    private void btnEndtaskActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEndtaskActionPerformed
        String ID = txtID.getText();
        if (!isNumeric(ID))
        {
            JOptionPane.showMessageDialog(this,"ID is invalid.","ERROR",JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            dataOutput.writeUTF("End app");
            dataOutput.flush();
            dataOutput.writeUTF(ID);
            dataOutput.flush();
            JOptionPane.showMessageDialog(this,dataInput.readUTF(),"Response",JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException ex) {
            Logger.getLogger(End.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnEndtaskActionPerformed

  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEndtask;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField txtID;
    // End of variables declaration//GEN-END:variables
}
