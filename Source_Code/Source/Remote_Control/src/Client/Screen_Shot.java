
package Client;


import java.awt.Image;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;


public class Screen_Shot extends javax.swing.JFrame {

    Socket sending = null;
    DataOutputStream  dataOutput = null; 
    DataInputStream dataInput = null;
    String Host = null;
    
    ImageIcon icon = null;
    
    public Screen_Shot(String Host,Socket s) {
        
        try {
            this.sending = s;
            this.Host = Host;
            dataOutput = new DataOutputStream(s.getOutputStream());
            dataInput = new DataInputStream(s.getInputStream());
            initComponents();
        } catch (IOException ex) {
            Logger.getLogger(Screen_Shot.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
   
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnCapture = new javax.swing.JButton();
        image = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Screen Shot");

        btnCapture.setBackground(new java.awt.Color(204, 204, 204));
        btnCapture.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnCapture.setForeground(new java.awt.Color(255, 51, 51));
        btnCapture.setText("CAPTURE");
        btnCapture.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCaptureActionPerformed(evt);
            }
        });

        image.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(image, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 469, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(177, 177, 177)
                .addComponent(btnCapture)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(btnCapture, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(image, javax.swing.GroupLayout.DEFAULT_SIZE, 371, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCaptureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCaptureActionPerformed
       
         try {
            image.removeAll();
            String request = "SCREEN SHOT";
            dataOutput.writeUTF(request);
            dataOutput.flush();           
            
            String path = "D:// Image.jpg";
            File file = new File(path);
            int a = dataInput.readInt();            

            byte b[] = new byte[a];
            FileOutputStream fr = new  FileOutputStream(file);            
            dataInput.read(b,0,a);            
            fr.write(b);     
            fr.close();
            java.awt.image.BufferedImage img = ImageIO.read(file);
            Image dimg = img.getScaledInstance(image.getWidth(), image.getHeight(), Image.SCALE_SMOOTH);
            icon = new ImageIcon(dimg);
            image.setIcon(icon);
            icon.getImage().flush();

        } catch (IOException ex) {
            Logger.getLogger(Screen_Shot.class.getName()).log(Level.SEVERE, null, ex);
        } 

       
       
    }//GEN-LAST:event_btnCaptureActionPerformed

  
    public static void main(String args[]) {
        
       
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCapture;
    private javax.swing.JLabel image;
    // End of variables declaration//GEN-END:variables
}
