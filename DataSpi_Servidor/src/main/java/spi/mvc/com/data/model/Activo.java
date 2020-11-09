package spi.mvc.com.data.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="activo")
public class Activo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	//@Column(name = "idregistro")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idactivo;
	private String nombre;
	@ManyToOne
	@JoinColumn(name="idtipo")
	private Tipo idtipo;
	private String descripcion;
	
	
	public Long getIdactivo() {
		return idactivo;
	}
	public void setIdactivo(Long idactivo) {
		this.idactivo = idactivo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Tipo getIdtipo() {
		return idtipo;
	}
	public void setIdtipo(Tipo idtipo) {
		this.idtipo = idtipo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	@Override
	public String toString() {
		return "Activo [idactivo=" + idactivo + ", nombre=" + nombre + ", idtipo=" + idtipo + ", descripcion="
				+ descripcion + "]";
	}
	
	
	

}
