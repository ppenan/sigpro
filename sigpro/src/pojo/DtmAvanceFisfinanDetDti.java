package pojo;
// Generated Sep 25, 2017 8:25:07 PM by Hibernate Tools 5.2.3.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * DtmAvanceFisfinanDetDti generated by hbm2java
 */
@Entity
@Table(name = "dtm_avance_fisfinan_det_dti", catalog = "sipro")
public class DtmAvanceFisfinanDetDti implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -873140307793893205L;
	private DtmAvanceFisfinanDetDtiId id;

	public DtmAvanceFisfinanDetDti() {
	}

	public DtmAvanceFisfinanDetDti(DtmAvanceFisfinanDetDtiId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "ejercicioFiscal", column = @Column(name = "ejercicio_fiscal", nullable = false, precision = 15, scale = 0)),
			@AttributeOverride(name = "mesDesembolso", column = @Column(name = "mes_desembolso", length = 45)),
			@AttributeOverride(name = "codigoPresupuestario", column = @Column(name = "codigo_presupuestario", length = 45)),
			@AttributeOverride(name = "entidadSicoin", column = @Column(name = "entidad_sicoin")),
			@AttributeOverride(name = "unidadEjecutoraSicoin", column = @Column(name = "unidad_ejecutora_sicoin")),
			@AttributeOverride(name = "monedaDesembolso", column = @Column(name = "moneda_desembolso", length = 45)),
			@AttributeOverride(name = "desembolsosMesMoneda", column = @Column(name = "desembolsos_mes_moneda", precision = 15)),
			@AttributeOverride(name = "tcMonUsd", column = @Column(name = "tc_mon_usd", precision = 15)),
			@AttributeOverride(name = "desembolsosMesUsd", column = @Column(name = "desembolsos_mes_usd", precision = 15)),
			@AttributeOverride(name = "tcUsdGtq", column = @Column(name = "tc_usd_gtq", precision = 15)),
			@AttributeOverride(name = "desembolsosMesGtq", column = @Column(name = "desembolsos_mes_gtq", precision = 15)) })
	public DtmAvanceFisfinanDetDtiId getId() {
		return this.id;
	}

	public void setId(DtmAvanceFisfinanDetDtiId id) {
		this.id = id;
	}

}
