package practice.web;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import practice.Book;
import practice.service.BookService;

@RestController
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@GetMapping("/books")
	public List<Book> list() {
		return bookService.listAll();
	}
	
	@GetMapping("/books/{bookCode}")
	public ResponseEntity<Book> get(@PathVariable Long bookCode) {
		try {
			Book book = bookService.get(bookCode);
			return new ResponseEntity<Book>(book, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<Book>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/books")
	public void add(@RequestBody Book book) {
		bookService.save(book);
	}
	
	@PutMapping("/books/{bookCode}")
	public ResponseEntity<?> update(@RequestBody Book book, @PathVariable Long bookCode) {
		try {
			Book existBook = bookService.get(bookCode);
			bookService.save(book);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/books/{bookCode}")
	public void delete(@PathVariable Long bookCode) {
		bookService.delete(bookCode);
	}
}
