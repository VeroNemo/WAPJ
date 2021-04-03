package persistence.dao;

import java.util.List;

import business.dto.TOAutor;
import persistence.model.Autor;

public interface IAutorDao {
	
	public Autor createAutor(Autor autor);
	public Autor editAutor(Autor autor);
	public void deleteAutor(Autor autor);
	public List<Autor> getAutorByName(String firstName, String lastName);
	public Autor getAutorById(Integer id);
	public List<TOAutor> getAllTOAutors();

}
