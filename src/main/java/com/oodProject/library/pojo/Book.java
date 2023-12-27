package com.oodProject.library.pojo;

import java.util.Date;

public class Book {
	
	 private int bookId;
	 private String title;
	 private String author;
	 private String genre;
	 private String language;
	 
	 private boolean isBorrowed;
	 private Date borrowedDate;
	 private Member borrowedBy;
	 
	 
	 
	 
	 public Book(int bookId, String title, String author, String genre, String language) {
		 
		 this.bookId = bookId;
		 this.title = title;
		 this.author = author;
		 this.genre = genre;
		 this.language = language;
		 this.isBorrowed = false;
		 this.borrowedDate = null;
		 this.borrowedBy = null;
		 
	 }




	public int getBookId() {
		return bookId;
	}




	public void setBookId(int bookId) {
		this.bookId = bookId;
	}




	public String getTitle() {
		return title;
	}




	public void setTitle(String title) {
		this.title = title;
	}




	public String getAuthor() {
		return author;
	}




	public void setAuthor(String author) {
		this.author = author;
	}




	public String getGenre() {
		return genre;
	}




	public void setGenre(String genre) {
		this.genre = genre;
	}




	public String getLanguage() {
		return language;
	}




	public void setLanguage(String language) {
		this.language = language;
	}




	public boolean isBorrowed() {
		return isBorrowed;
	}




	public void setBorrowed(boolean isBorrowed) {
		this.isBorrowed = isBorrowed;
	}




	public Date getBorrowedDate() {
		return borrowedDate;
	}




	public void setBorrowedDate(Date borrowedDate) {
		this.borrowedDate = borrowedDate;
	}




	public Member getBorrowedBy() {
		return borrowedBy;
	}




	public void setBorrowedBy(Member borrowedBy) {
		this.borrowedBy = borrowedBy;
	}
	
}


  


