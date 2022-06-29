package com.anmol.ExpenseTracker.DAO;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.anmol.ExpenseTracker.Entity.CategoryResponse;
import com.anmol.ExpenseTracker.Entity.ExpenseInfo;

@Repository
public interface ExpenseInfoRepository extends JpaRepository<ExpenseInfo, Long> {
	
	List<ExpenseInfo> findByToken(String token);

	List<ExpenseInfo> findByTokenOrderByAmountAsc(String token);
	List<ExpenseInfo> findByTokenOrderByAmountDesc(String token);
	List<ExpenseInfo> findByTokenOrderByDateAsc(String token);
	List<ExpenseInfo> findByTokenOrderByDateDesc(String token);
	
	@Query(value="select new com.anmol.ExpenseTracker.Entity.CategoryResponse(e.category,sum(e.amount)) from ExpenseInfo e where e.token=?1 group By e.category")
	List<CategoryResponse> getByCategory(String token);
	
	@Query(value="select new ExpenseInfo(e.id,e.category,e.amount,e.date,e.details,e.token) from ExpenseInfo e where e.token=?1 and e.date between ?2 and ?3 order by e.date")
	List<ExpenseInfo> getSpecific(String token, Date start, Date end);

}
