package com.teraha.commons.entities;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public abstract class Person extends BaseEntity {
	@Column(nullable = false)
	private String name;
	@Column(nullable = false, unique = true)
	private String document;
	private String address;
	private String email;
	private String phone;

	protected Person() {}

	protected Person(
			String name,
			String document,
			String address,
			String email,
			String phone
			) {
		this.name = name;
		this.document = document;
		this.address = address;
		this.email = email;
		this.phone = phone;
			}
}
