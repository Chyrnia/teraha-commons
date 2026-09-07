package com.teraha.commons.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "categories")
public class Category extends BaseEntity {

	@Column(nullable = false, unique = true)
	private String name;

	@ManyToMany(mappedBy = "categories")
	private List<Product> products;

	protected Category() {}

	public Category(String name){
		this.name = name;
	}
}
