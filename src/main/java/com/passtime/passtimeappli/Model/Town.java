package com.passtime.passtimeappli.Model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the town database table.
 * 
 */
@Entity
@NamedQuery(name="Town.findAll", query="SELECT t FROM Town t")
public class Town implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(name="code_insee")
	private int codeInsee;

	@Column(name="lower_name")
	private String lowerName;

	private String postcode;

	@Column(name="upper_name")
	private String upperName;

	@Transient
	//bi-directional many-to-one association to Country
	@ManyToOne
	@JoinColumn(name="id_country")
	private Country country;

	public Town() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCodeInsee() {
		return this.codeInsee;
	}

	public void setCodeInsee(int codeInsee) {
		this.codeInsee = codeInsee;
	}

	public String getLowerName() {
		return this.lowerName;
	}

	public void setLowerName(String lowerName) {
		this.lowerName = lowerName;
	}

	public String getPostcode() {
		return this.postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getUpperName() {
		return this.upperName;
	}

	public void setUpperName(String upperName) {
		this.upperName = upperName;
	}

	public Country getCountry() {
		return this.country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

}