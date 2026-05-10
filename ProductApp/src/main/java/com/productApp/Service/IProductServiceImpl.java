package com.productApp.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.productApp.Model.Product;
import com.productApp.Repository.IProductRepository;

@Service
public class IProductServiceImpl implements IProductService {

	@Autowired
	IProductRepository productRepository;
	
	public void addProduct(Product product) {
		productRepository.save(product);
	}

	@Override
	public void updateProduct(Product productName) {
		productRepository.save(productName);
	}

	@Override
	public void deleteProduct(int productId) {
		productRepository.deleteById(productId);
	}

	@Override
	public List<Product> getAllProducts() {
		List<Product> products = productRepository.findAll();
		return products;
	}

	@Override
	public Product getById(int id) {

		Optional<Product> productOpt = productRepository.findById(id);
		if(productOpt.isPresent())
			return productOpt.get();
		return null;
	}

}
