/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import Model.Student;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author An Dong PC
 */
public class StudentRes {

    Connection con = null;
    PreparedStatement sttm = null;

    public List<Student> getAll() {
        List<Student> listST = new ArrayList<>();
        ResultSet rs = null;
        Statement sttm = null;
        try {

            String sSQL = "SELECT * FROM STUDENTS";
            con = databaseHelper.DatabaseHelper.getDBConnect();
            sttm = con.createStatement();
            rs = sttm.executeQuery(sSQL);
            while (rs.next()) {
                Student st = new Student();
                st.setMaSV(rs.getString(1));
                st.setHoTen(rs.getString(2));
                st.setEmail(rs.getString(3));
                st.setSoDT(rs.getString(4));
                st.setGioiTinh(rs.getBoolean(5));
                st.setDiaChi(rs.getString(6));
                st.setHinhAnh(rs.getString(7));

                listST.add(st);
            }

        } catch (Exception e) {
            System.out.println("Erorr" + e.toString());
        } finally {
            try {
                rs.close();
                sttm.close();
                con.close();
            } catch (SQLException ex) {
                System.out.println("Error" + ex.getLocalizedMessage());
            }
            
        }

        return listST;
    }//end getall
    
    public int Add(Student st) {
        try {
            String sSQL = "INSERT INTO STUDENTS(MASV,HoTen,Email,SoDT,GioiTinh,DiaChi,Hinh) VALUES(?,?,?,?,?,?,?)";
            con = databaseHelper.DatabaseHelper.getDBConnect();
            sttm = con.prepareStatement(sSQL);
            sttm.setString(1, st.getMaSV());
            sttm.setString(2, st.getHoTen());
            sttm.setString(3, st.getEmail());
            sttm.setString(4, st.getSoDT());
            sttm.setBoolean(5, st.isGioiTinh());
            sttm.setString(6, st.getDiaChi());
            sttm.setString(7, st.getHinhAnh());
            if (sttm.executeUpdate() > 0) {
                System.out.println("Them thanh cong");
                return 1;
            }
        } catch (Exception e) {
            System.out.println("error: " + e.toString());
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                System.out.println("Error" + ex.getLocalizedMessage());
            }
        }
        return -1;
    }//end add
    
    public int Update(Student st) {
        try {
            String sSQL = "UPDATE STUDENTS SET HoTen = ?, Email = ?, SoDT = ?, GioiTinh = ?, DiaChi = ? WHERE MASV = ?";
            con = databaseHelper.DatabaseHelper.getDBConnect();
            sttm = con.prepareStatement(sSQL);
            sttm.setString(1, st.getHoTen());
            sttm.setString(2, st.getEmail());
            sttm.setString(3, st.getSoDT());
            sttm.setBoolean(4, st.isGioiTinh());
            sttm.setString(5, st.getDiaChi());
            
            sttm.setString(6, st.getMaSV()); // Set the RegID as the last parameter

            // Debug information
            System.out.println("Executing SQL Query: " + sttm.toString());

            int rowsAffected = sttm.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Update successful. Rows affected: " + rowsAffected);
                return 1;
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
            e.printStackTrace();
        } finally {
            // If you are using manual commit, remember to commit the changes.
            // con.commit();

            try {
                con.close();
            } catch (SQLException ex) {
                System.out.println("Error" + ex.getLocalizedMessage());
            }
        }

        return -1;
    }//end update
    
    public int delete(String maSV) {
        try {
            String sSQL = "DELETE STUDENTS WHERE MASV = ?";
            con = databaseHelper.DatabaseHelper.getDBConnect();
            sttm = con.prepareStatement(sSQL);
            sttm.setString(1, maSV);
            if (sttm.executeUpdate() > 0) {
                System.out.println("Xoa thanh cong");
                return 1;
            }
        } catch (Exception e) {
            System.out.println("error: " + e.toString());
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                System.out.println("Error" + ex.getLocalizedMessage());
            }
        }
        return -1;
    }//end delete
    
    public int checkMaSV(String maSV) {
        try {
            String sSQL = "SELECT * FROM STUDENTS WHERE MASV = ?";
            con = databaseHelper.DatabaseHelper.getDBConnect();
            PreparedStatement st = con.prepareStatement(sSQL);
            st.setString(1, maSV);
            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                rs.close();
                st.close();
                con.close();
                return 1;
            } else {
                rs.close();
                st.close();
                con.close();
                return -1;
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.toString());
            e.printStackTrace();
            return -1;
        }
    }//end check masv
}
