
package task9;

public class Lecturer extends SubPersonViewer implements Person{

    String subject;
    
    public Lecturer(String name,String email,String subject){
        super(name,email);
        this.subject=subject;
    }
    
    @Override
    public String getDescription() {
        return "Teaches "+subject;
    }
    
    public String getSubject(){
        return subject;
    }
}
