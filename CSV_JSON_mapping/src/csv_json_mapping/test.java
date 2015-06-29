/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package csv_json_mapping;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import javax.swing.text.html.HTMLDocument;
import org.json.JSONObject;

/**
 *
 * @author cb-admin1
 */
public class test {
    public static void main(String[] args) throws Exception {
        File src=new File(System.getProperty("user.home")+"/myrepo/training/extfiles/config.json");
        
        FileInputStream fin=new FileInputStream(src);
        
        byte[] b=new byte[fin.available()];
      
        fin.read(b);
        
        JSONObject ob=new JSONObject(new String(b));
        
        Iterator it=  ob.keys();
        while (it.hasNext()) {
            
            System.out.println(it.next());
            
        }
        System.out.println(ob);
        
        
    }
}
