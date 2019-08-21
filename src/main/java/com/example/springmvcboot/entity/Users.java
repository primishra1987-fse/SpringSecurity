package com.example.springmvcboot.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Repository;

@Repository
@Entity
@Table(name="users")
public class Users {


	
	@Column(name = "username")
	private String userName;
	
	@Id
	@Column(name = "user_id")
	private int userID;
	
	@Column(name = "password")
	private String password;
	
	
	@Column (name="role")
	private String role;
	


	@OneToMany(cascade = CascadeType.ALL, orphanRemoval= true, mappedBy="userID" , fetch=FetchType.EAGER)
	private Set<Authorities> references =new HashSet<Authorities>();

	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Set<Authorities> getReferences() {
		return references;
	}

	public void setReferences(Set<Authorities> references) {
		this.references = references;
	}

			
}
