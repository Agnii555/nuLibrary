package com.oodProject.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.oodProject.library.pojo.Application;
import com.oodProject.library.pojo.Book;
import com.oodProject.library.pojo.Librarian;
import com.oodProject.library.pojo.Library;
import com.oodProject.library.pojo.Member;

import jakarta.servlet.http.HttpSession;


@Controller
public class LibrarianController {
	
	
	@Autowired
	private final Library libraryService;

    public LibrarianController(Library libraryService) {
        this.libraryService = libraryService;
    }
	
	@GetMapping("/applyLibrarian")
	public String applyLibrarian(Model model) {
		
		
		Application application = new Application();
		
		
		
		model.addAttribute("application", application);
	        return "apply_Librarian";
	}
	
	
	@PostMapping("/applyLibrarian")
    public String createLibrarian(@ModelAttribute("application") Application application, Model model) {
		
		
	    libraryService.addApplication(application);
	    
	   
	    for(Application app: libraryService.getAllApplications()) {
	    	
	    	System.out.println(app.getId());
	    	
	    }
		
		model.addAttribute("message", "Application submitted successfully!");

        return "apply_Librarian";
		
		
	}
	
	
	@PostMapping("/LibrarianLogin") 
	public String loginCheck(@RequestParam String username, @RequestParam String password, Model model, HttpSession session) {
		
		if (libraryService.authenticateLibrarian(username, password)) {
			
			Librarian librarian = libraryService.getLibrarianByusername(username);
			
			session.setAttribute("librarian", librarian);
			
			List<Book> returnRequests = libraryService.getReturnRequests(librarian);			
			List<Book> borrowRequests = libraryService.getBorrowRequests(librarian);
			
		
			model.addAttribute("borrowRequests",borrowRequests);
			model.addAttribute("returnRequests",returnRequests);
			model.addAttribute("librarian",librarian);
			
			return "librarian_home";
			
     	   
     } 
     	
       model.addAttribute("errorMessage", "Invalid credentials");
       return "librarian_login"; 
    
		
	}
	
	
	@PostMapping("/acceptBorrowRequest")
	public String acceptBorrowRequest(@RequestParam("bookId") int bookId, HttpSession session, Model model) {
		
		Book book = libraryService.getBookByid(bookId);
		
		Member member = book.getBorrowedBy();
		
		System.out.println("borrowed by" + member.getFirstName());
		
	
		book.setBorrowed(true);
		
		libraryService.getBorrowedBooks().add(book);
		
		
		member.getBooksBorrowed().add(book);
		
		System.out.println("borrow request size" + member.getBorrowRequests().size());
			
		
		libraryService.deleteBook(member.getBorrowRequests(), bookId);
		
		
		libraryService.deleteBook(libraryService.getAllBooks(), bookId);
		
		
		Librarian librarian = (Librarian) session.getAttribute("librarian");
		
		

		
		System.out.println("librarian" + librarian.getFirstName());
		
		System.out.println("lib borrow request size" + librarian.getBorrowRequests().size());
		
		
		
		libraryService.deleteBook(librarian.getBorrowRequests(), bookId);
		
		model.addAttribute("message", "borrow request accepted");
		
		model.addAttribute("librarian",librarian);
	
		return "librarian_home";
		

	}
	
	
	

}
