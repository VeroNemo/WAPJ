package ui.controller;


import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import business.BookService;
import business.dto.TOBook;
import persistence.dao.IBookDao;
import persistence.qualifiers.Real;

@ViewScoped //pokým existuje stránka
@Named
public class BookSinglePageController implements Serializable {

	private static final long serialVersionUID = 7217777665137930015L;
	
	@Inject @Real
	private IBookDao ibookdao;
	
	private List<TOBook> booksList;
	
	@Inject
	private BookService bookService;
	
	@PostConstruct
	private void init() {
		this.loadBooksList();
		System.out.println("BookSinglePageController created");
	}
	
	//pre pridanie novej knihy sa presuniem do nového layout-u
	public String goToNewBookPage() {
		return "/newBook.xhtml?faces-redirect=true";
	}
	
	//editovanie a zmazanie knihy
	public void loadBooksList() {
		this.booksList = this.ibookdao.getAllTOBooks();
	}
	
	
	public void editBook(TOBook tobook) {
		tobook.setEditingMode(true);
		System.out.println("Edit mode on");
	}
	
	public void saveBook(TOBook tobook) {
		try {
			bookService.editBook(tobook);
		} catch (Exception e) {
			// TODO: handle exception
		}
		tobook.setEditingMode(false);
		System.out.println("Edit mode off");
	}
	
	public void deleteBook(TOBook toBook) {
		try {
			bookService.deleteBook(toBook);
			this.loadBooksList(); 			//update tabu¾ky do deletovaní
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Deleted book: ", "success"));
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Deleted failed: ", e.getMessage()));
		}
	}

	public List<TOBook> getBooksList() {
		return booksList;
	}

	public void setBooksList(List<TOBook> booksList) {
		this.booksList = booksList;
	}
	
}
