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
//		Product product = new Product("Microphone","Moana","Electronics",20000);
//		productService.addProduct(product);
//		product = new Product("Laptop","HP","Electronics",73000);
//		productService.addProduct(product);
//		Product product1 = new Product("Ear phone","Samsung","Electronics",600);
//		productService.addProduct(product1);
//		Product product2 = new Product("Speaker","Samsung","Electronics",15000);
//		productService.addProduct(product2);
//		Product product3 = new Product("Head phone","Boat","Electronics",13000);
//		productService.addProduct(product3);
//		Product product4 = new Product("Pencils","Camlin","Stationary",200);
//		productService.addProduct(product4);
//		Product product5 = new Product("Pen","Classmate","Stationary",300);
//		productService.addProduct(product5);
//		Product product6 = new Product("Color Pencils","Camlin","Stationary",200);
//		productService.addProduct(product6);
		//productService.updateProduct(product);
		
		System.out.println();
		//System.out.println(productService.getAllProducts());
//		
//		System.out.println();
//		System.out.println(productService.getById(1));
		
//		System.out.println("Get By Brand");
//		System.out.println(productService.getByBrand("HP"));
//		
//		System.out.println("Get By Brand And Name containing");
//		System.out.println(productService.getByBrandContains("Camlin","pen"));
		
//		System.out.println("Get By Category");
//		productService.getByCat("Electronics").forEach(System.out::println);
//		
//		System.out.println("Get By Brand And Price Less Than");
//		productService.getByBrandPriceLess("Camlin",600).forEach(System.out::println);
		
//		System.out.println("Get By Lesser Price:");
//		productService.getByLesserPrice(30000).forEach(System.out::println);
//		
//		System.out.println("Get By Category & name contains:");
//		productService.getByCategoryName("Electronics","Mo").forEach(System.out::println);
		
		System.out.println("Get Product By Brand:");
		productService.getProductByBrand("Camlin").forEach(System.out::println);
		
		System.out.println("Get By Category & price less than:");
		productService.getByCatPriceLess("Electronics",13000).forEach(System.out::println);
	}

}
