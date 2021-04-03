package persistence.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "autor")
@NamedQueries({
	@NamedQuery(name = "Autor_findByName", query = "SELECT a FROM Autor a WHERE a.firstName =:first_name AND a.lastName =:last_name"),
	@NamedQuery(name = "Autor_selectNewTO", query = "SELECT NEW business.dto.TOAutor(a) FROM Autor a")
})

public class Autor implements Serializable{

	private static final long serialVersionUID = -3609836967311857512L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull //spadne to, ak bude atribút nulový ešte pred tým, ako pojde do databázy
	@Column(name = "first_name", nullable = true)
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "nationality")
	private String nationality;
	
	@Column(name = "age")
	private Integer age;
	
	@OneToMany(mappedBy = "autor")
	private List<Book> books;

	public Autor() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
}
