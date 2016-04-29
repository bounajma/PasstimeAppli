package com.passtime.passtimeappli.Model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the code_card_letter database table.
 * 
 */
@Entity
@Table(name="code_card_letter")
@NamedQuery(name="CodeCardLetter.findAll", query="SELECT c FROM CodeCardLetter c")
public class CodeCardLetter implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String letter;

	private String year;

	public CodeCardLetter() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLetter() {
		return this.letter;
	}

	public void setLetter(String letter) {
		this.letter = letter;
	}

	public String getYear() {
		return this.year;
	}

	public void setYear(String year) {
		this.year = year;
	}

}