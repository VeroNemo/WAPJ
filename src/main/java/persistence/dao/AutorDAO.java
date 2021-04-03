package persistence.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import business.dto.TOAutor;
import persistence.model.Autor;
import persistence.qualifiers.Real;

@Stateless
@Real
public class AutorDAO implements IAutorDao{
	
	@PersistenceContext(unitName = "wapjPU") 
	private EntityManager em;
	
	@PostConstruct 
	private void init() {
		System.out.println("Created AutorDAO");
	}
	
	@PreDestroy 
	private void destroy() {
		System.out.println("Destroying AutorDAO");
	}
	
	public List<Autor> getAutorByName (String firstName, String lastName){
		TypedQuery<Autor> tq = em.createNamedQuery("Autor_findByName", Autor.class);
		tq.setParameter("first_name", firstName);
		tq.setParameter("last_name", lastName);
		return tq.getResultList();
	}
	
	@Override
	public List<TOAutor> getAllTOAutors() {
		TypedQuery<TOAutor> tq = em.createNamedQuery("Autor_selectNewTO", TOAutor.class);
		return tq.getResultList();
	}
	
	public Autor createAutor(Autor autor) {
		em.persist(autor);
		return autor;
	}

	@Override
	public Autor editAutor(Autor autor) {
		em.merge(autor);
		return autor;
	}

	@Override
	public void deleteAutor(Autor autor) {
		em.remove(autor);
		
	}

	@Override
	public Autor getAutorById(Integer id) {
		return em.find(Autor.class, id);
	}

}
