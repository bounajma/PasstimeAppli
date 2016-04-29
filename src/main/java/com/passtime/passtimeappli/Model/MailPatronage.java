package com.passtime.passtimeappli.Model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the mail_patronage database table.
 * 
 */
@Entity
@Table(name="mail_patronage")
@NamedQuery(name="MailPatronage.findAll", query="SELECT m FROM MailPatronage m")
public class MailPatronage implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(name="reduc_price_card")
	private String reducPriceCard;

	@Column(name="reduc_price_guide")
	private String reducPriceGuide;

	//bi-directional many-to-one association to FranchiseSpace
	@ManyToOne
	@JoinColumn(name="id_franchise_space")
	private FranchiseSpace franchiseSpace;

	public MailPatronage() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getReducPriceCard() {
		return this.reducPriceCard;
	}

	public void setReducPriceCard(String reducPriceCard) {
		this.reducPriceCard = reducPriceCard;
	}

	public String getReducPriceGuide() {
		return this.reducPriceGuide;
	}

	public void setReducPriceGuide(String reducPriceGuide) {
		this.reducPriceGuide = reducPriceGuide;
	}

	public FranchiseSpace getFranchiseSpace() {
		return this.franchiseSpace;
	}

	public void setFranchiseSpace(FranchiseSpace franchiseSpace) {
		this.franchiseSpace = franchiseSpace;
	}

}