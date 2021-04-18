package business;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.RollbackException;

import business.dto.TOBookGenre;
import persistence.dao.IGenreDao;
import persistence.model.BookGenre;

@Stateless
public class BookGenreService {

	@Inject
	private IGenreDao igenredao;
	
	public TOBookGenre editGenre(TOBookGenre togenre) {
		BookGenre genre = igenredao.getGenreById(togenre.getId());
		if(genre == null) {
			try {
				
			} catch (Exception e) {
				System.out.println("Editing genre failed: not found id = " + togenre.getId());
			}
			return togenre;
		}
		genre.setGenreName(togenre.getGenreName());
		return new TOBookGenre(igenredao.editGenre(genre));
	}
	
	public void deleteGenre(TOBookGenre togenre) throws RollbackException {
		BookGenre genre = igenredao.getGenreById(togenre.getId());
		if(genre == null) {
			System.out.println("Deleting genre failed: not found id = " + togenre.getId());
			throw new RollbackException("Deleting genre failed: not found id = " + togenre.getId());
		}
		igenredao.deleteGenre(genre);
	}
}
