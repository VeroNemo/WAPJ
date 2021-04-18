package ui.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import business.BookGenreService;
import business.dto.TOBookGenre;
import persistence.dao.IGenreDao;

@ViewScoped
@Named
public class GenreSinglePageController implements Serializable {

	private static final long serialVersionUID = 4308703006323994826L;

	private List<TOBookGenre> genresList;
	
	@Inject
	private IGenreDao igenredao;
	
	@Inject
	private BookGenreService genreService;
	
	@PostConstruct
	private void init() {
		this.loadGenresList();
		System.out.println("BookSinglePageController created");
	}
	
	public String goToNewGenrePage() {
		return "/newGenre.xhtml?faces-redirect=true";
	}
	
	public void loadGenresList() {
		this.genresList = this.igenredao.getAllTOGenres();
	}
	
	public void editGenre(TOBookGenre togenre) {
		togenre.setEditingMode(true);
		System.out.println("Edit mode on");
	}
	
	public void saveGenre(TOBookGenre togenre) {
		System.out.println("Save genre");
		try {
			genreService.editGenre(togenre);
		} catch (Exception e) {
			// TODO: handle exception
		}
		togenre.setEditingMode(false);
		System.out.println("Edit mode off");
	}
	
	public void deleteGenre(TOBookGenre togenre) {
		try {
			genreService.deleteGenre(togenre);
			this.loadGenresList(); 			
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Deleted genre: ", "success"));
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Deleted failed: ", "Could not delete genre that it foreign key to book. First delete that book."));
		}
	}

	public List<TOBookGenre> getGenresList() {
		return genresList;
	}

	public void setGenresList(List<TOBookGenre> genresList) {
		this.genresList = genresList;
	}
	
}
