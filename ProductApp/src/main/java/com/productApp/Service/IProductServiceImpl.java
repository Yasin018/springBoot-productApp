package com.productApp.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.productApp.Exceptions.ProductNotFoundException;
import com.productApp.Model.Product;
import com.productApp.Model.ProductDTO;
import com.productApp.Model.ProductMapper;
import com.productApp.Repository.IProductRepository;

@Service
public class IProductServiceImpl implements IProductService {

	@Autowired
	IProductRepository productRepository;
	
	@Autowired
	ProductMapper productMapper;
	
	public void addProduct(ProductDTO productDTO) {
		Product product = productMapper.convertToEntity(productDTO);
		productRepository.save(product);
	}

	@Override
	public void updateProduct(ProductDTO productDTO) {
		Product product = productMapper.convertToEntity(productDTO);
		productRepository.save(product);
	}

	@Override
	public void deleteProduct(int productId) {
		productRepository.deleteById(productId);
	}

	@Override
	public List<ProductDTO> getAllProducts() {
		List<Product> products = productRepository.findAll();
//		List<ProductDTO> prdouctDTOList = products.stream().map(product -> productMapper.convertToDTO(product))
//				.collect(Collectors.toList());
		List<ProductDTO> prdouctDTOList = convertToDTOList(products);
		return prdouctDTOList;
	}

	@Override
	public ProductDTO getById(int id) {

		Optional<Product> productOpt = productRepository.findById(id);
		if(productOpt.isPresent()) {
			Product product = productOpt.get();
			return productMapper.convertToDTO(product);
		}
		return null;
	}

	@Override
	public List<ProductDTO> getByBrand(String brand) {

		List<Product> products = productRepository.findByBrand(brand);
//		List<ProductDTO> productDTOList = new ArrayList<>();
//		for(Product product: products) {
//			ProductDTO productDTO = productMapper.convertToDTO(product);
//			productDTOList.add(productDTO);
//		}
//		
//		if (productDTOList.isEmpty())
//			throw new ProductNotFoundException("Product with this brand not found");
//		return productDTOList;
		
		List<ProductDTO> productDTOList = products.stream().map(product -> productMapper.convertToDTO(product))
		.collect(Collectors.toList());
		
		if (productDTOList.isEmpty())
			throw new ProductNotFoundException("Product with this brand not found");
		return productDTOList;
	}


	public List<ProductDTO> getByBrandContains(String brand, String productName) {

		List<Product> products = productRepository.findByBrandAndProductNameContains(brand,productName);
		List<ProductDTO> productDTOList = convertToDTOList(products);
		
		if (productDTOList.isEmpty())
			throw new ProductNotFoundException("Product with this brand & name contains not found");
		return productDTOList;
	}

	@Override
	public List<ProductDTO> getByCat(String brand) {
		List<Product> products = productRepository.getByCat(brand);
		List<ProductDTO> productDTOList = convertToDTOList(products);
		
		if (productDTOList.isEmpty())
			throw new ProductNotFoundException("Product with this category not found");
		return productDTOList;
	}


	public List<ProductDTO> getByBrandPriceLess(String brand, double price) {
		List<Product> products = productRepository.getByBrandPriceLess(brand,price);
		List<ProductDTO> productDTOList = convertToDTOList(products);
		
		if (productDTOList.isEmpty())
			throw new ProductNotFoundException("Product with this brand & less price is not found");
		return productDTOList;
	}

	@Override
	public List<ProductDTO> getByLesserPrice(double price) {
		List<Product> products = productRepository.getByLesserPrice(price);
		List<ProductDTO> productDTOList = convertToDTOList(products);
		
		if (productDTOList.isEmpty())
			throw new ProductNotFoundException("Product with less price is not found");
		return productDTOList;
	}

	@Override
	public List<ProductDTO> getByCategoryName(String category, String product) {
		List<Product> products = productRepository.getByCatNameContains(category,"%"+product+"%");
		List<ProductDTO> productDTOList = convertToDTOList(products);
		
		if (productDTOList.isEmpty())
			throw new ProductNotFoundException("Product with this category & product name contains is not found");
		return productDTOList;
	}


	public List<ProductDTO> getProductByBrand(String brand) {
		List<Product> products = productRepository.getProductByBrand(brand);
		List<ProductDTO> productDTOList = convertToDTOList(products);
		
		if (productDTOList.isEmpty())
			throw new ProductNotFoundException("Product with this brand is not found");
		return productDTOList;
	}


	public List<ProductDTO> getByCatPriceLess(String category, double price) {
		List<Product> products = productRepository.getByCatPriceLess(category,price);
		List<ProductDTO> productDTOList = convertToDTOList(products);
		
		if (productDTOList.isEmpty())
			throw new ProductNotFoundException("Product with this category & lesser price is not found");
		return productDTOList;
	}
	
	private List<ProductDTO> convertToDTOList (List<Product> products) {
		List<ProductDTO> productDTOList = products.stream()
										.map(product -> productMapper.convertToDTO(product))
										.collect(Collectors.toList());
		return productDTOList;
	}

}
