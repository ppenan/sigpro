package pojo;
// Generated Oct 2, 2017 5:12:50 PM by Hibernate Tools 5.2.3.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * ActividadPropiedad generated by hbm2java
 */
@Entity
@Table(name = "actividad_propiedad", catalog = "sipro")
public class ActividadPropiedad implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private DatoTipo datoTipo;
	private String nombre;
	private String descripcion;
	private String usuarioCreo;
	private String usuarioActualizo;
	private Date fechaCreacion;
	private Date fechaActualizacion;
	private int estado;
	private Set<AtipoPropiedad> atipoPropiedads = new HashSet<AtipoPropiedad>(0);
	private Set<ActividadPropiedadValor> actividadPropiedadValors = new HashSet<ActividadPropiedadValor>(0);

	public ActividadPropiedad() {
	}

	public ActividadPropiedad(DatoTipo datoTipo, String nombre, String usuarioCreo, Date fechaCreacion, int estado) {
		this.datoTipo = datoTipo;
		this.nombre = nombre;
		this.usuarioCreo = usuarioCreo;
		this.fechaCreacion = fechaCreacion;
		this.estado = estado;
	}

	public ActividadPropiedad(DatoTipo datoTipo, String nombre, String descripcion, String usuarioCreo,
			String usuarioActualizo, Date fechaCreacion, Date fechaActualizacion, int estado,
			Set<AtipoPropiedad> atipoPropiedads, Set<ActividadPropiedadValor> actividadPropiedadValors) {
		this.datoTipo = datoTipo;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.usuarioCreo = usuarioCreo;
		this.usuarioActualizo = usuarioActualizo;
		this.fechaCreacion = fechaCreacion;
		this.fechaActualizacion = fechaActualizacion;
		this.estado = estado;
		this.atipoPropiedads = atipoPropiedads;
		this.actividadPropiedadValors = actividadPropiedadValors;
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "dato_tipoid", nullable = false)
	public DatoTipo getDatoTipo() {
		return this.datoTipo;
	}

	public void setDatoTipo(DatoTipo datoTipo) {
		this.datoTipo = datoTipo;
	}

	@Column(name = "nombre", nullable = false, length = 200)
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

	@Column(name = "usuario_creo", nullable = false, length = 30)
	public String getUsuarioCreo() {
		return this.usuarioCreo;
	}

	public void setUsuarioCreo(String usuarioCreo) {
		this.usuarioCreo = usuarioCreo;
	}

	@Column(name = "usuario_actualizo", length = 30)
	public String getUsuarioActualizo() {
		return this.usuarioActualizo;
	}

	public void setUsuarioActualizo(String usuarioActualizo) {
		this.usuarioActualizo = usuarioActualizo;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_creacion", nullable = false, length = 19)
	public Date getFechaCreacion() {
		return this.fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_actualizacion", length = 19)
	public Date getFechaActualizacion() {
		return this.fechaActualizacion;
	}

	public void setFechaActualizacion(Date fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}

	@Column(name = "estado", nullable = false)
	public int getEstado() {
		return this.estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "actividadPropiedad")
	public Set<AtipoPropiedad> getAtipoPropiedads() {
		return this.atipoPropiedads;
	}

	public void setAtipoPropiedads(Set<AtipoPropiedad> atipoPropiedads) {
		this.atipoPropiedads = atipoPropiedads;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "actividadPropiedad")
	public Set<ActividadPropiedadValor> getActividadPropiedadValors() {
		return this.actividadPropiedadValors;
	}

	public void setActividadPropiedadValors(Set<ActividadPropiedadValor> actividadPropiedadValors) {
		this.actividadPropiedadValors = actividadPropiedadValors;
	}

}
