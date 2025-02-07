package com.TJ7.Model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class AnswerTable {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer ansId;
	
	private String answer;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private QuestionTable question;
	
	
	public AnswerTable() {
		System.out.println("In AnswerTable object");
		
	}


	public Integer getAnsId() {
		return ansId;
	}


	public void setAnsId(Integer ansId) {
		this.ansId = ansId;
	}


	public String getAnswer() {
		return answer;
	}


	public void setAnswer(String answer) {
		this.answer = answer;
	}


	public QuestionTable getQuestion() {
		return question;
	}


	public void setQuestion(QuestionTable question) {
		this.question = question;
	}


	@Override
	public String toString() {
		return "AnswerTable [ansId=" + ansId + ", answer=" + answer + ", question=" + question + "]";
	}
	
	

}
