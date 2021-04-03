package business;

import javax.ejb.Stateless;
import javax.inject.Inject;

import business.dto.TOAutor;
import persistence.dao.IAutorDao;
import persistence.model.Autor;
import persistence.qualifiers.Real;

@Stateless
public class AutorService {
	
	@Inject @Real
	private IAutorDao iautordao;
	
	public TOAutor editAutor(TOAutor toautor) {
		Autor autor = iautordao.getAutorById(toautor.getId());
		if(autor == null) {
			//TODO: throw exception, show message
			System.out.println("Editing autor failed: not found id = " + toautor.getId());
			return toautor;
		}
		autor.setFirstName(toautor.getFirstName());
		autor.setLastName(toautor.getLastName());
		autor.setNationality(toautor.getNationality());
		autor.setAge(toautor.getAge());
		System.out.println(autor.getFirstName() + " " + autor.getLastName() + " with age " + autor.getAge() + " and nationality " + autor.getNationality());
		return toautor;
	}

}
