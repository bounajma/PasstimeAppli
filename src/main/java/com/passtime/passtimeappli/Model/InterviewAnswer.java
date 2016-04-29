package com.passtime.passtimeappli.Model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the interview_answer database table.
 * 
 */
@Entity
@Table(name="interview_answer")
@NamedQuery(name="InterviewAnswer.findAll", query="SELECT i FROM InterviewAnswer i")
public class InterviewAnswer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Lob
	private String answer;

	@Temporal(TemporalType.DATE)
	private Date date;

	//bi-directional many-to-one association to FranchiseSpace
	@ManyToOne
	@JoinColumn(name="id_franchise_space")
	private FranchiseSpace franchiseSpace;

	//bi-directional many-to-one association to InterviewQuestion
	@ManyToOne
	@JoinColumn(name="id_interview_question")
	private InterviewQuestion interviewQuestion;

	public InterviewAnswer() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAnswer() {
		return this.answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public FranchiseSpace getFranchiseSpace() {
		return this.franchiseSpace;
	}

	public void setFranchiseSpace(FranchiseSpace franchiseSpace) {
		this.franchiseSpace = franchiseSpace;
	}

	public InterviewQuestion getInterviewQuestion() {
		return this.interviewQuestion;
	}

	public void setInterviewQuestion(InterviewQuestion interviewQuestion) {
		this.interviewQuestion = interviewQuestion;
	}

}