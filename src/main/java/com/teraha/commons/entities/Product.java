package com.teraha.commons.entities;

import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="products")
public class Product extends BaseEntity {
	@Column(nullable = false, unique = true)
	private String code;
	 
	@Column(nullable = false)
	private String description;

	@Column(nullable = false)
	private Integer stock;

	@Column(nullable = false, precision = 17, scale = 2)
	private BigDecimal price;

	@Column(nullable = false, precision = 17, scale = 2)
	private BigDecimal cost;

	@Column(nullable = false, precision = 5, scale = 2)
	private BigDecimal margin; 

	@ManyToMany
	@JoinTable(
		name = "product_categories",
		joinColumns = @JoinColumn(name = "product_id"),
		inverseJoinColumns = @JoinColumn(name = "category_id")
	)
	private List<Category> categories = new ArrayList<>();

	@ManyToMany
	@JoinTable(
		name = "product_suppliers",
		joinColumns = @JoinColumn(name = "product_id"),
		inverseJoinColumns = @JoinColumn(name = "supplier_id")
	)
	private List<Supplier> suppliers = new ArrayList<>();

	protected Product() {}

	public Product(
			String code, 
			String description, 
			Integer stock, 
			BigDecimal price, 
			BigDecimal cost,
		   	BigDecimal margin
			) {
		this.code = code;
		this.description = description;
		this.stock = stock;
		this.price = price;
		this.cost = cost;
		this.margin = margin;
			}
}
