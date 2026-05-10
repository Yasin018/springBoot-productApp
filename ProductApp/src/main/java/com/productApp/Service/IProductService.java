package com.productApp.Service;

import java.util.List;

import com.productApp.Model.Product;

public interface IProductService {
	
	void addProduct(Product productName);
	void updateProduct(Product productName);
	void deleteProduct(int productId);
	List<Product> getAllProducts();
	Product getById(int id);
	
}
