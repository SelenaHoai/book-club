package com.selenanguyen.bookclub.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.selenanguyen.bookclub.models.Book;
import com.selenanguyen.bookclub.repos.BookRepo;


@Service
public class BookService {
	
	@Autowired
	private BookRepo bookRepo;
	
	// =========== Create/Update ================
	public Book save(Book s) {
		return bookRepo.save(s);
	}
	
	// =========== Read ====================
	public List<Book> getAll(){
		return bookRepo.findAll();
	}
	
	public Book getOne(Long id) {
		Optional<Book> s = bookRepo.findById(id);
		
		if (s.isPresent()) {
			return s.get();
		}else {
			return null;
		}
	}
	
	// =============== Delete =================
	public void delete(Long id) {
		bookRepo.deleteById(id);
	}

}
