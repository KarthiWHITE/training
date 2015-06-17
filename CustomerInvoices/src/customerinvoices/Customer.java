
package customerinvoices;

/**
 *
 * @author Karthikeyan @ cb
 */
public class Customer extends Person{ 

    // there is no members needed bcz this class extends Person
    
    public Customer(String name, int age, String contact) {
        super(name, age, contact);
    }
    
    //Methos to print the person details
    
    public void printCutomer(){
        System.out.print("Customer Name : "+name);
        System.out.print("\t Age : "+age);
        System.out.println("\t Contact : "+contact+"\n-------------------------------------------------------------------------");
    }
}
