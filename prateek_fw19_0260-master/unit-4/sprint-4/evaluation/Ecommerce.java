package sprint4Evaluation;

import java.util.*;

public class Ecommerce {
	 List<Product> Al = new ArrayList<>();
	public static boolean checkEqual(List<Product> Hs, Product P) {
		
		for(Product p:Hs) {
			if(p.equals(P)) {
				return true;
			}
		}
		return false;
		
	}
	public void addProduct(Product p) {
		
		if(checkEqual(Al, p)) {
			
			for(Product Pr:Al) {
				if(Pr.equals(p)) {
					Pr.setCount(p.getCount()+Pr.getCount());
				}
			}
			System.out.println("Count updated Product already exists");
		}else {
			Al.add(p);
			System.out.println("Product added successfully");
		}
		
	}
	
	public List<Product> showAllProduct() {
		return Al;
	}

	public static void main(String[] args) {
		Ecommerce ecommerce=new Ecommerce();
		ecommerce.addProduct(new Product("Shoes",2000,"Adidas",12));
		ecommerce.addProduct(new Product("Ipad",100000,"Apple",2));
		ecommerce.addProduct(new Product("Ipad",100000,"Apple",4));
		ecommerce.addProduct(new Product("Shoes",4000,"Nike",4));
		ecommerce.addProduct(new Product("Shoes",2000,"Adidas",8));
		
		System.out.println(ecommerce.showAllProduct());

	}
	
	
	
}
