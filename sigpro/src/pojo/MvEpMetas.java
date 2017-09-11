package pojo;
// Generated Sep 11, 2017 11:21:21 AM by Hibernate Tools 5.2.3.Final

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * MvEpMetas generated by hbm2java
 */
@Entity
@Table(name = "mv_ep_metas", catalog = "sipro")
public class MvEpMetas implements java.io.Serializable {

	private Integer id;
	private int ejercicio;
	private int objetoId;
	private int objetoTipo;
	private int metaUnidadMedidaid;
	private BigDecimal eneroP;
	private BigDecimal eneroR;
	private BigDecimal febreroP;
	private BigDecimal febreroR;
	private BigDecimal marzoP;
	private BigDecimal marzoR;
	private BigDecimal abrilP;
	private BigDecimal abrilR;
	private BigDecimal mayoP;
	private BigDecimal mayoR;
	private BigDecimal junioP;
	private BigDecimal junioR;
	private BigDecimal julioP;
	private BigDecimal julioR;
	private BigDecimal agostoP;
	private BigDecimal agostoR;
	private BigDecimal septiembreP;
	private BigDecimal septiembreR;
	private BigDecimal octubreP;
	private BigDecimal octubreR;
	private BigDecimal noviembreP;
	private BigDecimal noviembreR;
	private BigDecimal diciembreP;
	private BigDecimal diciembreR;
	private BigDecimal lineaBase;
	private BigDecimal metaFinal;

	public MvEpMetas() {
	}

	public MvEpMetas(int ejercicio, int objetoId, int objetoTipo, int metaUnidadMedidaid) {
		this.ejercicio = ejercicio;
		this.objetoId = objetoId;
		this.objetoTipo = objetoTipo;
		this.metaUnidadMedidaid = metaUnidadMedidaid;
	}

	public MvEpMetas(int ejercicio, int objetoId, int objetoTipo, int metaUnidadMedidaid, BigDecimal eneroP,
			BigDecimal eneroR, BigDecimal febreroP, BigDecimal febreroR, BigDecimal marzoP, BigDecimal marzoR,
			BigDecimal abrilP, BigDecimal abrilR, BigDecimal mayoP, BigDecimal mayoR, BigDecimal junioP,
			BigDecimal junioR, BigDecimal julioP, BigDecimal julioR, BigDecimal agostoP, BigDecimal agostoR,
			BigDecimal septiembreP, BigDecimal septiembreR, BigDecimal octubreP, BigDecimal octubreR,
			BigDecimal noviembreP, BigDecimal noviembreR, BigDecimal diciembreP, BigDecimal diciembreR,
			BigDecimal lineaBase, BigDecimal metaFinal) {
		this.ejercicio = ejercicio;
		this.objetoId = objetoId;
		this.objetoTipo = objetoTipo;
		this.metaUnidadMedidaid = metaUnidadMedidaid;
		this.eneroP = eneroP;
		this.eneroR = eneroR;
		this.febreroP = febreroP;
		this.febreroR = febreroR;
		this.marzoP = marzoP;
		this.marzoR = marzoR;
		this.abrilP = abrilP;
		this.abrilR = abrilR;
		this.mayoP = mayoP;
		this.mayoR = mayoR;
		this.junioP = junioP;
		this.junioR = junioR;
		this.julioP = julioP;
		this.julioR = julioR;
		this.agostoP = agostoP;
		this.agostoR = agostoR;
		this.septiembreP = septiembreP;
		this.septiembreR = septiembreR;
		this.octubreP = octubreP;
		this.octubreR = octubreR;
		this.noviembreP = noviembreP;
		this.noviembreR = noviembreR;
		this.diciembreP = diciembreP;
		this.diciembreR = diciembreR;
		this.lineaBase = lineaBase;
		this.metaFinal = metaFinal;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "ejercicio", nullable = false)
	public int getEjercicio() {
		return this.ejercicio;
	}

	public void setEjercicio(int ejercicio) {
		this.ejercicio = ejercicio;
	}

	@Column(name = "objeto_id", nullable = false)
	public int getObjetoId() {
		return this.objetoId;
	}

	public void setObjetoId(int objetoId) {
		this.objetoId = objetoId;
	}

	@Column(name = "objeto_tipo", nullable = false)
	public int getObjetoTipo() {
		return this.objetoTipo;
	}

	public void setObjetoTipo(int objetoTipo) {
		this.objetoTipo = objetoTipo;
	}

	@Column(name = "meta_unidad_medidaid", nullable = false)
	public int getMetaUnidadMedidaid() {
		return this.metaUnidadMedidaid;
	}

	public void setMetaUnidadMedidaid(int metaUnidadMedidaid) {
		this.metaUnidadMedidaid = metaUnidadMedidaid;
	}

	@Column(name = "eneroP", precision = 15)
	public BigDecimal getEneroP() {
		return this.eneroP;
	}

	public void setEneroP(BigDecimal eneroP) {
		this.eneroP = eneroP;
	}

	@Column(name = "eneroR", precision = 15)
	public BigDecimal getEneroR() {
		return this.eneroR;
	}

	public void setEneroR(BigDecimal eneroR) {
		this.eneroR = eneroR;
	}

	@Column(name = "febreroP", precision = 15)
	public BigDecimal getFebreroP() {
		return this.febreroP;
	}

	public void setFebreroP(BigDecimal febreroP) {
		this.febreroP = febreroP;
	}

	@Column(name = "febreroR", precision = 15)
	public BigDecimal getFebreroR() {
		return this.febreroR;
	}

	public void setFebreroR(BigDecimal febreroR) {
		this.febreroR = febreroR;
	}

	@Column(name = "marzoP", precision = 15)
	public BigDecimal getMarzoP() {
		return this.marzoP;
	}

	public void setMarzoP(BigDecimal marzoP) {
		this.marzoP = marzoP;
	}

	@Column(name = "marzoR", precision = 15)
	public BigDecimal getMarzoR() {
		return this.marzoR;
	}

	public void setMarzoR(BigDecimal marzoR) {
		this.marzoR = marzoR;
	}

	@Column(name = "abrilP", precision = 15)
	public BigDecimal getAbrilP() {
		return this.abrilP;
	}

	public void setAbrilP(BigDecimal abrilP) {
		this.abrilP = abrilP;
	}

	@Column(name = "abrilR", precision = 15)
	public BigDecimal getAbrilR() {
		return this.abrilR;
	}

	public void setAbrilR(BigDecimal abrilR) {
		this.abrilR = abrilR;
	}

	@Column(name = "mayoP", precision = 15)
	public BigDecimal getMayoP() {
		return this.mayoP;
	}

	public void setMayoP(BigDecimal mayoP) {
		this.mayoP = mayoP;
	}

	@Column(name = "mayoR", precision = 15)
	public BigDecimal getMayoR() {
		return this.mayoR;
	}

	public void setMayoR(BigDecimal mayoR) {
		this.mayoR = mayoR;
	}

	@Column(name = "junioP", precision = 15)
	public BigDecimal getJunioP() {
		return this.junioP;
	}

	public void setJunioP(BigDecimal junioP) {
		this.junioP = junioP;
	}

	@Column(name = "junioR", precision = 15)
	public BigDecimal getJunioR() {
		return this.junioR;
	}

	public void setJunioR(BigDecimal junioR) {
		this.junioR = junioR;
	}

	@Column(name = "julioP", precision = 15)
	public BigDecimal getJulioP() {
		return this.julioP;
	}

	public void setJulioP(BigDecimal julioP) {
		this.julioP = julioP;
	}

	@Column(name = "julioR", precision = 15)
	public BigDecimal getJulioR() {
		return this.julioR;
	}

	public void setJulioR(BigDecimal julioR) {
		this.julioR = julioR;
	}

	@Column(name = "agostoP", precision = 15)
	public BigDecimal getAgostoP() {
		return this.agostoP;
	}

	public void setAgostoP(BigDecimal agostoP) {
		this.agostoP = agostoP;
	}

	@Column(name = "agostoR", precision = 15)
	public BigDecimal getAgostoR() {
		return this.agostoR;
	}

	public void setAgostoR(BigDecimal agostoR) {
		this.agostoR = agostoR;
	}

	@Column(name = "septiembreP", precision = 15)
	public BigDecimal getSeptiembreP() {
		return this.septiembreP;
	}

	public void setSeptiembreP(BigDecimal septiembreP) {
		this.septiembreP = septiembreP;
	}

	@Column(name = "septiembreR", precision = 15)
	public BigDecimal getSeptiembreR() {
		return this.septiembreR;
	}

	public void setSeptiembreR(BigDecimal septiembreR) {
		this.septiembreR = septiembreR;
	}

	@Column(name = "octubreP", precision = 15)
	public BigDecimal getOctubreP() {
		return this.octubreP;
	}

	public void setOctubreP(BigDecimal octubreP) {
		this.octubreP = octubreP;
	}

	@Column(name = "octubreR", precision = 15)
	public BigDecimal getOctubreR() {
		return this.octubreR;
	}

	public void setOctubreR(BigDecimal octubreR) {
		this.octubreR = octubreR;
	}

	@Column(name = "noviembreP", precision = 15)
	public BigDecimal getNoviembreP() {
		return this.noviembreP;
	}

	public void setNoviembreP(BigDecimal noviembreP) {
		this.noviembreP = noviembreP;
	}

	@Column(name = "noviembreR", precision = 15)
	public BigDecimal getNoviembreR() {
		return this.noviembreR;
	}

	public void setNoviembreR(BigDecimal noviembreR) {
		this.noviembreR = noviembreR;
	}

	@Column(name = "diciembreP", precision = 15)
	public BigDecimal getDiciembreP() {
		return this.diciembreP;
	}

	public void setDiciembreP(BigDecimal diciembreP) {
		this.diciembreP = diciembreP;
	}

	@Column(name = "diciembreR", precision = 15)
	public BigDecimal getDiciembreR() {
		return this.diciembreR;
	}

	public void setDiciembreR(BigDecimal diciembreR) {
		this.diciembreR = diciembreR;
	}

	@Column(name = "lineaBase", precision = 15)
	public BigDecimal getLineaBase() {
		return this.lineaBase;
	}

	public void setLineaBase(BigDecimal lineaBase) {
		this.lineaBase = lineaBase;
	}

	@Column(name = "metaFinal", precision = 15)
	public BigDecimal getMetaFinal() {
		return this.metaFinal;
	}

	public void setMetaFinal(BigDecimal metaFinal) {
		this.metaFinal = metaFinal;
	}

}
