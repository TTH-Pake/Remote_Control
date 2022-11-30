
package Client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;


public class Keystroke extends javax.swing.JFrame {

    Socket sending = null;
    DataOutputStream dataOutput = null;
    DataInputStream dataInput = null;
    private End endTask = null;
    private Start  startTask = null;
    DefaultTableModel model;
    
    
      public Keystroke(Socket socket) throws IOException{
        ;
        sending = socket;
        dataOutput = new DataOutputStream(socket.getOutputStream());
        dataInput = new DataInputStream(socket.getInputStream());
        initComponents();
    }
      
    private Keystroke() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }  

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        jFrame2 = new javax.swing.JFrame();
        jColorChooser1 = new javax.swing.JColorChooser();
        jFrame3 = new javax.swing.JFrame();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        Hook = new javax.swing.JButton();
        Unhook = new javax.swing.JButton();
        Print = new javax.swing.JButton();
        Delete = new javax.swing.JButton();
        canvas1 = new java.awt.Canvas();
        jScrollPane1 = new javax.swing.JScrollPane();
        text = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jFrame2Layout = new javax.swing.GroupLayout(jFrame2.getContentPane());
        jFrame2.getContentPane().setLayout(jFrame2Layout);
        jFrame2Layout.setHorizontalGroup(
            jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame2Layout.setVerticalGroup(
            jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jFrame3Layout = new javax.swing.GroupLayout(jFrame3.getContentPane());
        jFrame3.getContentPane().setLayout(jFrame3Layout);
        jFrame3Layout.setHorizontalGroup(
            jFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame3Layout.setVerticalGroup(
            jFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        jLabel2.setText("jLabel2");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Client/BackGroun.jpg"))); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("KEYSTROKE");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 255, 255));
        jLabel1.setText("KEYSTROKE");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, 140, 30));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 400, 10));

        Hook.setBackground(new java.awt.Color(204, 204, 204));
        Hook.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Hook.setForeground(new java.awt.Color(0, 0, 204));
        Hook.setText("HOOK");
        Hook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HookActionPerformed(evt);
            }
        });
        getContentPane().add(Hook, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, -1, -1));

        Unhook.setBackground(new java.awt.Color(204, 204, 204));
        Unhook.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Unhook.setForeground(new java.awt.Color(0, 0, 204));
        Unhook.setText("UNHOOK");
        Unhook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UnhookActionPerformed(evt);
            }
        });
        getContentPane().add(Unhook, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 60, 90, -1));

        Print.setBackground(new java.awt.Color(204, 204, 204));
        Print.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Print.setForeground(new java.awt.Color(0, 0, 204));
        Print.setText("PRINT");
        Print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PrintActionPerformed(evt);
            }
        });
        getContentPane().add(Print, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 60, -1, -1));

        Delete.setBackground(new java.awt.Color(204, 204, 204));
        Delete.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Delete.setForeground(new java.awt.Color(0, 0, 204));
        Delete.setText("DELETE");
        Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteActionPerformed(evt);
            }
        });
        getContentPane().add(Delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 60, -1, -1));
        getContentPane().add(canvas1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        text.setColumns(20);
        text.setRows(5);
        jScrollPane1.setViewportView(text);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 330, 170));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 255, 255));
        jLabel4.setText("KEYSTROKE");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, 140, 30));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 51, 51));
        jLabel5.setText("FIT@HCMUS");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 280, -1, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Client/BackGroun.jpg"))); // NOI18N
        jLabel6.setText("jLabel6");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 390, 320));

        pack();
    }// </editor-fold>//GEN-END:initComponents
                
    
    private void HookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HookActionPerformed
       try {
             
            String request = "HOOK";
            dataOutput.writeUTF(request);
            dataOutput.flush();
            
        } catch (IOException ex) {
            Logger.getLogger(Client_FunctionBoard.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }//GEN-LAST:event_HookActionPerformed

    private void UnhookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UnhookActionPerformed
        try {
             
            String request = "UNHOOK";
            dataOutput.writeUTF(request);
            dataOutput.flush();
            
        } catch (IOException ex) {
            Logger.getLogger(Client_FunctionBoard.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }//GEN-LAST:event_UnhookActionPerformed

    private void PrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PrintActionPerformed
        try {
            String request = "PRINT";
            dataOutput.writeUTF(request);
            dataOutput.flush();
            
            String str = dataInput.readUTF();
            text.setText(str);
       
        } catch (IOException ex) {
            Logger.getLogger(Client_FunctionBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_PrintActionPerformed

    private void DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteActionPerformed
       try {
            String request = "DELETE";
            dataOutput.writeUTF(request);
            dataOutput.flush();
            
            text.setText("");
        } catch (IOException ex) {
            Logger.getLogger(Client_FunctionBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_DeleteActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
         try {
            dataOutput.writeUTF("QUIT");
            dataOutput.flush();
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(Process.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formWindowClosing

    public static void main(String args[]) {
      
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Keystroke().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Delete;
    private javax.swing.JButton Hook;
    private javax.swing.JButton Print;
    private javax.swing.JButton Unhook;
    private java.awt.Canvas canvas1;
    private javax.swing.JColorChooser jColorChooser1;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JFrame jFrame2;
    private javax.swing.JFrame jFrame3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextArea text;
    // End of variables declaration//GEN-END:variables
}
