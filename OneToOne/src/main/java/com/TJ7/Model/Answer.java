package com.TJ7.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Answer {
	
	@Id
	private Integer ansId;
	private String answer;
	
	public Answer() {
		
		System.out.println("Answer object is created");
		
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

	@Override
	public String toString() {
		return "Answer [ansId=" + ansId + ", answer=" + answer + "]";
	}
	
	

}
