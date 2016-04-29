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
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The persistent class for the country database table.
 * 
 */
@Entity
@NamedQuery(name="Country.findAll", query="SELECT c FROM Country c")
public class Country implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String name;

	@Column(name="short_name")
	private String shortName;

	//bi-directional many-to-one association to 
	@JsonIgnore
	@OneToMany(mappedBy="country")
	private List<Account> accounts;

	//bi-directional many-to-one association to Company
	
	@OneToMany(mappedBy="country")
	private List<Company> companies;

	//bi-directional many-to-one association to CompanyType
	@OneToMany(mappedBy="country")
	private List<CompanyType> companyTypes;

	//bi-directional many-to-one association to Currency
	@ManyToOne
	@JoinColumn(name="id_currency")
	private Currency currency;

	//bi-directional many-to-one association to Partner
	@Transient
	@OneToMany(mappedBy="country")
	private List<Partner> partners;

	//bi-directional many-to-one association to Sector
	@OneToMany(mappedBy="country")
	private List<Sector> sectors;

	//bi-directional many-to-one association to TaxVat
	@OneToMany(mappedBy="country")
	private List<TaxVat> taxVats;

	//bi-directional many-to-one association to Town
	@OneToMany(mappedBy="country")
	private List<Town> towns;

	public Country() {
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

	public List<Account> getAccounts() {
		return this.accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	public Account addAccount(Account account) {
		getAccounts().add(account);
		account.setCountry(this);

		return account;
	}

	public Account removeAccount(Account account) {
		getAccounts().remove(account);
		account.setCountry(null);

		return account;
	}

	public List<Company> getCompanies() {
		return this.companies;
	}

	public void setCompanies(List<Company> companies) {
		this.companies = companies;
	}

	public Company addCompany(Company company) {
		getCompanies().add(company);
		company.setCountry(this);

		return company;
	}

	public Company removeCompany(Company company) {
		getCompanies().remove(company);
		company.setCountry(null);

		return company;
	}

	public List<CompanyType> getCompanyTypes() {
		return this.companyTypes;
	}

	public void setCompanyTypes(List<CompanyType> companyTypes) {
		this.companyTypes = companyTypes;
	}

	public CompanyType addCompanyType(CompanyType companyType) {
		getCompanyTypes().add(companyType);
		companyType.setCountry(this);

		return companyType;
	}

	public CompanyType removeCompanyType(CompanyType companyType) {
		getCompanyTypes().remove(companyType);
		companyType.setCountry(null);

		return companyType;
	}

	public Currency getCurrency() {
		return this.currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	public List<Partner> getPartners() {
		return this.partners;
	}

	public void setPartners(List<Partner> partners) {
		this.partners = partners;
	}

	public Partner addPartner(Partner partner) {
		getPartners().add(partner);
		partner.setCountry(this);

		return partner;
	}

	public Partner removePartner(Partner partner) {
		getPartners().remove(partner);
		partner.setCountry(null);

		return partner;
	}

	public List<Sector> getSectors() {
		return this.sectors;
	}

	public void setSectors(List<Sector> sectors) {
		this.sectors = sectors;
	}

	public Sector addSector(Sector sector) {
		getSectors().add(sector);
		sector.setCountry(this);

		return sector;
	}

	public Sector removeSector(Sector sector) {
		getSectors().remove(sector);
		sector.setCountry(null);

		return sector;
	}

	public List<TaxVat> getTaxVats() {
		return this.taxVats;
	}

	public void setTaxVats(List<TaxVat> taxVats) {
		this.taxVats = taxVats;
	}

	public TaxVat addTaxVat(TaxVat taxVat) {
		getTaxVats().add(taxVat);
		taxVat.setCountry(this);

		return taxVat;
	}

	public TaxVat removeTaxVat(TaxVat taxVat) {
		getTaxVats().remove(taxVat);
		taxVat.setCountry(null);

		return taxVat;
	}

	public List<Town> getTowns() {
		return this.towns;
	}

	public void setTowns(List<Town> towns) {
		this.towns = towns;
	}

	public Town addTown(Town town) {
		getTowns().add(town);
		town.setCountry(this);

		return town;
	}

	public Town removeTown(Town town) {
		getTowns().remove(town);
		town.setCountry(null);

		return town;
	}

}