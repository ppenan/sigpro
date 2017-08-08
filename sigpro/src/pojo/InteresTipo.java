package pojo;
// Generated Aug 8, 2017 2:58:03 PM by Hibernate Tools 5.2.3.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * InteresTipo generated by hbm2java
 */
@Entity
@Table(name = "interes_tipo", catalog = "sipro")
public class InteresTipo implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8754865904297291384L;
	private Integer id;
	private String nombre;
	private String descripcion;
	private Set<Prestamo> prestamos = new HashSet<Prestamo>(0);

	public InteresTipo() {
	}

	public InteresTipo(String nombre) {
		this.nombre = nombre;
	}

	public InteresTipo(String nombre, String descripcion, Set<Prestamo> prestamos) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.prestamos = prestamos;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "nombre", nullable = false, length = 100)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "descripcion", length = 1000)
	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "interesTipo")
	public Set<Prestamo> getPrestamos() {
		return this.prestamos;
	}

	public void setPrestamos(Set<Prestamo> prestamos) {
		this.prestamos = prestamos;
	}

}
