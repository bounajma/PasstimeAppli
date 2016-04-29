package com.passtime.passtimeappli.Model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the guide_pagination database table.
 * 
 */
@Entity
@Table(name="guide_pagination")
@NamedQuery(name="GuidePagination.findAll", query="SELECT g FROM GuidePagination g")
public class GuidePagination implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(name="number_page")
	private int numberPage;

	//bi-directional many-to-one association to FranchiseSpace
	@OneToMany(mappedBy="guidePagination")
	private List<FranchiseSpace> franchiseSpaces;

	public GuidePagination() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumberPage() {
		return this.numberPage;
	}

	public void setNumberPage(int numberPage) {
		this.numberPage = numberPage;
	}

	public List<FranchiseSpace> getFranchiseSpaces() {
		return this.franchiseSpaces;
	}

	public void setFranchiseSpaces(List<FranchiseSpace> franchiseSpaces) {
		this.franchiseSpaces = franchiseSpaces;
	}

	public FranchiseSpace addFranchiseSpace(FranchiseSpace franchiseSpace) {
		getFranchiseSpaces().add(franchiseSpace);
		franchiseSpace.setGuidePagination(this);

		return franchiseSpace;
	}

	public FranchiseSpace removeFranchiseSpace(FranchiseSpace franchiseSpace) {
		getFranchiseSpaces().remove(franchiseSpace);
		franchiseSpace.setGuidePagination(null);

		return franchiseSpace;
	}

}