package com.passtime.passtimeappli.Model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigInteger;


/**
 * The persistent class for the guide_add_page database table.
 * 
 */
@Entity
@Table(name="guide_add_page")
@NamedQuery(name="GuideAddPage.findAll", query="SELECT g FROM GuideAddPage g")
public class GuideAddPage implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(name="file_name")
	private String fileName;

	private String name;

	@Column(name="nb_point")
	private BigInteger nbPoint;

	//bi-directional many-to-one association to FranchiseSpace
	@ManyToOne
	@JoinColumn(name="id_franchise_space")
	private FranchiseSpace franchiseSpace;

	//bi-directional many-to-one association to GuideAddPageType
	@ManyToOne
	@JoinColumn(name="id_guide_add_page_type")
	private GuideAddPageType guideAddPageType;

	public GuideAddPage() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFileName() {
		return this.fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigInteger getNbPoint() {
		return this.nbPoint;
	}

	public void setNbPoint(BigInteger nbPoint) {
		this.nbPoint = nbPoint;
	}

	public FranchiseSpace getFranchiseSpace() {
		return this.franchiseSpace;
	}

	public void setFranchiseSpace(FranchiseSpace franchiseSpace) {
		this.franchiseSpace = franchiseSpace;
	}

	public GuideAddPageType getGuideAddPageType() {
		return this.guideAddPageType;
	}

	public void setGuideAddPageType(GuideAddPageType guideAddPageType) {
		this.guideAddPageType = guideAddPageType;
	}

}