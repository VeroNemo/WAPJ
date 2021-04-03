package business;

import javax.ejb.Stateless;
import javax.inject.Inject;

import business.dto.TOBook;
import persistence.dao.IBookDao;
import persistence.model.Book;
import persistence.qualifiers.Fake;

@Stateless
public class BookService {
	
	@Inject @Fake
	private IBookDao bookDao;
	
	public TOBook editBook(TOBook tobook) {
		Book book = bookDao.getBookById(tobook.getId());
		if(book == null) {
			try {
				
			} catch (NullPointerException e) {
				System.out.println("Editing book failed: not found id = " + tobook.getId());
			}
			return tobook;
		}
		book.setTitle(tobook.getTitle());
		return tobook;
	}

}
