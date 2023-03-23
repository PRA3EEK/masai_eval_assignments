package sprint2Evaluation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

public class Main {
  public static void main(String[] args) {
	Student s1 = new Student(1, "prateek", 500, "delhi");
	Student s2 = new Student(2, "pratham", 470, "mumbai");
	Student s3 = new Student(3, "aniket", 550, "kolkata");
	Student s4 = new Student(4, "monty", 580, "bangalore");
	Student s5 = new Student(5, "bhoomika", 600, "goa");
  
   List<Student> l = new ArrayList<>();
   l.add(s1);
   l.add(s2);
   l.add(s3);
   l.add(s4);
   l.add(s5);
   Stream<Employee> sE  = l.stream().filter(s -> s.getMarks()>500).map((Function<? super Student, ? extends Employee>) s -> {
    	Employee e = new Employee(s.getRoll(), s.getName(), s.getMarks()*10000, s.getAddress());
    	return e;
    });
   List<Employee> empList = new ArrayList<>();
   sE.forEach(e -> empList.add(e));
   System.out.println(empList);
   
    
  
  
  }
}
