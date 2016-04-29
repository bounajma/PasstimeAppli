package com.passtime.passtimeappli.Model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the idea_we_saved database table.
 * 
 */
@Entity
@Table(name="idea_we_saved")
@NamedQuery(name="IdeaWeSaved.findAll", query="SELECT i FROM IdeaWeSaved i")
public class IdeaWeSaved implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date date;

	@Column(name="id_account")
	private int idAccount;

	@Column(name="partner_var_1")
	private int partnerVar1;

	@Column(name="partner_var_2")
	private int partnerVar2;

	//bi-directional many-to-one association to IdeaWe
	@Transient
	@ManyToOne
	@JoinColumn(name="id_idea_we")
	private IdeaWe ideaWe;

	public IdeaWeSaved() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getIdAccount() {
		return this.idAccount;
	}

	public void setIdAccount(int idAccount) {
		this.idAccount = idAccount;
	}

	public int getPartnerVar1() {
		return this.partnerVar1;
	}

	public void setPartnerVar1(int partnerVar1) {
		this.partnerVar1 = partnerVar1;
	}

	public int getPartnerVar2() {
		return this.partnerVar2;
	}

	public void setPartnerVar2(int partnerVar2) {
		this.partnerVar2 = partnerVar2;
	}

	public IdeaWe getIdeaWe() {
		return this.ideaWe;
	}

	public void setIdeaWe(IdeaWe ideaWe) {
		this.ideaWe = ideaWe;
	}

}