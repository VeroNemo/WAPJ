package ui.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import business.AutorService;
import business.dto.TOAutor;
import persistence.dao.IAutorDao;
import persistence.model.Autor;
import persistence.qualifiers.Real;

@ViewScoped //pokým existuje stránka
@Named
public class AutorSinglePageController implements Serializable{

	private static final long serialVersionUID = 7885629352510483165L;
	
	private String inputFisrtNameAutor;
	private String inputLastNameAutor;
	private Integer inputAge;
	private String inputNationality;
	private List<TOAutor> autorsList;
	
	@Inject @Real
	private IAutorDao iautordao;
	
	@Inject
	private AutorService autorService;
	
	@PostConstruct
	private void init() {
		this.autorsList = this.iautordao.getAllTOAutors();
		this.inputFisrtNameAutor = "First name";
		this.inputLastNameAutor = "Last name";
		this.inputNationality = "Nationality";
		this.inputAge = 40;
		System.out.println("AutorSinglePageController created");
	}
	
	public void addAutor() {
		Autor autor = new Autor();
	//	autor.setFirstName(this.inputFisrtNameAutor);
	//	autor.setLastName(this.inputLastNameAutor);
	//	autor.setAge(this.inputAge);
	//	autor.setNationality(this.inputNationality);
		iautordao.createAutor(autor);
	}
	
	public void editAutor(TOAutor toautor) {
		toautor.setEditingMode(true);
		System.out.println("Edit mode on");
	}
	
	public void saveAutor(TOAutor toautor) {
		toautor.setEditingMode(false);
		toautor.setFirstName(this.inputFisrtNameAutor);
		toautor.setLastName(this.inputLastNameAutor);
		toautor.setAge(this.inputAge);
		toautor.setNationality(this.inputNationality);
		autorService.editAutor(toautor);
		System.out.println(toautor.getFirstName() + " " + toautor.getLastName() + " with ID = " + toautor.getId());
		System.out.println("Edit mode off");
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
	
	public int getInputAge() {
		return inputAge;
	}
	
	public void setInputAge(int inputAge) {
		this.inputAge = inputAge;
	}
	
	public String getInputNationality() {
		return inputNationality;
	}
	
	public void setInputNationality(String inputNationality) {
		this.inputNationality = inputNationality;
	}

	public List<TOAutor> getAutorsList() {
		return autorsList;
	}

	public void setAutorsList(List<TOAutor> autorsList) {
		this.autorsList = autorsList;
	}
}
