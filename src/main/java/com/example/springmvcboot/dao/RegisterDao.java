package com.example.springmvcboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.springmvcboot.entity.Users;

public interface RegisterDao extends JpaRepository<Users, String>{ 
	
	
}
