package ui.session;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@SessionScoped //ostáva aj po resetovaní stránky, nie ako view
@Named
public class BookSession implements Serializable{

	private static final long serialVersionUID = -7815249232474415209L;
	
	private String favouriteBook;
	
	@PostConstruct
	private void init() {
		System.out.println("Created session bean.");
	}

	public String getFavouriteBook() {
		return favouriteBook;
	}

	public void setFavouriteBook(String favouriteBook) {
		this.favouriteBook = favouriteBook;
	}

}
