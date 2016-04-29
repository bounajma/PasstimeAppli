package com.passtime.passtimeappli.Model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The persistent class for the partner_status_raison database table.
 * 
 */
@Entity
@Table(name="partner_status_raison")
@NamedQuery(name="PartnerStatusRaison.findAll", query="SELECT p FROM PartnerStatusRaison p")
public class PartnerStatusRaison implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String name;

	//bi-directional many-to-one association to PartnerOverall
	@JsonIgnore
	@OneToMany(mappedBy="partnerStatusRaison")
	private List<PartnerOverall> partnerOveralls;

	public PartnerStatusRaison() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<PartnerOverall> getPartnerOveralls() {
		return this.partnerOveralls;
	}

	public void setPartnerOveralls(List<PartnerOverall> partnerOveralls) {
		this.partnerOveralls = partnerOveralls;
	}

	public PartnerOverall addPartnerOverall(PartnerOverall partnerOverall) {
		getPartnerOveralls().add(partnerOverall);
		partnerOverall.setPartnerStatusRaison(this);

		return partnerOverall;
	}

	public PartnerOverall removePartnerOverall(PartnerOverall partnerOverall) {
		getPartnerOveralls().remove(partnerOverall);
		partnerOverall.setPartnerStatusRaison(null);

		return partnerOverall;
	}

}