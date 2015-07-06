/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jdbc1;

import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;


public class JdbcDemo {

    public static void main(String[] args) {
        Connection con;
        PreparedStatement smt;
        ResultSet rs;
        try{
            
        con=DriverManager.getConnection("jdbc:mysql://localhost/inv?user=root&password=");
            
        con.setAutoCommit(false);
            //before insert the values
        
            System.out.println("before the insert takes place in db");
            
            printResultSet(con);
            
            smt=(PreparedStatement) con.prepareStatement("insert into stations values(?,?,?,?)");
            
            //creating batch
            
            //1=>station id
            //2=>station name
            //3=>address
            //4=>contact
            
            smt.setInt(1, 105);
            smt.setString(2, "sta5");
            smt.setString(3,"xxx");
            smt.setString(4,"12345");
            smt.addBatch();
           
            smt.setInt(1, 106);
            smt.setString(2, "sta6");
            smt.setString(3,"xxx");
            smt.setString(4,"12345");
            smt.addBatch();
            
            smt.setString(1, "107");
            smt.setString(2, "sta7");
            smt.setString(3,"xxx");
            smt.setString(4,"12345");
            smt.addBatch();
            
            smt.execute();
            
            System.out.println("Batch excuted but yet to commited");
 
            printResultSet(con);
            
            con.rollback();

            System.out.println("db Commited");
            printResultSet(con);
            
            con.close();
        
        }
        catch(SQLException ex){
            System.out.println(ex.toString());
        }
    }
    
    private static void printResultSet(Connection con)throws SQLException{
    
        ResultSet rs=con.prepareStatement("select * from stations").executeQuery();
        
        while(rs.next()){
            
            int stationId=rs.getInt("stationId");
            
            String stationName=rs.getString("stationName");
            
            String address=rs.getString("address");
            
            String contact=rs.getString("contact");
            
            
            System.out.print("Station Id : "+stationId
                            +"\tStation Name: "+stationName
                            +"\tAddress :"+address
                            +"\tContact :"+contact+"\n");
            
        }
    
    }
    
}
