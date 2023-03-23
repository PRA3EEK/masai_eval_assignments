package day11Assignment;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

public class Demo2 {

	
	public static void main(String[] args) {
		try {
			FileInputStream fis = new FileInputStream("StudentData.txt");
			try {
				ObjectInputStream ois = new ObjectInputStream(fis);
				try {
				List<Student> list = (List<Student>)ois.readObject();
			    list.forEach(s -> {System.out.println("Student roll is "+s.getRoll());
			    System.out.println("Student marks are "+s.getMarks());
			    System.out.println("Student name is "+s.getName());
			    System.out.println("Student state "+s.getAddress().getState());
			    System.out.println("Student city "+s.getAddress().getCity());
			    System.out.println("Student pincode "+s.getAddress().getPincode());
			    System.out.println("-------------------");});
					ois.close();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
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
