package com.passtime.passtimeappli.Model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the web_advantage database table.
 * 
 */
@Entity
@Table(name="web_advantage")
@NamedQuery(name="WebAdvantage.findAll", query="SELECT w FROM WebAdvantage w")
public class WebAdvantage implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String color;

	@Lob
	private String description;

	private String logo;

	private String name;

	@Column(name="photo_16_9")
	private String photo169;

	@Column(name="photo_4_3")
	private String photo43;

	private int position;

	private String shape;

	@Lob
	@Column(name="text_left")
	private String textLeft;

	@Lob
	@Column(name="text_right")
	private String textRight;

	@Column(name="title_description")
	private String titleDescription;

	private byte valid;

	public WebAdvantage() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getColor() {
		return this.color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLogo() {
		return this.logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoto169() {
		return this.photo169;
	}

	public void setPhoto169(String photo169) {
		this.photo169 = photo169;
	}

	public String getPhoto43() {
		return this.photo43;
	}

	public void setPhoto43(String photo43) {
		this.photo43 = photo43;
	}

	public int getPosition() {
		return this.position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public String getShape() {
		return this.shape;
	}

	public void setShape(String shape) {
		this.shape = shape;
	}

	public String getTextLeft() {
		return this.textLeft;
	}

	public void setTextLeft(String textLeft) {
		this.textLeft = textLeft;
	}

	public String getTextRight() {
		return this.textRight;
	}

	public void setTextRight(String textRight) {
		this.textRight = textRight;
	}

	public String getTitleDescription() {
		return this.titleDescription;
	}

	public void setTitleDescription(String titleDescription) {
		this.titleDescription = titleDescription;
	}

	public byte getValid() {
		return this.valid;
	}

	public void setValid(byte valid) {
		this.valid = valid;
	}

}