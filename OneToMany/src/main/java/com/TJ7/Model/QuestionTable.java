package com.TJ7.Model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class QuestionTable {
	
	@Id
	private Integer id;
	
	private String question;
	
	@OneToMany(cascade=CascadeType.ALL)
	private List<AnswerTable> answersList;
	
	
	public QuestionTable() {
		
		System.out.println("QuestionTable object is created");


	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getQuestion() {
		return question;
	}


	public void setQuestion(String question) {
		this.question = question;
	}


	public List<AnswerTable> getAnswers() {
		return answersList;
	}


	public void setAnswers(List<AnswerTable> answers) {
		this.answersList = answers;
	}


	@Override
	public String toString() {
		return "QuestionTable [id=" + id + ", question=" + question + ", answers=" + answersList+ "]";
	}
	

}
