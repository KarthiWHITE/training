package phonedirjson;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;




public class PhoneDirectory{
    
    List<Contact> cList = new ArrayList<Contact>() ;

    File src;
    
    
    public PhoneDirectory(File src){
        
        this.src=src;
    }
    
    /**
     * this method is used to assign the contact to list from the json file
     */
   public void assignToList() throws Exception{
   
        JSONArray condactsobject=(JSONArray)new JSONParser().parse(new FileReader(src));
        
        for(Iterator<JSONObject> it=condactsobject.iterator();it.hasNext();){
            
            JSONObject contact=it.next();
            String name=(String)contact.get("Name");
            String phone=(String)contact.get("Phone");
            String home=(String)contact.get("Home");
            String work=(String)contact.get("Work");
            
            cList.add(new Contact(name,phone,home,work));
        
        }
        
       
   }
   
   /**
    * This method for searching the contact info which are all has the given cell no
    * @param cellNo String type parameter
    */
   
   public void searchByCellNo(String cellNo){
   
       List<Contact> resultContacts=new ArrayList<Contact>();
       
       for(Contact c : cList){
          
           if(c.mobile.equals(cellNo)||c.home.equals(cellNo)||c.work.equals(cellNo))
               resultContacts.add(c);
              
       }
       
       if(resultContacts.isEmpty()){
           System.out.println("There is no contact info with CellNo : " + cellNo);
       }else{
           System.out.println("The contact info for cell No "+cellNo+" is : ");
           printList(resultContacts);
       }
   }
   
   /**
    * this method will search the contact details if the name of the contact contains the given string
    * @param nameContains  String type parameter to search the contact details
    */
   
  public void searchByNameContains(String nameContains){
      
      searchByName(nameContains, false);
  
  } 
   
   
  /**
   * this method will list all the contacts which is matches with given name
   * @param name 
   */
  public void searchByName(String name){
      searchByName(name,true);
  }
  
  /**
   * this method serve to the both search by name and name contains specified string if isEquals is false
   * @param name
   * @param isEquals  boolean that denotes the name is equal (true) or contains (false)
   */
   private void searchByName(String name, boolean isEquals){
   
       List<Contact> resultContacts=new ArrayList<Contact>();
       
       for(ListIterator<Contact> itr=cList.listIterator();itr.hasNext();){
          
           Contact c=itr.next();
           
           if(c.name.equals(name) && isEquals)
               resultContacts.add(c);
           else if(c.name.contains(name) && !isEquals){
               resultContacts.add(c);
           }
              
       }
       
       if(resultContacts.isEmpty()){
           System.out.println("There is no contact info with name : " + name);
       }else{
           System.out.println("The contact info for name "+name+" is : ");
           printList(resultContacts);
       }
   }
   
   
   /**
    * print the filtered contacts
    * @param cList 
    */
   private void printList(List<Contact> cList){
       
       for(ListIterator itr=cList.listIterator(); itr.hasNext();){
           Contact c=(Contact)itr.next();
           System.out.println("Name : "+c.getName());
           System.out.println("Mobile : "+c.mobile);
           System.out.println("Home : "+c.home);
           System.out.println("work : "+c.work);
           System.out.println("----------------------------------------");
       }
   
   }
   
   
   
    /**
     * It will print the all the contact from the list
     */
   public void printList(){
   
       for(ListIterator itr=cList.listIterator(); itr.hasNext();){
           Contact c=(Contact)itr.next();
           System.out.println("Name : "+c.name);
           System.out.println("Mobile : "+c.mobile);
           System.out.println("Home : "+c.home);
           System.out.println("work : "+c.work);
       }
   }
}