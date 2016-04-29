package com.passtime.passtimeappli.Model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the privilege_offer database table.
 * 
 */
@Entity
@Table(name="privilege_offer")
@NamedQuery(name="PrivilegeOffer.findAll", query="SELECT p FROM PrivilegeOffer p")
public class PrivilegeOffer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Lob
	private String description;

	private int doc;

	@Lob
	@Column(name="group_price")
	private String groupPrice;

	@Lob
	@Column(name="instead_of")
	private String insteadOf;

	private String value;

	//bi-directional many-to-one association to FranchiseSpace
	@ManyToOne
	@JoinColumn(name="id_franchise_space")
	private FranchiseSpace franchiseSpace;

	public PrivilegeOffer() {
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

	public int getDoc() {
		return this.doc;
	}

	public void setDoc(int doc) {
		this.doc = doc;
	}

	public String getGroupPrice() {
		return this.groupPrice;
	}

	public void setGroupPrice(String groupPrice) {
		this.groupPrice = groupPrice;
	}

	public String getInsteadOf() {
		return this.insteadOf;
	}

	public void setInsteadOf(String insteadOf) {
		this.insteadOf = insteadOf;
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public FranchiseSpace getFranchiseSpace() {
		return this.franchiseSpace;
	}

	public void setFranchiseSpace(FranchiseSpace franchiseSpace) {
		this.franchiseSpace = franchiseSpace;
	}

}