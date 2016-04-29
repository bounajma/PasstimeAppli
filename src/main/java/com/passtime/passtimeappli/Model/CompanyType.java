package com.passtime.passtimeappli.Model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the company_type database table.
 * 
 */
@Entity
@Table(name="company_type")
@NamedQuery(name="CompanyType.findAll", query="SELECT c FROM CompanyType c")
public class CompanyType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String name;

	@Column(name="short_name")
	private String shortName;

	//bi-directional many-to-one association to Company
	@OneToMany(mappedBy="companyType")
	private List<Company> companies;

	//bi-directional many-to-one association to Country
	@ManyToOne
	@JoinColumn(name="id_country")
	private Country country;

	public CompanyType() {
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

	public List<Company> getCompanies() {
		return this.companies;
	}

	public void setCompanies(List<Company> companies) {
		this.companies = companies;
	}

	public Company addCompany(Company company) {
		getCompanies().add(company);
		company.setCompanyType(this);

		return company;
	}

	public Company removeCompany(Company company) {
		getCompanies().remove(company);
		company.setCompanyType(null);

		return company;
	}

	public Country getCountry() {
		return this.country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

}