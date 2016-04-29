package com.passtime.passtimeappli.Model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the question database table.
 * 
 */
@Entity
@NamedQuery(name="Question.findAll", query="SELECT q FROM Question q")
public class Question implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Lob
	@Column(name="content_answer")
	private String contentAnswer;

	@Lob
	@Column(name="content_question")
	private String contentQuestion;

	@Temporal(TemporalType.DATE)
	@Column(name="date_answer")
	private Date dateAnswer;

	@Temporal(TemporalType.DATE)
	@Column(name="date_question")
	private Date dateQuestion;

	@Column(name="id_franchise_space")
	private int idFranchiseSpace;

	@Column(name="id_question_type")
	private int idQuestionType;

	@Column(name="public")
	private byte public_;

	private byte valid;

	public Question() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContentAnswer() {
		return this.contentAnswer;
	}

	public void setContentAnswer(String contentAnswer) {
		this.contentAnswer = contentAnswer;
	}

	public String getContentQuestion() {
		return this.contentQuestion;
	}

	public void setContentQuestion(String contentQuestion) {
		this.contentQuestion = contentQuestion;
	}

	public Date getDateAnswer() {
		return this.dateAnswer;
	}

	public void setDateAnswer(Date dateAnswer) {
		this.dateAnswer = dateAnswer;
	}

	public Date getDateQuestion() {
		return this.dateQuestion;
	}

	public void setDateQuestion(Date dateQuestion) {
		this.dateQuestion = dateQuestion;
	}

	public int getIdFranchiseSpace() {
		return this.idFranchiseSpace;
	}

	public void setIdFranchiseSpace(int idFranchiseSpace) {
		this.idFranchiseSpace = idFranchiseSpace;
	}

	public int getIdQuestionType() {
		return this.idQuestionType;
	}

	public void setIdQuestionType(int idQuestionType) {
		this.idQuestionType = idQuestionType;
	}

	public byte getPublic_() {
		return this.public_;
	}

	public void setPublic_(byte public_) {
		this.public_ = public_;
	}

	public byte getValid() {
		return this.valid;
	}

	public void setValid(byte valid) {
		this.valid = valid;
	}

}