package com.example.springmvcboot.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.springmvcboot.dao.BooksDao;
import com.example.springmvcboot.entity.Books;

@Controller
@RequestMapping("/bookDetails")
public class BookController {
	
	
	
	@Autowired
	private BooksDao booksDao;
	
	@RequestMapping("/bookList")
	public String getBooksDetails(ModelMap model){
		List <Books>booksList=booksDao.findAll();
		model.addAttribute("bookList",booksList);
		return "bookDetails";
	}
	
		
	@RequestMapping("/book")
	public String getBookDetailsById(@RequestParam long id, Model model){
		System.out.println(id);
		Optional<Books> book=booksDao.findById(id);
		model.addAttribute("book",book.get());
		return "bookView";
	}
	
	@RequestMapping("/deleteBook")
	public String deleteBookById(@RequestParam long id, Model model){
		System.out.println("Deleting id:"+ id);
		booksDao.deleteBookByID(id);
		
		return "successResponse";
	}

}
