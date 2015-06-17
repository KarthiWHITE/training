
package customerinvoices;

import java.io.BufferedReader;
import java.io.IOError;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CustomerInvoices {

    public static void main(String[] args)throws IOException{
        
       
        // creating objects for Service station, Employee, Customer and Vehicles
        
        ServiceStation ss=new ServiceStation("Vehile Cares", "40. Kanthan chavadi,chennai", "12345");
        
        Employee emp1= new Employee("karthi", 25, "9994901398", 101);
        Employee emp2= new Employee("Arun", 22, "8508525026", 102);
        Employee emp3= new Employee("karthikeyan", 26, "9994901398", 103);
        
        List<Employee> empList=new ArrayList<Employee>();
        
        empList.add(emp1);
        empList.add(emp2);
        empList.add(emp3);
        
        Customer cus1 = new Customer("Gobi", 24, "1234");
        Customer cus2 = new Customer("kumar", 30, "5678");
        Customer cus3 = new Customer("mano", 45, "901234");

        List<Customer> cusList=new ArrayList<Customer>();
                
        cusList.add(cus1);
        cusList.add(cus2);
        cusList.add(cus3);
        
        Vehicle vehicle1=new Vehicle("Bike", "Yellow", 1500);
        Vehicle vehicle2=new Vehicle("Car", "White", 10500);
        Vehicle vehicle3=new Vehicle("Bus", "Black", 14500);
        
        List<Vehicle> vehList=new ArrayList<Vehicle>();
        
        vehList.add(vehicle1);
        vehList.add(vehicle2);
        vehList.add(vehicle3);
        
        
        Invoice in1=new Invoice(cus3, vehicle1, emp2);
        Invoice in2=new Invoice(cus2, vehicle3, emp1);
        Invoice in3=new Invoice(cus1, vehicle2, emp3);
        
        List<Invoice> invList=new ArrayList<Invoice>();
        
        invList.add(in1);
        invList.add(in2);
        invList.add(in3);
        
        ss.setCusList(cusList);
        ss.setEmployeeList(empList);
        ss.setVehicleList(vehList);
        ss.setInvoiceList(invList);
        
        while(true){
        
        System.out.println("Menu\n PV : Print Vechicles \n PI : Print Invoice \n PE : Print Employee \n PC : Print Customer \n E : Exit");
        
            BufferedReader in= new BufferedReader(new InputStreamReader(System.in));
            String ch=in.readLine();
            switch(ch){
                case "PV":
                    //printing Vechicle details
                    ss.printVechiles();
                    break;
                case "PI":
                     //printing Invoices
                    ss.printInvoices();
                    break;
                case "PE":
                    //printing the Customers and Employee Details
                    ss.printEmplyees();
                    break;
                case "PC":
                    ss.printCustomers();
                    break;
                case "E":
                    System.out.println("The system will exit now");
                    System.exit(0);
            }
            
        }
    }
    
}
