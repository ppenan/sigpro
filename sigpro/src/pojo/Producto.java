package pojo;
// Generated Aug 8, 2017 2:58:03 PM by Hibernate Tools 5.2.3.Final

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
 * Producto generated by hbm2java
 */
@Entity
@Table(name = "producto", catalog = "sipro")
public class Producto implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4532298417388682491L;
	private Integer id;
	private Componente componente;
	private ProductoTipo productoTipo;
	private UnidadEjecutora unidadEjecutora;
	private String nombre;
	private String descripcion;
	private String usuarioCreo;
	private String usuarioActualizo;
	private Date fechaCreacion;
	private Date fechaActualizacion;
	private Integer estado;
	private Long snip;
	private Integer programa;
	private Integer subprograma;
	private Integer proyecto;
	private Integer actividad;
	private Integer obra;
	private Integer fuente;
	private String latitud;
	private String longitud;
	private Integer peso;
	private Set<ProductoUsuario> productoUsuarios = new HashSet<ProductoUsuario>(0);
	private Set<Subproducto> subproductos = new HashSet<Subproducto>(0);
	private Set<ProductoPropiedadValor> productoPropiedadValors = new HashSet<ProductoPropiedadValor>(0);

	public Producto() {
	}

	public Producto(Componente componente, ProductoTipo productoTipo, UnidadEjecutora unidadEjecutora, String nombre,
			String usuarioCreo, Date fechaCreacion) {
		this.componente = componente;
		this.productoTipo = productoTipo;
		this.unidadEjecutora = unidadEjecutora;
		this.nombre = nombre;
		this.usuarioCreo = usuarioCreo;
		this.fechaCreacion = fechaCreacion;
	}

	public Producto(Componente componente, ProductoTipo productoTipo, UnidadEjecutora unidadEjecutora, String nombre,
			String descripcion, String usuarioCreo, String usuarioActualizo, Date fechaCreacion,
			Date fechaActualizacion, Integer estado, Long snip, Integer programa, Integer subprograma, Integer proyecto,
			Integer actividad, Integer obra, Integer fuente, String latitud, String longitud, Integer peso,
			Set<ProductoUsuario> productoUsuarios, Set<Subproducto> subproductos,
			Set<ProductoPropiedadValor> productoPropiedadValors) {
		this.componente = componente;
		this.productoTipo = productoTipo;
		this.unidadEjecutora = unidadEjecutora;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.usuarioCreo = usuarioCreo;
		this.usuarioActualizo = usuarioActualizo;
		this.fechaCreacion = fechaCreacion;
		this.fechaActualizacion = fechaActualizacion;
		this.estado = estado;
		this.snip = snip;
		this.programa = programa;
		this.subprograma = subprograma;
		this.proyecto = proyecto;
		this.actividad = actividad;
		this.obra = obra;
		this.fuente = fuente;
		this.latitud = latitud;
		this.longitud = longitud;
		this.peso = peso;
		this.productoUsuarios = productoUsuarios;
		this.subproductos = subproductos;
		this.productoPropiedadValors = productoPropiedadValors;
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
	@JoinColumn(name = "componenteid", nullable = false)
	public Componente getComponente() {
		return this.componente;
	}

	public void setComponente(Componente componente) {
		this.componente = componente;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "producto_tipoid", nullable = false)
	public ProductoTipo getProductoTipo() {
		return this.productoTipo;
	}

	public void setProductoTipo(ProductoTipo productoTipo) {
		this.productoTipo = productoTipo;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "unidad_ejecutoraunidad_ejecutora", nullable = false)
	public UnidadEjecutora getUnidadEjecutora() {
		return this.unidadEjecutora;
	}

	public void setUnidadEjecutora(UnidadEjecutora unidadEjecutora) {
		this.unidadEjecutora = unidadEjecutora;
	}

	@Column(name = "nombre", nullable = false, length = 1000)
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

	@Column(name = "estado")
	public Integer getEstado() {
		return this.estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	@Column(name = "snip")
	public Long getSnip() {
		return this.snip;
	}

	public void setSnip(Long snip) {
		this.snip = snip;
	}

	@Column(name = "programa")
	public Integer getPrograma() {
		return this.programa;
	}

	public void setPrograma(Integer programa) {
		this.programa = programa;
	}

	@Column(name = "subprograma")
	public Integer getSubprograma() {
		return this.subprograma;
	}

	public void setSubprograma(Integer subprograma) {
		this.subprograma = subprograma;
	}

	@Column(name = "proyecto")
	public Integer getProyecto() {
		return this.proyecto;
	}

	public void setProyecto(Integer proyecto) {
		this.proyecto = proyecto;
	}

	@Column(name = "actividad")
	public Integer getActividad() {
		return this.actividad;
	}

	public void setActividad(Integer actividad) {
		this.actividad = actividad;
	}

	@Column(name = "obra")
	public Integer getObra() {
		return this.obra;
	}

	public void setObra(Integer obra) {
		this.obra = obra;
	}

	@Column(name = "fuente")
	public Integer getFuente() {
		return this.fuente;
	}

	public void setFuente(Integer fuente) {
		this.fuente = fuente;
	}

	@Column(name = "latitud", length = 30)
	public String getLatitud() {
		return this.latitud;
	}

	public void setLatitud(String latitud) {
		this.latitud = latitud;
	}

	@Column(name = "longitud", length = 30)
	public String getLongitud() {
		return this.longitud;
	}

	public void setLongitud(String longitud) {
		this.longitud = longitud;
	}

	@Column(name = "peso")
	public Integer getPeso() {
		return this.peso;
	}

	public void setPeso(Integer peso) {
		this.peso = peso;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "producto")
	public Set<ProductoUsuario> getProductoUsuarios() {
		return this.productoUsuarios;
	}

	public void setProductoUsuarios(Set<ProductoUsuario> productoUsuarios) {
		this.productoUsuarios = productoUsuarios;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "producto")
	public Set<Subproducto> getSubproductos() {
		return this.subproductos;
	}

	public void setSubproductos(Set<Subproducto> subproductos) {
		this.subproductos = subproductos;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "producto")
	public Set<ProductoPropiedadValor> getProductoPropiedadValors() {
		return this.productoPropiedadValors;
	}

	public void setProductoPropiedadValors(Set<ProductoPropiedadValor> productoPropiedadValors) {
		this.productoPropiedadValors = productoPropiedadValors;
	}

}
