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
 * FormularioItem generated by hbm2java
 */
@Entity
@Table(name = "formulario_item", catalog = "sipro")
public class FormularioItem implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2291788632844898856L;
	private Integer id;
	private Formulario formulario;
	private FormularioItemTipo formularioItemTipo;
	private String texto;
	private int orden;
	private String usuarioCreo;
	private Integer usuarioActualizacion;
	private Date fechaCreacion;
	private Date fechaActualizacion;
	private int estado;
	private Set<FormularioItemOpcion> formularioItemOpcions = new HashSet<FormularioItemOpcion>(0);
	private Set<FormularioItemValor> formularioItemValors = new HashSet<FormularioItemValor>(0);

	public FormularioItem() {
	}

	public FormularioItem(Formulario formulario, FormularioItemTipo formularioItemTipo, String texto, int orden,
			String usuarioCreo, Date fechaCreacion, int estado) {
		this.formulario = formulario;
		this.formularioItemTipo = formularioItemTipo;
		this.texto = texto;
		this.orden = orden;
		this.usuarioCreo = usuarioCreo;
		this.fechaCreacion = fechaCreacion;
		this.estado = estado;
	}

	public FormularioItem(Formulario formulario, FormularioItemTipo formularioItemTipo, String texto, int orden,
			String usuarioCreo, Integer usuarioActualizacion, Date fechaCreacion, Date fechaActualizacion, int estado,
			Set<FormularioItemOpcion> formularioItemOpcions, Set<FormularioItemValor> formularioItemValors) {
		this.formulario = formulario;
		this.formularioItemTipo = formularioItemTipo;
		this.texto = texto;
		this.orden = orden;
		this.usuarioCreo = usuarioCreo;
		this.usuarioActualizacion = usuarioActualizacion;
		this.fechaCreacion = fechaCreacion;
		this.fechaActualizacion = fechaActualizacion;
		this.estado = estado;
		this.formularioItemOpcions = formularioItemOpcions;
		this.formularioItemValors = formularioItemValors;
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
	@JoinColumn(name = "formularioid", nullable = false)
	public Formulario getFormulario() {
		return this.formulario;
	}

	public void setFormulario(Formulario formulario) {
		this.formulario = formulario;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "formulario_item_tipoid", nullable = false)
	public FormularioItemTipo getFormularioItemTipo() {
		return this.formularioItemTipo;
	}

	public void setFormularioItemTipo(FormularioItemTipo formularioItemTipo) {
		this.formularioItemTipo = formularioItemTipo;
	}

	@Column(name = "texto", nullable = false, length = 4000)
	public String getTexto() {
		return this.texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	@Column(name = "orden", nullable = false)
	public int getOrden() {
		return this.orden;
	}

	public void setOrden(int orden) {
		this.orden = orden;
	}

	@Column(name = "usuario_creo", nullable = false, length = 30)
	public String getUsuarioCreo() {
		return this.usuarioCreo;
	}

	public void setUsuarioCreo(String usuarioCreo) {
		this.usuarioCreo = usuarioCreo;
	}

	@Column(name = "usuario_actualizacion")
	public Integer getUsuarioActualizacion() {
		return this.usuarioActualizacion;
	}

	public void setUsuarioActualizacion(Integer usuarioActualizacion) {
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

	@Column(name = "estado", nullable = false)
	public int getEstado() {
		return this.estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "formularioItem")
	public Set<FormularioItemOpcion> getFormularioItemOpcions() {
		return this.formularioItemOpcions;
	}

	public void setFormularioItemOpcions(Set<FormularioItemOpcion> formularioItemOpcions) {
		this.formularioItemOpcions = formularioItemOpcions;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "formularioItem")
	public Set<FormularioItemValor> getFormularioItemValors() {
		return this.formularioItemValors;
	}

	public void setFormularioItemValors(Set<FormularioItemValor> formularioItemValors) {
		this.formularioItemValors = formularioItemValors;
	}

}
