package com.prateek.repos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.prateek.beans.Product;
import com.prateek.utilities.Provider;


@Repository
public class ProductRepoImpl implements ProductRepo{

	

	@Override
	public List<Product> getAllProductDetails() {
		// TODO Auto-generated method stub
		

		EntityManager em = Provider.provideEntityManager();
		
		String q = "from Product";
		
		TypedQuery<Product> query = em.createQuery(q, Product.class);

		List<Product> res = query.getResultList();
		
		em.close();
		return res;
	}


	@Override
	public List<Product> getProductInPriceRange(int fromPrice, int toPrice) {
		
		EntityManager em = Provider.provideEntityManager();
		
		String q = "from Product where price >= :fp and price <= :tp";
		
		TypedQuery<Product> query = em.createQuery(q, Product.class);
		
		query.setParameter("fp", fromPrice);
		query.setParameter("tp", toPrice);
		
		List<Product> res = query.getResultList();
		
		
		em.close();
				
		return res;
	}

	@Override
	public boolean insertProductDetails(Product p) {
		// TODO Auto-generated method stub
		EntityManager em = Provider.provideEntityManager();
		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();
		em.close();
		return true;
	}

	@Override
	public Product findProduct(int id) {
		// TODO Auto-generated method stub
		EntityManager em = Provider.provideEntityManager();
		Product p = em.find(Product.class, id);
		em.close();
		return p;
	}

}
