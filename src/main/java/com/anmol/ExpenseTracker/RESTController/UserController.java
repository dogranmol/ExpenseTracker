package com.anmol.ExpenseTracker.RESTController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.anmol.ExpenseTracker.Entity.Response;
import com.anmol.ExpenseTracker.Entity.UserInfo;
import com.anmol.ExpenseTracker.Service.UserInfoService;

@RestController
public class UserController {

	@Autowired
	private UserInfoService userService;
	
	
	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/register1")
	public Response registerUser(@RequestBody UserInfo userInfo) {
		
		return userService.register(userInfo);
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/login1")
	public UserInfo loginUser(@RequestBody UserInfo userInfo) {
		
		return userService.login(userInfo);
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/login1")
	public List<UserInfo> loginUser() {
		
		return userService.loginCred();
	}
	
}
