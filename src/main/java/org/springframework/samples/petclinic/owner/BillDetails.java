package org.springframework.samples.petclinic.owner;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Digits;

import org.hibernate.annotations.Cascade;
import org.springframework.samples.petclinic.model.BaseEntity;

@Entity
@Table(name = "billdetails")
public class BillDetails extends BaseEntity {

	
	@ManyToOne
    @JoinColumn(name = "id_bill")
	public Bill bill;

	@Column(name = "details")
	private String details;
	
	public Bill getBill() {
		return bill;
	}

	public void setBill(Bill bill) {
		this.bill = bill;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}
  


}
