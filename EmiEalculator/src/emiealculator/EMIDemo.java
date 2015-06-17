/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package emiealculator;

/**
 *
 * @author cb-admin1
 */
public class EMIDemo {
    
    public static void main(String ar[]){
    
        try{
        
           System.out.println("EMI Amount : "+EmiEalculator.emiCalculation());
        
        
        }catch(AccountNoNotFount ac){
            
            System.out.println("The given account number is not found. Set up a new Account.");
            
            try{
            EmiEalculator.NewAccount();
            }catch(Exception e){
                System.out.println(e.toString());
            }
            
        }catch(SalaryUnderLimit sul){
            
            System.out.println("Salary  under the limit for the given account number. we cant proceed further   ");
        
        }catch(LoanExitesLimt e){
        
            System.out.println("Loaan amount should between 1l and 25l");
            
        }catch(Exception e){
            System.out.println("");
        }
        
        
    }
}
