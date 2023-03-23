package day11Assignment;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Question1 {

	
	
	public static void main(String[] args) {
		File f = new File("abc.txt");
        try {
			f.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
        
        try {
			FileWriter fw = new FileWriter("abc.txt");
			Scanner sc = new Scanner(System.in);
			boolean flag = true;
			int i = 1;
			while(flag) {
				 System.out.println("Enter employee name");
			        String ename = sc.nextLine();
			        System.out.println("Enter address");
			        String adr = sc.nextLine();
			        fw.write("Name of employee"+(i)+" = "+ename);
			        fw.write("\n");
			        fw.write("Address"+" = "+adr);
			        fw.write("\n");
			        System.out.println("Continue Adding ? (Y/N)");
			        String res = sc.nextLine();
			        i++;
			        if(res.toLowerCase().equals("n")) {
			        	flag = false;
			        }
			}
	       sc.close();
	       fw.flush();
	       fw.close();
	       
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        
}
}