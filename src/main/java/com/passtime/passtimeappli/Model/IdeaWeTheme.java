package com.passtime.passtimeappli.Model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the idea_we_theme database table.
 * 
 */
@Entity
@Table(name="idea_we_theme")
@NamedQuery(name="IdeaWeTheme.findAll", query="SELECT i FROM IdeaWeTheme i")
public class IdeaWeTheme implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_theme")
	private int idTheme;

	@Lob
	private String description;

	private String name;

	//bi-directional many-to-one association to IdeaWeGroupTheme
	@OneToMany(mappedBy="ideaWeTheme")
	private List<IdeaWeGroupTheme> ideaWeGroupThemes;

	//bi-directional many-to-one association to IdeaWeTestimonial
	@OneToMany(mappedBy="ideaWeTheme")
	private List<IdeaWeTestimonial> ideaWeTestimonials;

	public IdeaWeTheme() {
	}

	public int getIdTheme() {
		return this.idTheme;
	}

	public void setIdTheme(int idTheme) {
		this.idTheme = idTheme;
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

	public List<IdeaWeGroupTheme> getIdeaWeGroupThemes() {
		return this.ideaWeGroupThemes;
	}

	public void setIdeaWeGroupThemes(List<IdeaWeGroupTheme> ideaWeGroupThemes) {
		this.ideaWeGroupThemes = ideaWeGroupThemes;
	}

	public IdeaWeGroupTheme addIdeaWeGroupTheme(IdeaWeGroupTheme ideaWeGroupTheme) {
		getIdeaWeGroupThemes().add(ideaWeGroupTheme);
		ideaWeGroupTheme.setIdeaWeTheme(this);

		return ideaWeGroupTheme;
	}

	public IdeaWeGroupTheme removeIdeaWeGroupTheme(IdeaWeGroupTheme ideaWeGroupTheme) {
		getIdeaWeGroupThemes().remove(ideaWeGroupTheme);
		ideaWeGroupTheme.setIdeaWeTheme(null);

		return ideaWeGroupTheme;
	}

	public List<IdeaWeTestimonial> getIdeaWeTestimonials() {
		return this.ideaWeTestimonials;
	}

	public void setIdeaWeTestimonials(List<IdeaWeTestimonial> ideaWeTestimonials) {
		this.ideaWeTestimonials = ideaWeTestimonials;
	}

	public IdeaWeTestimonial addIdeaWeTestimonial(IdeaWeTestimonial ideaWeTestimonial) {
		getIdeaWeTestimonials().add(ideaWeTestimonial);
		ideaWeTestimonial.setIdeaWeTheme(this);

		return ideaWeTestimonial;
	}

	public IdeaWeTestimonial removeIdeaWeTestimonial(IdeaWeTestimonial ideaWeTestimonial) {
		getIdeaWeTestimonials().remove(ideaWeTestimonial);
		ideaWeTestimonial.setIdeaWeTheme(null);

		return ideaWeTestimonial;
	}

}