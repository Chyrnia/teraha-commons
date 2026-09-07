package com.teraha.commons.entities;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "sale_invoice_details")
public class SaleInvoiceDetail extends InvoiceDetail {

	@ManyToOne
	@JoinColumn(name = "invoice_id", nullable = false)
	private SaleInvoice invoice;

	@Column(name = "unit_price", nullable = false, precision = 17, scale = 2)
	private BigDecimal unitPrice;

	protected SaleInvoiceDetail() {}

	public SaleInvoiceDetail(
			Product product,
			Integer quantity,
			SaleInvoice invoice,
			BigDecimal unitPrice)
	{
		super(product, quantity);
		this.invoice = invoice;
		this.unitPrice = unitPrice;
	}
}

