package com.selenanguyen.bookclub.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.selenanguyen.bookclub.models.Book;
import com.selenanguyen.bookclub.models.User;
import com.selenanguyen.bookclub.services.BookService;
import com.selenanguyen.bookclub.services.UserService;

@Controller
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@Autowired
	private UserService serv;
	
	// =================== Display =======================
	@GetMapping("/books/new")
	public String newBook(@Valid @ModelAttribute("book") Book book, Model model) {
		model.addAttribute("users", serv.getAll());
		
		return "addBook.jsp";
	}
	
	@GetMapping("/books/{id}/show")
	public String showBook(@PathVariable("id") Long id, Model model) {
		model.addAttribute("book", bookService.getOne(id));
		
		return "showBook.jsp";
	}
	
	@GetMapping("/books/{id}/edit")
	public String editBook(@PathVariable("id") Long id, Model model) {
		model.addAttribute("book", bookService.getOne(id));
		
		return "editBook.jsp";
	}
	
	
	// ================= Action ================
	@PostMapping("/books/create")
	public String createBook(@Valid @ModelAttribute("book") Book book, BindingResult result, Model model, HttpSession session) {
		model.addAttribute("users", serv.getAll());
		if (result.hasErrors()) {
			return "addBook.jsp";
		}else {	
			User user = serv.getOne((Long)session.getAttribute("uuid"));
			book.setUser(user);
			bookService.save(book);
			
			return "redirect:/dashboard";
		}
	}
	
	@RequestMapping(value="/books/{id}/update", method=RequestMethod.PUT)
	public String updateBook(@Valid @ModelAttribute("book") Book book, BindingResult result, HttpSession session) {
		if (result.hasErrors()) {
			return "editBook.jsp";
		}else {
			User user = serv.getOne((Long)session.getAttribute("uuid"));
			book.setUser(user);
			bookService.save(book);
			
			return "redirect:/dashboard";
		}
	}
	
    @DeleteMapping("/books/{id}/delete")
    public String destroy(@PathVariable("id") Long id) {
        bookService.delete(id);
        return "redirect:/dashboard";
    }

}
