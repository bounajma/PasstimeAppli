package com.passtime.passtimeappli.Model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the idea_we_step database table.
 * 
 */
@Entity
@Table(name="idea_we_step")
@NamedQuery(name="IdeaWeStep.findAll", query="SELECT i FROM IdeaWeStep i")
public class IdeaWeStep implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_step")
	private int idStep;

	private int number;

	@Column(name="partners_list")
	private String partnersList;

	private String type;

	//bi-directional many-to-one association to IdeaWe
	@Transient
	@ManyToOne
	@JoinColumn(name="id_idea_we")
	private IdeaWe ideaWe;

	public IdeaWeStep() {
	}

	public int getIdStep() {
		return this.idStep;
	}

	public void setIdStep(int idStep) {
		this.idStep = idStep;
	}

	public int getNumber() {
		return this.number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getPartnersList() {
		return this.partnersList;
	}

	public void setPartnersList(String partnersList) {
		this.partnersList = partnersList;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public IdeaWe getIdeaWe() {
		return this.ideaWe;
	}

	public void setIdeaWe(IdeaWe ideaWe) {
		this.ideaWe = ideaWe;
	}

}