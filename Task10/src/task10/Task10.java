/*

Task No :10

    Given a array of strings store all strings in a map of list keyed by their sizes. 
    First provide me a visual representation of this in the paper.
    Then print the map and the list nicely.

*/
package task10;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;


/**
 *
 * @author Karthikeyan @ CB
 */
public class Task10 {

    public static void main(String[] args) {
        
        //creating HashMap Object to Store the Strings
        
        Map m=new HashMap();
        
        //Test case 1 to test the code
        
        String[] str={"one","two","Three","Four","five","six","seven","eight","nine","Ten"};
        
        //fetch a string from the given array
        //and check its length is already as a key in a map
        
        for (String st : str) {
            int stLen=st.length();
            //check key is available or not
            
            if(!m.containsKey(stLen)){
                //if the length is not avilable the create that length as a key and group the string which are all in that length
                
                ArrayList<String> al=new ArrayList<String>();
                al.add(st);
                m.put(stLen,al);
                
            }else{
                ArrayList<String> tmp = (ArrayList<String>) m.get(stLen);
                tmp.add(st);
                m.put(stLen,tmp);
                    
            }
        }
        
        // create a iterator for key set to read the list one by one from the map
        
        Iterator i= m.keySet().iterator();
        
        while(i.hasNext()){
            int k=(int)i.next();
            System.out.println("Length : "+k);
            
            //Read the  list from the map and list out its strings
            
            ListIterator lit=((ArrayList)m.get(k)).listIterator();
            while(lit.hasNext()){
                System.out.println(lit.next().toString());
            }
            
        }
    }
    
}
