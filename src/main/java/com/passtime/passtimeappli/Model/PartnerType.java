package com.passtime.passtimeappli.Model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The persistent class for the partner_type database table.
 * 
 */
@Entity
@Table(name="partner_type")
@NamedQuery(name="PartnerType.findAll", query="SELECT p FROM PartnerType p")
public class PartnerType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String name;

	@Column(name="partner_type_parent")
	private Integer partnerTypeParent;

	//bi-directional many-to-one association to PartnerOffer
	@Transient
	@OneToMany(mappedBy="partnerType")
	private List<PartnerOffer> partnerOffers;

	//bi-directional many-to-one association to PartnerOverall
	@JsonIgnore
	@OneToMany(mappedBy="partnerType")
	private List<PartnerOverall> partnerOveralls;

	//bi-directional many-to-one association to PartnerMainType
	
	@ManyToOne
	@JoinColumn(name="id_partner_main_type")
	private PartnerMainType partnerMainType;

	public PartnerType() {
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

	public Integer getPartnerTypeParent() {
		return this.partnerTypeParent;
	}

	public void setPartnerTypeParent(Integer partnerTypeParent) {
		this.partnerTypeParent = partnerTypeParent;
	}

	public List<PartnerOffer> getPartnerOffers() {
		return this.partnerOffers;
	}

	public void setPartnerOffers(List<PartnerOffer> partnerOffers) {
		this.partnerOffers = partnerOffers;
	}

	public PartnerOffer addPartnerOffer(PartnerOffer partnerOffer) {
		getPartnerOffers().add(partnerOffer);
		partnerOffer.setPartnerType(this);

		return partnerOffer;
	}

	public PartnerOffer removePartnerOffer(PartnerOffer partnerOffer) {
		getPartnerOffers().remove(partnerOffer);
		partnerOffer.setPartnerType(null);

		return partnerOffer;
	}

	public List<PartnerOverall> getPartnerOveralls() {
		return this.partnerOveralls;
	}

	public void setPartnerOveralls(List<PartnerOverall> partnerOveralls) {
		this.partnerOveralls = partnerOveralls;
	}

	public PartnerOverall addPartnerOverall(PartnerOverall partnerOverall) {
		getPartnerOveralls().add(partnerOverall);
		partnerOverall.setPartnerType(this);

		return partnerOverall;
	}

	public PartnerOverall removePartnerOverall(PartnerOverall partnerOverall) {
		getPartnerOveralls().remove(partnerOverall);
		partnerOverall.setPartnerType(null);

		return partnerOverall;
	}

	public PartnerMainType getPartnerMainType() {
		return this.partnerMainType;
	}

	public void setPartnerMainType(PartnerMainType partnerMainType) {
		this.partnerMainType = partnerMainType;
	}

}