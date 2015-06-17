/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package task12;

/**
 *
 * @author cb-admin1
 */
public class MCQQuestion extends Question{
    private    String  questionName,option1,option2,option3,option4,rightOption;
    
    public MCQQuestion(int marks,String questionName,String option1,String option2,String option3,String option4,String rightOption){
        super(marks);
        this.questionName=questionName;
        this.option1=option1;
        this.option2=option2;
        this.option3=option3;
        this.option4=option4;
        this.rightOption=rightOption;
    }
}
