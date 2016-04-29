package com.passtime.passtimeappli.Model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the idea_we_testimonial database table.
 * 
 */
@Entity
@Table(name="idea_we_testimonial")
@NamedQuery(name="IdeaWeTestimonial.findAll", query="SELECT i FROM IdeaWeTestimonial i")
public class IdeaWeTestimonial implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Lob
	private String description;

	//bi-directional many-to-one association to FranchiseSpace
	@ManyToOne
	@JoinColumn(name="id_franchise_space")
	private FranchiseSpace franchiseSpace;

	//bi-directional many-to-one association to IdeaWeTheme
	@ManyToOne
	@JoinColumn(name="id_idea_we_theme")
	private IdeaWeTheme ideaWeTheme;

	public IdeaWeTestimonial() {
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

	public FranchiseSpace getFranchiseSpace() {
		return this.franchiseSpace;
	}

	public void setFranchiseSpace(FranchiseSpace franchiseSpace) {
		this.franchiseSpace = franchiseSpace;
	}

	public IdeaWeTheme getIdeaWeTheme() {
		return this.ideaWeTheme;
	}

	public void setIdeaWeTheme(IdeaWeTheme ideaWeTheme) {
		this.ideaWeTheme = ideaWeTheme;
	}

}