/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import Model.Grade;
import Model.Student;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

/**
 *
 * @author An Dong PC
 */
public class GradeRES {

    Connection con = null;
    PreparedStatement sttm = null;

    public List<Grade> getAll() {
        List<Grade> listGR = new ArrayList<>();
        ResultSet rs = null;
        Statement sttm = null;
        try {

            String sSQL = "SELECT top 3 GRADE.MASV, HoTen, TiengAnh, TinHoc, GDTC, (TiengAnh + TinHoc + GDTC) / 3 AS DiemTB FROM GRADE JOIN STUDENTS ON STUDENTS.MASV=GRADE.MASV ORDER BY DiemTB DESC";
            con = databaseHelper.DatabaseHelper.getDBConnect();
            sttm = con.createStatement();
            rs = sttm.executeQuery(sSQL);
            while (rs.next()) {
                Student st = new Student();
                st.setMaSV(rs.getString(1));
                st.setHoTen(rs.getString(2));

                Grade gr = new Grade();
                gr.setTiengAnh(rs.getInt(3));
                gr.setTinHoc(rs.getInt(4));
                gr.setgDTC(rs.getInt(5));
                
                gr.setStu(st);
                
                listGR.add(gr);
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

        return listGR;
    }//end getall
    
    public int Add(Grade gr) {
        try {
            String sSQL = "INSERT INTO GRADE(MASV,TiengAnh, TinHoc, GDTC) VALUES (?,?,?,?)";
            con = databaseHelper.DatabaseHelper.getDBConnect();
            sttm = con.prepareStatement(sSQL);
            
            sttm.setString(1, gr.getMaSV());
            sttm.setInt(2, gr.getTiengAnh());
            sttm.setInt(3, gr.getTinHoc());
            sttm.setInt(4, gr.getgDTC());
            
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
 
    public int checkMaSV(String maSV) {
        try {
            String sSQL = "SELECT * FROM GRADE WHERE MASV = ?";
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
    
    public int checkMaSVInStudent(String maSV) {
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
    
    public int delete(String maSV) {
        try {
            String sSQL = "DELETE GRADE WHERE MASV=?";

            con = databaseHelper.DatabaseHelper.getDBConnect();
            sttm = con.prepareStatement(sSQL);

            sttm.setString(1, maSV);

            if (sttm.executeUpdate() > 0) {
                System.out.println("delete thanh cong");
                return 1;
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }
        return -1;
    }
    
    public Grade timMaSVInGrade(String maSV) {
        
        ResultSet rs = null;
        Statement sttm = null;
        try {
            String sSQL = "SELECT HoTen, GRADE.MASV, TiengAnh, TinHoc, GDTC FROM GRADE JOIN STUDENTS ON STUDENTS.MASV=GRADE.MASV WHERE GRADE.MASV='"+maSV+"'";
            con = databaseHelper.DatabaseHelper.getDBConnect();
            sttm = con.createStatement();
            rs= sttm.executeQuery(sSQL);
            while (rs.next()) {                
                Student st=new Student();
                st.setHoTen(rs.getString(1));
                st.setMaSV(rs.getString(2));
                
                Grade gr = new Grade();
                gr.setTiengAnh(rs.getInt(3));
                gr.setTinHoc(rs.getInt(4));
                gr.setgDTC(rs.getInt(5));
                
                gr.setStu(st);
                
                return gr;
            }
        } catch (Exception e) {
            System.out.println("Error: "+e.toString());
        }
        finally{
            try {
                rs.close();
                sttm.close();
                con.close();
            } catch (Exception e) {
            }
        }
        return null;
    }
    public int update(Grade gr) {
        try {
            String sSQL = "UPDATE GRADE SET TiengAnh=?, TinHoc=?, GDTC=? WHERE MASV=?";

            con = databaseHelper.DatabaseHelper.getDBConnect();
            sttm = con.prepareStatement(sSQL);

            sttm.setString(4, gr.getMaSV());
            sttm.setInt(1, gr.getTiengAnh());
            sttm.setInt(2, gr.getTinHoc());
            sttm.setInt(3, gr.getgDTC());
            if (sttm.executeUpdate() > 0) {
                System.out.println("update thanh cong");
                return 1;
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }
        return -1;
    }
    
    public List<Grade> getAll1() {
        List<Grade> listGR = new ArrayList<>();
        ResultSet rs = null;
        Statement sttm = null;
        try {

            String sSQL = "SELECT HoTen, GRADE.MASV, TiengAnh, TinHoc, GDTC FROM GRADE JOIN STUDENTS ON STUDENTS.MASV=GRADE.MASV";
            con = databaseHelper.DatabaseHelper.getDBConnect();
            sttm = con.createStatement();
            rs = sttm.executeQuery(sSQL);
            while (rs.next()) {
                Student st=new Student();
                st.setHoTen(rs.getString(1));
                st.setMaSV(rs.getString(2));
                
                Grade gr = new Grade();
                gr.setTiengAnh(rs.getInt(3));
                gr.setTinHoc(rs.getInt(4));
                gr.setgDTC(rs.getInt(5));
                
                gr.setStu(st);
                
                listGR.add(gr);
                
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

        return listGR;
    }//end getall1
    
}
