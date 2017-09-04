package pojo;
// Generated Sep 4, 2017 9:37:50 AM by Hibernate Tools 5.2.3.Final

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * ProyectoMiembroId generated by hbm2java
 */
@Embeddable
public class ProyectoMiembroId implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8560493063640463731L;
	private int proyectoid;
	private int colaboradorid;

	public ProyectoMiembroId() {
	}

	public ProyectoMiembroId(int proyectoid, int colaboradorid) {
		this.proyectoid = proyectoid;
		this.colaboradorid = colaboradorid;
	}

	@Column(name = "proyectoid", nullable = false)
	public int getProyectoid() {
		return this.proyectoid;
	}

	public void setProyectoid(int proyectoid) {
		this.proyectoid = proyectoid;
	}

	@Column(name = "colaboradorid", nullable = false)
	public int getColaboradorid() {
		return this.colaboradorid;
	}

	public void setColaboradorid(int colaboradorid) {
		this.colaboradorid = colaboradorid;
	}

	@Override
	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof ProyectoMiembroId))
			return false;
		ProyectoMiembroId castOther = (ProyectoMiembroId) other;

		return (this.getProyectoid() == castOther.getProyectoid())
				&& (this.getColaboradorid() == castOther.getColaboradorid());
	}

	@Override
	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getProyectoid();
		result = 37 * result + this.getColaboradorid();
		return result;
	}

}
