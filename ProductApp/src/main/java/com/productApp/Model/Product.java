package com.productApp.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data //alternate for below 3
//@Getter
//@Setter
//@ToString
@Entity
//@Table(name="Product_Data")
public class Product {
	@Column(length = 30)
	private String productName;
	@Id
	@GeneratedValue
	private Integer productId;
	@Column(length = 30)
	private String brand;
	@Column(length = 30)
	private String category;
	@Column(name = "cost")
	private double price;
	
	//as our product id is auto generated we have constructor without id
	public Product(String productName, String brand, String category, double price) {
		super();
		this.productName = productName;
		this.brand = brand;
		this.category = category;
		this.price = price;
	}
}
