package pojo;
// Generated Sep 11, 2017 11:21:21 AM by Hibernate Tools 5.2.3.Final

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
 * SubprodtipoPropiedad generated by hbm2java
 */
@Entity
@Table(name = "subprodtipo_propiedad", catalog = "sipro")
public class SubprodtipoPropiedad implements java.io.Serializable {

	private SubprodtipoPropiedadId id;
	private SubproductoPropiedad subproductoPropiedad;
	private SubproductoTipo subproductoTipo;
	private String usuarioCreo;
	private String usuarioActualizo;
	private Date fechaCreacion;
	private Date fechaActualizacion;

	public SubprodtipoPropiedad() {
	}

	public SubprodtipoPropiedad(SubprodtipoPropiedadId id, SubproductoPropiedad subproductoPropiedad,
			SubproductoTipo subproductoTipo, String usuarioCreo, Date fechaCreacion) {
		this.id = id;
		this.subproductoPropiedad = subproductoPropiedad;
		this.subproductoTipo = subproductoTipo;
		this.usuarioCreo = usuarioCreo;
		this.fechaCreacion = fechaCreacion;
	}

	public SubprodtipoPropiedad(SubprodtipoPropiedadId id, SubproductoPropiedad subproductoPropiedad,
			SubproductoTipo subproductoTipo, String usuarioCreo, String usuarioActualizo, Date fechaCreacion,
			Date fechaActualizacion) {
		this.id = id;
		this.subproductoPropiedad = subproductoPropiedad;
		this.subproductoTipo = subproductoTipo;
		this.usuarioCreo = usuarioCreo;
		this.usuarioActualizo = usuarioActualizo;
		this.fechaCreacion = fechaCreacion;
		this.fechaActualizacion = fechaActualizacion;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "subproductoTipoid", column = @Column(name = "subproducto_tipoid", nullable = false)),
			@AttributeOverride(name = "subproductoPropiedadid", column = @Column(name = "subproducto_propiedadid", nullable = false)) })
	public SubprodtipoPropiedadId getId() {
		return this.id;
	}

	public void setId(SubprodtipoPropiedadId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "subproducto_propiedadid", nullable = false, insertable = false, updatable = false)
	public SubproductoPropiedad getSubproductoPropiedad() {
		return this.subproductoPropiedad;
	}

	public void setSubproductoPropiedad(SubproductoPropiedad subproductoPropiedad) {
		this.subproductoPropiedad = subproductoPropiedad;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "subproducto_tipoid", nullable = false, insertable = false, updatable = false)
	public SubproductoTipo getSubproductoTipo() {
		return this.subproductoTipo;
	}

	public void setSubproductoTipo(SubproductoTipo subproductoTipo) {
		this.subproductoTipo = subproductoTipo;
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

}
