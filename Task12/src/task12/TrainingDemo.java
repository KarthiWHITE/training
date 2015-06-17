/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package task12;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author cb-admin1
 */
public class TrainingDemo {

        public static void main(String arg[]){
            
            MCQQuestion m1=new MCQQuestion(1, "static is a", "variable", "keyword", "data type", "object", "keyword");
            MCQQuestion m2=new MCQQuestion(1, "static is a", "variable", "keyword", "data type", "object", "keyword");
            MCQQuestion m3=new MCQQuestion(1, "static is a", "variable", "keyword", "data type", "object", "keyword");
            MCQQuestion m4=new MCQQuestion(1, "static is a", "variable", "keyword", "data type", "object", "keyword");
            
            ArrayList<Question> mcqList=new ArrayList();
            
            mcqList.add(m1);
            mcqList.add(m2);
            mcqList.add(m3);
            mcqList.add(m4);
            
            Assessment ass1;
            ass1 = new Assessment(1, "mcq1", 4, new Date(), mcqList);
            Assessment ass2 = new Assessment(1, "mcq1", 4, new Date(), mcqList);
            Assessment ass3 = new Assessment(1, "mcq1", 4, new Date(), mcqList);
            Assessment ass4 = new Assessment(1, "mcq1", 4, new Date(), mcqList);
            
            ArrayList<Assessment> alist=new ArrayList();
            
            alist.add(ass1);
            alist.add(ass2);
            alist.add(ass3);
            alist.add(ass4);
            
            Course c=new Course("123", "MCA", alist);
            
            Iteration[] ita=new Iteration[3];
            ita[0]=new Iteration(1, "test", c, alist);
             ita[1]=new Iteration(1, "test", c, alist);
            ita[2]=new Iteration(1, "test", c, alist);
            
            
            SkillAssureTrainingModel saattest=new SkillAssureTrainingModel("CB", ita);
            
            System.out.println("Total no of the Assessments : "+saattest.getTotalAssessmentInTheTraining());
            System.out.println("Total no.of MCQ Based Assessments : "+saattest.getNumMCQBasedAssessments());
            System.out.println("Total no.of Hands On Question Based Assessments : "+saattest.getNumHandsOnBasedAssessments());
            System.out.println("Total score of all assessments : "+saattest.getTotalScoreOfAllAssessment());
             
        }

}
