package com.passtime.passtimeappli.Model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the guide_add_page_type database table.
 * 
 */
@Entity
@Table(name="guide_add_page_type")
@NamedQuery(name="GuideAddPageType.findAll", query="SELECT g FROM GuideAddPageType g")
public class GuideAddPageType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String name;

	//bi-directional many-to-one association to GuideAddPage
	@OneToMany(mappedBy="guideAddPageType")
	private List<GuideAddPage> guideAddPages;

	public GuideAddPageType() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<GuideAddPage> getGuideAddPages() {
		return this.guideAddPages;
	}

	public void setGuideAddPages(List<GuideAddPage> guideAddPages) {
		this.guideAddPages = guideAddPages;
	}

	public GuideAddPage addGuideAddPage(GuideAddPage guideAddPage) {
		getGuideAddPages().add(guideAddPage);
		guideAddPage.setGuideAddPageType(this);

		return guideAddPage;
	}

	public GuideAddPage removeGuideAddPage(GuideAddPage guideAddPage) {
		getGuideAddPages().remove(guideAddPage);
		guideAddPage.setGuideAddPageType(null);

		return guideAddPage;
	}

}