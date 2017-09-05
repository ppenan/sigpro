package pojo;
// Generated Sep 5, 2017 4:14:55 PM by Hibernate Tools 5.2.3.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * EstructuraArbol generated by hbm2java
 */
@Entity
@Table(name = "estructura_arbol", catalog = "sipro")
public class EstructuraArbol implements java.io.Serializable {

	private EstructuraArbolId id;

	public EstructuraArbol() {
	}

	public EstructuraArbol(EstructuraArbolId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({ @AttributeOverride(name = "prestamo", column = @Column(name = "prestamo")),
			@AttributeOverride(name = "componente", column = @Column(name = "componente")),
			@AttributeOverride(name = "producto", column = @Column(name = "producto")),
			@AttributeOverride(name = "subproducto", column = @Column(name = "subproducto")),
			@AttributeOverride(name = "actividad", column = @Column(name = "actividad")),
			@AttributeOverride(name = "treelevel", column = @Column(name = "treelevel")),
			@AttributeOverride(name = "treepath", column = @Column(name = "treepath", length = 511)),
			@AttributeOverride(name = "fechaInicio", column = @Column(name = "fecha_inicio", length = 19)),
			@AttributeOverride(name = "fechaFin", column = @Column(name = "fecha_fin", length = 19)) })
	public EstructuraArbolId getId() {
		return this.id;
	}

	public void setId(EstructuraArbolId id) {
		this.id = id;
	}

}
