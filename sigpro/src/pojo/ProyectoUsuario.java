package pojo;
// Generated Sep 5, 2017 4:14:55 PM by Hibernate Tools 5.2.3.Final

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
 * ProyectoUsuario generated by hbm2java
 */
@Entity
@Table(name = "proyecto_usuario", catalog = "sipro")
public class ProyectoUsuario implements java.io.Serializable {

	private ProyectoUsuarioId id;
	private Proyecto proyecto;
	private String usuarioCreo;
	private String usuarioActualizo;
	private Date fechaCreacion;
	private Date fechaActualizacion;

	public ProyectoUsuario() {
	}

	public ProyectoUsuario(ProyectoUsuarioId id, Proyecto proyecto) {
		this.id = id;
		this.proyecto = proyecto;
	}

	public ProyectoUsuario(ProyectoUsuarioId id, Proyecto proyecto, String usuarioCreo, String usuarioActualizo,
			Date fechaCreacion, Date fechaActualizacion) {
		this.id = id;
		this.proyecto = proyecto;
		this.usuarioCreo = usuarioCreo;
		this.usuarioActualizo = usuarioActualizo;
		this.fechaCreacion = fechaCreacion;
		this.fechaActualizacion = fechaActualizacion;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "proyectoid", column = @Column(name = "proyectoid", nullable = false)),
			@AttributeOverride(name = "usuario", column = @Column(name = "usuario", nullable = false, length = 30)) })
	public ProyectoUsuarioId getId() {
		return this.id;
	}

	public void setId(ProyectoUsuarioId id) {
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

}
