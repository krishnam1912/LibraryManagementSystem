/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package jframe;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.util.Date;
/**
 *
 * @author krishnam
 */
public class ReturnBook extends javax.swing.JFrame {

    /**
     * Creates new form IssueBook
     */
    public ReturnBook() {
        initComponents();
    }
    
    public void  getIssueBookDetails(){
        int bookId= Integer.parseInt(txt_bookid.getText()); 
        int studentId = Integer.parseInt(txt_studentid.getText()); 
        
        try{
             Connection con = DBConnection.getConnection();
             String sql= "select * from issue_book_details where book_id = ?  and student_id = ?  and status = ?";
             PreparedStatement pst = con.prepareStatement(sql);   
             pst.setInt(1, bookId);
             pst.setInt(2, studentId);
             pst.setString(3, "pending" ); 
             ResultSet rs = pst.executeQuery();
            if(rs.next())
            {
               
              lbl_issueid.setText(rs.getString("id"));
              lbl_bookname.setText(rs.getString("book_name"));
              lbl_studentname.setText(rs.getString("student_name"));
              lbl_issuedate.setText(rs.getString("issue_date"));
              lbl_duedate.setText(rs.getString("due_date"));
              lbl_bookerror.setText("");
            }else{
               
              lbl_bookerror.setText("No Record Found ");  
              lbl_issueid.setText("");
              lbl_bookname.setText("");
              lbl_studentname.setText("");
              lbl_issuedate.setText("");
              lbl_duedate.setText("");
              
              
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public boolean returnBook(){
        boolean isReturned =false;
         int bookId= Integer.parseInt(txt_bookid.getText()); 
         int studentId = Integer.parseInt(txt_studentid.getText()); 
         
          try{
             Connection con = DBConnection.getConnection();
             String sql= "update issue_book_details set status= ? where student_id = ? and book_id = ? and status = ?";
             PreparedStatement pst = con.prepareStatement(sql);   
             pst.setString(1, "returned");
             pst.setInt(2, studentId);
             pst.setInt(3, bookId);
             pst.setString(4,"pending");
             
            int RowCount = pst.executeUpdate();
           
           if (RowCount > 0) {
             isReturned = true;
           }
        }catch (Exception e){
            e.printStackTrace();
        }
       return isReturned;
    }  
    
    
    
   
    
    
   
    
   
    
    
    public void updateBookCount(){
        int bookId= Integer.parseInt(txt_bookid.getText());
        
        try{
             Connection con = DBConnection.getConnection();
             String sql= "update book_details set quantity  = quantity +1 where book_id = ?";
             PreparedStatement pst = con.prepareStatement (sql);   
             pst.setInt(1, bookId);
         
        int row=pst.executeUpdate();
            if(row>0)
            {
               JOptionPane.showMessageDialog(this, "Book Count Updated");
            } else{
               JOptionPane.showMessageDialog(this, "Can't update Book Count");  
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
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

        panel_main = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        lbl_duedate = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        lbl_bookerror = new javax.swing.JLabel();
        lbl_issueid = new javax.swing.JLabel();
        lbl_bookname = new javax.swing.JLabel();
        lbl_studentname = new javax.swing.JLabel();
        lbl_issuedate = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txt_bookid = new app.bolivia.swing.JCTextField();
        txt_studentid = new app.bolivia.swing.JCTextField();
        jLabel15 = new javax.swing.JLabel();
        rSMaterialButtonCircle1 = new rojerusan.RSMaterialButtonCircle();
        jPanel6 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        rSMaterialButtonCircle2 = new rojerusan.RSMaterialButtonCircle();
        jLabel13 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel_main.setBackground(new java.awt.Color(255, 255, 255));
        panel_main.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(255, 51, 51));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 25)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/AddNewBookIcons/icons8_Literature_100px_1.png"))); // NOI18N
        jLabel8.setText("Book Details");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 110, 260, 110));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 330, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, 330, 5));

        jLabel11.setFont(new java.awt.Font("Adobe Devanagari", 1, 22)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Book name:");
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 440, 140, 50));

        jLabel12.setFont(new java.awt.Font("Adobe Devanagari", 1, 22)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Student name :");
        jPanel3.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 500, -1, 50));

        jLabel18.setFont(new java.awt.Font("Adobe Devanagari", 1, 22)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Due Date :");
        jPanel3.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 620, 120, 50));

        lbl_duedate.setFont(new java.awt.Font("Adobe Devanagari", 1, 22)); // NOI18N
        lbl_duedate.setForeground(new java.awt.Color(255, 204, 0));
        jPanel3.add(lbl_duedate, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 620, 230, 40));

        jLabel19.setFont(new java.awt.Font("Adobe Devanagari", 1, 22)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Issue Date :");
        jPanel3.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 560, 130, 50));

        lbl_bookerror.setFont(new java.awt.Font("Adobe Devanagari", 1, 22)); // NOI18N
        lbl_bookerror.setForeground(new java.awt.Color(255, 204, 0));
        jPanel3.add(lbl_bookerror, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 700, 240, 40));

        lbl_issueid.setFont(new java.awt.Font("Adobe Devanagari", 1, 22)); // NOI18N
        lbl_issueid.setForeground(new java.awt.Color(255, 204, 0));
        jPanel3.add(lbl_issueid, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 380, 230, 40));

        lbl_bookname.setFont(new java.awt.Font("Adobe Devanagari", 1, 22)); // NOI18N
        lbl_bookname.setForeground(new java.awt.Color(255, 204, 0));
        jPanel3.add(lbl_bookname, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 440, 230, 40));

        lbl_studentname.setFont(new java.awt.Font("Adobe Devanagari", 1, 22)); // NOI18N
        lbl_studentname.setForeground(new java.awt.Color(255, 204, 0));
        jPanel3.add(lbl_studentname, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 500, 230, 40));

        lbl_issuedate.setFont(new java.awt.Font("Adobe Devanagari", 1, 22)); // NOI18N
        lbl_issuedate.setForeground(new java.awt.Color(255, 204, 0));
        jPanel3.add(lbl_issuedate, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 560, 230, 40));

        jLabel14.setFont(new java.awt.Font("Adobe Devanagari", 1, 22)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Issue Id :");
        jPanel3.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 380, 100, 50));

        panel_main.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 0, 420, 810));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 51, 51));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/AddNewBookIcons/icons8_Books_52px_1.png"))); // NOI18N
        jLabel3.setText("Return Book ");
        panel_main.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 160, 280, 70));

        jPanel5.setBackground(new java.awt.Color(255, 51, 51));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 310, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        panel_main.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 230, 310, 5));

        jPanel7.setBackground(new java.awt.Color(255, 51, 51));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Verdana", 1, 20)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("X");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        jPanel7.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 20, 40));

        panel_main.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1510, 0, -1, 40));

        jLabel10.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 51, 51));
        jLabel10.setText("Book Id :");
        panel_main.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 380, 130, 40));

        txt_bookid.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 51, 51)));
        txt_bookid.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        txt_bookid.setPlaceholder("Enter Book Id....");
        txt_bookid.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_bookidFocusLost(evt);
            }
        });
        txt_bookid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_bookidActionPerformed(evt);
            }
        });
        panel_main.add(txt_bookid, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 380, 340, 40));

        txt_studentid.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 51, 51)));
        txt_studentid.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        txt_studentid.setPlaceholder("Enter Student Id....");
        txt_studentid.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_studentidFocusLost(evt);
            }
        });
        txt_studentid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_studentidActionPerformed(evt);
            }
        });
        panel_main.add(txt_studentid, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 480, 340, 40));

        jLabel15.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 51, 51));
        jLabel15.setText("Student Id :");
        panel_main.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 480, 130, 40));

        rSMaterialButtonCircle1.setBackground(new java.awt.Color(102, 102, 255));
        rSMaterialButtonCircle1.setText("FIND");
        rSMaterialButtonCircle1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle1ActionPerformed(evt);
            }
        });
        panel_main.add(rSMaterialButtonCircle1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 580, 360, 70));

        jPanel6.setBackground(new java.awt.Color(0, 0, 204));

        jLabel7.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/AddNewBookIcons/icons8_Rewind_48px.png"))); // NOI18N
        jLabel7.setText("BACK");
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jLabel7)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        panel_main.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        rSMaterialButtonCircle2.setBackground(new java.awt.Color(255, 51, 51));
        rSMaterialButtonCircle2.setText("RETURN BOOK");
        rSMaterialButtonCircle2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle2ActionPerformed(evt);
            }
        });
        panel_main.add(rSMaterialButtonCircle2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 680, 360, 70));

        jLabel13.setFont(new java.awt.Font("Adobe Devanagari", 1, 22)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons/library-2.png"))); // NOI18N
        panel_main.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(-60, 70, 750, 750));

        getContentPane().add(panel_main, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1540, 800));

        setSize(new java.awt.Dimension(1729, 803));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        HomePage home  = new HomePage(); 
        home.setVisible (true); 
        dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel7MouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        System.exit(0);  // TODO add your handling code here:
    }//GEN-LAST:event_jLabel4MouseClicked

    private void txt_bookidFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_bookidFocusLost
   
    }//GEN-LAST:event_txt_bookidFocusLost

    private void txt_bookidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_bookidActionPerformed
      // TODO add your handling code here:
    }//GEN-LAST:event_txt_bookidActionPerformed

    private void txt_studentidFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_studentidFocusLost
       
    }//GEN-LAST:event_txt_studentidFocusLost

    private void txt_studentidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_studentidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_studentidActionPerformed

    private void rSMaterialButtonCircle1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle1ActionPerformed
      getIssueBookDetails();
    }//GEN-LAST:event_rSMaterialButtonCircle1ActionPerformed

    private void rSMaterialButtonCircle2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle2ActionPerformed
      if(returnBook() == true){
           JOptionPane.showMessageDialog(this, "Book Retured Successfully ");
           updateBookCount();
      }else{
           JOptionPane.showMessageDialog(this, "Book Returned Failed ");
      }
    }//GEN-LAST:event_rSMaterialButtonCircle2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ReturnBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReturnBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReturnBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReturnBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReturnBook().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JLabel lbl_bookerror;
    private javax.swing.JLabel lbl_bookname;
    private javax.swing.JLabel lbl_duedate;
    private javax.swing.JLabel lbl_issuedate;
    private javax.swing.JLabel lbl_issueid;
    private javax.swing.JLabel lbl_studentname;
    private javax.swing.JPanel panel_main;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle1;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle2;
    private app.bolivia.swing.JCTextField txt_bookid;
    private app.bolivia.swing.JCTextField txt_studentid;
    // End of variables declaration//GEN-END:variables
}