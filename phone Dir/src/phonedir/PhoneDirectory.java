package phonedir;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;




public class PhoneDirectory{
    
    List<Contact> cList = new ArrayList<Contact>() ;

    String[][] cAList={{"karthi","123","987","345"},{"keyan","123","875","243432"},{"karthi","325","49658","3423"},{"karthikeyn","123","234","3456"}};
    
    /**
     * this method is used to assign the contact to list from the array
     */
    
   public void assignToList(){
   
        for(String[] str:cAList){
            cList.add(new Contact(str[0],str[1],str[2],str[3]));
        }
   
   }
   
   /**
    * This method for searching the contact info which are all has the given cell no
    * @param cellNo String type parameter
    */
   
   public void searchByCellNo(String cellNo){
   
       List<Contact> resultContacts=new ArrayList<Contact>();
       
       for(Contact c:cList){
           
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