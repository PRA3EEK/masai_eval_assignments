package day8Assignment;

import java.util.Scanner;

public class Main {

	public static String reversString(String input){
		//write the logic
		 String res = "";
		 char[] arr = new char[input.length()];
		 for(int i=0 ; i<input.length() ; i++) {
			 arr[i] =  input.charAt(i);
		 }
		  for(int i=input.length()-1 ; i>=0 ; i--) {
			  res = res+arr[i];
		  }
		  return res;
		}
	
	
		public static void main(String[] args){
			
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter a String to reverse");
		
		String originalString = sc.next();
		
		String result = reversString(originalString);
		
		System.out.println("Original String is :"+ originalString);
		
		System.out.println("Reversed String is :"+ result);
		
		}

	
}
