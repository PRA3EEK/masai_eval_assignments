package sprint2Evaluation;
import java.util.function.*;
public class Question2 {

	
	public static void main(String[] args) {
		Predicate<Student> p = s -> s.getMarks()<500;
		
		System.out.println(p.test(new Student(1, "prateek", 500, "delhi")));
		Consumer<Student> c = s -> System.out.println(s);
		
	   c.accept(new Student(1, "prateek", 500, "delhi"));
		Supplier<Student> s = () -> {Student x = new Student(1, "prateek", 500, "delhi");
		                   return x;
		} ;
		System.out.println(s.get());
	    
		
		Function<String, Integer> f = num -> {
			int res = Integer.parseInt(num);
			return res;
		};
		System.out.println(f.apply("5684"));
		
	}
	 
}
