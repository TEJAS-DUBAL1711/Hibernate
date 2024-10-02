package com.TJ7.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;

@Entity
public class Employee {
	@Id
	int empId;
	
	String empName;
	@Transient
	String empCity;
	
	float empSal;
	
	public int getEmpId() {
		return empId;
	}
	
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	
	public String getEmpName() {
		return empName;
	}
	
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	
	public String getEmpCity() {
		return empCity;
	}
	

	public void setEmpCity(String empCity) {
		this.empCity = empCity;
	}
	
	public float getEmpSal() {
		return empSal;
	}
	
	public void setEmpSal(float empSal) {
		this.empSal = empSal;
	}
	
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empCity=" + empCity + ", empSal=" + empSal
				+ "]";
	}
	

}
