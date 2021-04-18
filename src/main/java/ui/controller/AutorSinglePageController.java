package ui.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import business.AutorService;
import business.dto.TOAutor;
import persistence.dao.IAutorDao;
import persistence.qualifiers.Real;

@ViewScoped //pokým existuje stránka
@Named
public class AutorSinglePageController implements Serializable{

	private static final long serialVersionUID = 7885629352510483165L;
	
	private List<TOAutor> autorsList;
	
	@Inject @Real
	private IAutorDao iautordao;
	
	@Inject
	private AutorService autorService;
	
	@PostConstruct
	private void init() {
		this.loadAutorsList();
		System.out.println("AutorSinglePageController created");
	}
	
	public void loadAutorsList() {
		this.autorsList = this.iautordao.getAllTOAutors();
	}
	
	public String goToNewAutorPage() {
		return "/newAutor.xhtml?faces-redirect=true";
	}
	
	public void editAutor(TOAutor toautor) {
		toautor.setEditingMode(true);
		System.out.println("Edit mode on");
	}
	
	public void saveAutor(TOAutor toautor) {
		try {
			autorService.editAutor(toautor);
		} catch (Exception e) {
			// TODO: handle exception
		}
		toautor.setEditingMode(false);
		System.out.println("Edit mode off");
	}

	public void deleteAutor(TOAutor toautor) {
		try {
			autorService.deleteAutor(toautor);
			this.loadAutorsList();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Deleted autor: ", "success"));
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Deleted failed: ", "Could not delete autor that it foreign key to book. First delete that book."));
		}
	}

	public List<TOAutor> getAutorsList() {
		return autorsList;
	}

	public void setAutorsList(List<TOAutor> autorsList) {
		this.autorsList = autorsList;
	}
}
