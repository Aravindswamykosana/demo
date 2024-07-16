package com.jsp.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jsp.demo.dto.User;

public interface UserRepo extends JpaRepository<User, Integer>  {
	
	public abstract User findByEmail(String email);
}
