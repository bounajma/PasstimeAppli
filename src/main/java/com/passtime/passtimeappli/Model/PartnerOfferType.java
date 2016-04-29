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

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The persistent class for the partner_offer_type database table.
 * 
 */
@Entity
@Table(name="partner_offer_type")
@NamedQuery(name="PartnerOfferType.findAll", query="SELECT p FROM PartnerOfferType p")
public class PartnerOfferType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String name;

	@Column(name="short_name")
	private String shortName;

	//bi-directional many-to-one association to PartnerOffer
	@JsonIgnore
	@OneToMany(mappedBy="partnerOfferType")
	private List<PartnerOffer> partnerOffers;

	public PartnerOfferType() {
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

	public String getShortName() {
		return this.shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public List<PartnerOffer> getPartnerOffers() {
		return this.partnerOffers;
	}

	public void setPartnerOffers(List<PartnerOffer> partnerOffers) {
		this.partnerOffers = partnerOffers;
	}

	public PartnerOffer addPartnerOffer(PartnerOffer partnerOffer) {
		getPartnerOffers().add(partnerOffer);
		partnerOffer.setPartnerOfferType(this);

		return partnerOffer;
	}

	public PartnerOffer removePartnerOffer(PartnerOffer partnerOffer) {
		getPartnerOffers().remove(partnerOffer);
		partnerOffer.setPartnerOfferType(null);

		return partnerOffer;
	}

}