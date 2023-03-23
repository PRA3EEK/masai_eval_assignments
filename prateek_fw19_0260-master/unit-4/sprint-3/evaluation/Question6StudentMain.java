package sprint3Evaluation;
import java.util.Scanner;

public class Question6StudentMain {
	public static double getStudent(int choice) {
		Scanner sc = new Scanner(System.in);
		switch(choice){
			case 1 : 
			    System.out.println("Enter marks for hindi");
			    int hindi = sc.nextInt();
			    System.out.println("Enter marks for english");
			    int english = sc.nextInt();
			    System.out.println("Enter marks for history");
			    int history = sc.nextInt();
			    ArtStudent AS = new ArtStudent(hindi, english, history);
			    double perc = AS.findPercentage();
			    return perc;
			case 2 : 
				System.out.println("Enter marks for physics");
				int physics = sc.nextInt();
				System.out.println("Enter marks for chemistry");
				int chemistry = sc.nextInt();
				System.out.println("Enter marks for maths");
				int maths = sc.nextInt();
				System.out.println("Enter marks for biology");
				int biology = sc.nextInt();
				ScienceStudent SS = new ScienceStudent(physics, chemistry, maths, biology);
				double Sperc = SS.findPercentage();
				return Sperc;
			case 3 : 
				System.out.println("Enter marks for accounts");
				int accounts = sc.nextInt();
				System.out.println("Enter marks for economics");
				int economics = sc.nextInt();
				System.out.println("Enter marks for business studies");
				int bst = sc.nextInt();
				
				CommerceStudent CS = new CommerceStudent(accounts, economics, bst);
				double Cperc = CS.findPercentage();
				return Cperc;
			default:
				return 0;
		}
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Which Student percentage do you want to find");
		System.out.println("1. Art Student");
		System.out.println("2. Science Student");
		System.out.println("3. Commerce Student");
		int choice  = sc.nextInt();
		
		System.out.println(getStudent(choice));
		
	}
}
