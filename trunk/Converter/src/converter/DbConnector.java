/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package converter;
import com.mysql.jdbc.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Andre
 */
public class DbConnector {
    String url;
    String username;
    String password;
    Connection connection;
    
    public DbConnector (String url,String username,String password){
        this.url = url;
        this.username = username;
        this.password = password;
        //load jdbc driver for mysql database
	try {
            System.out.println("Loading driver...");
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver loaded!"); 
        }catch(Exception e) {
            System.out.println("Unable to load Driver");
        }
    } 
    
    public void connect() throws SQLException{
        //Connect to database
        try {
            System.out.println("Connecting to database...");
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connection successfull!");
        } catch (SQLException e) {
            System.out.println("Unable to connect to database: "+e.toString());
        }
    }
    
    public void disconnect() throws SQLException{
        try {
            System.out.println("Disconnecting from database!");
            connection.close();
            System.out.println("Disconnected");
        } catch (SQLException e) {
            System.out.println("Can't disconnect: "  +e.toString());
        }
    }
    
    public ResultSet selectSqlQuery() throws SQLException{
       ResultSet resultSet;
       Statement statement = (Statement) connection.createStatement();
       if(statement != null) {
            try {
                 resultSet = statement.executeQuery("SELECT * FROM test1");
                 return resultSet;
            } catch (SQLException e) {
                 System.out.println("Unable to create statement: "+e.toString());
            }
	}
       return null;
    }
    
    public int insertNorskOrdbok() throws SQLException{
        int response;
        Statement statement = (Statement) connection.createStatement();
        if(statement != null) {
            try {
                response = statement.executeUpdate("INSERT INTO test120 (kolonne2) VALUES ('Mulla')");
                return response;
            } catch (SQLException e) {
                System.out.println("Unable to create statement: "+e.toString());
            }
	}
        return -1;
    }
    
    
    
}
