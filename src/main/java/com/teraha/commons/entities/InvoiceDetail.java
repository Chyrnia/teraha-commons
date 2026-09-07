package com.teraha.commons.entities;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public abstract class InvoiceDetail extends BaseEntity {

	@ManyToOne
	@JoinColumn(name = "product_id", nullable = false)
	private Product product;

	@Column(nullable = false)
	private Integer quantity;

	protected InvoiceDetail() {}

	protected InvoiceDetail(
			Product product,
			Integer quantity)
	{
		this.product = product;
		this.quantity = quantity;
	}
}
