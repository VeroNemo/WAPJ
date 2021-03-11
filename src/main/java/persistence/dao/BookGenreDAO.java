package persistence.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import persistence.model.BookGenre;

@Stateless
public class BookGenreDAO {
	
	@PersistenceContext(unitName = "wapjPU") 
	private EntityManager em;
	
	@PostConstruct 
	private void init() {
		System.out.println("Created BookGenreDAO");
	}
	
	@PreDestroy 
	private void destroy() {
		System.out.println("Destroying BookGenreDAO");
	}
	
	public List<BookGenre> getBooksByGenre (String genreName){
		TypedQuery<BookGenre> tq = em.createNamedQuery("Book_findByGenre", BookGenre.class);
		tq.setParameter("genre_name", genreName);
		return tq.getResultList();
	}
	
	public BookGenre create(BookGenre genre) {
		em.persist(genre);
		return genre;
	}

}
