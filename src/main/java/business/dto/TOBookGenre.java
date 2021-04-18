package business.dto;

import persistence.model.BookGenre;

public class TOBookGenre {
	
	private Integer id;
	private String genreName;
	private boolean editingMode;
	
	public TOBookGenre(BookGenre genre) {
		this.id = genre.getId();
		this.genreName = genre.getGenreName();
		this.editingMode = false;
	}

	public Integer getId() {
		return id;
	}

	public String getGenreName() {
		return genreName;
	}

	public void setGenreName(String genreName) {
		this.genreName = genreName;
	}

	public boolean isEditingMode() {
		return editingMode;
	}

	public void setEditingMode(boolean editingMode) {
		this.editingMode = editingMode;
	}

}
