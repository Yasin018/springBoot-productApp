package com.productApp.Model;

import org.springframework.stereotype.Component;

@Component
public class ProductMapper {
	public ProductDTO convertToDTO(Product product) {
		ProductDTO productDTO = new ProductDTO();
		productDTO.setProductName(product.getProductName());
		productDTO.setBrand(product.getBrand());
		productDTO.setCategory(product.getCategory());
		productDTO.setProductId(product.getProductId());
		productDTO.setPrice(product.getPrice());
		
		return productDTO;
	}
	
	//call this while using add method and update method
	public Product convertToEntity(ProductDTO productDTO) {
		Product product = new Product();
		product.setProductName(productDTO.getProductName());
		product.setBrand(productDTO.getBrand());
		product.setCategory(productDTO.getCategory());
		product.setProductId(productDTO.getProductId());
		product.setPrice(productDTO.getPrice());
		
		return product;
	}
}
