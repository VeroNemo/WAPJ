package business;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.RollbackException;

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
			try {
				
			} catch (Exception e) {
				System.out.println("Editing autor failed: not found id = " + toautor.getId());
			}
			
			return toautor;
		}
		autor.setFirstName(toautor.getFirstName());
		autor.setLastName(toautor.getLastName());
		autor.setNationality(toautor.getNationality());
		autor.setAge(toautor.getAge());
		return new TOAutor(iautordao.editAutor(autor));
	}
	
	public void deleteAutor(TOAutor toautor) throws RollbackException {
		Autor autor = iautordao.getAutorById(toautor.getId());
		if(autor == null) {
			System.out.println("Deleting autor failed: not found id = " + toautor.getId());
			throw new RollbackException("Deleting autor failed: not found id = " + toautor.getId());
		}
		iautordao.deleteAutor(autor);
	}

}
