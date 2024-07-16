package com.jsp.demo.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	@Column(unique = true)
	private String email;
	private String pwd;
	private double sal;
	@Override
	public String toString() {
		return "/nUser [id=" + id + ", name=" + name + ", email=" + email + ", pwd=" + pwd + ", sal=" + sal + "]";
	}
	
}
