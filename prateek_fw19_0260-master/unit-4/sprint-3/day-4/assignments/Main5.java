package day12Assignmnet;
import java.util.Scanner;
public class Main5 {
  public static void main(String[] args) {
	  Scanner sc = new Scanner(System.in);
	  System.out.println("Enter the number to find prime numbers upto");
		int num = sc.nextInt();
	  
	Test T = new Test();
	int[] primeArr = T.display(num);
	String res = "";
	
	
	for(int i=0 ; i<primeArr.length ; i++) {
		if(primeArr[i]!=0) {
			res = res + primeArr[i] + " ";
		}
	}
	System.out.println(res);
}
}
