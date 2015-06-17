
package task9;


public class Employee extends SubPersonViewer implements Person{

     String department;
     
       public Employee(String name,String email,String department){
           super(name,email);
           this.department=department;
       }
    @Override
    public String getDescription() {
        return "This employee working in "+department;
    }
    
    public String getDepartment(){
        return department;
    }
    
}
