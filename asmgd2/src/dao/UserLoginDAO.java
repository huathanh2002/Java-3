/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import Model.UserLogin;
import View.ViewLogin;
import java.sql.*;

/**
 *
 * @author An Dong PC
 */
public class UserLoginDAO {
//    public UserLogin checkLogin(String username, String pass){
//        String sSQL="SELECT username, password, role FROM USERS WHERE username=? and password=?";
//        try(Connection con= databaseHelper.DatabaseHelper.openConnection();
//            PreparedStatement pstmt=con.prepareStatement(sSQL);) {
//            pstmt.setString(1, username);
//            pstmt.setString(2, pass);
//            try(ResultSet rs=pstmt.executeQuery();) {
//                if (rs.next()) {
//                    UserLogin uL=new UserLogin();
//                    uL.setUser(username);
//                    uL.setRole("role");
//                    return uL;
//                }
//            } catch (Exception e) {
//            }
//        } catch (Exception e) {
//        }
//        return null;
//    }

    public static boolean checkLogin(String username, String pass) {
        int row=0;
        try {
            Connection con = databaseHelper.DatabaseHelper.getDBConnect();
            Statement stm = con.createStatement();
            String sSQL = "SELECT username, password, role FROM USERS WHERE username='"+username+"' AND password='"+pass+"'";
            ResultSet rs=stm.executeQuery(sSQL);
            while (rs.next()) {
                row=1;
                String un=rs.getString(1);
                String pwd=rs.getString(2);
                String role=rs.getString(3);
                ViewLogin.USER=new UserLogin(un, pass, role);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (row>0);
    }
}
