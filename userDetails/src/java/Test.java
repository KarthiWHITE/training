
import org.json.JSONObject;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author cb-admin1
 */
public class Test {
     public static void main(String[] args) throws Exception {
        JSONObject mssg=new JSONObject();
        mssg.put("COMMAND STATUS","---CMD-SUCCEEDED---");
        
        mssg.put("InstatnceName", "test");
        System.out.println(mssg.toString());
        //sendMsg(mssg.toString());
    }
}
