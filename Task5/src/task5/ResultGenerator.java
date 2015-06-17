package task5;



public class ResultGenerator{
	
	public static void generateResult(Student student){
		System.out.println("-----------------------------------------------------------------------------------------");
		System.out.println("                                  Mark Statement");
		System.out.println("-----------------------------------------------------------------------------------------");
		System.out.println("Student Id : "+student.getId());
		System.out.println("Student Name : "+student.getStudentName());
	
		String gender=(student.getGender())?"Male":"Female";
		System.out.println("Gender : "+gender);
		System.out.println("-----------------------------------------------------------------------------------------");

		System.out.println(student.getSubject1()+" 	: "+student.getMark1());
		System.out.println(student.getSubject2()+" 	: "+student.getMark2());
		System.out.println(student.getSubject3()+" 	: "+student.getMark3());
		System.out.println("-----------------------------------------------------------------------------------------");
	}	
}
