/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.PreparedStatement;
import java.sql.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import messages.ErrorMessage;
import messages.SuccesMessage;
public class developer extends javax.swing.JFrame {

   
    
    private PreparedStatement preparedstatment;
    private  Connection connection;
    
    public developer() throws ClassNotFoundException, SQLException {
        initComponents();
        tblist();
    }
    
    private  void openConnection() throws ClassNotFoundException, SQLException{
        Driver.class.forName("org.postgresql.Driver");
        connection=DriverManager.getConnection("jdbc:postgresql://localhost:5432/deneme",
                "postgres",
                "313131"
                );
        
        
    }
    
    private  void closeConnection() throws SQLException{
        connection.close();
        
    }
    private  void clearText(){
        txtid.setText("");
        txtname.setText("");
        txtsurname.setText("");
        txtdepartment.setText("");
        txtuniversity.setText("");
        txtlanguage.setText("");
        txtlanguage.setText("");
        
    }
      private  void tblist() throws ClassNotFoundException, SQLException{
          openConnection();
          try {
              String select="select * from developer order by id asc";
              preparedstatment=connection.prepareCall(select);
              ResultSet resulset=preparedstatment.executeQuery();
              ResultSetMetaData resulsetMetadata=resulset.getMetaData();
             int count=  resulsetMetadata.getColumnCount();
             
         DefaultTableModel  defaulttable=(DefaultTableModel)tblDeveloper.getModel();
         defaulttable.setRowCount(0);
         while(resulset.next()){
             Vector list=new Vector();
             for(int i=0;i<=count;i++){
                 list.add(resulset.getString("id"));
                 list.add(resulset.getString("name"));
                 list.add(resulset.getString("surname"));
                 list.add(resulset.getString("department"));
                 list.add(resulset.getString("university"));
                 list.add(resulset.getString("planguage"));
             }
           defaulttable.addRow(list);
           
         }
         
              closeConnection();
              
          } catch (Exception e) {
              System.err.println(e.getMessage());
          }finally{
              closeConnection();
          }
      }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtname = new javax.swing.JTextField();
        txtid = new javax.swing.JTextField();
        txtuniversity = new javax.swing.JTextField();
        txtsurname = new javax.swing.JTextField();
        txtdepartment = new javax.swing.JTextField();
        txtlanguage = new javax.swing.JTextField();
        btnInsert = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDeveloper = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(211, 18, 88));
        setForeground(new java.awt.Color(255, 51, 204));

        jLabel1.setForeground(new java.awt.Color(51, 0, 51));
        jLabel1.setText("DEVELOPER REGISTRATION");

        jLabel2.setForeground(new java.awt.Color(51, 0, 51));
        jLabel2.setText("NAME");

        jLabel3.setForeground(new java.awt.Color(51, 0, 51));
        jLabel3.setText("SURNAME");

        jLabel4.setForeground(new java.awt.Color(51, 0, 51));
        jLabel4.setText("DEPARTMENT");

        jLabel5.setForeground(new java.awt.Color(51, 0, 51));
        jLabel5.setText("UNIVERSITY");

        jLabel6.setForeground(new java.awt.Color(51, 0, 51));
        jLabel6.setText("LANGUAGE");

        jLabel7.setForeground(new java.awt.Color(51, 0, 51));
        jLabel7.setText("ID");

        btnInsert.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        btnInsert.setText("INSERT");
        btnInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertActionPerformed(evt);
            }
        });

        btnDelete.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        btnDelete.setText("DELETE");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnUpdate.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        btnUpdate.setText("UPDATE");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        tblDeveloper.setForeground(new java.awt.Color(204, 0, 255));
        tblDeveloper.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NAME", "SURNAME", "DEPARTMENT", "UNIVERSITY", "LANGUAGE"
            }
        ));
        tblDeveloper.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDeveloperMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblDeveloper);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnInsert, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(76, 76, 76)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtuniversity, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtsurname, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtdepartment, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtlanguage, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtname, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 482, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnInsert)
                    .addComponent(btnUpdate)
                    .addComponent(btnDelete))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtsurname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtdepartment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtuniversity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtlanguage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertActionPerformed
        try {
            String id=txtid.getText();
            String name=txtname.getText();
            String surname=txtsurname.getText();
            String department=txtdepartment.getText();
            String university=txtuniversity.getText();
            String planguage=txtlanguage.getText();
            
            openConnection();
            
            preparedstatment=connection.prepareStatement("insert into developer (id,name,surname,department,university,planguage)"
                    + "values(?,?,?,?,?,?)" );
            preparedstatment.setInt(1,Integer.parseInt(id));
            preparedstatment.setString(2, name);
             preparedstatment.setString(3, surname);
              preparedstatment.setString(4, department);
               preparedstatment.setString(5, university);
                preparedstatment.setString(6, planguage);
                
            preparedstatment.executeUpdate();
            
            
            JOptionPane.showMessageDialog(this,SuccesMessage.SUCCESS_INSERT,SuccesMessage.SUCCESS,JOptionPane.INFORMATION_MESSAGE);
            tblist();
            closeConnection();
            clearText();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,ErrorMessage.ERROR_INSERT,ErrorMessage.ERROR+"/n"+ErrorMessage.ADMINSTRATION,JOptionPane.ERROR_MESSAGE);
            e.getMessage();
        }
    }//GEN-LAST:event_btnInsertActionPerformed

    private void tblDeveloperMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDeveloperMouseClicked
        DefaultTableModel defalttable=(DefaultTableModel) tblDeveloper.getModel();
        int selectedIndex=tblDeveloper.getSelectedRow();
        
        txtid.setText(defalttable.getValueAt(selectedIndex,0).toString());
        txtname.setText(defalttable.getValueAt(selectedIndex,1).toString());
         txtsurname.setText(defalttable.getValueAt(selectedIndex,2).toString());
          txtdepartment.setText(defalttable.getValueAt(selectedIndex,3).toString());
           txtuniversity.setText(defalttable.getValueAt(selectedIndex,4).toString());
            txtlanguage.setText(defalttable.getValueAt(selectedIndex,5).toString());
        
       
    }//GEN-LAST:event_tblDeveloperMouseClicked

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        DefaultTableModel defaultTableModel=(DefaultTableModel)tblDeveloper.getModel();
        int secilenindex=tblDeveloper.getSelectedRow();
        
        try {
           int id=Integer.parseInt(defaultTableModel.getValueAt(secilenindex, 0).toString());
         int secim=  JOptionPane.showConfirmDialog(this,"Are you sure.?","WARNING",JOptionPane.YES_NO_OPTION);
         
         
         if(secim==JOptionPane.YES_OPTION){
             openConnection();
             preparedstatment=connection.prepareStatement("delete from developer where id=?");
             preparedstatment.setInt(1, id);
             preparedstatment.executeUpdate();
             JOptionPane.showMessageDialog(this,SuccesMessage.SUCCES_DELETE); 
             tblist();
             clearText();
             closeConnection();
             
             
         }
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(this,ErrorMessage.ERROR_DELETE);
            
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
       DefaultTableModel defaultTableModel=(DefaultTableModel)tblDeveloper.getModel();
        int secilenindex=tblDeveloper.getSelectedRow();
        try {
            int id=Integer.parseInt(defaultTableModel.getValueAt(secilenindex, 0).toString());
            
           String name=txtname.getText();
           String Surname=txtsurname.getText();
           String department=txtdepartment.getText();
           String  university=txtuniversity.getText();
           String plangue=txtlanguage.getText();
           openConnection();
           
           preparedstatment=connection.prepareStatement("update developer set name=?,surname=?,"+
           "department=?,university=?,planguage=? where id=?");
            preparedstatment.setString(1, name);
            preparedstatment.setString(2, Surname);
            preparedstatment.setString(3, department);
            preparedstatment.setString(4, university);
            preparedstatment.setString(5, plangue);
            preparedstatment.setInt(6 , id);
            
            preparedstatment.executeUpdate();
            JOptionPane.showMessageDialog(this,SuccesMessage.SUCCES_UPDATE);
            tblist();
            clearText();
            
            
            
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(this,ErrorMessage.ERROR_UPDATE);
          
            
            System.out.println(e.getMessage());
            
        }finally{
            try {
                
                    
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(developer.class.getName()).log(Level.SEVERE,null,ex);
                
            }
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new developer().setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(developer.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(developer.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnInsert;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblDeveloper;
    private javax.swing.JTextField txtdepartment;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtlanguage;
    private javax.swing.JTextField txtname;
    private javax.swing.JTextField txtsurname;
    private javax.swing.JTextField txtuniversity;
    // End of variables declaration//GEN-END:variables
}
