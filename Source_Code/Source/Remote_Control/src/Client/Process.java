
package Client;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

public class Process extends  JDialog {

    Socket sending = null;
    DataOutputStream dataOutput = null;
    DataInputStream dataInput = null;
    private End endTask = null;
    private Start  startTask = null;
    DefaultTableModel model;
    
    public Process(JFrame owner, boolean modal, Socket socket) throws IOException{
        super(owner, modal);
        sending = socket;
        dataOutput = new DataOutputStream(socket.getOutputStream());
        dataInput = new DataInputStream(socket.getInputStream());
        initComponents();
    }



    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        StartTask = new javax.swing.JButton();
        EndTask = new javax.swing.JButton();
        Load = new javax.swing.JButton();
        Reset = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtTable = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Processes Running");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(102, 153, 255)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        StartTask.setBackground(new java.awt.Color(204, 204, 204));
        StartTask.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        StartTask.setForeground(new java.awt.Color(51, 102, 255));
        StartTask.setText("Start Task");
        StartTask.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StartTaskActionPerformed(evt);
            }
        });
        jPanel1.add(StartTask, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 100, -1));

        EndTask.setBackground(new java.awt.Color(204, 204, 204));
        EndTask.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        EndTask.setForeground(new java.awt.Color(51, 102, 255));
        EndTask.setText("End Task");
        EndTask.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EndTaskActionPerformed(evt);
            }
        });
        jPanel1.add(EndTask, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, 90, -1));
        EndTask.getAccessibleContext().setAccessibleParent(EndTask);

        Load.setBackground(new java.awt.Color(204, 204, 204));
        Load.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Load.setForeground(new java.awt.Color(51, 102, 255));
        Load.setText("Load");
        Load.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoadActionPerformed(evt);
            }
        });
        jPanel1.add(Load, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 10, 90, -1));

        Reset.setBackground(new java.awt.Color(204, 204, 204));
        Reset.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Reset.setForeground(new java.awt.Color(51, 102, 255));
        Reset.setText("Reset");
        Reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResetActionPerformed(evt);
            }
        });
        jPanel1.add(Reset, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 10, 92, -1));

        txtTable.setBackground(new java.awt.Color(204, 204, 204));
        txtTable.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name Process", "PID", "Session Name", " Session#", "Mem Usage"
            }
        )
        {
            public boolean isCellEditable(int row, int column) {
                //all cells false
                return false;
            }
        }
    );
    jScrollPane1.setViewportView(txtTable);
    txtTable.getAccessibleContext().setAccessibleName("");

    jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 411, 283));
    jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 42, 444, -1));

    jLabel1.setBackground(new java.awt.Color(51, 51, 255));
    jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    jLabel1.setForeground(new java.awt.Color(255, 51, 51));
    jLabel1.setText("  FIT@HCMUS ");
    jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 340, 110, 30));
    jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 360, 0, 0));
    jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 380, 450, -1));

    jLabel4.setBackground(new java.awt.Color(255, 255, 255));
    jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Client/BackGroun.jpg"))); // NOI18N
    jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 450, 380));

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );

    getAccessibleContext().setAccessibleParent(this);

    pack();
    setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    private void ResetJTable(DefaultTableModel tableModel)
        {
            while(tableModel.getRowCount() > 0)
            {
                tableModel.removeRow(0);
            }
        }    
    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        try {
            dataOutput.writeUTF("QUIT");
            dataOutput.flush();
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(Process.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formWindowClosing

    private void ResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResetActionPerformed
        model = (DefaultTableModel) txtTable.getModel();
        this.ResetJTable(model);
    }//GEN-LAST:event_ResetActionPerformed

    private void LoadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoadActionPerformed

        try {
            model = (DefaultTableModel) txtTable.getModel();
            this.ResetJTable(model);
            dataOutput.writeUTF("Load processes running");
            dataOutput.flush();

            String[] process;
            String  temp = dataInput.readUTF();
            while(!"".equals(temp))
            {
                process = temp.substring(1, (temp.length()-2)).split("\",\"");
                model = (DefaultTableModel) txtTable.getModel();
                model.addRow(new Object[]{process[0], process[1], process[2], process[3], process[4]});
                temp =  dataInput.readUTF();
            }
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(Process.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_LoadActionPerformed

    private void EndTaskActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EndTaskActionPerformed
        try {
            if (endTask!=null && endTask.isVisible()){
                return;
            }
            endTask = new End(this, true, sending);
            endTask.setTitle("End process");
            endTask.setLocationRelativeTo(null);
            endTask.setVisible(true);
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(Process.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_EndTaskActionPerformed

    private void StartTaskActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StartTaskActionPerformed
        try {
            if (endTask!=null && endTask.isVisible()){
                return;
            }
            startTask = new Start(this, true, sending);
            startTask.setTitle("Start process");
            startTask.setLocationRelativeTo(null);
            startTask.setVisible(true);
        } catch (IOException ex) {
            Logger.getLogger(Process.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_StartTaskActionPerformed

 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    javax.swing.JButton EndTask;
    javax.swing.JButton Load;
    javax.swing.JButton Reset;
    javax.swing.JButton StartTask;
    javax.swing.JLabel jLabel1;
    javax.swing.JLabel jLabel2;
    javax.swing.JLabel jLabel3;
    javax.swing.JLabel jLabel4;
    javax.swing.JPanel jPanel1;
    javax.swing.JScrollPane jScrollPane1;
    javax.swing.JSeparator jSeparator1;
    javax.swing.JTable txtTable;
    // End of variables declaration//GEN-END:variables
    

}
