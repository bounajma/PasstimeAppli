package com.passtime.passtimeappli.Model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The persistent class for the partner_offer database table.
 * 
 */
@Entity
@Table(name="partner_offer")
@NamedQuery(name="PartnerOffer.findAll", query="SELECT p FROM PartnerOffer p")
public class PartnerOffer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(name="binary_multi_main_type")
	private String binaryMultiMainType;

	@Lob
	private String condition;

	@Column(name="condition_lock")
	private byte conditionLock;

	@Column(name="for_all")
	private byte forAll;

	@Column(name="group_number")
	private String groupNumber;

	private String letter;

	private String value;

	@Column(name="value_lock")
	private byte valueLock;

	//bi-directional many-to-one association to PartnerContentDescription
	@JsonIgnore
	@OneToMany(mappedBy="partnerOffer1")
	private List<PartnerContentDescription> partnerContentDescriptions1;

	//bi-directional many-to-one association to PartnerContentDescription
	@Transient
	@OneToMany(mappedBy="partnerOffer2")
	private List<PartnerContentDescription> partnerContentDescriptions2;

	//bi-directional many-to-one association to PartnerMainType
	@Transient
	@ManyToOne
	@JoinColumn(name="id_partner_main_type")
	private PartnerMainType partnerMainType;

	//bi-directional many-to-one association to PartnerOfferType
	@ManyToOne
	@JoinColumn(name="id_partner_offer_type")
	private PartnerOfferType partnerOfferType;

	//bi-directional many-to-one association to PartnerType
	@Transient
	@ManyToOne
	@JoinColumn(name="id_partner_type")
	private PartnerType partnerType;

	public PartnerOffer() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBinaryMultiMainType() {
		return this.binaryMultiMainType;
	}

	public void setBinaryMultiMainType(String binaryMultiMainType) {
		this.binaryMultiMainType = binaryMultiMainType;
	}

	public String getCondition() {
		return this.condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public byte getConditionLock() {
		return this.conditionLock;
	}

	public void setConditionLock(byte conditionLock) {
		this.conditionLock = conditionLock;
	}

	public byte getForAll() {
		return this.forAll;
	}

	public void setForAll(byte forAll) {
		this.forAll = forAll;
	}

	public String getGroupNumber() {
		return this.groupNumber;
	}

	public void setGroupNumber(String groupNumber) {
		this.groupNumber = groupNumber;
	}

	public String getLetter() {
		return this.letter;
	}

	public void setLetter(String letter) {
		this.letter = letter;
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public byte getValueLock() {
		return this.valueLock;
	}

	public void setValueLock(byte valueLock) {
		this.valueLock = valueLock;
	}

	public List<PartnerContentDescription> getPartnerContentDescriptions1() {
		return this.partnerContentDescriptions1;
	}

	public void setPartnerContentDescriptions1(List<PartnerContentDescription> partnerContentDescriptions1) {
		this.partnerContentDescriptions1 = partnerContentDescriptions1;
	}

	public PartnerContentDescription addPartnerContentDescriptions1(PartnerContentDescription partnerContentDescriptions1) {
		getPartnerContentDescriptions1().add(partnerContentDescriptions1);
		partnerContentDescriptions1.setPartnerOffer1(this);

		return partnerContentDescriptions1;
	}

	public PartnerContentDescription removePartnerContentDescriptions1(PartnerContentDescription partnerContentDescriptions1) {
		getPartnerContentDescriptions1().remove(partnerContentDescriptions1);
		partnerContentDescriptions1.setPartnerOffer1(null);

		return partnerContentDescriptions1;
	}

	public List<PartnerContentDescription> getPartnerContentDescriptions2() {
		return this.partnerContentDescriptions2;
	}

	public void setPartnerContentDescriptions2(List<PartnerContentDescription> partnerContentDescriptions2) {
		this.partnerContentDescriptions2 = partnerContentDescriptions2;
	}

	public PartnerContentDescription addPartnerContentDescriptions2(PartnerContentDescription partnerContentDescriptions2) {
		getPartnerContentDescriptions2().add(partnerContentDescriptions2);
		partnerContentDescriptions2.setPartnerOffer2(this);

		return partnerContentDescriptions2;
	}

	public PartnerContentDescription removePartnerContentDescriptions2(PartnerContentDescription partnerContentDescriptions2) {
		getPartnerContentDescriptions2().remove(partnerContentDescriptions2);
		partnerContentDescriptions2.setPartnerOffer2(null);

		return partnerContentDescriptions2;
	}

	public PartnerMainType getPartnerMainType() {
		return this.partnerMainType;
	}

	public void setPartnerMainType(PartnerMainType partnerMainType) {
		this.partnerMainType = partnerMainType;
	}

	public PartnerOfferType getPartnerOfferType() {
		return this.partnerOfferType;
	}

	public void setPartnerOfferType(PartnerOfferType partnerOfferType) {
		this.partnerOfferType = partnerOfferType;
	}

	public PartnerType getPartnerType() {
		return this.partnerType;
	}

	public void setPartnerType(PartnerType partnerType) {
		this.partnerType = partnerType;
	}

}