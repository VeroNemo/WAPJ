package persistence.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import business.dto.TOBookGenre;
import persistence.model.BookGenre;

@Stateless
public class BookGenreDAO implements IGenreDao{
	
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
	
	@Override
	public List<BookGenre> getBooksByGenre (String genreName){
		TypedQuery<BookGenre> tq = em.createNamedQuery("Book_findByGenre", BookGenre.class);
		tq.setParameter("genre_name", genreName);
		return tq.getResultList();
	}
	
	@Override
	public BookGenre createGenre(BookGenre genre) {
		em.persist(genre);
		return genre;
	}

	@Override
	public BookGenre editGenre(BookGenre genre) {
		return em.merge(genre);
	}

	@Override
	public void deleteGenre(BookGenre genre) {
		em.remove(genre);
	}

	@Override
	public List<BookGenre> getAllGenres() {
		TypedQuery<BookGenre> tq = em.createNamedQuery("Genre_allGenres", BookGenre.class);
		return tq.getResultList();
	}

	@Override
	public List<TOBookGenre> getAllTOGenres() {
		TypedQuery<TOBookGenre> tq = em.createNamedQuery("Genre_selectNewTO", TOBookGenre.class);
		return tq.getResultList();
	}

	@Override
	public BookGenre getGenreById(Integer id) {
		return em.find(BookGenre.class, id);
	}

}
