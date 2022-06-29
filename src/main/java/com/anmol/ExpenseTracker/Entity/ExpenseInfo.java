package com.anmol.ExpenseTracker.Entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "expenseinfo")
public class ExpenseInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "category")
	private String category;
	
	@Column(name = "amount")
	private Long amount;
	
	@Column(name = "date")
	private Date date;

	@Lob
	@Column(name = "details", columnDefinition = "MEDIUMBLOB")
	private String details;
	
	@Column(name = "token")
	private String token;
	
	

	public ExpenseInfo() {
	}


	public ExpenseInfo(String category, Long amount, Date date, String details, String token) {
		this.category = category;
		this.amount = amount;
		this.date = date;
		this.details = details;
		this.token = token;
	}
	
	

	public ExpenseInfo(int id, String category, Long amount, java.util.Date date, String details, String token) {
		
		this.id = id;
		this.category = category;
		this.amount = amount;
		this.date = (Date) date;
		this.details = details;
		this.token = token;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
	
	
	
}
