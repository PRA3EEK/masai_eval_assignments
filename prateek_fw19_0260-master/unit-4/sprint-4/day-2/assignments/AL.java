package day14Assignment;
import java.util.ArrayList;
import java.util.Iterator;
public class AL {
  
    
    
  public static void main(String[] args) {
	  
	  
	  
	  ArrayList<String> A1= new ArrayList<String>();
	  A1.add("prateek");
	  A1.add("pratham");
	  A1.add("Aniket");
	  A1.add("Shobhit");
	  Iterator<String> I = A1.iterator();
	  
	  
	  while(I.hasNext()) {
		  System.out.println(I.next()+" ");
		  
	  }
	  
	  System.out.println("==========================");
	  
	  for(int i=0 ; i<A1.size() ; i++) {
		  System.out.println(A1.get(i));
	  }
	  
	  System.out.println("==========================");
	  
	  for(String s:A1) {
		  System.out.println(s);
	  }
	  
}
   
	   
   
}
