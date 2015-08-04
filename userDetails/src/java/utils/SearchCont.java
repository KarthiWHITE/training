package utils;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import userclasses.Contact;
import userclasses.Number;

public class SearchCont{
    /**
     * this method will return the list of contacts for given keyword and user id
     * @param keyWord the result list contains the contacts matched with at least one of (name,email or any phone number) 
     * @param curuserid
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException 
     */
    public static List<Contact> getSearchContacts(String keyWord,int curuserid) throws SQLException, ClassNotFoundException{
        
       String sql="select * from contacts c left join numbers n on c.id=n.contactid where userid=? and (name like ? or number like ? or email like ?);";
       PreparedStatement stmt = DbUtils.getPreparedStatement(sql);
       stmt.setInt(1, curuserid);
       stmt.setString(2, '%'+keyWord+'%');
       stmt.setString(3, '%'+keyWord+'%');
       stmt.setString(4, '%'+keyWord+'%');
       ResultSet set=stmt.executeQuery();
       
       List<Contact> contacts=new ArrayList();
      Contact contact=new Contact();
       while(set.next()){
           if(contact.getId()!=set.getLong("id")){
            contact=new Contact(set.getLong("id"),set.getString("name"), set.getString("email"));
            contacts.add(contact);
           }
           contact.addNumber(new Number(set.getInt("type"), set.getString("number")));
       }
        return  contacts;
    }
    
    public static void main(String[] args) {
    }
}