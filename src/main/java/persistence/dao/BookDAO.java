package persistence.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import persistence.model.Book;

@Stateless //t·to class bude maù nejakÈ öpeci·lne pridanÈ funkcionality
public class BookDAO {
	
	@PersistenceContext(unitName = "wapjPU") //nahradÌ z·pis EntityManagerFactory
	private EntityManager em;
	
	@PostConstruct //pri vytvorenÌ
	private void init() {
		System.out.println("Created BookDAO");
	}
	
	@PreDestroy //pred zniËenÌm inötancie
	private void destroy() {
		System.out.println("Destroying BookDAO");
	}

	public List<Book> getBooksByTitle(String title) {
		TypedQuery<Book> tq = em.createNamedQuery("Book_findByTitle", Book.class);
		tq.setParameter("title", title);
		return tq.getResultList();
    }
	
	public Book create(Book book) {		
		em.persist(book);	
		return book;
    }
}
