package pojo;
// Generated Sep 4, 2017 9:37:50 AM by Hibernate Tools 5.2.3.Final

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * ProgtipoPropiedadId generated by hbm2java
 */
@Embeddable
public class ProgtipoPropiedadId implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5154611946077674905L;
	private int programaPropiedadid;
	private int programaTipoid;

	public ProgtipoPropiedadId() {
	}

	public ProgtipoPropiedadId(int programaPropiedadid, int programaTipoid) {
		this.programaPropiedadid = programaPropiedadid;
		this.programaTipoid = programaTipoid;
	}

	@Column(name = "programa_propiedadid", nullable = false)
	public int getProgramaPropiedadid() {
		return this.programaPropiedadid;
	}

	public void setProgramaPropiedadid(int programaPropiedadid) {
		this.programaPropiedadid = programaPropiedadid;
	}

	@Column(name = "programa_tipoid", nullable = false)
	public int getProgramaTipoid() {
		return this.programaTipoid;
	}

	public void setProgramaTipoid(int programaTipoid) {
		this.programaTipoid = programaTipoid;
	}

	@Override
	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof ProgtipoPropiedadId))
			return false;
		ProgtipoPropiedadId castOther = (ProgtipoPropiedadId) other;

		return (this.getProgramaPropiedadid() == castOther.getProgramaPropiedadid())
				&& (this.getProgramaTipoid() == castOther.getProgramaTipoid());
	}

	@Override
	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getProgramaPropiedadid();
		result = 37 * result + this.getProgramaTipoid();
		return result;
	}

}
