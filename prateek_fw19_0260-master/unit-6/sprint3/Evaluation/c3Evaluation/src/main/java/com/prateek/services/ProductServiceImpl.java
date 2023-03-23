package com.prateek.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prateek.Exceptions.ProductException;
import com.prateek.beans.Product;
import com.prateek.repos.ProductRepoImpl;


@Service
public class ProductServiceImpl implements ProductService{

	
	@Autowired
	private ProductRepoImpl pri;
	
	@Override
	public boolean addProduct(Product p) {
		// TODO Auto-generated method stub
	  return pri.insertProductDetails(p);
	   
		
	}

	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return pri.getAllProductDetails();
//		return null;
	}

	@Override
	public Product getProductById(int id) throws ProductException {
		// TODO Auto-generated method stub
		Product p = pri.findProduct(id);
		if(p == null) {
			throw new ProductException("No Product exists with this id");
		}else {
			return p;
		}
//		return null;
	}

	@Override
	public List<Product> getProductsBetweenPrice(int fromPrice, int toPrice) throws ProductException {
		// TODO Auto-generated method stub
		List<Product> res = pri.getProductInPriceRange(fromPrice, toPrice);
		if(res.size()>0) {
			return res;
		}else {
			throw new ProductException("No Product Exists in this price range");
		}
//		return null;
	}

}
