package sprint4Evaluation;

import java.util.Objects;

public class Product {
   
//	name : String
//	-price : double
//	-company : String
//	-count : int
	private String name;
	private double price;
	private String company;
	private int count;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	
	public Product(String name, double price, String company, int count) {
		super();
		this.name = name;
		this.price = price;
		this.company = company;
		this.count = count;
	}
	
	public Product() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Product [name=" + this.name + ", price=" + this.price + ", company=" + this.company + ", count= "+ this.count+ "]";
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(company, name, price);
	}
	@Override
	public boolean equals(Object obj) {
	 Product P = (Product)obj;
	 if(this.name.equals(P.name) && this.company.equals(P.company) && this.price == P.price) {
		 return true;
	 }else {
		 return false;
	 }
	}

	
	
	
	
	
}
