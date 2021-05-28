package org.htl.springweb.demo.demo;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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

	@GetMapping("/book_by_isbn")
	@ResponseBody
	public String bookByIsbn(@RequestParam String isbn) {
		if (isbn == null || isbn.length() == 0)
			return "Keine ISBN gesetzt";
		for (Book b : books) {
			if (isbn.equals(b.getIsbn())) {
				return b + "";
			}
		}
		return String.format("%s nicht gefunden!", isbn);
	}

	@RequestMapping(value = "/book_by_isbn_json", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String bookByIsbnJSON(@RequestParam String isbn) {
		if (isbn == null || isbn.length() == 0)
			return "{\"Message\": \"Keine ISBN gesetzt\"}";
		for (Book b : books) {
			if (isbn.equals(b.getIsbn())) {
				return new JSONObject(b) + "";
			}
		}
		return "{\"Message\": \"nicht gefunden\"}";
	}

	@RequestMapping("/books")
	public String getBooks(Model model) {
		model.addAttribute("books", books);
		return "books/list";
	}
}
