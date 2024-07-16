package com.jsp.demo.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.demo.config.EmailSender1;
import com.jsp.demo.dto.User;
import com.jsp.demo.repo.UserRepo;

@Repository
public class UserCrud{
	@Autowired
	private UserRepo repo;
	
	@Autowired
	 EmailSender1 sender;
	
	public User saveUser(User user) {
		return repo.save(user);
	}
	
	public User loginUser(String email,String pwd) {
		User db = repo.findByEmail(email);
		if(db!=null) {
			if(db.getPwd().equals(pwd)) {
				sender.msgSend(email);
				return fetchUser(db.getId());
			}
			else {
				return null;
			}
		}
		else {
			return null;
		}
	}
	
	public User update(User user) {
		 User db = repo.findById(user.getId()).get();
		if(db!=null) {
			if(db.getName()!=null) {
				db.setName(user.getName());
			}
			if(db.getEmail()!=null) {
				db.setEmail(user.getEmail());
			}
			if(db.getPwd()!=null) {
				db.setPwd(user.getPwd());
			}
			if(db.getSal()!=0) {
				db.setPwd(user.getPwd());
			}
			return repo.save(db);
		}
		else {
			return null;
		}
	}
	
	public User fetchUser(int id) {
		Optional<User> db = repo.findById(id);
		if(db.isPresent()) {
			return repo.findById(id).get();
		}
		else {
			return null;
		}
	}
	
	public List<User> fetch(){
		 List<User> sal = repo.findAll();
		 List<User> li=new ArrayList<User>();		 
		 for(int i=0;i<sal.size();i++) {
			 User u=sal.get(i);
			 double mon = u.getSal();
			 if(mon>24000) {
				 li.add(u);
			 }
		 }
		 return li;
	}
	
}
