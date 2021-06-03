package org.htl.springweb.demo.demo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	Map<String, String> links = new HashMap<String, String>();

	public HomeController() {
		links.put("Buch", "book");
		links.put("Bücher", "books");
	}

	@GetMapping("/")
	public String home(Map<String, Object> model) {
		model.put("links", links);
		return "home";
	}

}
