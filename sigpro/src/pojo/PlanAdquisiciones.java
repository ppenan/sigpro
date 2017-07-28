package pojo;
// Generated Jul 13, 2017 10:05:07 AM by Hibernate Tools 5.2.3.Final

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
 * PlanAdquisiciones generated by hbm2java
 */
@Entity
@Table(name = "plan_adquisiciones", catalog = "sipro")
public class PlanAdquisiciones implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5298821529243579501L;
	private Integer id;
	private UnidadMedida unidadMedida;
	private Integer metodo;
	private Integer cantidad;
	private BigDecimal total;
	private BigDecimal precioUnitario;
	private Date preparacionDocPlanificado;
	private Date preparacionDocReal;
	private Date lanzamientoEventoPlanificado;
	private Date lanzamientoEventoReal;
	private Date recepcionOfertasPlanificado;
	private Date recepcionOfertasReal;
	private Date adjudicacionPlanificado;
	private Date adjudicacionReal;
	private Date firmaContratoPlanificado;
	private Date firmaContratoReal;
	private int objetoId;
	private int objetoTipo;
	private String usuarioCreo;
	private String usuarioActualizo;
	private Date fechaCreacion;
	private Date fechaActualizacion;
	private int estado;
	private Set<Pago> pagos = new HashSet<Pago>(0);

	public PlanAdquisiciones() {
	}

	public PlanAdquisiciones(BigDecimal total, int objetoId, int objetoTipo, String usuarioCreo, Date fechaCreacion,
			int estado) {
		this.total = total;
		this.objetoId = objetoId;
		this.objetoTipo = objetoTipo;
		this.usuarioCreo = usuarioCreo;
		this.fechaCreacion = fechaCreacion;
		this.estado = estado;
	}

	public PlanAdquisiciones(UnidadMedida unidadMedida, Integer metodo, Integer cantidad, BigDecimal total,
			BigDecimal precioUnitario, Date preparacionDocPlanificado, Date preparacionDocReal,
			Date lanzamientoEventoPlanificado, Date lanzamientoEventoReal, Date recepcionOfertasPlanificado,
			Date recepcionOfertasReal, Date adjudicacionPlanificado, Date adjudicacionReal,
			Date firmaContratoPlanificado, Date firmaContratoReal, int objetoId, int objetoTipo, String usuarioCreo,
			String usuarioActualizo, Date fechaCreacion, Date fechaActualizacion, int estado, Set<Pago> pagos) {
		this.unidadMedida = unidadMedida;
		this.metodo = metodo;
		this.cantidad = cantidad;
		this.total = total;
		this.precioUnitario = precioUnitario;
		this.preparacionDocPlanificado = preparacionDocPlanificado;
		this.preparacionDocReal = preparacionDocReal;
		this.lanzamientoEventoPlanificado = lanzamientoEventoPlanificado;
		this.lanzamientoEventoReal = lanzamientoEventoReal;
		this.recepcionOfertasPlanificado = recepcionOfertasPlanificado;
		this.recepcionOfertasReal = recepcionOfertasReal;
		this.adjudicacionPlanificado = adjudicacionPlanificado;
		this.adjudicacionReal = adjudicacionReal;
		this.firmaContratoPlanificado = firmaContratoPlanificado;
		this.firmaContratoReal = firmaContratoReal;
		this.objetoId = objetoId;
		this.objetoTipo = objetoTipo;
		this.usuarioCreo = usuarioCreo;
		this.usuarioActualizo = usuarioActualizo;
		this.fechaCreacion = fechaCreacion;
		this.fechaActualizacion = fechaActualizacion;
		this.estado = estado;
		this.pagos = pagos;
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
	@JoinColumn(name = "unidad_medida_id")
	public UnidadMedida getUnidadMedida() {
		return this.unidadMedida;
	}

	public void setUnidadMedida(UnidadMedida unidadMedida) {
		this.unidadMedida = unidadMedida;
	}

	@Column(name = "metodo")
	public Integer getMetodo() {
		return this.metodo;
	}

	public void setMetodo(Integer metodo) {
		this.metodo = metodo;
	}

	@Column(name = "cantidad")
	public Integer getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	@Column(name = "total", nullable = false, precision = 15)
	public BigDecimal getTotal() {
		return this.total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	@Column(name = "precio_unitario", precision = 15)
	public BigDecimal getPrecioUnitario() {
		return this.precioUnitario;
	}

	public void setPrecioUnitario(BigDecimal precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "preparacion_doc_planificado", length = 19)
	public Date getPreparacionDocPlanificado() {
		return this.preparacionDocPlanificado;
	}

	public void setPreparacionDocPlanificado(Date preparacionDocPlanificado) {
		this.preparacionDocPlanificado = preparacionDocPlanificado;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "preparacion_doc_real", length = 19)
	public Date getPreparacionDocReal() {
		return this.preparacionDocReal;
	}

	public void setPreparacionDocReal(Date preparacionDocReal) {
		this.preparacionDocReal = preparacionDocReal;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "lanzamiento_evento_planificado", length = 19)
	public Date getLanzamientoEventoPlanificado() {
		return this.lanzamientoEventoPlanificado;
	}

	public void setLanzamientoEventoPlanificado(Date lanzamientoEventoPlanificado) {
		this.lanzamientoEventoPlanificado = lanzamientoEventoPlanificado;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "lanzamiento_evento_real", length = 19)
	public Date getLanzamientoEventoReal() {
		return this.lanzamientoEventoReal;
	}

	public void setLanzamientoEventoReal(Date lanzamientoEventoReal) {
		this.lanzamientoEventoReal = lanzamientoEventoReal;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "recepcion_ofertas_planificado", length = 19)
	public Date getRecepcionOfertasPlanificado() {
		return this.recepcionOfertasPlanificado;
	}

	public void setRecepcionOfertasPlanificado(Date recepcionOfertasPlanificado) {
		this.recepcionOfertasPlanificado = recepcionOfertasPlanificado;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "recepcion_ofertas_real", length = 19)
	public Date getRecepcionOfertasReal() {
		return this.recepcionOfertasReal;
	}

	public void setRecepcionOfertasReal(Date recepcionOfertasReal) {
		this.recepcionOfertasReal = recepcionOfertasReal;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "adjudicacion_planificado", length = 19)
	public Date getAdjudicacionPlanificado() {
		return this.adjudicacionPlanificado;
	}

	public void setAdjudicacionPlanificado(Date adjudicacionPlanificado) {
		this.adjudicacionPlanificado = adjudicacionPlanificado;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "adjudicacion_real", length = 19)
	public Date getAdjudicacionReal() {
		return this.adjudicacionReal;
	}

	public void setAdjudicacionReal(Date adjudicacionReal) {
		this.adjudicacionReal = adjudicacionReal;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "firma_contrato_planificado", length = 19)
	public Date getFirmaContratoPlanificado() {
		return this.firmaContratoPlanificado;
	}

	public void setFirmaContratoPlanificado(Date firmaContratoPlanificado) {
		this.firmaContratoPlanificado = firmaContratoPlanificado;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "firma_contrato_real", length = 19)
	public Date getFirmaContratoReal() {
		return this.firmaContratoReal;
	}

	public void setFirmaContratoReal(Date firmaContratoReal) {
		this.firmaContratoReal = firmaContratoReal;
	}

	@Column(name = "objeto_id", nullable = false)
	public int getObjetoId() {
		return this.objetoId;
	}

	public void setObjetoId(int objetoId) {
		this.objetoId = objetoId;
	}

	@Column(name = "objeto_tipo", nullable = false)
	public int getObjetoTipo() {
		return this.objetoTipo;
	}

	public void setObjetoTipo(int objetoTipo) {
		this.objetoTipo = objetoTipo;
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "planAdquisiciones")
	public Set<Pago> getPagos() {
		return this.pagos;
	}

	public void setPagos(Set<Pago> pagos) {
		this.pagos = pagos;
	}

}