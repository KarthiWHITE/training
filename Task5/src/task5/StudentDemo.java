/*
        Karthikeyan
        CharageBee
Date : 2/04/2015
    
Student mark statements

version 1.1 
    
    modified the members names and using setmethods for assigning the members' values.
    
*/

package task5;



public class StudentDemo{
	
	public static void main(String arg[]){
		
		//creating object for Subject
            
		Subject subject=new Subject();
            
                //Assign member variables in the subject object using setMarks and setSubjects methods.
                
                subject.setMarks(88.55f, 56.75f, 100f);
                subject.setSubjects("Tamil","English","Computer");
		
                //creating student object
                
		Student student_Karthi=new Student();
                
                boolean gender=true;  //gender true for male otherwise false
                
                //assigning the members in the student object through storeStudentData Method.
                
                student_Karthi.storeStudentData(12322,"Karthikeyan",true,subject);
		
                //Invoke the generateResult (static method) which is available in the ResultGenerator Class.
                
		ResultGenerator.generateResult(student_Karthi);
	}

}