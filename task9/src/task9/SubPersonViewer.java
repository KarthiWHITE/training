
package task9;

public class SubPersonViewer extends PersonViewer{

    
    
    public SubPersonViewer(String name, String email) {
        super(name, email);
    }
    
   
    public void view(){
        if(this instanceof Student){
            viewPerson((Student)this);
        }else if(this instanceof Employee){
            viewPerson((Employee)this);
        }else if(this instanceof Lecturer){
            viewPerson((Lecturer)this);
        }
    }
    
    public void viewPerson(Student stu){
        view();
        System.out.println(stu.getDescription());
    }
    public void viewPerson(Employee emp){
        view();
        System.out.println(emp.getDescription());
    }
    public void viewPerson(Lecturer lec){
        view();
        System.out.println(lec.getDescription());
    }
}
