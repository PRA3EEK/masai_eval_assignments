package day11Assignment;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Demo1 {

	
	public static void main(String[] args) {
		
		List<Student> list = new ArrayList<>();
		list.add(new Student(1, 500, "prateek chauhan", new Address("Delhi", "New Delhi", "India")));
		list.add(new Student(2, 570, "prathan chauhan", new Address("Delhi", "New Delhi", "India")));
		list.add(new Student(3, 590, "monty", new Address("Delhi", "New Delhi", "India")));
		list.add(new Student(4, 400, "aniket", new Address("Delhi", "New Delhi", "India")));
		list.add(new Student(5, 450, "Sandeep", new Address("Delhi", "New Delhi", "India")));
		
		try {
			FileOutputStream fos = new FileOutputStream("StudentData.txt");
			try {
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				oos.writeObject(list);
				oos.flush();
				oos.close();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
