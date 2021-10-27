package learn.web;

import javax.persistence.TemporalType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import learn.Book;
import learn.service.BookServiceImpl;

@Controller
@RequestMapping("/add")
public class AddController {
	
	@Autowired
	private BookServiceImpl service;
	
	@GetMapping
	public String add(Model model) {
		model.addAttribute("newBook", new Book());
		return "add";
	}
	

	@PostMapping
	public String add(@Validated @ModelAttribute Book book) {
		service.add(book);
		return "redirect:/manage-books/"; 
	}
}
