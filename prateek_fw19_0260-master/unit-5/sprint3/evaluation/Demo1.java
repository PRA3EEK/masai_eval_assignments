package sprint3evauation;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Demo1 {

	
	public static void main(String[] args) throws FileNotFoundException {
		List<Student> list = new ArrayList<>();
	 	list.add(new Student(1, "prateek", 500, "prateek@gmail.com", "prateek@123", new Address("delhi", "new delhi", "110051")));
	 	list.add(new Student(2, "pratham", 550, "pratham@gmail.com", "pratham@123", new Address("delhi", "new delhi", "110051")));
	 	list.add(new Student(3, "aniket", 570, "aniket@gmail.com", "aniket@123", new Address("delhi", "new delhi", "110051")));
	 	list.add(new Student(4, "bhoomika", 450, "bhoomika@gmail.com", "bhoomika@123", new Address("delhi", "new delhi", "110051")));
	 	list.add(new Student(5, "monty", 590, "monty@gmail.com", "monty@123", new Address("delhi", "new delhi", "110051")));
	  
	 	try {
	 		FileOutputStream fos = new FileOutputStream("studentdata.txt");
	 		 try {
	 			ObjectOutputStream o = new ObjectOutputStream(fos);
	 		
	 			o.writeObject(list);
	 			o.flush();
	 			o.close();
	 		} catch (IOException e) {
	 			// TODO Auto-generated catch block
	 			e.printStackTrace();
	 		}
	 	}
	  catch(FileNotFoundException fnf) {
		  fnf.printStackTrace();
	  }
	  
	  
	 
	
	}
}
