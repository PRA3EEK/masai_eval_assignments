package day2Assignment;

import java.util.HashMap;
import java.util.TreeMap;

public class StudentMain {
   public static void main(String[] args) {
	
	   HashMap<Student, String> map = new HashMap<>();
	   
	   map.put(new Student(1, "prateek chauhan", 455), "delhi");
	   map.put(new Student(2, "pratham chauhan", 475), "delhi");
	   map.put(new Student(3, "Monty", 467), "delhi");
	   map.put(new Student(4, "Aniket", 478), "delhi");
	   map.put(new Student(5, "Bhoomika", 346), "delhi");
	  
	   TreeMap<Student, String> tmap = new TreeMap<>(new StudentComp());
	   tmap.putAll(map);
	  System.out.println(tmap);
	   
}
}
