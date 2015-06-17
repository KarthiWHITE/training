/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package task12;

import java.util.ArrayList;

/**
 *
 * @author cb-admin1
 */
public class Iteration {

    private final int iterationNo;
    private final String goal;
   
   public final Course course;
   
   public final ArrayList<Assessment> iterationAssessmentList;
   
   public Iteration(int iterationNo,String goal,Course course,ArrayList<Assessment> iterationAssessmentList){
       this.iterationNo=iterationNo;
       this.goal=goal;
       this.course=course;
       this.iterationAssessmentList=new ArrayList(iterationAssessmentList); 
   }
   
}
