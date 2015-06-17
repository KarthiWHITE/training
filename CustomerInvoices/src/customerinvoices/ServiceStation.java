/**
 *
 * @author Karthikeyan @ cb
*/


package customerinvoices;


import java.util.List;
import java.util.ListIterator;



public class ServiceStation {

    //members
    
    private final String name,address,contact;
    
    private List<Employee> empList;
    
    private List<Customer> cusList;
    
    private List<Invoice> invList;
    
    private List<Vehicle> vehList;
    
   
    //constructor
    
    public ServiceStation(String name,String address,String contact){
    
        this.name=name;
        
        this.address=address;
        
        this.contact=contact;
        
    }
  
    //method to print the service station details
    
    public void printServiceStation(){
    
        System.out.println("Service Station : "+name+" \nAddress : "+address+" \nContatct No : "+contact+"\n-------------------------------------------------------------------------");
    }
    
    public void setEmployeeList(List<Employee> empList){
            this.empList=empList;
    }
    
    public void setCusList(List<Customer> cusList){
        this.cusList=cusList;
    }
    
    public void setInvoiceList(List<Invoice> invLlist){
        this.invList=invLlist;
    }
    
    
    public void setVehicleList(List<Vehicle> vehList){
        this.vehList=vehList;
    }
    
    public void printEmplyees(){
        if(empList.isEmpty()){
            System.out.println("There is no employee in this service station.");
        }else{
            ListIterator it=empList.listIterator();
            while(it.hasNext()){
                ((Employee)it.next()).printEmployee();
            }
        }
    }
 
    public void printCustomers(){
        if(cusList.isEmpty()){
            System.out.println("There is no customer available in this Service station.");
        }else{
            ListIterator it=cusList.listIterator();
            while(it.hasNext()){
                ((Customer)it.next()).printCutomer();
            }
        }
    }
    
    public void printInvoices(){
        if(invList.isEmpty()){
            System.out.println("There is no Invoice available in this servive station.");
        }else{
            ListIterator it=invList.listIterator();
            while(it.hasNext()){
                ((Invoice)it.next()).printInvoice();
            }
        }
    }
    
    public void printVechiles(){
        if(vehList.isEmpty()){
            System.out.println("There is no vechicle will get repaired in this service station.");
        }else{
            ListIterator it=vehList.listIterator();
            while(it.hasNext()){
                ((Vehicle)it.next()).printVehicle();
            }
        }
    }
    
}

