package org.htl.springweb.demo.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {

	@RequestMapping("/book")
	public String getBook(Model model) {
		model.addAttribute("book", new Book("ISB1234", "O'Brian", "Irischer Lebenslauf"));
		return "books/single";
	}

	@RequestMapping("/books")
	public String getBooks(Model model) {
		List<Book> books = new ArrayList<Book>();
		books.add(new Book("ISB1234", "O'Brian", "Irischer Lebenslauf"));
		books.add(new Book("ISB1554", "Christian Ullenboom ", "Java ist auch eine Insel"));
		model.addAttribute("books", books);
		return "books/list";
	}
}
