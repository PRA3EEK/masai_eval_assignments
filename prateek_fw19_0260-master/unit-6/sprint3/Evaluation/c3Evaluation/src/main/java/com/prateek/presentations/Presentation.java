package com.prateek.presentations;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.prateek.Exceptions.ProductException;
import com.prateek.beans.Product;
import com.prateek.services.ProductService;
import com.prateek.services.ProductServiceImpl;

@Controller
public class Presentation {
  
	
	@Autowired
	private ProductServiceImpl psi;
	
	Scanner sc = new Scanner(System.in);
	public void insertProduct() {
		
		System.out.println("Enter product name");
		String name = sc.nextLine();
		
		System.out.println("Enter Quantity");
		int qnt = sc.nextInt();
		
		System.out.println("Enter price per piece");
		int price = sc.nextInt();
		
		Product p = new Product(name, qnt, price);
		
		if(psi.addProduct(p)) {
			System.out.println("Product Added successfully...");
		}else {
			System.out.println("Product was not added...");
		}
		
	}
	
	public void printAllProduct () {
		
		List<Product> products = psi.getAllProducts();
		
		products.forEach(p -> {
			System.out.println(p);
		});
	}
	
	public void searchProduct() {
		
		System.out.println("Enter ProductId to find");
		
		int id = sc.nextInt();
		
		try {
			System.out.println(psi.getProductById(id));
		} catch (ProductException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
	
	public void findProductsWithinGivenRange () {
		
		System.out.println("Enter lower limit of price");
		int lp = sc.nextInt();
		
		System.out.println("Enter Upper limit of price");
		int up = sc.nextInt();
		
		try {
			List<Product> res = psi.getProductsBetweenPrice(lp, up);
			res.forEach(p -> {
				System.out.println(p);
			});
		} catch (ProductException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			System.out.println(e.getMsg());
		}
		
	}
	
}
