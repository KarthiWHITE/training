
package task9;

import java.util.ArrayList;
import java.util.ListIterator;

public class PersonViewerTest {
    private static ArrayList list;
    public static void main(String[] args) {
        
        list = new ArrayList();
         list.add(new Student("karthi", "karthikeyan@chargebee.com", "B"));
        list.add(new Employee("arun","arun@gmail.com", "Civil"));
        list.add(new Lecturer("kk", "kk@gmail.com", "Java"));
        
        ListIterator li=list.listIterator();
        
        while(li.hasNext()){
            PersonViewer pv=(PersonViewer)li.next();
            pv.view();
        }
    }
    
}
