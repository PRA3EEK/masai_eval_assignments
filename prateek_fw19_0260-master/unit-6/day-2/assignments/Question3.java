package day2Assignment;

import java.util.LinkedHashMap;
import java.util.Map;

public class Question3 {
	
	public static void main(String[] args) {
		
		LinkedHashMap<String, String> map = new LinkedHashMap<>();
	    map.put("Andhra Pradesh", "Amravati");
	    map.put("Arunachal Pradesh", "Itanagar");
	    map.put("Assam", "Dispur");
	    map.put("Bihar", "Patna");
	    map.put("Chattisgarh", "Raipur");
	    
	    for(Map.Entry<String, String> m: map.entrySet()) {
	    	System.out.println(m.getKey()+"=="+m.getValue());
	    }
	    
	}

}
