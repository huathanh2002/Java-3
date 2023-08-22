/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package databaseHelper;
import java.sql.*;

/**
 *
 * @author An Dong PC
 */
public class DatabaseHelper {
//    public static Connection openConnection() throws Exception{
//        Class.forName("com.microsoft.sqlserver.jsbc.SQLServerDriver");
//        String connectionUrl="jdbc:sqlserver://THANH:1433;encrypt=true;trustServerCertificate=true;databaseName=FPL_DaoTao";
////        ;user=sa;password=123456
//         String user="sa";
//         String password="123456";
//         Connection con =DriverManager.getConnection(connectionUrl,user,password);
//         return con;
//    }
    public static final String connectionUrl = "jdbc:sqlserver://THANH:1433;encrypt=true;trustServerCertificate=true;"
            + "databaseName=FPL_DaoTao;user=sa;password=123456";
    public static Connection getDBConnect(){
        Connection conn=null;
        try {
            Class.forName("com.microsoft.sqlserver.jsbc.SQLServerDriver");
        } catch (Exception e) {
            //System.out.println("Chưa có Driver !"+e.toString());
        }
        
        try {
            conn=DriverManager.getConnection(connectionUrl);
            return conn;
        } catch (Exception e) {
            //Lỗi sai tên database
            //lỗi tên đăng nhập và mật khẩu
            System.out.println("Lỗi connect"+e.toString());
        }
        return null;
    }
}
