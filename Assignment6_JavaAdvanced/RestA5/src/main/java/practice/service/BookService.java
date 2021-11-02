package practice.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import practice.Book;
import practice.data.BookRepository;

@Service
@Transactional
public class BookService {
	
	@Autowired
	private BookRepository bookRepo;
	
	public List<Book> listAll() {
		return bookRepo.findAll();
	}
	
	public void save(Book book) {
		bookRepo.save(book);
	}
	
	public Book get(Long bookCode) {
		return bookRepo.findById(bookCode).get();
	}
	
	public void delete(Long bookCode) {
		bookRepo.deleteById(bookCode);
	}
}
