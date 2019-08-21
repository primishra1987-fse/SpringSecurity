package com.example.springmvcboot.dao;
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.springmvcboot.entity.Books;

public interface BooksDao extends JpaRepository<Books, Long>{
	
	    @Modifying
	    @Transactional
	    @Query("delete from Books u where u.bookId = ?1")
	    void deleteBookByID(long id);
	    
	    @Modifying
	    @Transactional
	    @Query("delete from Books u where u.subjectID = ?1")
	    void deleteBookBySubjectID(long id);

}
