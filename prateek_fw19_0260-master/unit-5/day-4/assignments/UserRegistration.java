package day4Assignment;
import java.util.Scanner;
public class UserRegistration {
  public static void regirsterUser(String username, String userCountry) throws InvalidCountryException{
	  if(userCountry.toLowerCase().equals("india")) {
		  System.out.println("User registration done successfully");
	  }else {
		  InvalidCountryException ice = new InvalidCountryException();
		  throw ice;
	  }
  }
  public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter Username");
	String name = sc.next();
	System.out.println("Enter User Country");
	String con = sc.next();
	try {
		regirsterUser(name, con);
	}catch(InvalidCountryException e) {
		System.out.println(e.message);
	}finally {
		System.out.println("Thank you!");
	}
}
}
