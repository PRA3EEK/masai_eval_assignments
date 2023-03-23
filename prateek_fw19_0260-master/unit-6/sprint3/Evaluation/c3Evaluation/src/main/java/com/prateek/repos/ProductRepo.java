package com.prateek.repos;

import java.util.List;

import com.prateek.beans.Product;

public interface ProductRepo {

	public boolean insertProductDetails (Product p) ;
	public List<Product>  getAllProductDetails();
	public Product findProduct(int id);
	public List<Product> getProductInPriceRange(int fromPrice, int toPrice);

	
}
