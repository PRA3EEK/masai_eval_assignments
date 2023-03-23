package day5Assignment;

import java.util.ArrayList;
import java.util.List;

public class Question4 {
     public static void main(String[] args) {
	    PrintList x = list -> 
	    	System.out.println(list);
	    List<String> l = new ArrayList<>();
	    
	    l.add("delhi");
	    l.add("Mumbai");
	    l.add("Goa");
	    l.add("Chennai");
	    l.add("Bangalore");
	    	x.display(l);
     }
}
