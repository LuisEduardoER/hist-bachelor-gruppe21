/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package converter;

import java.sql.ResultSet;
import java.sql.SQLException;


/**
 *
 * @author Andre
 */
public class DBtest {
    public static void main (String[] args) throws SQLException{
        String url  = "jdbc:mysql://158.38.120.160:3306/test offline sync" ;
        String username = "andre";
        String password  = "f3ilif";
        
        DbConnector db = new DbConnector(url, username, password);
        db.connect();
        
        ResultSet res;
        /*res = db.selectSqlQuery();
        while (res.next()){
            System.out.println(res.getString(1));
        } 
        db.insertNorskOrdbok();
        */
        db.disconnect();
    }
}
