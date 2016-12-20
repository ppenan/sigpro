package pojo;
// Generated 20/12/2016 11:26:44 AM by Hibernate Tools 5.2.0.Beta1

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
 * DatoTipo generated by hbm2java
 */
@Entity
@Table(name = "dato_tipo", catalog = "sigpro")
public class DatoTipo implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8041387820979209256L;
	private Integer id;
	private String nombre;
	private String descripcion;
	private Set<ComponentePropiedad> componentePropiedads = new HashSet<ComponentePropiedad>(0);
	private Set<ProyectoPropiedad> proyectoPropiedads = new HashSet<ProyectoPropiedad>(0);
	private Set<ProductoPropiedad> productoPropiedads = new HashSet<ProductoPropiedad>(0);

	public DatoTipo() {
	}

	public DatoTipo(String nombre) {
		this.nombre = nombre;
	}

	public DatoTipo(String nombre, String descripcion, Set<ComponentePropiedad> componentePropiedads,
			Set<ProyectoPropiedad> proyectoPropiedads, Set<ProductoPropiedad> productoPropiedads) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.componentePropiedads = componentePropiedads;
		this.proyectoPropiedads = proyectoPropiedads;
		this.productoPropiedads = productoPropiedads;
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "datoTipo")
	public Set<ComponentePropiedad> getComponentePropiedads() {
		return this.componentePropiedads;
	}

	public void setComponentePropiedads(Set<ComponentePropiedad> componentePropiedads) {
		this.componentePropiedads = componentePropiedads;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "datoTipo")
	public Set<ProyectoPropiedad> getProyectoPropiedads() {
		return this.proyectoPropiedads;
	}

	public void setProyectoPropiedads(Set<ProyectoPropiedad> proyectoPropiedads) {
		this.proyectoPropiedads = proyectoPropiedads;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "datoTipo")
	public Set<ProductoPropiedad> getProductoPropiedads() {
		return this.productoPropiedads;
	}

	public void setProductoPropiedads(Set<ProductoPropiedad> productoPropiedads) {
		this.productoPropiedads = productoPropiedads;
	}

}
