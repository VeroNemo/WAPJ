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


@Entity
@Table(name = "book")
@NamedQuery(name = "Book_findByTitle", query = "SELECT b FROM Book b WHERE b.title =:title")
public class Book implements Serializable{

	private static final long serialVersionUID = 3309558141723701732L;

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Integer id;
		
		@Column(name = "title")
		private String title;
		
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

}
