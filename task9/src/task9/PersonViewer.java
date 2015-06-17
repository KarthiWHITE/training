
package task9;

public class PersonViewer {
    public String name,email;
    
    public PersonViewer(String name,String email){
        
        this.name=name;
        this.email=email;
    }
    
    public void view(){
        System.out.println("Name : "+name);
        System.out.println("Email : "+email);
    }
}
