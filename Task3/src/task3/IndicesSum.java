
package task3;
/*
	Program to find the summation of indices of the characters in given input is odd or even. Indices start from 1(for a) to 26(for z).
	
	Karthikeyan @ ChargeBee
	
	Date: 30/03/2015 @ ChargeBee

*/

import java.io.*;

class IndicesSum{
	
	//Variable to store the input String	
	
	private static String str;

	// Main method

	public static void main(String arg[])throws IOException{
			
		//Reader to dear input from the console
	
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
				
		System.out.println("Eneter the String");
		
		// Read the input string

		str=in.readLine();
		
		//Convert into Lowercase String

		str=str.toLowerCase();
			
		// temp variable to store sum of the indices

		int sum=0;

		String sumString="";

		for(int i=0;i<str.length();i++){

			sum+=(int)str.charAt(i)-96; // read Char by Char and subtract 96 from its ASCII value BCZ ASCII for a=97 therefore 97-96=1
			
			sumString+=((int)str.charAt(i)-96)+"+";
			
		}

		//find odd or Even

		if(sum%2==0)
			System.out.print("Even (");
		
		else
			System.out.print("Odd (");

		System.out.println(sumString+"="+sum+")");
		
	}//Main method ends here

}// Class ends here
