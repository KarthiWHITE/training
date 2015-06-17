/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package task12;

import java.util.ArrayList;
import java.util.ListIterator;

/**
 *
 * @author cb-admin1
 */
public class SkillAssureTrainingModel {

   private final String clientName;
   
   private Iteration[] iteration=new Iteration[3];
   
   public SkillAssureTrainingModel(String clienNme,Iteration[] iteration){
       this.clientName=clienNme;
       this.iteration=iteration;
   }
   
   
   
   public int getTotalAssessmentInTheTraining(){
       int count=0;
       
       for(Iteration it:this.iteration){
           count+=it.iterationAssessmentList.size();
           count+=it.course.assessmentList.size();
       }
       
       return count;
   }
   
   public int getNumMCQBasedAssessments(){
       int count=0;
       
       for(Iteration it:iteration){
           
           ListIterator ialit=it.iterationAssessmentList.listIterator();
           
           while(ialit.hasNext()){
              Question q=((Assessment)ialit.next()).qustionList.get(0);
              if(q instanceof MCQQuestion)
                  count++;
           }
           
           ListIterator calit=it.course.assessmentList.listIterator();
           while(calit.hasNext()){
              Question q=((Assessment)calit.next()).qustionList.get(0);
              if(q instanceof MCQQuestion)
                  count++;
           }        
       }
       return count;
   }
   
   public int getNumHandsOnBasedAssessments(){
       
       return getTotalAssessmentInTheTraining()-getNumMCQBasedAssessments();
   }
   
   public int getTotalScoreOfAllAssessment(){
   
       int totalScore=0;
       for(Iteration it:iteration){
           
           ListIterator ialit=it.iterationAssessmentList.listIterator();
           
           while(ialit.hasNext()){
               
               totalScore+=((Assessment)ialit.next()).getTotalMarks();
           }
           
           ListIterator calit=it.course.assessmentList.listIterator();
           
           while(calit.hasNext()){
               totalScore+=((Assessment)calit.next()).getTotalMarks();
           }
       }
   return totalScore;
   }
}
