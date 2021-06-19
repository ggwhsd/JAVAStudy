package com.studyspringcloud.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="person")
public class Person {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Column
	private String username;
	
	@Column
	private String name;
	@Column
	private Integer age;
	@Column
	private BigDecimal balance;
	
	public BigDecimal getBalance() {
		return balance;
	}
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}

	private Long getId() {
		return id;
	}
	public void setId(Long id){
		this.id = id;
	}
	
	public String toString()
	{
		
		String ps = "Person:"+"id:"+ getId() + ",username:"+getName() + ",age:"+ getAge() + ",balance:"+ getBalance()+".";
		return ps;
	}
}
