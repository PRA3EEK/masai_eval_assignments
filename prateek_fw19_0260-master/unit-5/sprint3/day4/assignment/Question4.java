package day11Assignment;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Question4 {
 
	public static void func() throws IOException {
		
			FileReader fr = new FileReader("C:\\Users\\Prateek Chauhan\\OneDrive\\Desktop\\java Notes\\Numbers.txt");
			BufferedReader br = new BufferedReader(fr);
			FileWriter fw = new FileWriter("C:\\Users\\Prateek Chauhan\\OneDrive\\Desktop\\java Notes\\SelectedNumbers.txt");
			BufferedWriter bw = new BufferedWriter(fw);
			String num;
		
				num = br.readLine();
				Pattern p1 = Pattern.compile("mob:6");
				Pattern p2 = Pattern.compile("mob:7");
				Pattern p3 = Pattern.compile("mob:8");
				Pattern p4 = Pattern.compile("mob:9");
				while(num!=null) {
					Matcher m1 = p1.matcher(num);
					Matcher m2 = p2.matcher(num);
					Matcher m3 = p3.matcher(num);
					Matcher m4 = p4.matcher(num);
					if((m1.find() || m2.find() || m3.find() || m4.find()) && num.length() == 14) {
						bw.write(num);
						bw.newLine();
					}
					num = br.readLine();
				}
				br.close();
				bw.flush();
				bw.close();
			} 
		
	
	public static void main(String[] args) {
		
		
		try {
			func();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	   
	}
}
