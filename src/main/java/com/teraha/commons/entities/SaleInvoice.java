package com.teraha.commons.entities;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.ArrayList;

import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.CascadeType;

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

	@OneToMany(mappedBy = "invoice", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<SaleInvoiceDetail> details = new ArrayList<>();

	@Column(name = "invoice_sequential", nullable = false, insertable = false, updatable = false)
	private Integer invoiceSequential;

	protected SaleInvoice() {}

	public SaleInvoice(
		   	OffsetDateTime transactionDate,
			Client thirdParty)
	{
		super(transactionDate);
		this.thirdParty = thirdParty;
	}

	public void addDetail(SaleInvoiceDetail detail){
		details.add(detail);
		detail.setInvoice(this);
	}

}
