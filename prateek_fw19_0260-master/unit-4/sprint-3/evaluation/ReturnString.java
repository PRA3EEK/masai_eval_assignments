package sprint3Evaluation;
import java.util.Scanner;
public class ReturnString {
    private String name;
    public ReturnString(String name) {
    	this.name = name;
    }
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a String");
		String name = sc.nextLine();
		ReturnString RS = new ReturnString(name);
		System.out.println("Enter a postion");
		int p = sc.nextInt();
	    if(p>RS.name.length() && p<=0) {
	    	System.out.println("Invalid position, Please enter a valid position");
	    }else {
	    	System.out.println(RS.name.charAt(p-1));
	    }
	}
}
