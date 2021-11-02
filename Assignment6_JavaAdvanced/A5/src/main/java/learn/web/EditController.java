package learn.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import learn.Book;
import learn.service.BookServiceImpl;

@Controller
@RequestMapping("/edit/{bookCode}")
public class EditController {
	
	@Autowired
	private BookServiceImpl service;
	
	@GetMapping
	public String update(@PathVariable("bookCode") Long bookCode, Model model) {
		Book book = service.findByBookCode(bookCode);
		model.addAttribute(book);
		return "edit";
	}

	@PostMapping
	public String update(@RequestParam Long bookCode, Book book) {
		service.update(bookCode, book);
		return "redirect:/manage-books/"; 
	}
}
