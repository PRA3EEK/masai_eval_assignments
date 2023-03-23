package day2Assignment;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
//import java.util.TreeMap;

public class Question4 {
	
   public static void main(String[] args) {
	
	   HashMap<Student, String> map = new HashMap<>();
	   
	   
	   
	   map.put(new Student(3, "Monty", 467), "delhi");
	   map.put(new Student(1, "prateek chauhan", 455), "delhi");
	   map.put(new Student(5, "Bhoomika", 346), "delhi");  
	   map.put(new Student(2, "pratham chauhan", 475), "delhi");
	   map.put(new Student(4, "Aniket", 478), "delhi");
	   LinkedHashMap<Student, String> tmap = new LinkedHashMap<>();
	   map.entrySet().stream().sorted(Map.Entry.comparingByKey(new StudentComp())).forEachOrdered(e -> tmap.put(e.getKey(), e.getValue()));
       System.out.println(tmap);
   }

}
