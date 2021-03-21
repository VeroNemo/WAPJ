package persistence.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import persistence.fakestuffs.FakeDatabase;
import persistence.model.Book;

@Stateless
@Default
public class FakeBookDAO implements IBookDao {
	
	@Inject
	private FakeDatabase fakeDatabase;
	
	private EntityManager em;
	
	@PostConstruct
	private void init() {
		System.out.println("This is fake DAO of Book");
	}

	@Override
	public Book createBook(Book book) {
		return fakeDatabase.insertBook(book);
	}

	@Override
	public Book editBook(Book book) {
		return fakeDatabase.editBook(book);
	}

	@Override
	public void deleteBook(Book book) {
		fakeDatabase.removeBook(book);
		
	}

	@Override
	public List<Book> getAllBooks() {
		TypedQuery<Book> tq = em.createNamedQuery("Book_allBooks", Book.class);
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
	public List<Book> getBooksByTitle(String title) {
		TypedQuery<Book> tq = em.createNamedQuery("Book_findByTitle", Book.class);
		tq.setParameter("title", title);
		return tq.getResultList();
	}

	@Override
	public Book getBookById(Integer id) {
		TypedQuery<Book> tq = em.createNamedQuery("Book_findById", Book.class);
		tq.setParameter("id", id);
		return tq.getSingleResult();
	}

}
