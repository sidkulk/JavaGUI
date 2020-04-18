/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bus.management;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
public class AddBusDetails extends javax.swing.JInternalFrame {

    /**
     * Creates new form AddBusDetails
     */         
    public AddBusDetails() {
        initComponents();
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
        departDateDP.setFormats(format);
        Date date=new Date();
        departDateDP.setDate(date);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        bus_noTF = new javax.swing.JTextField();
        bus_sourceTF = new javax.swing.JTextField();
        bus_destTF = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        deratTimeTF = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        seatTF = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        moveCB = new javax.swing.JComboBox<String>();
        jLabel9 = new javax.swing.JLabel();
        priceTF = new javax.swing.JTextField();
        departDateDP = new org.jdesktop.swingx.JXDatePicker();
        jLabel10 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Bus Details");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Add Bus Details");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Bus No");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Source");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Destination");

        bus_noTF.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        bus_sourceTF.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        bus_sourceTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                bus_sourceTFKeyPressed(evt);
            }
        });

        bus_destTF.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        bus_destTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bus_destTFActionPerformed(evt);
            }
        });
        bus_destTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                bus_destTFKeyPressed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton1.setText("Save");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton2.setText("Reset");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Date");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Time");

        deratTimeTF.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("Seat");

        seatTF.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        seatTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                seatTFKeyPressed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setText("Movement");

        moveCB.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        moveCB.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "UP", "DOWN" }));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setText("Price");

        priceTF.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        priceTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                priceTFKeyPressed(evt);
            }
        });

        departDateDP.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        departDateDP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                departDateDPActionPerformed(evt);
            }
        });

        jLabel10.setForeground(new java.awt.Color(255, 0, 0));
        jLabel10.setText("*in hh:mm format (24-Hour)");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(302, 302, 302)
                                .addComponent(jButton1))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel9)
                                .addGap(18, 18, 18)
                                .addComponent(priceTF, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(86, 86, 86)
                                .addComponent(jButton2))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 133, Short.MAX_VALUE)
                                .addComponent(jLabel7)
                                .addGap(45, 45, 45)
                                .addComponent(seatTF, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(113, 113, 113)
                                .addComponent(jLabel2))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(bus_noTF, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(80, 80, 80)
                                .addComponent(jLabel8))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(departDateDP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(bus_sourceTF, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))))
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(deratTimeTF)
                            .addComponent(bus_destTF, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                            .addComponent(moveCB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(31, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(292, 292, 292))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bus_noTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel8)
                    .addComponent(moveCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bus_destTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(bus_sourceTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(deratTimeTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(jLabel5)
                        .addComponent(departDateDP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(seatTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel9)
                    .addComponent(priceTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
 public void infoMessage(String message, String tittle) {
        JOptionPane.showMessageDialog(null, message, tittle, JOptionPane.INFORMATION_MESSAGE);
    }
 public void clearFieldValue()
 {
     bus_noTF.setText("");
     bus_sourceTF.setText("");
     bus_destTF.setText("");
 }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
          
       String busnoD=bus_noTF.getText();
       String busMoveD=(String)moveCB.getSelectedItem();
       String bussourceD=bus_sourceTF.getText();
       String busdestD=bus_destTF.getText();
              java.util.Date departDateD= departDateDP.getDate();
             SimpleDateFormat oDateFormat = new SimpleDateFormat("yyyy-MM-dd");
       String departDate = oDateFormat.format(departDateD);
       String departTimeD=deratTimeTF.getText();
       String priceD=priceTF.getText();
       String seatD=seatTF.getText();
       
       String time = "([01]?[0-9]|2[0-3]):[0-5][0-9]";
        Pattern patt = Pattern.compile(time);
        Matcher regexMatcher = patt.matcher(deratTimeTF.getText());
        
        String Vhno = "^[A-Z]{2}[ -][0-9]{1,2}(?: [A-Z])?(?: [A-Z]*)? [0-9]{4}$";
        Pattern vpatt = Pattern.compile(Vhno);
        Matcher regexMatcherV =  vpatt.matcher(bus_noTF.getText());
        
       if(busnoD.isEmpty() || busdestD.isEmpty() || bussourceD.isEmpty() || departTimeD.isEmpty() || priceD.isEmpty() || seatD.isEmpty() || (bussourceD.equals(busdestD))){
           JOptionPane.showMessageDialog(this, "Enter valid Details");
       }
       else{
             if(!regexMatcher.matches() || !regexMatcherV.matches()){
            JOptionPane.showMessageDialog(this, "Enter valid details");
        }
            else{
       try
        {
        
             Class.forName("com.mysql.jdbc.Driver");
            String databaseURL = "jdbc:mysql://localhost:3306/busm";
            Connection con = DriverManager.getConnection(databaseURL, "root", "");
            Statement stat = con.createStatement();    
            String selectQuery = "select * from bus_details where bus_no='"+busnoD+"'";
            
            ResultSet rs=stat.executeQuery(selectQuery);
         
           if(rs.next()==true)
           {
             infoMessage("Already Bus Details is Added", "Create Fresh Entry !!");
             clearFieldValue();
           }
           else
           {
          String insertQuery = "insert into bus_details values(null,'" + busnoD + "','" + busMoveD + "','" + bussourceD + "','" + busdestD + "','" + departDate + "','" + departTimeD + "','" + priceD + "','" + seatD + "')";
           
          stat.executeUpdate(insertQuery);
          infoMessage("Bus Details is Added", "Great work !!");
          clearFieldValue();
            
        }
               
        }
        catch(Exception e)
        {
        }
            }
       }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void departDateDPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_departDateDPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_departDateDPActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        bus_destTF.setText("");
        bus_sourceTF.setText("");
        bus_noTF.setText("");
        deratTimeTF.setText("");
        priceTF.setText("");
        seatTF.setText("");
        

    }//GEN-LAST:event_jButton2ActionPerformed

    private void bus_sourceTFKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bus_sourceTFKeyPressed
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if(Character.isLetter(c) || Character.isWhitespace(c) || Character.isISOControl(c)){
            bus_sourceTF.setEditable(true);
        }
        else{
            bus_sourceTF.setEditable(false);
        }
    }//GEN-LAST:event_bus_sourceTFKeyPressed

    private void bus_destTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bus_destTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bus_destTFActionPerformed

    private void bus_destTFKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bus_destTFKeyPressed
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if(Character.isLetter(c) || Character.isWhitespace(c) || Character.isISOControl(c)){
           bus_destTF.setEditable(true);
        }
        else{
            bus_destTF.setEditable(false);
        }
    }//GEN-LAST:event_bus_destTFKeyPressed

    private void priceTFKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_priceTFKeyPressed
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        String price = priceTF.getText();
        //int len = price.length();
        if(Character.isLetter(c)){
            priceTF.setEditable(false);
        }
        else{
            priceTF.setEditable(true);
        }
    }//GEN-LAST:event_priceTFKeyPressed

    private void seatTFKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_seatTFKeyPressed
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        String seat = seatTF.getText();
        //int len = seat.length();
        if(Character.isLetter(c)){
            seatTF.setEditable(false);
        }
        else{
            seatTF.setEditable(true);
        }
    }//GEN-LAST:event_seatTFKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField bus_destTF;
    private javax.swing.JTextField bus_noTF;
    private javax.swing.JTextField bus_sourceTF;
    private org.jdesktop.swingx.JXDatePicker departDateDP;
    private javax.swing.JTextField deratTimeTF;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JComboBox<String> moveCB;
    private javax.swing.JTextField priceTF;
    private javax.swing.JTextField seatTF;
    // End of variables declaration//GEN-END:variables
}
