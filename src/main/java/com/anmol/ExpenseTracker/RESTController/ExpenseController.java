package com.anmol.ExpenseTracker.RESTController;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.anmol.ExpenseTracker.Entity.CategoryResponse;
import com.anmol.ExpenseTracker.Entity.ExpenseInfo;
import com.anmol.ExpenseTracker.Service.EmailService;
import com.anmol.ExpenseTracker.Service.ExpenseInfoService;

@RestController
public class ExpenseController {

	@Autowired
	private ExpenseInfoService expenseService;
	
	@Autowired
	private EmailService emailService;
	
	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/getExpenses")
	public List<ExpenseInfo> findAllExpenseInfo(@RequestBody Pair pair ) {
		//System.out.println(pair.toString());
		
		return expenseService.getAllExpenses(pair.getToken(),pair.getSortBy(),pair.getSortType());
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/getByCategory")
	public List<CategoryResponse> eachCategory(@RequestBody Pair pair ) {
		//System.out.println(pair.toString());
		
		return expenseService.getByCategory(pair.getToken());
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/specific")
	public List<ExpenseInfo> specificExpenses(@RequestBody Pair2 pair ) {
		//System.out.println(pair.toString());
		
		return expenseService.getSpecific(pair.getToken(),pair.getStart(),pair.getEnd());
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/saveExpense")
	public ExpenseInfo saveExpense(@RequestBody ExpenseInfo expense) {
		
		return expenseService.save(expense);
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/deleteExpense")
	public ExpenseInfo deleteExpense(@RequestBody ExpenseInfo expense) {
		
		 expenseService.delete(expense);
		 return expense;
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/mail")
	public void mailExpense() {
		
		emailService.sendMail("anmoldogra52362@gmail.com", "Test Subject", "details");
	}
	
}

class Pair{
	String token;
	String sortBy;
	String sortType;
	
	
	@Override
	public String toString() {
		return "Pair [token=" + token + ", sortBy=" + sortBy + ", sortType=" + sortType + "]";
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getSortBy() {
		return sortBy;
	}
	public void setSortBy(String sortBy) {
		this.sortBy = sortBy;
	}
	public String getSortType() {
		return sortType;
	}
	public void setSortType(String sortType) {
		this.sortType = sortType;
	}
	
	
	
	
}

class Pair2{
	String token;
	Date start;
	Date end;
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public Date getStart() {
		return start;
	}
	public void setStart(Date start) {
		this.start = start;
	}
	public Date getEnd() {
		return end;
	}
	public void setEnd(Date end) {
		this.end = end;
	}
	
	
	
	
}
