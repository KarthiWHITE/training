package hello;

public class Customer 
{
	protected String name;
	protected String maritalStatus;
	protected String gender;
	protected int age;
		
	public Customer() {
		name = "Robinson";
		maritalStatus = "Married";
		gender = "Female";
		age = 25;
	}

	public String getGender() {
		return gender;
	}
	public String getMaritalStatus() {
		return maritalStatus;
	}
	public String getName() {
		return name;
	}
	public void setGender(String string) {
		gender = string;
	}
	public void setMaritalStatus(String string) {
		maritalStatus = string;
	}
	public void setName(String string) {
		name = string;
	}

	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}