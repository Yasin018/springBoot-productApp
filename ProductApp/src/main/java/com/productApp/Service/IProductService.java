package com.productApp.Service;

import java.util.List;

import com.productApp.Exceptions.ProductNotFoundException;
import com.productApp.Model.Product;
import com.productApp.Model.ProductDTO;

public interface IProductService {
	
	void addProduct(ProductDTO productDTO);
	void updateProduct(ProductDTO productDTO);
	void deleteProduct(int productId);
	List<ProductDTO> getAllProducts();
	ProductDTO getById(int id);
	
	//derived querying
	public List<ProductDTO> getByBrand(String brand) throws ProductNotFoundException;
	public List<ProductDTO> getByBrandContains(String brand, String productName) throws ProductNotFoundException;
	
	//custom querying
	public List<ProductDTO> getByCat(String brand) throws ProductNotFoundException;
	public List<ProductDTO> getByBrandPriceLess(String brand, double price) throws ProductNotFoundException;
	
	//native querying
	public List<ProductDTO> getByLesserPrice(double price) throws ProductNotFoundException;
	public List<ProductDTO> getByCategoryName(String category, String product) throws ProductNotFoundException;
	
	//named querying
	public List<ProductDTO> getProductByBrand(String brand) throws ProductNotFoundException;
	public List<ProductDTO> getByCatPriceLess(String category, double price) throws ProductNotFoundException;
}
