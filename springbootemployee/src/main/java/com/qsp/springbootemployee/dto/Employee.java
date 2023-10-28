package com.qsp.springbootemployee.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//import lombok.Data;
//import lombok.Getter;
//import lombok.Setter;

@Entity
//@Data - To Generate all the necessary details
//@Getter - To generate getters only
//@Setter - To generate setters only
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	@Column(unique = true)
	private long phone;
	private String address;
	@Column(unique = true)
	private String email;
	private double salary;
	private char grade;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public char getGrade() {
		return grade;
	}
	public void setGrade(char grade) {
		this.grade = grade;
	}
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", phone=" + phone + ", address=" + address + ", email="
				+ email + ", salary=" + salary + "]";
	}
	
	
	
	
	
	
}
