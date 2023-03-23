package com.prateek.services;

import java.util.List;

import com.prateek.Exceptions.ProductException;
import com.prateek.beans.Product;

public interface ProductService {

	public boolean addProduct(Product p);
	public List<Product> getAllProducts();
	public Product getProductById(int id) throws ProductException;
	public List<Product> getProductsBetweenPrice (int fromPrice, int toPrice) throws ProductException;
	
}
