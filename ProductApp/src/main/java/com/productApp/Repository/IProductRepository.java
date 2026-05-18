package com.productApp.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.productApp.Exceptions.ProductNotFoundException;
import com.productApp.Model.Product;
import com.productApp.Model.ProductDTO;

@Repository
public interface IProductRepository extends JpaRepository<Product, Integer>{

	//derived query - query from property names, method names must match property names
	List<Product> findByBrand(String brand);
	List<Product> findByBrandAndProductNameContains(String brand, String productName);
	
	//custom query - uses JPQL(JPA Persistence Query Language), method name can be anything
	//we use entity name & entity property names
	//annotated with @Query
	@Query("from Product p where p.category=?1")
	public List<Product> getByCat(String brand);
	@Query("from Product p where p.brand=?1 and p.price<?2")
	public List<Product> getByBrandPriceLess(String brand, double price);
	
	//native querying - method name can be anything
	//@Query annotation with value & nativeQuery attributes
	//normal sql query
	@Query(value="select * from product where cost < ?1", nativeQuery = true)
	public List<Product> getByLesserPrice(double price);
	@Query(value="select * from product where category=?1 and product_name like ?2", nativeQuery = true)
	public List<Product> getByCatNameContains(String category, String productName);
	
	@Query(name="getProductsByBrand")
	public List<Product> getProductByBrand(String brand);
	@Query(name="getByCatPriceLess")
	public List<Product> getByCatPriceLess(String category, double price);
}





