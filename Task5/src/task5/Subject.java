package task5;

public class Subject{

	// Members of the class

	private String subject1,subject2,subject3;
 	
	private float mark1,mark2,mark3;
	
	//Constructor
/*
	public Subject(String subject1,float mark1,String subject2,float mark2,String subject3,float mark3){
		
		this.subject1=subject1;
		this.mark1=mark1;
		

		this.subject2=subject2;
                this.mark2=mark2;
		
		this.subject3=subject3;
                this.mark3=mark3;
	}


	//Copy constructor

	public Subject(Subject subject){
	
		subject1=subject.subject1;
		subject2=subject.subject2;
		subject3=subject.subject3;

		mark1=subject.mark1;
		mark2=subject.mark2;
		mark3=subject.mark3;
	}
*/
	public float getMark1(){
		
		return mark1;

	}

	public float getMark2(){

		return mark2;
	}
	
	public float getMark3(){
		
		return mark3;
	}
	
	public String getSubject1(){
		
		return subject1;
	}

	public String  getSubject2(){
	
		return subject2;
	}

	public String getSubject3(){
		
		return subject3;
	}

	public void setMarks(float mark1,float mark2,float mark3){
		
		this.mark1=mark1;
		this.mark2=mark2;
		this.mark3=mark3;
	}

	public void setMark1(float mark1){this.mark1=mark1;}
	public void setMark2(float mark2){this.mark2=mark2;}
	public void setMark3(float mark3){this.mark3=mark3;}

	public void setSubject1(String subject1){this.subject1=subject1;}
	public void setSubject2(String subject2){this.subject2=subject2;}
	public void setSubject3(String subject3){this.subject3=subject3;}

	public void setSubjects(String subject1,String subject2,String subject3){
		
		this.subject1=subject1;
		this.subject2=subject2;
		this.subject3=subject3;
	}
}
