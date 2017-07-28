package pojo;
// Generated 27/07/2017 10:30:52 AM by Hibernate Tools 5.2.3.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Estado generated by hbm2java
 */
@Entity
@Table(name = "estado", catalog = "sipro")
public class Estado implements java.io.Serializable {

	private int id;
	private String nombre;
	private int valor;

	public Estado() {
	}

	public Estado(int id, String nombre, int valor) {
		this.id = id;
		this.nombre = nombre;
		this.valor = valor;
	}

	@Id

	@Column(name = "id", unique = true, nullable = false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "nombre", nullable = false, length = 30)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "valor", nullable = false)
	public int getValor() {
		return this.valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

}
