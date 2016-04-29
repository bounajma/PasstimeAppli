package com.passtime.passtimeappli.Model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tax_vat database table.
 * 
 */
@Entity
@Table(name="tax_vat")
@NamedQuery(name="TaxVat.findAll", query="SELECT t FROM TaxVat t")
public class TaxVat implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private float value;

	//bi-directional many-to-one association to FranchiseSpace
	@OneToMany(mappedBy="taxVat")
	private List<FranchiseSpace> franchiseSpaces;

	//bi-directional many-to-one association to Country
	@ManyToOne
	@JoinColumn(name="id_country")
	private Country country;

	public TaxVat() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getValue() {
		return this.value;
	}

	public void setValue(float value) {
		this.value = value;
	}

	public List<FranchiseSpace> getFranchiseSpaces() {
		return this.franchiseSpaces;
	}

	public void setFranchiseSpaces(List<FranchiseSpace> franchiseSpaces) {
		this.franchiseSpaces = franchiseSpaces;
	}

	public FranchiseSpace addFranchiseSpace(FranchiseSpace franchiseSpace) {
		getFranchiseSpaces().add(franchiseSpace);
		franchiseSpace.setTaxVat(this);

		return franchiseSpace;
	}

	public FranchiseSpace removeFranchiseSpace(FranchiseSpace franchiseSpace) {
		getFranchiseSpaces().remove(franchiseSpace);
		franchiseSpace.setTaxVat(null);

		return franchiseSpace;
	}

	public Country getCountry() {
		return this.country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

}