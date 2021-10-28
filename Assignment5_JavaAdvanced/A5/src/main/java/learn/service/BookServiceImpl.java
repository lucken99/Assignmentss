package learn.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import learn.Book;

@Service
public class BookServiceImpl {
	@Value("${resource.books}")
	private String resource;
	
	@Value("${resource.books}/{bookCode}")
	private String idResource;
	
	@Autowired
	private RestTemplate restTemplate;
	
	public List<Book> findAll() {
//		System.out.print(resource);
		return Arrays.stream(restTemplate.getForObject(resource, Book[].class)).collect(Collectors.toList());
	}
	
	public Book add(Book book) {
		return restTemplate.postForObject(resource, book, Book.class);
	}
	
	public Book update(Long bookCode, Book book) {
		return restTemplate.exchange(idResource, HttpMethod.PUT, new HttpEntity<>(book), Book.class, bookCode).getBody();
	}
	
	public void delete(Long bookCode) {
		restTemplate.delete(idResource, bookCode);
	}
	
	public Book findByBookCode(Long bookCode) {
		return restTemplate.getForObject(idResource, Book.class, bookCode);
	}
}
