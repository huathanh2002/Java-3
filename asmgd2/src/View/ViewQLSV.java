/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Model.Student;
import dao.StudentDAO;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author An Dong PC
 */
public class ViewQLSV extends javax.swing.JFrame {

    String strHinhAnh = "";
    private StudentDAO dao = new StudentDAO();
    private DefaultTableModel tblModel = new DefaultTableModel();

    /**
     * Creates new form ViewQLSV
     */
    public ViewQLSV() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.fillTable(dao.getAll());
        rdoNam.setSelected(true);
    }

    public Student getModel() {
        Student st = new Student();
        st.setMaSV(txtMaSV.getText().trim());
        st.setHoTen(txtHoTen.getText().trim());
        st.setEmail(txtEmail.getText().trim());
//        st.setSoDT(txtSoDT.getText().trim());
        boolean gt = false; //nu mac dinh
        if (rdoNam.isSelected()) {
            gt = true;
        }
        st.setGioiTinh(gt);
        st.setDiaChi(txtDiaChi.getText().trim());
        st.setHinhAnh(strHinhAnh);
        if (txtMaSV.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Mã sinh viên không được để trống !");
            txtMaSV.requestFocus();
            return null;
        }
        if (txtHoTen.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Họ tên sinh viên không được để trống !");
            txtMaSV.requestFocus();
            return null;
        }
        if (txtEmail.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Email sinh viên không được để trống !");
            txtMaSV.requestFocus();
            return null;
        } else {
            if (!txtEmail.getText().trim().contains("@") || !txtEmail.getText().trim().contains(".")) {
                JOptionPane.showMessageDialog(this, "Email phải có ' @ và . ' ");
                return null;
            }
        }
        if (txtSoDT.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Số điện thoại sinh viên không được để trống !");
            txtMaSV.requestFocus();
            return null;
        } else {
            String soDT = txtSoDT.getText().trim();
            // Kiểm tra chuỗi số điện thoại có chứa chỉ chữ số hay không
            if (!soDT.matches("\\d+")) {
                JOptionPane.showMessageDialog(this, "Số điện thoại không đúng định dạng");
                return null;
            }
            if (soDT.length() != 10) {
                JOptionPane.showMessageDialog(this, "Số điện thoại phải có 10 số !");
                return null;
            }
            st.setSoDT(soDT);
        }
        if (txtDiaChi.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Địa chỉ của sinh viên không được để trống !");
            txtMaSV.requestFocus();
            return null;
        }

        return st;
    }

    void setModel(Student st) {
        txtMaSV.setText(st.getMaSV());
        txtHoTen.setText(st.getHoTen());
        txtEmail.setText(st.getEmail());
        txtSoDT.setText(st.getSoDT());
        if (st.isGioiTinh()) {
            rdoNam.setSelected(true);
        } else {
            rdoNu.setSelected(true);
        }
        txtDiaChi.setText(st.getDiaChi());
//        if (st.getHinhAnh() != null) {
        //
        ImageIcon imgIcon = new ImageIcon(getClass().getResource("/img/" + st.getHinhAnh()));
        Image img = imgIcon.getImage();

        // Lấy kích thước hiện tại của hình ảnh
        int imgWidth = img.getWidth(null);
        int imgHeight = img.getHeight(null);

        // Lấy kích thước của nhãn
        int labelWidth = lblHinhAnh.getWidth();
        int labelHeight = lblHinhAnh.getHeight();

        // Tính toán tỷ lệ giữa chiều rộng và chiều cao của nhãn và hình ảnh
        double widthRatio = (double) labelWidth / imgWidth;
        double heightRatio = (double) labelHeight / imgHeight;

        // Tìm tỷ lệ nhỏ nhất để hình ảnh vừa với nhãn
        double minRatio = Math.min(widthRatio, heightRatio);

        // Tính toán kích thước mới của hình ảnh
        int newWidth = (int) (imgWidth * minRatio);
        int newHeight = (int) (imgHeight * minRatio);

        // Lấy hình ảnh mới đã được thay đổi kích thước
        Image scaledImg = img.getScaledInstance(newWidth, newHeight, Image.SCALE_DEFAULT);

        // Gán hình ảnh mới vào nhãn để hiển thị
        lblHinhAnh.setIcon(new ImageIcon(scaledImg));
//
//        } //else {
////            lblHinhAnh.setText("          Hình ảnh");
////            lblHinhAnh.setIcon(null);
////        }
    }

    void fillTable(List<Student> st) {
        tblModel = (DefaultTableModel) tblList.getModel();
        tblModel.setRowCount(0);
        for (Student student : st) {
            Object dataRow[] = new Object[7];
            dataRow[0] = student.getMaSV();
            dataRow[1] = student.getHoTen();
            dataRow[2] = student.getEmail();
            dataRow[3] = student.getSoDT();
            dataRow[4] = student.isGioiTinh() ? "nam" : "nữ";
            dataRow[5] = student.getDiaChi();
            dataRow[6] = student.getHinhAnh();

            tblModel.addRow(dataRow);
        }
    }

    void resetForm() {
        txtMaSV.setText("");
        txtHoTen.setText("");
        txtEmail.setText("");
        txtSoDT.setText("");
        rdoNam.setSelected(true);
        txtDiaChi.setText("");
        lblHinhAnh.setText("          Hình ảnh");
        lblHinhAnh.setIcon(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtMaSV = new javax.swing.JTextField();
        txtHoTen = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtSoDT = new javax.swing.JTextField();
        rdoNam = new javax.swing.JRadioButton();
        rdoNu = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDiaChi = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblList = new javax.swing.JTable();
        btnNew = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        lblHinhAnh = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 255));
        jLabel1.setText("QUẢN LÝ SINH VIÊN");

        jLabel2.setText("Mã SV:");

        jLabel3.setText("Họ Tên:");

        jLabel4.setText("Email:");

        jLabel5.setText("Số ĐT:");

        jLabel6.setText("Giới Tính:");

        jLabel7.setText("Địa Chỉ:");

        buttonGroup1.add(rdoNam);
        rdoNam.setText("Nam");

        buttonGroup1.add(rdoNu);
        rdoNu.setText("Nữ");

        txtDiaChi.setColumns(20);
        txtDiaChi.setRows(5);
        jScrollPane1.setViewportView(txtDiaChi);

        tblList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã SV", "Họ Tên", "Email", "Số ĐT", "Giới Tính", "Địa Chỉ", "Hình"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblListMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblList);

        btnNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/add.png"))); // NOI18N
        btnNew.setText("NEW");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/delete.png"))); // NOI18N
        btnDelete.setText("DELETE");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/save.png"))); // NOI18N
        btnSave.setText("SAVE");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/update.png"))); // NOI18N
        btnUpdate.setText("UPDATE");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        lblHinhAnh.setText("         Hình Ảnh");
        lblHinhAnh.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblHinhAnh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblHinhAnhMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(161, 161, 161)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(jLabel2))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(jLabel3))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel4))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(jLabel5))
                            .addComponent(jLabel6))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMaSV, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSoDT, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(rdoNam)
                                .addGap(35, 35, 35)
                                .addComponent(rdoNu)))
                        .addGap(52, 52, 52)
                        .addComponent(lblHinhAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(jLabel7)
                        .addGap(6, 6, 6)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnNew, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDelete))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnUpdate)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 650, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jLabel2)
                        .addGap(16, 16, 16)
                        .addComponent(jLabel3)
                        .addGap(16, 16, 16)
                        .addComponent(jLabel4)
                        .addGap(16, 16, 16)
                        .addComponent(jLabel5)
                        .addGap(13, 13, 13)
                        .addComponent(jLabel6))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtMaSV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(txtSoDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rdoNam)
                            .addComponent(rdoNu)))
                    .addComponent(lblHinhAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnNew)
                        .addGap(10, 10, 10)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnSave)
                        .addGap(12, 12, 12)
                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        String masv = txtMaSV.getText().trim();
        Student st = getModel();
        if (dao.checkMaSV(masv) > 0) {
            JOptionPane.showMessageDialog(this, "Mã sinh viên đã tồn tại !");
            txtMaSV.requestFocus();
            this.resetForm();
        }
        if (dao.Add(st) > 0) {
            JOptionPane.showMessageDialog(this, "Thêm sinh viên thành công");
            this.fillTable(dao.getAll());
            this.resetForm();
        } else {
            JOptionPane.showMessageDialog(this, "Thêm thất bại !");
            this.resetForm();
        }

    }//GEN-LAST:event_btnSaveActionPerformed

    private void tblListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblListMouseClicked
        int index = tblList.getSelectedRow();
        Student st = dao.getAll().get(index);
        this.setModel(st);
    }//GEN-LAST:event_tblListMouseClicked

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        int index = tblList.getSelectedRow();
        if (index == -1) {
            JOptionPane.showMessageDialog(this, "Bạn chưa chọn dòng cần update");
        } else {
            Student st = getModel();
            if (dao.Update(st) > 0) {
                JOptionPane.showMessageDialog(this, "Update thành công");
                this.fillTable(dao.getAll());
                this.resetForm();
            } else {
                JOptionPane.showMessageDialog(this, "Update thất bại !");
                this.resetForm();
            }

        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        this.resetForm();
    }//GEN-LAST:event_btnNewActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        int index = tblList.getSelectedRow();
        if (index == -1) {
            JOptionPane.showMessageDialog(this, "Bạn chưa chọn dòng cần xóa");
            return;
        }
        Student st = dao.getAll().get(index);
        if (dao.delete(st.getMaSV()) > 0) {
            JOptionPane.showMessageDialog(this, "Xóa thành công");
            this.fillTable(dao.getAll());
            this.resetForm();
        } else {
            JOptionPane.showMessageDialog(this, "Xóa thất bại");
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void lblHinhAnhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHinhAnhMouseClicked
        // TODO add your handling code here:
        try {
            JFileChooser jfc = new JFileChooser("B:\\JAVA3\\asmgd2\\src\\img");
            int chon = jfc.showOpenDialog(null);
            if (chon == 0) {
                File file = jfc.getSelectedFile();
                Image img = ImageIO.read(file);
                strHinhAnh = file.getName();
                lblHinhAnh.setText("");
                int width = lblHinhAnh.getWidth();
                int height = lblHinhAnh.getHeight();
                lblHinhAnh.setIcon(new ImageIcon(img.getScaledInstance(width, height, 0)));
            }

        } catch (IOException ex) {
            System.out.println("Lỗi: " + ex.toString());

        }
    }//GEN-LAST:event_lblHinhAnhMouseClicked

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
            java.util.logging.Logger.getLogger(ViewQLSV.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewQLSV.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewQLSV.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewQLSV.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewQLSV().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnUpdate;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblHinhAnh;
    private javax.swing.JRadioButton rdoNam;
    private javax.swing.JRadioButton rdoNu;
    private javax.swing.JTable tblList;
    private javax.swing.JTextArea txtDiaChi;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtHoTen;
    private javax.swing.JTextField txtMaSV;
    private javax.swing.JTextField txtSoDT;
    // End of variables declaration//GEN-END:variables
}
