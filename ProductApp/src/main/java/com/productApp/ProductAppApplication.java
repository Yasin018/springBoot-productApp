package com.productApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.productApp.Model.Product;
import com.productApp.Service.IProductService;

@SpringBootApplication
public class ProductAppApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ProductAppApplication.class, args);
	}

	@Autowired
	IProductService productService;
	
	@Override
	public void run(String... args) throws Exception {
		Product product = new Product("Mobile","Realme","Electronics",23000);
		//productService.addProduct(product);
		productService.updateProduct(product);
		
		System.out.println();
		System.out.println(productService.getAllProducts());
		
		System.out.println();
		System.out.println(productService.getById(1));
	}

}
