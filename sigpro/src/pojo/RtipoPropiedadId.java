package pojo;
// Generated Feb 3, 2017 7:56:02 AM by Hibernate Tools 5.2.0.CR1

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * RtipoPropiedadId generated by hbm2java
 */
@Embeddable
public class RtipoPropiedadId implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 248272296510857334L;
	private int riesgoTipoid;
	private int riesgoPropiedadid;

	public RtipoPropiedadId() {
	}

	public RtipoPropiedadId(int riesgoTipoid, int riesgoPropiedadid) {
		this.riesgoTipoid = riesgoTipoid;
		this.riesgoPropiedadid = riesgoPropiedadid;
	}

	@Column(name = "riesgo_tipoid", nullable = false)
	public int getRiesgoTipoid() {
		return this.riesgoTipoid;
	}

	public void setRiesgoTipoid(int riesgoTipoid) {
		this.riesgoTipoid = riesgoTipoid;
	}

	@Column(name = "riesgo_propiedadid", nullable = false)
	public int getRiesgoPropiedadid() {
		return this.riesgoPropiedadid;
	}

	public void setRiesgoPropiedadid(int riesgoPropiedadid) {
		this.riesgoPropiedadid = riesgoPropiedadid;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof RtipoPropiedadId))
			return false;
		RtipoPropiedadId castOther = (RtipoPropiedadId) other;

		return (this.getRiesgoTipoid() == castOther.getRiesgoTipoid())
				&& (this.getRiesgoPropiedadid() == castOther.getRiesgoPropiedadid());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getRiesgoTipoid();
		result = 37 * result + this.getRiesgoPropiedadid();
		return result;
	}

}
