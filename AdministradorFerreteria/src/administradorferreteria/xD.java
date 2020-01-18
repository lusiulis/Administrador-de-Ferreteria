/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package administradorferreteria;

import cr.ac.database.managers.DBManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class xD {

    private static final String DATABASE = "ferreteria";
    private static final String USER = "root";
    private static final String PASSWORD = "1234";
    
    public xD() {
        Leer();
    }
    
    
    public void Leer(){
        try {
            //Class.forName("com.mysql.jdbc.Driver");
            DBManager db = DBManager.getDBManager(DBManager.DB_MGR.MYSQL_SERVER);
            Connection con = db.getConnection(DATABASE, USER, PASSWORD);
            Statement stmt = con.createStatement();
            String sql = "SELECT * FROM ferreteria.producto";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                Object ob = rs.getObject("idTipo");
                tipo t = (tipo)ob;
                System.out.println(t);
            }
            con.close();
        } catch (Exception ex) {
            Logger.getLogger(xD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
