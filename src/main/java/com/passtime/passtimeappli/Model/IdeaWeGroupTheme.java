package com.passtime.passtimeappli.Model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the idea_we_group_theme database table.
 * 
 */
@Entity
@Table(name="idea_we_group_theme")
@NamedQuery(name="IdeaWeGroupTheme.findAll", query="SELECT i FROM IdeaWeGroupTheme i")
public class IdeaWeGroupTheme implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_group_theme")
	private int idGroupTheme;

	//bi-directional many-to-one association to IdeaWe
	@Transient
	@ManyToOne
	@JoinColumn(name="id_idea_we")
	private IdeaWe ideaWe;

	//bi-directional many-to-one association to IdeaWeTheme
	@ManyToOne
	@JoinColumn(name="id_theme")
	private IdeaWeTheme ideaWeTheme;

	public IdeaWeGroupTheme() {
	}

	public int getIdGroupTheme() {
		return this.idGroupTheme;
	}

	public void setIdGroupTheme(int idGroupTheme) {
		this.idGroupTheme = idGroupTheme;
	}

	public IdeaWe getIdeaWe() {
		return this.ideaWe;
	}

	public void setIdeaWe(IdeaWe ideaWe) {
		this.ideaWe = ideaWe;
	}

	public IdeaWeTheme getIdeaWeTheme() {
		return this.ideaWeTheme;
	}

	public void setIdeaWeTheme(IdeaWeTheme ideaWeTheme) {
		this.ideaWeTheme = ideaWeTheme;
	}

}