package pojo;
// Generated Jul 13, 2017 10:05:07 AM by Hibernate Tools 5.2.3.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * MvEpPrestamo generated by hbm2java
 */
@Entity
@Table(name = "mv_ep_prestamo", catalog = "sipro")
public class MvEpPrestamo implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -508159434711013885L;
	private MvEpPrestamoId id;

	public MvEpPrestamo() {
	}

	public MvEpPrestamo(MvEpPrestamoId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({ @AttributeOverride(name = "ejercicio", column = @Column(name = "ejercicio")),
			@AttributeOverride(name = "fuente", column = @Column(name = "fuente")),
			@AttributeOverride(name = "organismo", column = @Column(name = "organismo")),
			@AttributeOverride(name = "correlativo", column = @Column(name = "correlativo")),
			@AttributeOverride(name = "mes1r", column = @Column(name = "mes1r", precision = 59)),
			@AttributeOverride(name = "mes2r", column = @Column(name = "mes2r", precision = 59)),
			@AttributeOverride(name = "mes3r", column = @Column(name = "mes3r", precision = 59)),
			@AttributeOverride(name = "mes4r", column = @Column(name = "mes4r", precision = 59)),
			@AttributeOverride(name = "mes5r", column = @Column(name = "mes5r", precision = 59)),
			@AttributeOverride(name = "mes6r", column = @Column(name = "mes6r", precision = 59)),
			@AttributeOverride(name = "mes7r", column = @Column(name = "mes7r", precision = 59)),
			@AttributeOverride(name = "mes8r", column = @Column(name = "mes8r", precision = 59)),
			@AttributeOverride(name = "mes9r", column = @Column(name = "mes9r", precision = 59)),
			@AttributeOverride(name = "mes10r", column = @Column(name = "mes10r", precision = 59)),
			@AttributeOverride(name = "mes11r", column = @Column(name = "mes11r", precision = 59)),
			@AttributeOverride(name = "mes12r", column = @Column(name = "mes12r", precision = 59)) })
	public MvEpPrestamoId getId() {
		return this.id;
	}

	public void setId(MvEpPrestamoId id) {
		this.id = id;
	}

}