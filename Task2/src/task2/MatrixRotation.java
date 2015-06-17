

package task2;

	/*
			Test-2
			
			Matrix Rotation (Left/Right)
			
			Karthikeyan - ChargeBee
			
			Date:30/03/2015 @ CargeBee Chennai
			
		
	*/

import java.io.*;

class MatrixRotation{
	
	// To store matrix and no.of rows and cols

	private static int mat[][],row,col;

	// input streat to read user data

	private static BufferedReader in;

	//Main method starts here

	public static void main(String arg[])throws IOException{
		
		//creating BufferedReader Object		

		in= new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Enter the Row and Col of the matrix");

		//Read No.of Rows and Cols
		
		row=Integer.parseInt(in.readLine());
		col=Integer.parseInt(in.readLine());
		
		//creating Matrix

		mat=new int[row][col];
		
		// call readMatrix method to read Matrix for console
		readMatrix();

		//Repeat the process untils user enter Exit
		
		while(true){
			
			System.out.println("Enter R for Right Rotation \n Enter L for Left Rotation \n Enter E for Exi");

			// Menu R-> Right Rotation L-Left Rotation E->Exit

			char c=(char)in.read();			

			if(c=='R')
				
				rotateRight(); 

			else if(c=='L')	

				rotateLeft();
			
			
			else if(c=='E')
				break;
		}
			
		
	}

	//Method for read the matrix
	
	private static void readMatrix()throws IOException{
		
		for(int i=0;i<row;i++){
		
			System.out.println("Enter the "+(i+1)+" Row");
		
			for(int j=0;j<col;j++)
			
				mat[i][j]=Integer.parseInt(in.readLine());	
		
		
		}
	}
		
	//Method for Rotate  Left	
	
	private static void rotateLeft(){
		
		for(int i=col-1;i>=0;i--){
		
			for(int j=0;j<row;System.out.print("\t"+mat[j++][i]));
		
			System.out.println();
		}

				
	}

	//Method for Rotate Right

	private static void rotateRight(){
		
		for(int i=0;i<col;i++){
		
			for(int j=row-1;j>=0;System.out.print("\t"+mat[j--][i]));	
			System.out.println();
		}
	}




} // class ends here