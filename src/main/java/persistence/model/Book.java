package persistence.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
@Table(name = "book")
@NamedQuery(name = "Book_findByTitle", query = "SELECT b FROM Book b WHERE b.title =:title")
@NamedQuery(name = "Book_allBooks", query = "SELECT b FROM Book b")
@NamedQuery(name = "Book_maxID", query = "SELECT MAX(b.id) AS maxId FROM Book b")
@NamedQuery(name = "Book_findById", query = "SELECT b FROM Book b WHERE b.id =:id")
public class Book implements Serializable {

	private static final long serialVersionUID = 3309558141723701732L;

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Integer id;
		
		@Column(name = "title")
		private String title;
		
		@Transient //nebude braù tak˝to atrib˙t do datab·zy
		private int age;
		
		@ManyToOne
		@JoinColumn(name = "fk_autor")
		private Autor autor;
		
		@ManyToOne
		@JoinColumn(name = "fk_genre")
		private BookGenre genre;

		public Book() {
			super();
		}

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		public Autor getAutor() {
			return autor;
		}

		public void setAutor(Autor autor) {
			this.autor = autor;
		}

		public BookGenre getGenre() {
			return genre;
		}

		public void setGenre(BookGenre genre) {
			this.genre = genre;
		}

}
