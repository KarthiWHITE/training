
package quetionntest;

public class Question {
    
    private final String question,option1,option2,option3,option4,rightOption;
    
    public Question(String question,String option1,String option2,String option3,String option4,String rightOption){
    
        this.question=question;
        this.option1=option1;
        this.option2=option2;
        this.option3=option3;
        this.option4=option4;
        this.rightOption=rightOption;
    }
    
    public void printQuestion(){
        System.out.println(question);
        System.out.println("A:"+option1+" B: "+option2+" C: "+option3+" D: "+option4);
    }
    
    public boolean check(String rightOption){
        return this.rightOption.equals(rightOption);
    }
    public String getAns(){
        return rightOption;
    }
}
