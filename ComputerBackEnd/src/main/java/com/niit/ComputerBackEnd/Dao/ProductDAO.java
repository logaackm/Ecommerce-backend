package com.niit.ComputerBackEnd.Dao;

import java.util.List;

import com.niit.ComputerBackEnd.Model.Product;



public interface ProductDAO 
{
	public boolean addProduct(Product product);
	public boolean deleteProduct(Product product);
	public boolean updateProduct(Product product);
	public Product getProduct(int productId);
	public List<Product> listProducts();
	
}
