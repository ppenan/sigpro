package pojo;
// Generated May 15, 2017 4:04:46 PM by Hibernate Tools 5.2.1.Final

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * ProgramaProyectoId generated by hbm2java
 */
@Embeddable
public class ProgramaProyectoId implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6693791864773252071L;
	private int programaid;
	private int proyectoid;

	public ProgramaProyectoId() {
	}

	public ProgramaProyectoId(int programaid, int proyectoid) {
		this.programaid = programaid;
		this.proyectoid = proyectoid;
	}

	@Column(name = "programaid", nullable = false)
	public int getProgramaid() {
		return this.programaid;
	}

	public void setProgramaid(int programaid) {
		this.programaid = programaid;
	}

	@Column(name = "proyectoid", nullable = false)
	public int getProyectoid() {
		return this.proyectoid;
	}

	public void setProyectoid(int proyectoid) {
		this.proyectoid = proyectoid;
	}

	@Override
	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof ProgramaProyectoId))
			return false;
		ProgramaProyectoId castOther = (ProgramaProyectoId) other;

		return (this.getProgramaid() == castOther.getProgramaid())
				&& (this.getProyectoid() == castOther.getProyectoid());
	}

	@Override
	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getProgramaid();
		result = 37 * result + this.getProyectoid();
		return result;
	}

}
