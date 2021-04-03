package business.dto;

import persistence.model.Autor;

public class TOAutor {
	
	private Integer id;
	private String firstName;
	private String lastName;
	private Integer age;
	private String nationality;
	private boolean editingMode;
	
	public TOAutor(Autor autor) {
		this.id = autor.getId();
		this.firstName = autor.getFirstName();
		this.lastName = autor.getLastName();
		this.age = autor.getAge();
		this.nationality = autor.getNationality();
		this.editingMode = false;
	}

	public Integer getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public boolean isEditingMode() {
		return editingMode;
	}

	public void setEditingMode(boolean editingMode) {
		this.editingMode = editingMode;
	}

}
