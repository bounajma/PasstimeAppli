package com.passtime.passtimeappli.Model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the central_management database table.
 * 
 */
@Entity
@Table(name="central_management")
@NamedQuery(name="CentralManagement.findAll", query="SELECT c FROM CentralManagement c")
public class CentralManagement implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Lob
	private String description;

	private String link;

	private String logo;

	private String name;

	@Column(name="name_ref")
	private String nameRef;

	//bi-directional many-to-one association to 
	@Transient
	@OneToMany(mappedBy="centralManagement")
	private List<Account> accounts;

	public CentralManagement() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLink() {
		return this.link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getLogo() {
		return this.logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNameRef() {
		return this.nameRef;
	}

	public void setNameRef(String nameRef) {
		this.nameRef = nameRef;
	}

	public List<Account> getAccounts() {
		return this.accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	public Account addAccount(Account account) {
		getAccounts().add(account);
		account.setCentralManagement(this);

		return account;
	}

	public Account removeAccount(Account account) {
		getAccounts().remove(account);
		account.setCentralManagement(null);

		return account;
	}

}