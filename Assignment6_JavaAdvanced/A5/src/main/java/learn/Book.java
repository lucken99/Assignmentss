package learn;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class Book {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	private Long bookCode;
	
	private String bookName;
	private String author;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateAdded;

	
	public Book(Long bookCode, String bookName, String author, Date dateAdded) {
		this.author = author;
		this.bookCode = bookCode;
		this.bookName = bookName;
		this.dateAdded = dateAdded;
	}
}
