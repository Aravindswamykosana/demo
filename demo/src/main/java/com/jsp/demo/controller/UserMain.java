package com.jsp.demo.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.demo.dao.UserCrud;
import com.jsp.demo.dto.User;

@RestController
public class UserMain {
	@Autowired
	private UserCrud crud;
	
	@PostMapping("/save")
	public User save(@RequestBody User user) {
		return crud.saveUser(user);
	}
	
	@GetMapping("/loginuser")
	public User loginUser(@RequestParam String email,@RequestParam String pwd) {
		return crud.loginUser(email,pwd);
	}
	
	@PostMapping("/update")
	public User updateUser(@RequestBody User user) {
		return crud.saveUser(user);
	}
	
	@GetMapping("/fetch")
	public User fetchUser(@RequestParam int id) {
		return crud.fetchUser(id);
	}
	
	@PostMapping("/fetchall")
	public List<User> fetch(){
		return crud.fetch();
	}
}
