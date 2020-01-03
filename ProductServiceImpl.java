package com.deloitte.estore.service;

import java.sql.Connection;
import java.util.List;

import com.deloitte.estore.model.Product;
import com.deloitte.estore.repo.ProductRepo;
import com.deloitte.estore.repo.ProductRepoImpl;


public class ProductServiceImpl implements ProductService {
	ProductRepo repo;
	public ProductServiceImpl()
	{
		repo=new ProductRepoImpl();
	}
	@Override
	public boolean addProduct(Product product) throws Exception {
		 
		return repo.addProduct(product);
	}
	@Override
	public boolean deleteProduct(Product product) throws Exception {
	 
		return repo.deleteProduct(product);
	}
	@Override
	public boolean updateProduct(Product product) throws Exception {
	 
		return repo.updateProduct(product);
	}
	@Override
	public Product getProductById(int productId) throws Exception {
		// TODO Auto-generated method stub
		return repo.getProductById(productId);
		
	}
	@Override
	public List<Product> getAllProducts() throws Exception {
		// TODO Auto-generated method stub
		return repo.getAllProducts();
	}
	@Override
	public Connection getDbConnection() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
