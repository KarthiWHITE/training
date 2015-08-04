/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package utils;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author cb-admin1
 */
public class Utils {
    
    public enum MobileTypes{
        PHONE(100), HOME(200), WORK(300);
        private final int type;

        private MobileTypes(int type) {
            this.type=type;
        }
        
        public int value(){
            return type;
        }   
    }
    
    public static String getUserID(HttpServletRequest request){
        return request.getSession().getAttribute("userid").toString();
    }
    
    public static void main(String[] args) {
        for(MobileTypes m:MobileTypes.values()){
            System.out.println(m.value());
        }
    }
}
