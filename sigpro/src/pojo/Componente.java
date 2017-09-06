package pojo;
// Generated Sep 6, 2017 10:45:35 AM by Hibernate Tools 5.2.3.Final

import java.math.BigDecimal;
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
 * Componente generated by hbm2java
 */
@Entity
@Table(name = "componente", catalog = "sipro")
public class Componente implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8612755535776551525L;
	private Integer id;
	private AcumulacionCosto acumulacionCosto;
	private ComponenteTipo componenteTipo;
	private Proyecto proyecto;
	private UnidadEjecutora unidadEjecutora;
	private String nombre;
	private String descripcion;
	private String usuarioCreo;
	private String usuarioActualizo;
	private Date fechaCreacion;
	private Date fechaActualizacion;
	private int estado;
	private Long snip;
	private Integer programa;
	private Integer subprograma;
	private Integer proyecto_1;
	private Integer actividad;
	private Integer obra;
	private String latitud;
	private String longitud;
	private BigDecimal costo;
	private Integer renglon;
	private Integer ubicacionGeografica;
	private Date fechaInicio;
	private Date fechaFin;
	private Integer duracion;
	private String duracionDimension;
	private Integer orden;
	private String treePath;
	private Integer nivel;
	private Set<ComponenteUsuario> componenteUsuarios = new HashSet<ComponenteUsuario>(0);
	private Set<Producto> productos = new HashSet<Producto>(0);
	private Set<ComponentePropiedadValor> componentePropiedadValors = new HashSet<ComponentePropiedadValor>(0);

	public Componente() {
	}

	public Componente(ComponenteTipo componenteTipo, Proyecto proyecto, UnidadEjecutora unidadEjecutora, String nombre,
			String usuarioCreo, Date fechaCreacion, int estado) {
		this.componenteTipo = componenteTipo;
		this.proyecto = proyecto;
		this.unidadEjecutora = unidadEjecutora;
		this.nombre = nombre;
		this.usuarioCreo = usuarioCreo;
		this.fechaCreacion = fechaCreacion;
		this.estado = estado;
	}

	public Componente(AcumulacionCosto acumulacionCosto, ComponenteTipo componenteTipo, Proyecto proyecto,
			UnidadEjecutora unidadEjecutora, String nombre, String descripcion, String usuarioCreo,
			String usuarioActualizo, Date fechaCreacion, Date fechaActualizacion, int estado, Long snip,
			Integer programa, Integer subprograma, Integer proyecto_1, Integer actividad, Integer obra, String latitud,
			String longitud, BigDecimal costo, Integer renglon, Integer ubicacionGeografica, Date fechaInicio,
			Date fechaFin, Integer duracion, String duracionDimension, Integer orden, String treePath, Integer nivel,
			Set<ComponenteUsuario> componenteUsuarios, Set<Producto> productos,
			Set<ComponentePropiedadValor> componentePropiedadValors) {
		this.acumulacionCosto = acumulacionCosto;
		this.componenteTipo = componenteTipo;
		this.proyecto = proyecto;
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
		this.proyecto_1 = proyecto_1;
		this.actividad = actividad;
		this.obra = obra;
		this.latitud = latitud;
		this.longitud = longitud;
		this.costo = costo;
		this.renglon = renglon;
		this.ubicacionGeografica = ubicacionGeografica;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.duracion = duracion;
		this.duracionDimension = duracionDimension;
		this.orden = orden;
		this.treePath = treePath;
		this.nivel = nivel;
		this.componenteUsuarios = componenteUsuarios;
		this.productos = productos;
		this.componentePropiedadValors = componentePropiedadValors;
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
	@JoinColumn(name = "acumulacion_costoid")
	public AcumulacionCosto getAcumulacionCosto() {
		return this.acumulacionCosto;
	}

	public void setAcumulacionCosto(AcumulacionCosto acumulacionCosto) {
		this.acumulacionCosto = acumulacionCosto;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "componente_tipoid", nullable = false)
	public ComponenteTipo getComponenteTipo() {
		return this.componenteTipo;
	}

	public void setComponenteTipo(ComponenteTipo componenteTipo) {
		this.componenteTipo = componenteTipo;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "proyectoid", nullable = false)
	public Proyecto getProyecto() {
		return this.proyecto;
	}

	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
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

	@Column(name = "estado", nullable = false)
	public int getEstado() {
		return this.estado;
	}

	public void setEstado(int estado) {
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
	public Integer getProyecto_1() {
		return this.proyecto_1;
	}

	public void setProyecto_1(Integer proyecto_1) {
		this.proyecto_1 = proyecto_1;
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

	@Column(name = "costo", precision = 15)
	public BigDecimal getCosto() {
		return this.costo;
	}

	public void setCosto(BigDecimal costo) {
		this.costo = costo;
	}

	@Column(name = "renglon")
	public Integer getRenglon() {
		return this.renglon;
	}

	public void setRenglon(Integer renglon) {
		this.renglon = renglon;
	}

	@Column(name = "ubicacion_geografica")
	public Integer getUbicacionGeografica() {
		return this.ubicacionGeografica;
	}

	public void setUbicacionGeografica(Integer ubicacionGeografica) {
		this.ubicacionGeografica = ubicacionGeografica;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_inicio", length = 19)
	public Date getFechaInicio() {
		return this.fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_fin", length = 19)
	public Date getFechaFin() {
		return this.fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	@Column(name = "duracion")
	public Integer getDuracion() {
		return this.duracion;
	}

	public void setDuracion(Integer duracion) {
		this.duracion = duracion;
	}

	@Column(name = "duracion_dimension", length = 1)
	public String getDuracionDimension() {
		return this.duracionDimension;
	}

	public void setDuracionDimension(String duracionDimension) {
		this.duracionDimension = duracionDimension;
	}

	@Column(name = "orden")
	public Integer getOrden() {
		return this.orden;
	}

	public void setOrden(Integer orden) {
		this.orden = orden;
	}

	@Column(name = "treePath", length = 1000)
	public String getTreePath() {
		return this.treePath;
	}

	public void setTreePath(String treePath) {
		this.treePath = treePath;
	}

	@Column(name = "nivel")
	public Integer getNivel() {
		return this.nivel;
	}

	public void setNivel(Integer nivel) {
		this.nivel = nivel;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "componente")
	public Set<ComponenteUsuario> getComponenteUsuarios() {
		return this.componenteUsuarios;
	}

	public void setComponenteUsuarios(Set<ComponenteUsuario> componenteUsuarios) {
		this.componenteUsuarios = componenteUsuarios;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "componente")
	public Set<Producto> getProductos() {
		return this.productos;
	}

	public void setProductos(Set<Producto> productos) {
		this.productos = productos;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "componente")
	public Set<ComponentePropiedadValor> getComponentePropiedadValors() {
		return this.componentePropiedadValors;
	}

	public void setComponentePropiedadValors(Set<ComponentePropiedadValor> componentePropiedadValors) {
		this.componentePropiedadValors = componentePropiedadValors;
	}

}
