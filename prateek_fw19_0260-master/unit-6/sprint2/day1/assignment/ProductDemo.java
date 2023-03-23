package day5Assignment;

import java.util.ArrayList;
import java.util.List;

public class ProductDemo {

	
	public static void main(String[] args) {
		List<Product> l = new ArrayList<>();
		l.add(new Product(1, "i phone 14", 50, 7500000));
		l.add(new Product(2, "Air force 1", 40, 250000));
		l.add(new Product(3, "Huion tablet", 20, 600000));
		l.add(new Product(4, "ducati panigalle v4s", 4, 20000000));
		
		l.sort((o1,o2) -> {
			if(o1.getPrice() > o2.getPrice()) {
				return -1;
			}else if(o1.getPrice() < o2.getPrice()) {
				return +1;
			}else {
				return 0;
			}
		});
		System.out.println(l);
	}
}
