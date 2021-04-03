package ui.controller;


import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import business.dto.TOBook;
import persistence.dao.BookGenreDAO;
import persistence.dao.IAutorDao;
import persistence.dao.IBookDao;
import persistence.model.Autor;
import persistence.model.Book;
import persistence.model.BookGenre;
import persistence.qualifiers.Real;

@ViewScoped //pok˝m existuje str·nka
@Named
public class BookSinglePageController implements Serializable {

	private static final long serialVersionUID = 7217777665137930015L;
	
	private String inputTitle; //vûdy musÌm maù gettery a settery
	private String inputFisrtNameAutor;
	private String inputLastNameAutor;
	private String inputGenre;
	
	@Inject @Real
	private IBookDao ibookdao;
	
	@Inject @Real
	private IAutorDao autordao;
	
	@Inject
	private BookGenreDAO bookgenredao;
	
	private List<TOBook> booksList;
	
	@PostConstruct
	private void init() {
		this.booksList = this.ibookdao.getAllTOBooks();
		this.inputTitle = "Title";
		this.inputFisrtNameAutor = "First name";
		this.inputLastNameAutor = "Last name";
		this.inputGenre = "Genre";
		System.out.println("BookSinglePageController created");
	}
	
	public void addBook() {
		Autor autor = new Autor();
		autor.setFirstName(this.inputFisrtNameAutor);
		autor.setLastName(this.inputLastNameAutor);
		autordao.createAutor(autor);
		
		BookGenre genre = new BookGenre();
		genre.setGenreName(this.inputGenre);
		bookgenredao.create(genre);
		
		Book book = new Book();
		book.setTitle(this.inputTitle);
		book.setAutor(autor);
		book.setGenre(genre);
		ibookdao.createBook(book);
			
		System.out.println("Adding autor with name: " + this.inputFisrtNameAutor + " " + this.inputLastNameAutor);
		System.out.println("Adding genre with name: " + this.inputGenre);
		System.out.println("Adding book with title: " +this.inputTitle);
	}
	
	public void editBook(TOBook tobook) {
		tobook.setEditingMode(true);
		System.out.println("Edit mode on");
	}
	
	public void saveBook(TOBook tobook) {
		tobook.setEditingMode(false);
		System.out.println(tobook.getTitle());
		System.out.println("Edit mode off");
	}
	
	/*public void addAuthor() {
		autor = new Autor();
		autor.setFirstName(this.inputFisrtNameAutor);
		autor.setLastName(this.inputLastNameAutor);
		autordao.create(autor);
		System.out.println("Adding autor with name: " + this.inputFisrtNameAutor + " " + this.inputLastNameAutor);
	}
	
	public void addBookGenre() {
		genre = new BookGenre();
		genre.setGenreName(this.inputGenre);
		bookgenredao.create(genre);
		System.out.println("Adding genre with name: " + this.inputGenre);
	} */

	public String getInputTitle() {
		return inputTitle;
	}

	public void setInputTitle(String inputTitle) {
		this.inputTitle = inputTitle;
	}

	public String getInputFisrtNameAutor() {
		return inputFisrtNameAutor;
	}

	public void setInputFisrtNameAutor(String inputFisrtNameAutor) {
		this.inputFisrtNameAutor = inputFisrtNameAutor;
	}

	public String getInputLastNameAutor() {
		return inputLastNameAutor;
	}

	public void setInputLastNameAutor(String inputLastNameAutor) {
		this.inputLastNameAutor = inputLastNameAutor;
	}

	public String getInputGenre() {
		return inputGenre;
	}

	public void setInputGenre(String inputGenre) {
		this.inputGenre = inputGenre;
	}

	public List<TOBook> getBooksList() {
		return booksList;
	}

	public void setBooksList(List<TOBook> booksList) {
		this.booksList = booksList;
	}
	
}
