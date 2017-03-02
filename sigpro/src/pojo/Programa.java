package pojo;
// Generated Mar 1, 2017 5:54:17 PM by Hibernate Tools 5.2.1.Final

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
 * Programa generated by hbm2java
 */
@Entity
@Table(name = "programa", catalog = "sipro")
public class Programa implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7960975687187201906L;
	private Integer id;
	private ProgramaTipo programaTipo;
	private String nombre;
	private String descripcion;
	private String usuarioCreo;
	private String usuarioActualizo;
	private Date fechaCreacion;
	private Date fechaActualizacion;
	private Integer estado;
	private Set<ProgramaProyecto> programaProyectos = new HashSet<ProgramaProyecto>(0);
	private Set<ProgramaPropiedadValor> programaPropiedadValors = new HashSet<ProgramaPropiedadValor>(0);

	public Programa() {
	}

	public Programa(ProgramaTipo programaTipo) {
		this.programaTipo = programaTipo;
	}

	public Programa(ProgramaTipo programaTipo, String nombre, String descripcion, String usuarioCreo,
			String usuarioActualizo, Date fechaCreacion, Date fechaActualizacion, Integer estado,
			Set<ProgramaProyecto> programaProyectos, Set<ProgramaPropiedadValor> programaPropiedadValors) {
		this.programaTipo = programaTipo;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.usuarioCreo = usuarioCreo;
		this.usuarioActualizo = usuarioActualizo;
		this.fechaCreacion = fechaCreacion;
		this.fechaActualizacion = fechaActualizacion;
		this.estado = estado;
		this.programaProyectos = programaProyectos;
		this.programaPropiedadValors = programaPropiedadValors;
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
	@JoinColumn(name = "programa_tipoid", nullable = false)
	public ProgramaTipo getProgramaTipo() {
		return this.programaTipo;
	}

	public void setProgramaTipo(ProgramaTipo programaTipo) {
		this.programaTipo = programaTipo;
	}

	@Column(name = "nombre", length = 2000)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "descripcion", length = 4000)
	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Column(name = "usuario_creo", length = 30)
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
	@Column(name = "fecha_creacion", length = 19)
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

	@Column(name = "estado")
	public Integer getEstado() {
		return this.estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "programa")
	public Set<ProgramaProyecto> getProgramaProyectos() {
		return this.programaProyectos;
	}

	public void setProgramaProyectos(Set<ProgramaProyecto> programaProyectos) {
		this.programaProyectos = programaProyectos;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "programa")
	public Set<ProgramaPropiedadValor> getProgramaPropiedadValors() {
		return this.programaPropiedadValors;
	}

	public void setProgramaPropiedadValors(Set<ProgramaPropiedadValor> programaPropiedadValors) {
		this.programaPropiedadValors = programaPropiedadValors;
	}

}
