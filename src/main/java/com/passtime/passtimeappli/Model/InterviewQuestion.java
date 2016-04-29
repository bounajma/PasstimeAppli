package com.passtime.passtimeappli.Model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the interview_question database table.
 * 
 */
@Entity
@Table(name="interview_question")
@NamedQuery(name="InterviewQuestion.findAll", query="SELECT i FROM InterviewQuestion i")
public class InterviewQuestion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private int number;

	@Lob
	private String question;

	//bi-directional many-to-one association to InterviewAnswer
	@OneToMany(mappedBy="interviewQuestion")
	private List<InterviewAnswer> interviewAnswers;

	public InterviewQuestion() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumber() {
		return this.number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getQuestion() {
		return this.question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public List<InterviewAnswer> getInterviewAnswers() {
		return this.interviewAnswers;
	}

	public void setInterviewAnswers(List<InterviewAnswer> interviewAnswers) {
		this.interviewAnswers = interviewAnswers;
	}

	public InterviewAnswer addInterviewAnswer(InterviewAnswer interviewAnswer) {
		getInterviewAnswers().add(interviewAnswer);
		interviewAnswer.setInterviewQuestion(this);

		return interviewAnswer;
	}

	public InterviewAnswer removeInterviewAnswer(InterviewAnswer interviewAnswer) {
		getInterviewAnswers().remove(interviewAnswer);
		interviewAnswer.setInterviewQuestion(null);

		return interviewAnswer;
	}

}