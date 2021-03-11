package persistence.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "book_genre")
@NamedQuery(name = "Book_findByGenre", query = "SELECT f FROM BookGenre f WHERE f.genreName =:genre_name")
public class BookGenre implements Serializable{

	private static final long serialVersionUID = -2345189929832941274L;

	public BookGenre() {
		super();
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "genre_name")
	private String genreName;
	
	@OneToMany(mappedBy = "genre")
	private List<Book> books;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getGenreName() {
		return genreName;
	}

	public void setGenreName(String genreName) {
		this.genreName = genreName;
	}

}
