package day1Assignment;
import java.util.Scanner;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;

public class ProductMain {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Queue<Product> q = new PriorityQueue<>();
		
		boolean temp = true;
		
		while(temp) {
			System.out.println("Add Product details!");
			System.out.println("Enter Product id");
			int id = sc.nextInt();
			sc.nextLine();
			System.out.println("Enter Product name");
			String name = sc.nextLine();
			System.out.println("Enter Product price");
			double price = sc.nextDouble();
			
			Product p = new Product(id, name, price);
			q.offer(p);
			System.out.println("Want to add more produts? (Y/N)");
			String s = sc.next();
			if(s.equals("N")) {
				temp = false;
			}else if(s.equals("Y")) {
				temp = true;
			}else {
				System.out.println("Please enter valid input");
			}
			
			
		}
		
		Iterator<Product> itr = q.iterator();
		
		while(itr.hasNext()) {
			System.out.print(itr.next()+" ");
		}
		
		
	}
	
}
