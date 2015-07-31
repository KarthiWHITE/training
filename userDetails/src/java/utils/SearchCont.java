package utils;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import utils.DbUtils;

public class SearchCont{
    
    public static ResultSet getSearchContacts(String keyWord,int curuserid) throws SQLException, ClassNotFoundException{
        
       String sql="select id,name,email,res.types,res.num  from  contacts c  left join  ( 	SELECT contactid, GROUP_CONCAT(type SEPARATOR ', ')as types, GROUP_CONCAT(number SEPARATOR ', ') as num  FROM numbers n GROUP BY contactid )res on  c.id=res.contactid where c.userid= ? and (c.name like ? or res.num like ?)";
        PreparedStatement stmt = DbUtils.getPreparedStatement(sql);
        stmt.setInt(1, curuserid);
        stmt.setString(2, '%'+keyWord+'%');
        stmt.setString(3, '%'+keyWord+'%');
        ResultSet set=stmt.executeQuery();
        
        return  set;
    }
    
    
}