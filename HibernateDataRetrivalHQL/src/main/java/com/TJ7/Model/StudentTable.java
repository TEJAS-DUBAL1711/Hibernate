package com.TJ7.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class StudentTable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int sId;
	@Column(name="StudentName")
	private String sName;
	@Column(name="StudentCity")
	private String sCity;
	
	public StudentTable(String sName, String sCity) {
		super();
		this.sName = sName;
		this.sCity = sCity;
	}

	public StudentTable() {
	
	}

	public int getsId() {
		return sId;
	}

	public void setsId(int sId) {
		this.sId = sId;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public String getsCity() {
		return sCity;
	}

	public void setsCity(String sCity) {
		this.sCity = sCity;
	}

	@Override
	public String toString() {
		return "StudentTable [sId=" + sId + ", sName=" + sName + ", sCity=" + sCity + "]";
	}
	
	
	


}
