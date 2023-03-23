package day5Assignment;

import java.util.ArrayList;

import java.util.List;

public class Question2 {
   
	public static void main(String[] args) {
		List<String> l = new ArrayList<>();
		l.add("delhi");
		l.add("arunachal pradesh");
		l.add("mumbai");
		l.add("goa");
	 l.sort((o1, o2) -> {
	    return o2.compareTo(o1);
	 }
	 );
	 System.out.println(l);
	}
}
