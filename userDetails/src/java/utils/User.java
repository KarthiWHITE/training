package utils;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import jdk.nashorn.internal.codegen.CompilerConstants;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author cb-admin1
 */
public class User {
    private String name;
    private String fname;
    private String lname;
    private String email;
    private String line1;
    private String line2;
    private String city;
    private String state;
    private String country;
    private String zip;
    private String phone;
    public boolean addValid=true;
    
    public User setName(String name){
        this.name=name;
        return this;
    }
    
    public User setFName(String fname){
        this.fname=fname;
        return this;
    }
    
    public User setLName(String lname){
        this.lname=lname;
        return this;
    }
    
    public User setEmail(String email){
        this.email=email;
        return this;
    }
    
    public User setLine1(String line1){
        this.line1=line1;
        return this;
    }
    
    public User setLine2(String line2){
        this.line2=line2;
        return  this;
    }
    
    public User setState(String state){
        this.state=state;
        return this;
    }
    
    public User setCity(String city){
        this.city=city;
        return this;
    }
    public User setCountry(String country){
        this.country=country;
        return  this;
    }
    
    public  User setZip(String zip){
        this.zip=zip;
        return this;
    }
    
    public User setPhone(String phone){
     this.phone=phone;
     return this;
    }
    
    public String getName(){
        return this.name==null?"":this.name;
    }
    public String getEmail(){ 
        return this.email==null?"":this.email;
    }
    public String getFName(){
        return this.fname==null?"":this.fname;
    }
    public String getLName(){ 
        return this.lname==null?"":this.lname;
    }
    public String getLine1(){ 
        return this.line1==null?"":this.line1;
    }
    public String getLine2(){ 
        return this.line2==null?"":this.line2;
    }
    public String getCity(){ 
        return this.city==null?"":this.city;
    }
    public String getState(){ 
        return this.state==null?"":this.state;
    }
    public String getCountry(){ 
        return this.country==null?"":this.country;
    }
    public String getZip(){ 
        return this.zip==null?"":this.zip;
    }
    public String getPhone(){ 
        return this.phone==null?"":this.phone;
    }
    
    public static User getUser(String id) throws SQLException, ClassNotFoundException{
        
        User user=new User();
        
        Connection con=DbUtils.getConnection();
        
        PreparedStatement stmt=con.prepareStatement("select * from user where id=?");
        stmt.setString(1, id);
        ResultSet set=stmt.executeQuery();
        if(set.next()){
            user.setName(set.getString("name")).setEmail(set.getString("email")).setPhone(set.getString("phone"));
            stmt=con.prepareStatement("select * from address where userid=?");
            stmt.setString(1, id);
            set=stmt.executeQuery();
            if(set.next()){
                user.setFName(set.getString("fname")).setLName(set.getString("lname")).setLine1(set.getString("line1")).setLine2(set.getString("line2"))
                        .setCity(set.getString("city")).setCountry(set.getString("country")).setState(set.getString("state")).setZip(set.getString("zip"));
            }else{
                user.addValid=false;
            }
            
        }else{
            return null;
        }
        
        return user;
    }
}
