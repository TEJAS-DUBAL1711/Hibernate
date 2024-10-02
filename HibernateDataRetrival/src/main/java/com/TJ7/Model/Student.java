package com.TJ7.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Student") //optional if not mention then also creates the table same as class name
public class Student {
	
	
	Student(){
		System.out.println("object is created");
	}
	
	@Id  //primary key
	@Column(name="SID") // it also not need to mention it takes variable name as column name
	private int sid;

	@Column(name="SName")
	private String sName;
	
	@Column(name="SCITY")
	private String sCity;

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
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
		return "Student [sid=" + sid + ", sName=" + sName + ", sCity=" + sCity + "]";
	}
	
	

}
