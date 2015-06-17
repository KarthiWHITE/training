/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package task12;

import java.util.ArrayList;
import java.util.Date;
import java.util.ListIterator;

/**
 *
 * @author cb-admin1
 */
public class Assessment {
    private final int assessmentId,noQuestions;
    private final String desc;
    private final Date dtAssessment;
    
    public final ArrayList<Question> qustionList;
    
    
    public int getTotalMarks(){
        int totalMarks=0;
        
        ListIterator lit=qustionList.listIterator();
        
        while(lit.hasNext()){
            totalMarks+=((Question)lit.next()).getMarks();
        }
        return totalMarks;
    }
    
    public Assessment(int assessmentId,String desc,int noQuestions,Date dtassessment,ArrayList<Question> questionList){
        
        this.assessmentId=assessmentId;
        this.desc=desc;
        this.noQuestions=noQuestions;
        this.dtAssessment=dtassessment;
        this.qustionList=new ArrayList(questionList);
    }
    
    public void test(){
        
        
    
    }
    
}
