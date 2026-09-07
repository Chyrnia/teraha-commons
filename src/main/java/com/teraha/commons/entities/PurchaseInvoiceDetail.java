package com.teraha.commons.entities;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Column;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "purchase_invoice_details")
public class PurchaseInvoiceDetail extends InvoiceDetail {
	@ManyToOne
	@JoinColumn(name = "invoice_id", nullable = false)
	private PurchaseInvoice invoice;

	@Column(name = "unit_cost", nullable = false, precision = 17, scale = 2)
	private BigDecimal unitCost;

	protected PurchaseInvoiceDetail() {}

	public PurchaseInvoiceDetail(
			Product product,
			Integer quantity,
			PurchaseInvoice invoice,
			BigDecimal unitCost)
	{
		super(product, quantity);
		this.invoice = invoice;
		this.unitCost = unitCost;
	}
}
