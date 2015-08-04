    
package userclasses;

import java.util.ArrayList;
import java.util.List;


public class Contact {
    long id;
    String name;
    String email;
    List<Number> numbers;
            
    public Contact(long id,String name,String email){
        this.id=id;
        this.name=name;
        this.email=email;
        numbers=new ArrayList();
    }
    
    public Contact(){
        this.id=-1;
        
    }
    
    public void addNumber(Number number){
        this.numbers.add(number);
    }
    
    public long getId(){
        return this.id;
    }
    public String getName(){
     return this.name;   
    }
    public String getEmail(){
        return this.email;
    }
    
    public List<Number> getNumberList(){
        return this.numbers;
    }
}
