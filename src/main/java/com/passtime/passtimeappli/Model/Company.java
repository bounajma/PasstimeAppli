package com.passtime.passtimeappli.Model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the company database table.
 * 
 */
@Entity
@NamedQuery(name="Company.findAll", query="SELECT c FROM Company c")
public class Company implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Lob
	private String address;

	@Lob
	@Column(name="address_additional")
	private String addressAdditional;

	private int capital;

	private String email;

	@Column(name="fax_phone")
	private String faxPhone;

	@Column(name="home_phone")
	private String homePhone;

	@Lob
	@Column(name="identification_number")
	private String identificationNumber;

	private String name;

	private String postcode;

	private String town;

	//bi-directional many-to-one association to Account
	@Transient
	@OneToMany(mappedBy="company")
	private List<Account> accounts;

	//bi-directional many-to-one association to CompanyType
	@ManyToOne
	@JoinColumn(name="id_company_type")
	private CompanyType companyType;

	//bi-directional many-to-one association to Country
	@ManyToOne
	@JoinColumn(name="id_country")
	private Country country;

	public Company() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddressAdditional() {
		return this.addressAdditional;
	}

	public void setAddressAdditional(String addressAdditional) {
		this.addressAdditional = addressAdditional;
	}

	public int getCapital() {
		return this.capital;
	}

	public void setCapital(int capital) {
		this.capital = capital;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFaxPhone() {
		return this.faxPhone;
	}

	public void setFaxPhone(String faxPhone) {
		this.faxPhone = faxPhone;
	}

	public String getHomePhone() {
		return this.homePhone;
	}

	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}

	public String getIdentificationNumber() {
		return this.identificationNumber;
	}

	public void setIdentificationNumber(String identificationNumber) {
		this.identificationNumber = identificationNumber;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPostcode() {
		return this.postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getTown() {
		return this.town;
	}

	public void setTown(String town) {
		this.town = town;
	}

	public List<Account> getAccounts() {
		return this.accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	public Account addAccount(Account account) {
		getAccounts().add(account);
		account.setCompany(this);

		return account;
	}

	public Account removeAccount(Account account) {
		getAccounts().remove(account);
		account.setCompany(null);

		return account;
	}

	public CompanyType getCompanyType() {
		return this.companyType;
	}

	public void setCompanyType(CompanyType companyType) {
		this.companyType = companyType;
	}

	public Country getCountry() {
		return this.country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

}