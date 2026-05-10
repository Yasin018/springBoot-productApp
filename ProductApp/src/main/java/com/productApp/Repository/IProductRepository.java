package com.productApp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.productApp.Model.Product;

@Repository
public interface IProductRepository extends JpaRepository<Product, Integer>{

}
