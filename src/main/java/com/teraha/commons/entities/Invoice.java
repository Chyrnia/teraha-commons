package com.teraha.commons.entities;

import java.time.OffsetDateTime;
import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public abstract class Invoice extends BaseEntity {

	@Column(name = "invoice_nr", nullable = false)
	private String invoiceNumber;

	@Column(nullable = false)
	private OffsetDateTime createdAt;

	@Column(nullable = false)
	private OffsetDateTime transactionDate;

	@Column(nullable = false, precision = 17, scale = 2)
	private BigDecimal total;

	protected Invoice () {}

	protected Invoice(
			String invoiceNumber, 
		   	OffsetDateTime transactionDate,
			BigDecimal total)
	{
		this.invoiceNumber = invoiceNumber;
		this.transactionDate = transactionDate;
		this.total = total;
	}
}
