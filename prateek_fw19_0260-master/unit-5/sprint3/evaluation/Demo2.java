package sprint3evauation;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Demo2 {
  public static void main(String[] args) {
	
	  try {
		FileInputStream fis = new FileInputStream("studentdata.txt");
		try {
			ObjectInputStream ois = new ObjectInputStream(fis);
			try {
				List<Student> list = (List<Student>)ois.readObject();
				
				list.add(new Student(6, "charu", 600, "charu@gmail.com", "charu@123", new Address("delhi", "new delhi", "110051")));
				System.out.println(list);
				FileOutputStream fo = new FileOutputStream("studentdata.txt");
				ObjectOutputStream oo = new ObjectOutputStream(fo);
				oo.writeObject(list);
				oo.flush();
				oo.close();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ois.close();
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
