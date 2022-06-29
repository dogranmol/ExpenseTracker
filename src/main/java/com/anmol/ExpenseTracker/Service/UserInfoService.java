package com.anmol.ExpenseTracker.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anmol.ExpenseTracker.DAO.UserInfoRepository;
import com.anmol.ExpenseTracker.Entity.Response;
import com.anmol.ExpenseTracker.Entity.UserInfo;
@Service
public class UserInfoService {

	@Autowired
	private UserInfoRepository userRepo;
	
	
	public Response register(UserInfo userInfo) {
		// TODO Auto-generated method stub
		Response response = new Response();
		if(userRepo.findByEmail( userInfo.getEmail()).size()==0)
		{
			 userRepo.save(userInfo);
			response.setStatus("no user");
		}
		else 
		{
			response.setStatus("user found");
		}
		
		return response;
	}

	public  UserInfo login(UserInfo userInfo) {
		// TODO Auto-generated method stub
		List<UserInfo> list = userRepo.findByEmailAndPassword( userInfo.getEmail(), userInfo.getPassword());
		if(list.size()==0)
		{
			return new UserInfo();
		}
		else
			return list.get(0);
	}

	public List<UserInfo> loginCred() {
		// TODO Auto-generated method stub
		return userRepo.findAll();
	}

}
