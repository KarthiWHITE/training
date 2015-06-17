
package customerinvoices;

/**
 *
 * @author cb-admin1
 */
public class Employee extends Person{
    
    //member variable others in Person class
    
    private final int emp_Id;

    public Employee(String name, int age, String contact,int emp_Id) {
        
        // invoke super class constructor
        
        super(name, age, contact);
        
        this.emp_Id=emp_Id;
    
    }
    
    //method to print the employee details
    
    public void printEmployee(){
        
        System.out.println("Employee Id     : "+emp_Id);
        System.out.println("Employee Name   : "+name);
        System.out.println("Age             : "+age);
        System.out.println("Employee Contact : "+contact+"\n-------------------------------------------------------------------------");
        
    }
    
}
