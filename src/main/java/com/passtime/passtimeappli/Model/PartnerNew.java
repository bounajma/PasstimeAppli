package com.passtime.passtimeappli.Model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the partner_news database table.
 * 
 */
@Entity
@Table(name="partner_news")
@NamedQuery(name="PartnerNew.findAll", query="SELECT p FROM PartnerNew p")
public class PartnerNew implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String date;

	@Lob
	private String description;

	@Column(name="hide_for_card")
	private int hideForCard;

	@Column(name="id_franchise_space")
	private int idFranchiseSpace;

	@Column(name="id_partner")
	private int idPartner;

	public PartnerNew() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDate() {
		return this.date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getHideForCard() {
		return this.hideForCard;
	}

	public void setHideForCard(int hideForCard) {
		this.hideForCard = hideForCard;
	}

	public int getIdFranchiseSpace() {
		return this.idFranchiseSpace;
	}

	public void setIdFranchiseSpace(int idFranchiseSpace) {
		this.idFranchiseSpace = idFranchiseSpace;
	}

	public int getIdPartner() {
		return this.idPartner;
	}

	public void setIdPartner(int idPartner) {
		this.idPartner = idPartner;
	}

}