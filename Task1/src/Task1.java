/* 
	karthikeyan - ChargeBee

        Print triangle
        
        Date: 27/03/2015 @ ChargeBee

*/

import java.io.*;
class Task1{
	public static void main(String arg[])throws IOException{
		
		//  Input stream to reada user data

		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
	
		// Read user input and convert into integer using Wrapper class

		System.out.println("Enter a number to print triangle");

		int n=Integer.parseInt(in.readLine());
		
		// Invoke print method
		
		printTriangle(n);

		
		
		
	}
	
		// Method to print triangle
	
	private static void printTriangle(int n){
		
		//loop1		For print N rows

		for(int i=1;i<=n;i++){
			
			//loop2 for print Spaces before each line

			for(int j=n-i;j>=0;j--)
				System.out.print(" ");
			
			//loop3 for print number for first half of the line

			for(int j=1;j<=i;System.out.print(j++));	

			//loop4 for print number for second half of the line

			for(int j=i-1;j>0;System.out.print(j--));
			
			// Move cursor to next line
			
			System.out.println();

		} // loop1 ends here

	}// print method ends here	

} //class Triangle ends here 

