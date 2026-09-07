package com.teraha.commons.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "suppliers")
public class Supplier extends Person {
	@Column(nullable = false)
	private String timbrado; 

	@ManyToMany(mappedBy = "suppliers")
	private List<Product> products;

	protected Supplier() {}

	public Supplier(
			String name,
			String document,
			String address,
			String email,
			String phone,
			String timbrado
			){
		super(name, document, address, email, phone);
		this.timbrado = timbrado;
			}
}
