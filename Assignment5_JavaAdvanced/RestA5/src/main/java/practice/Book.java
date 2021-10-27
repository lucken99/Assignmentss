package practice;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;


@Entity(name="books")
@Data
@NoArgsConstructor
public class Book {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	private Long bookCode;
	
	private String bookName;
	private String author;
	private Date dateAdded;

	
	public Book(Long bookCode, String bookName, String author, Date dateAdded) {
		this.author = author;
		this.bookCode = bookCode;
		this.bookName = bookName;
		this.dateAdded = dateAdded;
	}
}
