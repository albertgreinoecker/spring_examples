package org.htl.springweb.demo.demo;

public class Book {
	private String isbn;
	private String author;
	private String title;
	public Book() {
	}
	public Book(String isbn, String author, String title) {
		this.isbn = isbn;
		this.author = author;
		this.title = title;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	@Override
	public String toString() {
		return "Book [isbn=" + isbn + ", author=" + author + ", title=" + title + "]";
	}

	
	@Override
	public boolean equals(Object obj) {
		Book b = (Book)obj;
		return isbn!= null && isbn.equals(b.getIsbn());
	}
	
	
}
