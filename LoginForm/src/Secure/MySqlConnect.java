/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Secure;
import java.sql.*;
import javax.swing.*;
/**
 *
 * @author Admin
 */
public class MySqlConnect {
    Connection conn = null;
    public static Connection ConnectDB(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/users", "root", ""); //localhost/(schema), "(username)", "(password)";
            JOptionPane.showMessageDialog(null, "Connected to Database!");
            return conn;
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
            return null; 
            
        }
        
    }
}
