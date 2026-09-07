package com.teraha.commons.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Setter;
import lombok.Getter;

@Getter
@Setter
@Entity
@Table(name = "clients")
public class Client extends Person {
	@Column(name = "birth_date")
	private LocalDate birthDate;

	protected Client() {}

	public Client(
			String name,
			String document,
			String address,
			String email,
			String phone,
			LocalDate birthDate
			){
		super(name, document, address, email, phone);
		this.birthDate = birthDate;
			}
}
