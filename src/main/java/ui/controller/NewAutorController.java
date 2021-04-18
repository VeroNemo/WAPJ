package ui.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import persistence.dao.IAutorDao;
import persistence.model.Autor;
import persistence.qualifiers.Real;

@ViewScoped
@Named
public class NewAutorController implements Serializable{

	private static final long serialVersionUID = -8759049109914386734L;
	
	private String inputFirstNameAutor;
	private String inputLastNameAutor;
	private Integer inputAge;
	private String inputNationality;
	
	@Inject @Real
	private IAutorDao iautordao;
	
	@PostConstruct
	private void init() {
		this.inputFirstNameAutor = "First name";
		this.inputLastNameAutor = "Last name";
		this.inputNationality = "Nationality";
		this.inputAge = 40;
		System.out.println("NewAutorController created");
	}
	
	public void addAutor() {
		Autor autor = new Autor();
		autor.setFirstName(this.inputFirstNameAutor);
		autor.setLastName(this.inputLastNameAutor);
		autor.setAge(this.inputAge);
		autor.setNationality(this.inputNationality);
		iautordao.createAutor(autor);
		
		System.out.println("Adding autor with name: " + this.inputFirstNameAutor + " " + this.inputLastNameAutor + ", age: " + this.inputAge + ", nationality: " + this.inputNationality);
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

	public Integer getInputAge() {
		return inputAge;
	}

	public void setInputAge(Integer inputAge) {
		this.inputAge = inputAge;
	}

	public String getInputNationality() {
		return inputNationality;
	}

	public void setInputNationality(String inputNationality) {
		this.inputNationality = inputNationality;
	}
	
}
