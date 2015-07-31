/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.spi.DirStateFactory;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author cb-admin1
 */
public class DbUtils {
    
    public static Connection getConnection() throws SQLException, ClassNotFoundException{
        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/training","root","");    
    }
    
    public static JSONObject getContacts(String userid){
        String sql="select * from contacts";
        return null;
    }
    
    public static JSONArray getContatTypes() throws Exception{
        String sql="select * from types";
        
        
            ResultSet set=getConnection().prepareStatement(sql).executeQuery();
            JSONArray types=new JSONArray();
            
            while(set.next()){
                JSONObject type=new JSONObject();
                type.put("type", set.getString("type"));
                type.put("value", set.getString("val"));
                types.put(type);
            }
            
        return  types;
    }
    public static PreparedStatement getPreparedStatement(String sql) throws SQLException, ClassNotFoundException{
        return getPreparedStatement(sql, -1);
    }
    
    public static PreparedStatement getPreparedStatement(String sql, int n) throws SQLException, ClassNotFoundException{
        
        Connection con=getConnection();
        if(n==-1){
            return con.prepareStatement(sql);
        }else{
            return con.prepareStatement(sql,n);
        }
    }
    public static void main(String[] args)throws Exception{
        JSONArray arr=getContatTypes();
        for(int i=0;i<arr.length();i++){
            System.out.println(arr.getJSONObject(i).toString());
        }
    }
    
    public static Long insertAndGetId(PreparedStatement stmt) throws SQLException{
        
        int affectedRows = stmt.executeUpdate();

        if (affectedRows == 0) {
            throw new SQLException("Inserted Failed, no ID obtained.");
        }
        ResultSet generatedKeys = stmt.getGeneratedKeys();
        
            if (generatedKeys.next()) {
                return generatedKeys.getLong(1);
            }
            else {
                throw new SQLException("Inserted Failed, no ID obtained.");
            }
    
    }
}
