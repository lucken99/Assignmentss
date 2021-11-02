package learn.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import learn.service.BookServiceImpl;

@Controller
@RequestMapping("/delete")
public class DeleteController {
	
	@Autowired
	private BookServiceImpl service;
	
	@PostMapping
	public String delete(@RequestParam Long bookCode) {
		service.delete(bookCode);
		return "redirect:/manage-books/";
	}
}
