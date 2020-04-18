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
import javax.swing.JTable;

public class BookingDetails extends javax.swing.JInternalFrame {

    /**
     * Creates new form BookingDetails
     */
String luser;
    public BookingDetails(String loginuser) {
        initComponents();
        this.luser=loginuser;
                try
        {
            Class.forName("com.mysql.jdbc.Driver");
            String databaseURL = "jdbc:mysql://localhost:3306/busm";
            Connection con = DriverManager.getConnection(databaseURL, "root", "");
            Statement stat = con.createStatement();    
            String selectQuery ="select * from bus_booking where booking_user='"+luser+"'";
            ResultSet rs=stat.executeQuery(selectQuery);
         
            jTable1.setModel(DbUtils.resultSetToTableModel(rs));
            jTable1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
           
                    }
        catch(Exception e)
        {
            System.out.println(e);
        }
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        busmPUEntityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("busmPU").createEntityManager();
        busBookingQuery = java.beans.Beans.isDesignTime() ? null : busmPUEntityManager.createQuery("SELECT b FROM BusBooking b");
        busBookingList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : busBookingQuery.getResultList();
        busBookingQuery1 = java.beans.Beans.isDesignTime() ? null : busmPUEntityManager.createQuery("SELECT b FROM BusBooking b");
        busBookingList1 = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : busBookingQuery1.getResultList();
        busBookingQuery2 = java.beans.Beans.isDesignTime() ? null : busmPUEntityManager.createQuery("SELECT b FROM BusBooking b");
        busBookingList2 = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : busBookingQuery2.getResultList();
        entityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("busm?zeroDateTimeBehavior=convertToNullPU").createEntityManager();
        busBookingQuery3 = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery("SELECT b FROM BusBooking b");
        busBookingList3 = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : busBookingQuery3.getResultList();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 805, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.util.List<bus.management.BusBooking> busBookingList;
    private java.util.List<bus.management.BusBooking> busBookingList1;
    private java.util.List<bus.management.BusBooking> busBookingList2;
    private java.util.List<bus.management.BusBooking> busBookingList3;
    private javax.persistence.Query busBookingQuery;
    private javax.persistence.Query busBookingQuery1;
    private javax.persistence.Query busBookingQuery2;
    private javax.persistence.Query busBookingQuery3;
    private javax.persistence.EntityManager busmPUEntityManager;
    private javax.persistence.EntityManager entityManager;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
