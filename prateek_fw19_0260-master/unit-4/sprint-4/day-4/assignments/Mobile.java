package extraAssignment;

import java.util.Scanner;

public class Mobile {

	static void SearchOutdatedModel( String companyName, String... modelNames) {
		String[] outdatedModels = {"note4","note5","note6","note7"};
		
		
		for(int i=0 ; i<modelNames.length ; i++) {
		    for(String s:outdatedModels) {
		    	if(modelNames[i].equals(s)) {
		    		System.out.println(modelNames[i]+"_"+"OUTDATED");
		    	}
		    }
			
		}
//		for(int i=0 ; i<modelNames.length ; i++) {
//			System.out.println(modelNames[i]);
//		}
//		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter company name");
		String company = sc.next();
		sc.nextLine();
		System.out.println("Enter the model names with space to check");
		String[] arr = sc.nextLine().split(" ");
		Mobile.SearchOutdatedModel(company, arr);
		
	}
}
