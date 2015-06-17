
package quetionntest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.ListIterator;

public class QuestionPaper {
    
    
    private int noofQuestions;
    
    private static int overAllMarks=0;
    private ArrayList<Question> questions;
    
    public QuestionPaper(ArrayList<Question> questions){
        
        this.noofQuestions=questions.size();
        this.questions=questions;
    }
    
    public void conductTest()throws IOException{
        
        int totalMark=0;
    

    
    BufferedReader in= new BufferedReader(new InputStreamReader(System.in));
    System.out.println("This test consist of "+noofQuestions+" questions\nEach questions carries 4 marks if ans is correct \n -1 for each wrrong ans.");
    
        ListIterator lit=questions.listIterator();
        
        while(lit.hasNext()){
            
            Question q=(Question) lit.next();
            
            q.printQuestion();
            
            System.out.print("Enter your Ans : ");
            
            if(q.check(in.readLine())){
                
                
                totalMark+=4;
                
            }else{
                
                System.out.println("The correct ans is : "+q.getAns());
                
                totalMark-=1;
            }
            
        }
    overAllMarks+=totalMark;
        System.out.println("______________________________________________");
    System.out.println("The Total marks in the test "+ totalMark);
    System.out.println("The over all marks "+ overAllMarks);
    System.out.println("______________________________________________");
    
    }
}
