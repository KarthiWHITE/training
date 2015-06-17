/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package exceptiondemo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author cb-admin1
 */
public class ExceptionDemo {

    /**
     * @param args the command line arguments
     */
    
    private static BufferedReader in;
    
    public static void main(String[] args) throws IOException{    //here we re through the IOExeception
        
        in=new BufferedReader(new InputStreamReader(System.in));
        
       
        
        int[] b={1,2,3};
        
        try{
            
            int n=get();
            System.out.println(5/n);
            System.out.println(b[5]);
            
            
            
        
        }catch(NumberFormatException nm){                       //here we caught the invalid number format in user input
            System.out.println("invalid Number format");
        }catch(ArithmeticException ae){                         //for arithmetic exceptions like dived by zero
            System.out.println("Divde by zero");
        }catch(ArrayIndexOutOfBoundsException aiob){            //array index out of bounds
            System.out.println("array index ouot of bounds");
        }catch(Exception e){                                    //incase of any other exception takes place in the code inside the try block
            System.out.println("Error");
        }
        
    }
    private static int get()throws IOException{ //re through the IOException to the called method. this exception where handled in that method
    
        return Integer.parseInt(in.readLine());
    }
    
}
