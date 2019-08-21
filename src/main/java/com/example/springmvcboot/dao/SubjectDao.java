package com.example.springmvcboot.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.springmvcboot.entity.Subject;

public interface SubjectDao extends JpaRepository<Subject, Long>{

	
		@Modifying
	    @Transactional
	    @Query("delete from Subject u where subject_id = ?1")
	    void deleteSubjectByID(long id);

	 
}
