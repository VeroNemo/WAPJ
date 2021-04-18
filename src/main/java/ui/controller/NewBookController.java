package ui.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import persistence.dao.IAutorDao;
import persistence.dao.IBookDao;
import persistence.dao.IGenreDao;
import persistence.model.Autor;
import persistence.model.Book;
import persistence.model.BookGenre;
import persistence.qualifiers.Real;

@ViewScoped
@Named
public class NewBookController implements Serializable{

	private static final long serialVersionUID = -4382653688500109282L;

	private String inputTitle; 
	private String inputFirstNameAutor;
	private String inputLastNameAutor;
	private String inputGenre;
	
	@Inject @Real
	private IAutorDao autordao;
	
	@Inject @Real
	private IBookDao ibookdao;
	
	@Inject 
	private IGenreDao bookgenredao;
	
	@PostConstruct
	private void init() {
		this.inputTitle = "Title";
		this.inputFirstNameAutor = "First Name";
		this.inputLastNameAutor = "Last Name";
		this.inputGenre = "Genre";
		System.out.println("NewBookController created");
	}
	
	public void addBook() {
		Autor autor = new Autor();
		autor.setFirstName(this.inputFirstNameAutor);
		autor.setLastName(this.inputLastNameAutor);
		autordao.createAutor(autor);
		
		BookGenre genre = new BookGenre();
		genre.setGenreName(this.inputGenre);
		bookgenredao.createGenre(genre);
		
		Book book = new Book();
		book.setTitle(this.inputTitle);
		book.setAutor(autor);
		book.setGenre(genre);
		ibookdao.createBook(book);
			
		System.out.println("Adding autor with name: " + this.inputFirstNameAutor + " " + this.inputLastNameAutor);
		System.out.println("Adding genre with name: " + this.inputGenre);
		System.out.println("Adding book with title: " +this.inputTitle);
	}

	public String getInputTitle() {
		return inputTitle;
	}

	public void setInputTitle(String inputTitle) {
		this.inputTitle = inputTitle;
	}

	public String getInputFirstNameAutor() {
		return inputFirstNameAutor;
	}

	public void setInputFirstNameAutor(String inputFirstNameAutor) {
		this.inputFirstNameAutor = inputFirstNameAutor;
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
	
}
