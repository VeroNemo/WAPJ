package persistence.fakestuffs;

import java.util.HashMap;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;

import persistence.model.Book;

@Singleton
public class FakeDatabase {
	
	private Integer lastId;
	
	private HashMap<Integer, Book> bookTable;
	
	@PostConstruct
	private void init() {
		this.lastId = 0;
		this.bookTable = new HashMap<Integer, Book>();
	}
	
	public Book insertBook(Book book) {
		lastId++;
		book.setId(lastId);
		this.bookTable.put(lastId, book);
		return book;
	}
	
	public Book editBook(Book book) {
		this.bookTable.put(book.getId(), book);
		return book;
	}
	
	public void removeBook(Book book) {
		this.bookTable.remove(book.getId());
	}
	
	public Book randomBook() {
		//int max = Collections.max(bookTable.values());
		int size = bookTable.size();
		int rdm = (int) (Math.random() * size); //HashMap zaèína od 0
		return this.bookTable.get(rdm);
	}
	
	public Book bookById(Integer id) {
		return this.bookTable.get(id);
	}

}
