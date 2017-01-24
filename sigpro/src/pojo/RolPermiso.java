package pojo;
// Generated Jan 24, 2017 3:13:19 PM by Hibernate Tools 5.2.0.CR1

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
 * RolPermiso generated by hbm2java
 */
@Entity
@Table(name = "rol_permiso", catalog = "sigpro")
public class RolPermiso implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7805734339771843527L;
	private RolPermisoId id;
	private Permiso permiso;
	private Rol rol;
	private String usuarioCreo;
	private String usuarioActualizo;
	private Date fechaCreacion;
	private Date fechaActualizacion;
	private Integer estado;

	public RolPermiso() {
	}

	public RolPermiso(RolPermisoId id, Permiso permiso, Rol rol) {
		this.id = id;
		this.permiso = permiso;
		this.rol = rol;
	}

	public RolPermiso(RolPermisoId id, Permiso permiso, Rol rol, String usuarioCreo, String usuarioActualizo,
			Date fechaCreacion, Date fechaActualizacion, Integer estado) {
		this.id = id;
		this.permiso = permiso;
		this.rol = rol;
		this.usuarioCreo = usuarioCreo;
		this.usuarioActualizo = usuarioActualizo;
		this.fechaCreacion = fechaCreacion;
		this.fechaActualizacion = fechaActualizacion;
		this.estado = estado;
	}

	@EmbeddedId

	@AttributeOverrides({ @AttributeOverride(name = "rolid", column = @Column(name = "rolid", nullable = false)),
			@AttributeOverride(name = "permisoid", column = @Column(name = "permisoid", nullable = false)) })
	public RolPermisoId getId() {
		return this.id;
	}

	public void setId(RolPermisoId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "permisoid", nullable = false, insertable = false, updatable = false)
	public Permiso getPermiso() {
		return this.permiso;
	}

	public void setPermiso(Permiso permiso) {
		this.permiso = permiso;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "rolid", nullable = false, insertable = false, updatable = false)
	public Rol getRol() {
		return this.rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
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
