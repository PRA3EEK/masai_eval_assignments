package day3Assignment;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Question4 {
  
	public static void main(String[] args) {
		
		Map<String, List<String>> map = new HashMap<>();
		
		List<String> l1 = Arrays.asList("Visakhapatnam", "Vijayawada", "Guntur", "Nellore");
		List<String> l2 = Arrays.asList("Miao", "Seppa", "Rupa", "Mipi");
		List<String> l3 = Arrays.asList("Guwahati", "Silchar", "Dibrugarh", "Jorhat");
		List<String> l4 = Arrays.asList("Patna", "Gaya", "Bhagalpur", "Muzaffarpur");
		List<String> l5 = Arrays.asList("Raipur", "	Bilaspur", "Durg", "Janjgir Champa");
		
		map.put("Andhra Pradesh", l1);
		map.put("Arunachal Pradesh", l2);
		map.put("Assam", l3);
		map.put("Bihar", l4);
		map.put("Chhattisgarh", l5);
//		System.out.println(map);
		
		Map<String, List<String>> lhm = new LinkedHashMap<>();
		map.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEachOrdered(e -> lhm.put(e.getKey(), e.getValue()));
	    System.out.println(lhm);
	}
	
}
