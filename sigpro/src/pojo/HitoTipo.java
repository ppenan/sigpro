package pojo;
// Generated Sep 5, 2017 4:14:55 PM by Hibernate Tools 5.2.3.Final

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
 * HitoTipo generated by hbm2java
 */
@Entity
@Table(name = "hito_tipo", catalog = "sipro")
public class HitoTipo implements java.io.Serializable {

	private Integer id;
	private DatoTipo datoTipo;
	private String nombre;
	private String descripcion;
	private int estado;
	private String usuarioCreo;
	private String usuarioActualizacion;
	private Date fechaCreacion;
	private Date fechaActualizacion;
	private Set<Hito> hitos = new HashSet<Hito>(0);

	public HitoTipo() {
	}

	public HitoTipo(DatoTipo datoTipo, int estado, String usuarioCreo, Date fechaCreacion) {
		this.datoTipo = datoTipo;
		this.estado = estado;
		this.usuarioCreo = usuarioCreo;
		this.fechaCreacion = fechaCreacion;
	}

	public HitoTipo(DatoTipo datoTipo, String nombre, String descripcion, int estado, String usuarioCreo,
			String usuarioActualizacion, Date fechaCreacion, Date fechaActualizacion, Set<Hito> hitos) {
		this.datoTipo = datoTipo;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.estado = estado;
		this.usuarioCreo = usuarioCreo;
		this.usuarioActualizacion = usuarioActualizacion;
		this.fechaCreacion = fechaCreacion;
		this.fechaActualizacion = fechaActualizacion;
		this.hitos = hitos;
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

	@Column(name = "nombre", length = 1000)
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

	@Column(name = "estado", nullable = false)
	public int getEstado() {
		return this.estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	@Column(name = "usuario_creo", nullable = false, length = 30)
	public String getUsuarioCreo() {
		return this.usuarioCreo;
	}

	public void setUsuarioCreo(String usuarioCreo) {
		this.usuarioCreo = usuarioCreo;
	}

	@Column(name = "usuario_actualizacion", length = 30)
	public String getUsuarioActualizacion() {
		return this.usuarioActualizacion;
	}

	public void setUsuarioActualizacion(String usuarioActualizacion) {
		this.usuarioActualizacion = usuarioActualizacion;
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "hitoTipo")
	public Set<Hito> getHitos() {
		return this.hitos;
	}

	public void setHitos(Set<Hito> hitos) {
		this.hitos = hitos;
	}

}
