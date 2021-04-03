package business.dto;

import persistence.model.Book;

public class TOBook {
	
	private Integer id;
	private String title;
	private String autorFullName;
	private boolean editingMode;

	
	public TOBook(Book book) {
		this.id = book.getId();
		this.title = book.getTitle();
		this.editingMode = false;
		this.autorFullName = book.getAutor() == null ? "-" : book.getAutor().getFirstName() + " " + book.getAutor().getLastName();
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getAutorFullName() {
		return autorFullName;
	}


	public void setAutorFullName(String autorFullName) {
		this.autorFullName = autorFullName;
	}


	public boolean isEditingMode() {
		return editingMode;
	}


	public void setEditingMode(boolean editingMode) {
		this.editingMode = editingMode;
	}
	
	public Integer getId() {
		return id;
	}
	
}
