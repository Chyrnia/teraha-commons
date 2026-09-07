package com.teraha.commons.entities;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "sale_invoices")
public class SaleInvoice extends Invoice {
	@ManyToOne
	@JoinColumn(name = "client_id", nullable = false)
	private Client thirdParty;

	@OneToMany(mappedBy = "invoice")
	private List<SaleInvoiceDetail> details;

	protected SaleInvoice() {}

	public SaleInvoice(
			String invoiceNumber, 
		   	OffsetDateTime transactionDate,
			BigDecimal total,
			Client thirdParty)
	{
		super(invoiceNumber, transactionDate, total);
		this.thirdParty = thirdParty;
	}

}
