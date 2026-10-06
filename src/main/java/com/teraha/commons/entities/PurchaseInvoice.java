package com.teraha.commons.entities;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.ArrayList;

import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.CascadeType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "purchase_invoices")
public class PurchaseInvoice extends Invoice {
	@ManyToOne
	@JoinColumn(name = "supplier_id", nullable = false)
	private Supplier thirdParty;

	@OneToMany(mappedBy = "invoice", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<PurchaseInvoiceDetail> details = new ArrayList<>();

	protected PurchaseInvoice() {}

	public PurchaseInvoice(
			String invoiceNumber, 
		   	OffsetDateTime transactionDate,
			Supplier thirdParty)
	{
		super(invoiceNumber, transactionDate);
		this.thirdParty = thirdParty;
	}

	public void addDetail(PurchaseInvoiceDetail detail){
		details.add(detail);
		detail.setInvoice(this);
	}
}
