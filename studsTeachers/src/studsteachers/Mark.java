
package studsteachers;

public class Mark {
    String subject;
    long mark;
    
    public Mark(String subject,long mark){
        this.mark=mark;
        this.subject=subject;
    }
    
    public String getSubject(){
    
        return subject;
    
    }
    public long getMark(){
        
        return mark;
    }
}
