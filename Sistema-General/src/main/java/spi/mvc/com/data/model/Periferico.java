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
@Table(name="periferico")
public class Periferico implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@ManyToOne
	@JoinColumn(name="idzona")
	private Zona idzona;
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	private Long idperiferico ;
	private String nombreperiferico ;
	private String marca  ;
	private String modelo ;
	private String serie ;
	private String estado  ;
	private String observaciones;  
	public Long getIdperiferico() {
		return idperiferico;
	}
	public void setIdperiferico(Long idperiferico) {
		this.idperiferico = idperiferico;
	}
	public Zona getZona() {
		return idzona;
	}
	public void setIdzona(Zona idzona) {
		this.idzona = idzona;
	}
	public String getNombreperiferico() {
		return nombreperiferico;
	}
	public void setNombreperiferico(String nombreperiferico) {
		this.nombreperiferico = nombreperiferico;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getSerie() {
		return serie;
	}
	public void setSerie(String serie) {
		this.serie = serie;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	@Override
	public String toString() {
		return "Periferico [idperiferico=" + idperiferico + ", nombreperiferico=" + nombreperiferico + ", marca="
				+ marca + ", modelo=" + modelo + ", serie=" + serie + ", estado=" + estado + "]";
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	
	
}
