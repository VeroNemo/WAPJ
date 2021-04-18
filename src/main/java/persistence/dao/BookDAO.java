package persistence.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import business.dto.TOBook;
import persistence.model.Book;
import persistence.qualifiers.Real;

@Stateless//t·to class bude maù nejakÈ öpeci·lne pridanÈ funkcionality
@Real
public class BookDAO implements IBookDao {
	
	@PersistenceContext(unitName = "wapjPU") //nahradÌ z·pis EntityManagerFactory
	private EntityManager em;
	
	@PostConstruct //pri vytvorenÌ
	private void init() {
		System.out.println("This is real BookDAO");
	}
	
	@PreDestroy //pred zniËenÌm inötancie
	private void destroy() {
		System.out.println("Destroying BookDAO");
	}

	@Override
	public List<Book> getBooksByTitle(String title) {
		TypedQuery<Book> tq = em.createNamedQuery("Book_findByTitle", Book.class);
		tq.setParameter("title", title);
		return tq.getResultList();
    }

	@Override
	public Book createBook(Book book) {
		em.persist(book);
		return book;
	}

	@Override
	public Book editBook(Book book) {
		return em.merge(book);
	}

	@Override
	public void deleteBook(Book book) {
		em.remove(book);
	}

	@Override
	public List<Book> getAllBooks() {
		TypedQuery<Book> tq = em.createNamedQuery("Book_allBooks", Book.class);
		return tq.getResultList();
	}
	
	@Override
	public List<TOBook> getAllTOBooks() {
		TypedQuery<TOBook> tq = em.createNamedQuery("Book_selectNewTO", TOBook.class);
		return tq.getResultList();
	}

	@Override
	public Book getRandomBook() {
		Query query = (Query)em.createNamedQuery("Book_maxID", Book.class);
		Object obj = query.getSingleResult();
		int rdm = (int) (Math.random()*((Integer)obj));
		TypedQuery<Book> tq = em.createNamedQuery("Book_findById", Book.class);
		tq.setParameter("id", rdm);
		return tq.getSingleResult();
	}

	@Override
	public Book getBookById(Integer id) {
		return em.find(Book.class, id);
	}
}
