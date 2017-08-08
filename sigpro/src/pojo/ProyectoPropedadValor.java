package pojo;
// Generated Aug 6, 2017 10:04:13 PM by Hibernate Tools 5.2.3.Final

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * ProyectoPropedadValor generated by hbm2java
 */
@Entity
@Table(name = "proyecto_propedad_valor", catalog = "sipro")
public class ProyectoPropedadValor implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 335384242640647365L;
	private ProyectoPropedadValorId id;
	private Proyecto proyecto;
	private ProyectoPropiedad proyectoPropiedad;
	private String valorString;
	private Integer valorEntero;
	private BigDecimal valorDecimal;
	private Date valorTiempo;
	private String usuarioCreo;
	private String usuarioActualizo;
	private Date fechaCreacion;
	private Date fechaActualizacion;
	private int estado;

	public ProyectoPropedadValor() {
	}

	public ProyectoPropedadValor(ProyectoPropedadValorId id, Proyecto proyecto, ProyectoPropiedad proyectoPropiedad,
			String usuarioCreo, Date fechaCreacion, int estado) {
		this.id = id;
		this.proyecto = proyecto;
		this.proyectoPropiedad = proyectoPropiedad;
		this.usuarioCreo = usuarioCreo;
		this.fechaCreacion = fechaCreacion;
		this.estado = estado;
	}

	public ProyectoPropedadValor(ProyectoPropedadValorId id, Proyecto proyecto, ProyectoPropiedad proyectoPropiedad,
			String valorString, Integer valorEntero, BigDecimal valorDecimal, Date valorTiempo, String usuarioCreo,
			String usuarioActualizo, Date fechaCreacion, Date fechaActualizacion, int estado) {
		this.id = id;
		this.proyecto = proyecto;
		this.proyectoPropiedad = proyectoPropiedad;
		this.valorString = valorString;
		this.valorEntero = valorEntero;
		this.valorDecimal = valorDecimal;
		this.valorTiempo = valorTiempo;
		this.usuarioCreo = usuarioCreo;
		this.usuarioActualizo = usuarioActualizo;
		this.fechaCreacion = fechaCreacion;
		this.fechaActualizacion = fechaActualizacion;
		this.estado = estado;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "proyectoid", column = @Column(name = "proyectoid", nullable = false)),
			@AttributeOverride(name = "proyectoPropiedadid", column = @Column(name = "proyecto_propiedadid", nullable = false)) })
	public ProyectoPropedadValorId getId() {
		return this.id;
	}

	public void setId(ProyectoPropedadValorId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "proyectoid", nullable = false, insertable = false, updatable = false)
	public Proyecto getProyecto() {
		return this.proyecto;
	}

	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "proyecto_propiedadid", nullable = false, insertable = false, updatable = false)
	public ProyectoPropiedad getProyectoPropiedad() {
		return this.proyectoPropiedad;
	}

	public void setProyectoPropiedad(ProyectoPropiedad proyectoPropiedad) {
		this.proyectoPropiedad = proyectoPropiedad;
	}

	@Column(name = "valor_string", length = 4000)
	public String getValorString() {
		return this.valorString;
	}

	public void setValorString(String valorString) {
		this.valorString = valorString;
	}

	@Column(name = "valor_entero")
	public Integer getValorEntero() {
		return this.valorEntero;
	}

	public void setValorEntero(Integer valorEntero) {
		this.valorEntero = valorEntero;
	}

	@Column(name = "valor_decimal", precision = 15)
	public BigDecimal getValorDecimal() {
		return this.valorDecimal;
	}

	public void setValorDecimal(BigDecimal valorDecimal) {
		this.valorDecimal = valorDecimal;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "valor_tiempo", length = 19)
	public Date getValorTiempo() {
		return this.valorTiempo;
	}

	public void setValorTiempo(Date valorTiempo) {
		this.valorTiempo = valorTiempo;
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

}
