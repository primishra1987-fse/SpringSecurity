package com.example.springmvcboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springmvcboot.entity.Authorities;


public interface AuthorityDao extends JpaRepository<Authorities, String>{

}
