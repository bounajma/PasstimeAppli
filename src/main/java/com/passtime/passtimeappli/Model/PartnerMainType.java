package com.passtime.passtimeappli.Model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The persistent class for the partner_main_type database table.
 * 
 */
@Entity
@Table(name="partner_main_type")
@NamedQuery(name="PartnerMainType.findAll", query="SELECT p FROM PartnerMainType p")
public class PartnerMainType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(name="main_type_child")
	private int mainTypeChild;

	@Column(name="main_type_parent")
	private int mainTypeParent;

	private String name;

	//bi-directional many-to-one association to PartnerOffer
	@Transient
	@OneToMany(mappedBy="partnerMainType")
	private List<PartnerOffer> partnerOffers;

	//bi-directional many-to-one association to PartnerType
	@JsonIgnore
	@OneToMany(mappedBy="partnerMainType")
	private List<PartnerType> partnerTypes;

	public PartnerMainType() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMainTypeChild() {
		return this.mainTypeChild;
	}

	public void setMainTypeChild(int mainTypeChild) {
		this.mainTypeChild = mainTypeChild;
	}

	public int getMainTypeParent() {
		return this.mainTypeParent;
	}

	public void setMainTypeParent(int mainTypeParent) {
		this.mainTypeParent = mainTypeParent;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<PartnerOffer> getPartnerOffers() {
		return this.partnerOffers;
	}

	public void setPartnerOffers(List<PartnerOffer> partnerOffers) {
		this.partnerOffers = partnerOffers;
	}

	public PartnerOffer addPartnerOffer(PartnerOffer partnerOffer) {
		getPartnerOffers().add(partnerOffer);
		partnerOffer.setPartnerMainType(this);

		return partnerOffer;
	}

	public PartnerOffer removePartnerOffer(PartnerOffer partnerOffer) {
		getPartnerOffers().remove(partnerOffer);
		partnerOffer.setPartnerMainType(null);

		return partnerOffer;
	}

	public List<PartnerType> getPartnerTypes() {
		return this.partnerTypes;
	}

	public void setPartnerTypes(List<PartnerType> partnerTypes) {
		this.partnerTypes = partnerTypes;
	}

	public PartnerType addPartnerType(PartnerType partnerType) {
		getPartnerTypes().add(partnerType);
		partnerType.setPartnerMainType(this);

		return partnerType;
	}

	public PartnerType removePartnerType(PartnerType partnerType) {
		getPartnerTypes().remove(partnerType);
		partnerType.setPartnerMainType(null);

		return partnerType;
	}

}