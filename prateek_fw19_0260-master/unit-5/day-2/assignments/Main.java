package day2Assignment;

//import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main{

	public static List<? super Employee> fun(List<? super Employee> l){
		return l;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		
		boolean flag = true;
		
		System.out.println("which class object do you want to add to the list among Employee class and its parent class");
		String s = sc.next();
		if(s.toLowerCase().equals("employee")) {
			List<Employee> list = new ArrayList<>();
			while(flag) {
				System.out.println("Enter employee id");
				int id = sc.nextInt();
				sc.nextLine();
				System.out.println("Enter employee name");
				String name = sc.nextLine();
				list.add(new Employee(id, name));
				System.out.println("Continue Adding? (Y/N");
				String x = sc.next();
				if(x.toLowerCase().equals("n")) {
					flag = false;
				}
			}
			List<? super Employee> l = fun(list);
			System.out.println(l);
		}else if(s.toLowerCase().equals("member")) {
			List<Member> list = new ArrayList<>();
			while(flag) {
				System.out.println("Enter member id");
				int id = sc.nextInt();
				sc.nextLine();
				System.out.println("Enter member name");
				String name = sc.nextLine();
				list.add(new Member(id, name));
				System.out.println("Continue Adding? (Y/N");
				String x = sc.next();
				if(x.toLowerCase().equals("n")) {
					flag = false;
				}
			}
			List<? super Employee> l = fun(list);
			System.out.println(l);
		}
		
		
		
	}
}
