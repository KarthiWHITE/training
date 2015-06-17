package task5;

public class Student{
	
	//Data members for this class where all are private members	

	private int studentId;
	private String studentName;
	private boolean gender;

	private Subject subject;

	//Constructor for this class

        public Student(){};
	public Student(int studentId,String studentName,boolean gender,Subject subject){
		
		this.studentId=studentId;
		this.studentName=studentName;
		this.gender=gender;
		this.subject=subject;
	}

		// Method for Get and Set Student Id

	public int getId(){
		return studentId;
	}
	
	public void setId(int studentId){
		
		this.studentId=studentId;

	}

	// Method for Get and set Student name 	

	public String getStudentName(){
		
		return studentName;
	}

	public void setStudentName(String studentName){
		
		this.studentName=studentName;

	}

	// Method for Get and Set Gender

	public boolean getGender(){
		
		return  gender;
	}

	public void setGender(boolean gender){
		
		this.gender=gender;
	}

		// Methods for Get And Set subject's object
	
	public void setSubjects(Subject subject){
		
		this.subject=subject;
	}
	
	public Subject getSubjects(){
		
		return subject;
	} 
	
	public void storeStudentData(int studentId,String studentName,boolean gender,Subject subject){
		
		this.studentId=studentId;

		this.studentName=studentName;

		this.gender=gender;
	
		this.subject=subject;
	}

	public float getMark1(){return subject.getMark1();}
	public float getMark2(){return subject.getMark2();}
	public float getMark3(){return subject.getMark3();}

	public String getSubject1(){return subject.getSubject1();}
	public String getSubject2(){return subject.getSubject2();}
	public String getSubject3(){return subject.getSubject3();}
}
