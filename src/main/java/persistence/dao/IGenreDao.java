package persistence.dao;


import java.util.List;

import business.dto.TOBookGenre;
import persistence.model.BookGenre;

public interface IGenreDao {
	
	public BookGenre createGenre(BookGenre genre);
	public BookGenre editGenre(BookGenre genre);
	public void deleteGenre (BookGenre genre);
	public List<BookGenre> getAllGenres();
	public List<TOBookGenre> getAllTOGenres();
	public BookGenre getGenreById(Integer id);
	public List<BookGenre> getBooksByGenre(String genreName);

}
