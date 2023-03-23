package sprint2Evaluation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Question4 {
 
	
	public static void main(String[] args) {
		List<String> nameList = Arrays.asList("Prateek chauhan", "Pratham", "Aniket", "Bhoomika", "Charu", "Shobhit", "Gudden", "Monty", "Vishal", "Sandeep");
	  Stream<String> l =  nameList.stream().filter(s->s.length()%2 == 0);
	  List<String> newL = new ArrayList<>();
	  l.forEach(s -> newL.add(s));
	  newL.sort((o1,o2) -> {
		  if(o1.length() < o2.length()) {
			  return +1;
		  }else if(o1.length() > o2.length()) {
			  return -1;
		  }else {
			  return o1.compareTo(o2);
		  }
	  });
	  System.out.println(nameList);
	  System.out.println(newL);
	}
}
