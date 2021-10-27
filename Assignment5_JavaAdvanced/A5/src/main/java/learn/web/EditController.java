package learn.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import learn.Book;
import learn.service.BookServiceImpl;

@Controller
@RequestMapping("/edit")
public class EditController {
	
	@Autowired
	private BookServiceImpl service;
	
	@GetMapping
	public String update(Model model, @ModelAttribute Book book) {
		model.addAttribute(book);
		model.addAttribute("newBook", new Book());
		return "edit";
	}

	@PutMapping
	public String update(@RequestParam Long bookCode, Book book) {
		service.update(bookCode, book);
		return "redirect:/manage-books/"; 
	}
}
