package day1Assignment;

public class Product implements Comparable<Product>{

	private int productId;
	private String productName;
	private double productPrice;
	
	public Product(int productId, String productName, double productPrice) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
	}
	
	public int getProductId() {
		return productId;
	}
	
	public void setProductId(int productId) {
		this.productId = productId;
	}
	
	public String getProductName() {
		return productName;
	}
	
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	public double getProductPrice() {
		return productPrice;
	}
	
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public Product() {
		// TODO Auto-generated constructor stub
		
	}
	@Override
	public int compareTo(Product o) {
		
	  if(this.productPrice > o.productPrice) {
		  return -1;
	  }else if(this.productPrice < o.productPrice) {
		  return +1;
	  }else {
		  return 0;
	  }
		
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productPrice=" + productPrice
				+"]";
	}



	

	
}
