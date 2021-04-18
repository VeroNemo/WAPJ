package ui.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import persistence.dao.IGenreDao;
import persistence.model.BookGenre;

@ViewScoped
@Named
public class NewGenreController implements Serializable {

	private static final long serialVersionUID = 3380453159697916659L;

	private String inputGenre;
	
	@Inject
	private IGenreDao igenredao;
	
	@PostConstruct
	public void init() {
		this.inputGenre = "Genre";
		System.out.println("NewGenreController created");
	}
	
	public void addGenre() {
		BookGenre genre = new BookGenre();
		genre.setGenreName(this.inputGenre);
		igenredao.createGenre(genre);
		System.out.println("Adding genre with name: " + this.inputGenre);
	}

	public String getInputGenre() {
		return inputGenre;
	}

	public void setInputGenre(String inputGenre) {
		this.inputGenre = inputGenre;
	}
}
