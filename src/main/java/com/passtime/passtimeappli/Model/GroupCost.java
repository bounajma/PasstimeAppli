package com.passtime.passtimeappli.Model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the group_cost database table.
 * 
 */
@Entity
@Table(name="group_cost")
@NamedQuery(name="GroupCost.findAll", query="SELECT g FROM GroupCost g")
public class GroupCost implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String cost;

	private String quantity;

	private int stage;

	//bi-directional many-to-one association to FranchiseSpace
	@ManyToOne
	@JoinColumn(name="id_franchise_space")
	private FranchiseSpace franchiseSpace;

	public GroupCost() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCost() {
		return this.cost;
	}

	public void setCost(String cost) {
		this.cost = cost;
	}

	public String getQuantity() {
		return this.quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public int getStage() {
		return this.stage;
	}

	public void setStage(int stage) {
		this.stage = stage;
	}

	public FranchiseSpace getFranchiseSpace() {
		return this.franchiseSpace;
	}

	public void setFranchiseSpace(FranchiseSpace franchiseSpace) {
		this.franchiseSpace = franchiseSpace;
	}

}