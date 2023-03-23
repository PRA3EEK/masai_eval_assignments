package sprint4Evaluation;

import java.util.*;

public class MainStudent {
  
	public static void main(String[] args) {
		
		
		ArrayList<Student> Hs = new ArrayList<>();
		
		
		Hs.add(new Student(3, "prateek", 80, 100, 95));
		Hs.add(new Student(1, "aniket", 80, 100, 95));
		Hs.add(new Student(2, "pratham", 70, 90, 100));
		Hs.add(new Student(4, "Monty", 97, 86, 80));
		
	  Hs.sort(null);
	  for(Student S:Hs) {
		  System.out.println(S);
	  }
		
		
		
	}
	
}
