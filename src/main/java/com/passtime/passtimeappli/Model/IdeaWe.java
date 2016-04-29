package com.passtime.passtimeappli.Model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The persistent class for the idea_we database table.
 * 
 */
@Entity
@Table(name="idea_we")
@NamedQuery(name="IdeaWe.findAll", query="SELECT i FROM IdeaWe i")
public class IdeaWe implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_idea_we")
	private int idIdeaWe;

	private int active;

	@Column(name="date_creation")
	private String dateCreation;

	@Lob
	private String description;

	private String name;

	//bi-directional many-to-one association to FranchiseSpace
	@Transient
	@ManyToOne
	@JoinColumn(name="id_franchise_space")
	private FranchiseSpace franchiseSpace;

	//bi-directional many-to-one association to Partner
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="id_partner_ref")
	private Partner partner;

	//bi-directional many-to-one association to IdeaWeGroupTheme
	@Transient
	@OneToMany(mappedBy="ideaWe")
	private List<IdeaWeGroupTheme> ideaWeGroupThemes;

	//bi-directional many-to-one association to IdeaWeSaved
	@Transient
	@OneToMany(mappedBy="ideaWe")
	private List<IdeaWeSaved> ideaWeSaveds;

	//bi-directional many-to-one association to IdeaWeStep
	@Transient
	@OneToMany(mappedBy="ideaWe")
	private List<IdeaWeStep> ideaWeSteps;

	public IdeaWe() {
	}

	public int getIdIdeaWe() {
		return this.idIdeaWe;
	}

	public void setIdIdeaWe(int idIdeaWe) {
		this.idIdeaWe = idIdeaWe;
	}

	public int getActive() {
		return this.active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public String getDateCreation() {
		return this.dateCreation;
	}

	public void setDateCreation(String dateCreation) {
		this.dateCreation = dateCreation;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public FranchiseSpace getFranchiseSpace() {
		return this.franchiseSpace;
	}

	public void setFranchiseSpace(FranchiseSpace franchiseSpace) {
		this.franchiseSpace = franchiseSpace;
	}

	public Partner getPartner() {
		return this.partner;
	}

	public void setPartner(Partner partner) {
		this.partner = partner;
	}

	public List<IdeaWeGroupTheme> getIdeaWeGroupThemes() {
		return this.ideaWeGroupThemes;
	}

	public void setIdeaWeGroupThemes(List<IdeaWeGroupTheme> ideaWeGroupThemes) {
		this.ideaWeGroupThemes = ideaWeGroupThemes;
	}

	public IdeaWeGroupTheme addIdeaWeGroupTheme(IdeaWeGroupTheme ideaWeGroupTheme) {
		getIdeaWeGroupThemes().add(ideaWeGroupTheme);
		ideaWeGroupTheme.setIdeaWe(this);

		return ideaWeGroupTheme;
	}

	public IdeaWeGroupTheme removeIdeaWeGroupTheme(IdeaWeGroupTheme ideaWeGroupTheme) {
		getIdeaWeGroupThemes().remove(ideaWeGroupTheme);
		ideaWeGroupTheme.setIdeaWe(null);

		return ideaWeGroupTheme;
	}

	public List<IdeaWeSaved> getIdeaWeSaveds() {
		return this.ideaWeSaveds;
	}

	public void setIdeaWeSaveds(List<IdeaWeSaved> ideaWeSaveds) {
		this.ideaWeSaveds = ideaWeSaveds;
	}

	public IdeaWeSaved addIdeaWeSaved(IdeaWeSaved ideaWeSaved) {
		getIdeaWeSaveds().add(ideaWeSaved);
		ideaWeSaved.setIdeaWe(this);

		return ideaWeSaved;
	}

	public IdeaWeSaved removeIdeaWeSaved(IdeaWeSaved ideaWeSaved) {
		getIdeaWeSaveds().remove(ideaWeSaved);
		ideaWeSaved.setIdeaWe(null);

		return ideaWeSaved;
	}

	public List<IdeaWeStep> getIdeaWeSteps() {
		return this.ideaWeSteps;
	}

	public void setIdeaWeSteps(List<IdeaWeStep> ideaWeSteps) {
		this.ideaWeSteps = ideaWeSteps;
	}

	public IdeaWeStep addIdeaWeStep(IdeaWeStep ideaWeStep) {
		getIdeaWeSteps().add(ideaWeStep);
		ideaWeStep.setIdeaWe(this);

		return ideaWeStep;
	}

	public IdeaWeStep removeIdeaWeStep(IdeaWeStep ideaWeStep) {
		getIdeaWeSteps().remove(ideaWeStep);
		ideaWeStep.setIdeaWe(null);

		return ideaWeStep;
	}

}