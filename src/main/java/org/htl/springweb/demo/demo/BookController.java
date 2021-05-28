package org.htl.springweb.demo.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {

	List<Book> books = new ArrayList<Book>();
	
	public BookController() {
		books.add(new Book("ISB1234", "O'Brian", "Irischer Lebenslauf"));
		books.add(new Book("ISB1554", "Christian Ullenboom ", "Java ist auch eine Insel"));
		books.add(new Book("ISB1555", "Franz Kafka ", "Der Prozess"));
	}
	@RequestMapping("/book")
	public String getBook(Model model) {
		model.addAttribute("book", new Book("ISB1234", "O'Brian", "Irischer Lebenslauf"));
		return "books/single";
	}

	@RequestMapping("/books")
	public String getBooks(Model model) {
		model.addAttribute("books", books);
		return "books/list";
	}
}
