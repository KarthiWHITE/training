/*  
    Karthikeyan
    ChargeBee
    Simple interest and compount Interest


*/
package task4;

import java.io.*;

class SimpleCompount{
		
	// Principal,Interest Rate and	Years

	private static float price,rate,time;

	//Main Method

	public static void main(String arg[])throws IOException{
		
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		
		//read Principal

		prin("Enter the price:");
		
		price=Float.parseFloat(in.readLine());

		// read Intrest Rate

		prin("Entere the Rate:");

		rate=Float.parseFloat(in.readLine());
		
		// read Time
		prin("Enter the Time in Years:");

		time = Float.parseFloat(in.readLine());

		// calculate Simple interest using static method	
	
		System.out.println("Simple Intrst: "+Intrst.simple(price,rate,time));

		//Calaulate the compoount intrest

		System.out.println("Compount Intrst: "+Intrst.compount(price,rate,time));
		
		
		
	}
	
		//method to print on console
	
	private static void prin(String str){
		System.out.println(str);
	}

}// class SimpleCompount ends here

	

class Intrst{
	
	//static method for calculate simple interest

	public static float simple(float price,float rate,float time ){
		
		return price*(rate/100)*time;
	}

	// static method for calculate Compount Interest

	public static float compount(float price,float rate,float time){

	
		return price*(float)Math.pow((1+(rate/100)),time)-price;
	}

}	//class Intrst ends here


