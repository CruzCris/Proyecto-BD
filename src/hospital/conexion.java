/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author crist
 */
public class conexion {
    
    public String usuario = "drackzy";
    public String pass = "mechacorta";
    public String url = "jdbc:sqlserver://localhost:1433;databaseName=Hospital;";
    public Connection cn = null;
    public Statement st = null;
    
    public Statement Conectar(){
        try{
            Connection cn = DriverManager.getConnection(url,usuario,pass);
            st = cn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        }catch(SQLException i){
            JOptionPane.showMessageDialog(null, i);
        }
        return st;
    }
    
}
