/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package emiealculator;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ListIterator;
import org.apache.commons.csv.*;
import org.apache.commons.io.FileUtils;
/**
 *
 * @author cb-admin1
 */
public class EmiEalculator {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static double emiCalculation() throws Exception {
        
        CSVParser csvParser=new CSVParser(new FileReader("sal.csv"), CSVFormat.EXCEL);
         
        List<CSVRecord> list=csvParser.getRecords();
        
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        
        printAllRecords(list);
        
        System.out.println("Enter the Account No");
        
        int acno=Integer.parseInt(in.readLine());
        
        int salary=getSalary(list,acno);
        
        
        
        if(salary==-1){
            
            Exception AccountNoNotFound=new AccountNoNotFount("AccountNoNotFound");
            
            throw AccountNoNotFound;
            
        }else if(salary<15000){
            
            Exception SalaryUnderLimit=new SalaryUnderLimit("SalaryUnderLimit");
            
            throw SalaryUnderLimit;
        }else{
        
            System.out.println("You are eligible to get Loan from as.");
            
            System.out.println("Please enter the loan amount:");
            
            
            long loanAmount=Long.parseLong(in.readLine());
            
            
            if(loanAmount<100000||loanAmount>2500000){
            
               Exception LoanExitesLimt =new LoanExitesLimt("LoanExistLimt"); //throw user defined exception
               //Exception LoanExitesLimt =new Exception("Loan amount should gerater than 1L and less than 25L"); //throw user defined exception
               
               throw  LoanExitesLimt;
                
            }else{
                
                System.out.println("Please enter the intrest Rate in %.");
                
                int intrestRate=Integer.parseInt(in.readLine());
                
                System.out.println("Enter the EMI  Period in Years.");
                
                int emiPeriod=Integer.parseInt(in.readLine());
                
                double intrest=loanAmount*emiPeriod*12*intrestRate/100;
                
                double totalAmount=loanAmount+intrest;
                
                double emiPerMonth=totalAmount/(emiPeriod*12);
                
                return emiPerMonth;
                
            }
        
        }
             
    }
    
    
    //list all the records
    private static void printAllRecords(List<CSVRecord> listOfRecords){
        ListIterator lit=listOfRecords.listIterator();
      //  lit.next();
        while(lit.hasNext()){
           
            CSVRecord csvR=((CSVRecord)lit.next());
           
            
            
            System.out.println(csvR.get(0));
        }
    }
  
    
    //to get the salary of an account no if account no is not available then return -1
    
    private static int getSalary(List<CSVRecord> listOfRecords,int accno){
    
        ListIterator<CSVRecord> lit=listOfRecords.listIterator();
        
        lit.next();
        
        while(lit.hasNext()){
            
            CSVRecord csvR = lit.next();
            
            if(Integer.parseInt(csvR.get(0))==accno){
                return Integer.parseInt(csvR.get(1));
            }
            
        }
        return -1; //incase the accno is not available.
    }
    
    
    public static boolean  NewAccount() throws Exception{
    
        CSVParser csvParser=new CSVParser(new FileReader("sal.csv"), CSVFormat.EXCEL);
         
        List<CSVRecord> list=csvParser.getRecords();
        
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        
        System.out.println("Enter the account number : ");
        
        int accountNo=Integer.parseInt(in.readLine());
        
        if(checkAccountNo(accountNo,list)){
            
            System.out.println("Enter the salary.");
            
            int newSalary=Integer.parseInt(in.readLine());
            
          //  FileWriter fil=new FileWriter("sal.csv");
               // CSVPrinter csvp=new CSVPrinter(fil, CSVFormat.EXCEL);
                
               // ListIterator lit=list.listIterator();
                
               /// while(lit.hasNext()){
                  //  csvp.printRecord(((CSVRecord)lit.next()).toString());
                //}
                String aa=Integer.toString(accountNo)+","+Integer.toString(newSalary);
                
                FileUtils.writeStringToFile(new File("sal.csv"), aa, true);
                
              //  csvp.printRecord(aa);
                
            //    csvp.close();
              //  fil.close();
            
        }else{
           throw new Exception("Accno is ");
        }
   
        return true;
     
    }
    
    private static boolean checkAccountNo(int accountNo,List<CSVRecord> listOfRecords){
    
        ListIterator<CSVRecord> lit=listOfRecords.listIterator();
        
        lit.next();
        
        while(lit.hasNext()){
            
            if(accountNo==Integer.parseInt(lit.next().get(0))){
                return false;
            }
        }
        return true;
        
    }

}
