
package task11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.TreeMap;

public class Task11 {
public static void main(String[] args) {
        
        //creating TreeMap Object to Store the Strings in sorted order
        
        TreeMap m=new TreeMap();
        
        //Test case 1 to test the code
        
        String[] str={"One","Two","Ball","Three","Four","Thread","Tive","Ball","Six","Seven","Eight","Nine","Arun","Ten"};
        
        //fetch a string from the given array
        //and check its prefix is already as a key in a map
        
        for (String st : str) {
            String prefix=st.substring(0,3);
            //check key is available or not
            
            if(!m.containsKey(prefix)){
                
                //if the prefix(key) is not avilable the create that prefix as a key and group the string which are all in that prefix
                
                List tmp=new ArrayList();
                for(String s : str){
                    if(prefix.equals(s.substring(0,3))){
                        tmp.add(s);
                    }
                }
                //add the key  and the corresponding list to the map
                
                m.put(prefix, tmp);
                
            }
        }
        
        // create a iterator for key set to read the list one by one from the map
        
        Iterator i= m.keySet().iterator();
        
        while(i.hasNext()){
            String k=(String)i.next();
            System.out.println("Prefix : "+k);
            
            //Read the  list from the map and list out its strings
            ArrayList al=(ArrayList)m.get(k);
            Collections.sort(al);
            ListIterator lit=al.listIterator();
            while(lit.hasNext()){
                System.out.println(lit.next().toString());
            }
            
        }
    }
    
}
