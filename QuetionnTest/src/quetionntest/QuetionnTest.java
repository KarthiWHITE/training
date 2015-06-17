/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package quetionntest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.ListIterator;

/**
 *
 * @author cb-admin1
 */
public class QuetionnTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)throws IOException{
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        Question q1=new Question("static is a", "variable", "keyword", "data type", "object", "keyword");
        Question q2=new Question("static is a", "variable", "keyword", "data type", "object", "keyword");
        Question q3=new Question("static is a", "variable", "keyword", "data type", "object", "keyword");
        Question q4=new Question("static is a", "variable", "keyword", "data type", "object", "keyword");
        
        ArrayList<Question> ql=new ArrayList<Question>();
        
        ql.add(q1);
        ql.add(q2);
        ql.add(q3);
        ql.add(q4);
        
        QuestionPaper qp1=new QuestionPaper(ql);
        QuestionPaper qp2=new QuestionPaper(ql);
        QuestionPaper qp3=new QuestionPaper(ql);
        QuestionPaper qp4=new QuestionPaper(ql);
        
        ArrayList<QuestionPaper> qpl=new ArrayList<QuestionPaper>();
        qpl.add(qp1);
        qpl.add(qp2);
        qpl.add(qp3);
        qpl.add(qp4);
        
        ListIterator lit = qpl.listIterator();
        
        while(lit.hasNext()){
            
            QuestionPaper qp=(QuestionPaper) lit.next();
            
            qp.conductTest();
           
            System.out.println("Do you want to continue text test? (y/n)");
            
            if(in.readLine().equals("n")){
                break;
            }
            
           
        }
        
    }
    
}
