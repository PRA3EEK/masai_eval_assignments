package day12Assignmnet;
import java.util.Scanner;
public class HotelDemo {
	public Hotel provideFood(int amount) {
		if(amount>=1000) {
			return new TajHotel();
		}else if(amount>200 && amount<1000) {
			return new RoadSideHotel();
		}else {
			return null;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Budget");
		int budget = sc.nextInt();
		HotelDemo HD = new HotelDemo();
	  Hotel H = HD.provideFood(budget);
	   if(H instanceof TajHotel) {
		   TajHotel TH = (TajHotel)H;
		   TH.welcomeDrink();
		   TH.chickenBiryani();
		   TH.masalaDosa();
	   }else if(H instanceof RoadSideHotel) {
		   RoadSideHotel RH = (RoadSideHotel) H;
		   RH.chickenBiryani();
		   RH.masalaDosa();
	   }else {
		   System.out.println("Please enter a valid amount!");
	   }
	}
}
