package com.anmol.ExpenseTracker.Service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anmol.ExpenseTracker.DAO.ExpenseInfoRepository;
import com.anmol.ExpenseTracker.Entity.CategoryResponse;
import com.anmol.ExpenseTracker.Entity.ExpenseInfo;

@Service
public class ExpenseInfoService {

	@Autowired
	private ExpenseInfoRepository expenseRepo;

	public List<ExpenseInfo> getAllExpenses(String token, String sortBy, String sortType) {
		// TODO Auto-generated method stub
		if(sortType.equalsIgnoreCase("asc"))
		{
			if(sortBy.equalsIgnoreCase("amount"))
			{
				return expenseRepo.findByTokenOrderByAmountAsc(token);
			}
			else
			{
				return expenseRepo.findByTokenOrderByDateAsc(token);
			}
		}
		else
		{
			if(sortBy.equalsIgnoreCase("amount"))
			{
				return expenseRepo.findByTokenOrderByAmountDesc(token);
			}
			else
			{
				return expenseRepo.findByTokenOrderByDateDesc(token);
			}
		}
		
	}

	public ExpenseInfo save(ExpenseInfo expense) {
		return expenseRepo.save(expense);

	}

	public void delete(ExpenseInfo expense) {

		 expenseRepo.delete(expense);
		
	}

	public List<CategoryResponse> getByCategory(String token) {
		
		return expenseRepo.getByCategory(token);
	}


	public List<ExpenseInfo> getSpecific(String token, Date start, Date end) {
		// TODO Auto-generated method stub
		 return expenseRepo.getSpecific(token,start,end);
	}

}
