package business;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

import persistence.dao.AutorDAO;
import persistence.dao.BookDAO;
import persistence.dao.BookGenreDAO;
import persistence.model.Autor;
import persistence.model.Book;
import persistence.model.BookGenre;

@Singleton //jedna jedin· inötancia danej class
@Startup
public class MyMain {
	
	@Inject //budem pouûÌvaù inötanciu nejakej svojej beany 
	private BookDAO bookDao; //injection point 
	
	@Inject
	private BookGenreDAO genreDao;
	
	@Inject
	private AutorDAO autorDao;
	
	@PostConstruct
	private void init() {
		Book b = new Book();
		b.setTitle("The Theory of Everything");
		bookDao.getBooksByTitle("Example title");
		bookDao.create(b); //kontainer vytvorÌ inötanciu danej triedy s·m 
		
		Autor au = new Autor();
		au.setFirstName("Stephen");
		au.setLastName("Hawking");
		autorDao.getAutorByName("Stephen", "Hawking");
		autorDao.create(au);
		
		BookGenre bg = new BookGenre();
		bg.setGenreName("Existential");
		genreDao.getBooksByGenre("Romantic");
		genreDao.create(bg);
		
	/*	EntityManagerFactory emf = Persistence.createEntityManagerFactory("wapjPU");
		EntityManager em = emf.createEntityManager();
		//em.persist(b);
		
		TypedQuery<Book> tq = em.createNamedQuery("Book_findByTitle", Book.class);
		tq.setParameter("title", "Example title");
		//tq.setParameter("title", "Example");
		//tq.getResultList();
		try {
			tq.getSingleResult();
		} catch (NoResultException e) {
			System.out.println("No result exception");
		} catch (NonUniqueResultException e) {
			System.out.println("NonUniqueResultException");
		} */
	}

}
