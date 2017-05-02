package pojo;
// Generated May 2, 2017 11:16:34 AM by Hibernate Tools 5.2.1.Final

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
 * ProgramaPropiedadValor generated by hbm2java
 */
@Entity
@Table(name = "programa_propiedad_valor", catalog = "sipro")
public class ProgramaPropiedadValor implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3859880240688878678L;
	private ProgramaPropiedadValorId id;
	private Programa programa;
	private ProgramaPropiedad programaPropiedad;
	private String valorString;
	private Integer valorEntero;
	private BigDecimal valorDecimal;
	private Date valorTiempo;
	private String usuarioCreo;
	private String usuarioActualizo;
	private Date fechaCreacion;
	private Date fechaActualizacion;
	private Integer estado;

	public ProgramaPropiedadValor() {
	}

	public ProgramaPropiedadValor(ProgramaPropiedadValorId id, Programa programa, ProgramaPropiedad programaPropiedad) {
		this.id = id;
		this.programa = programa;
		this.programaPropiedad = programaPropiedad;
	}

	public ProgramaPropiedadValor(ProgramaPropiedadValorId id, Programa programa, ProgramaPropiedad programaPropiedad,
			String valorString, Integer valorEntero, BigDecimal valorDecimal, Date valorTiempo, String usuarioCreo,
			String usuarioActualizo, Date fechaCreacion, Date fechaActualizacion, Integer estado) {
		this.id = id;
		this.programa = programa;
		this.programaPropiedad = programaPropiedad;
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
			@AttributeOverride(name = "programaPropiedadid", column = @Column(name = "programa_propiedadid", nullable = false)),
			@AttributeOverride(name = "programaid", column = @Column(name = "programaid", nullable = false)) })
	public ProgramaPropiedadValorId getId() {
		return this.id;
	}

	public void setId(ProgramaPropiedadValorId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "programaid", nullable = false, insertable = false, updatable = false)
	public Programa getPrograma() {
		return this.programa;
	}

	public void setPrograma(Programa programa) {
		this.programa = programa;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "programa_propiedadid", nullable = false, insertable = false, updatable = false)
	public ProgramaPropiedad getProgramaPropiedad() {
		return this.programaPropiedad;
	}

	public void setProgramaPropiedad(ProgramaPropiedad programaPropiedad) {
		this.programaPropiedad = programaPropiedad;
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

}
