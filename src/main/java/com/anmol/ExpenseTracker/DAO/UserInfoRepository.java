package com.anmol.ExpenseTracker.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.anmol.ExpenseTracker.Entity.UserInfo;
@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo, Long> {

	List<UserInfo> findByEmailAndPassword(String email, String password);

	List<UserInfo> findByEmail(String email);

}
