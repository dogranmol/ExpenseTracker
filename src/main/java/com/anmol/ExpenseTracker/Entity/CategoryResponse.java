package com.anmol.ExpenseTracker.Entity;


public class CategoryResponse {
	
	private String category;
	
	private Long amount;

	
	
	public CategoryResponse(String category, Long amount) {
		super();
		this.category = category;
		this.amount = amount;
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
	
	

}
