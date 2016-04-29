package com.passtime.passtimeappli.Model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the code_card database table.
 * 
 */
@Entity
@Table(name="code_card")
@NamedQuery(name="CodeCard.findAll", query="SELECT c FROM CodeCard c")
public class CodeCard implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String code;

	@Column(name="code_active")
	private byte codeActive;

	//bi-directional many-to-one association to Account
	@ManyToOne
	@JoinColumn(name="id_account")
	private Account account;

	public CodeCard() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public byte getCodeActive() {
		return this.codeActive;
	}

	public void setCodeActive(byte codeActive) {
		this.codeActive = codeActive;
	}

	public Account getAccount() {
		return this.account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

}