package spi.mvc.com.data.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="spi_datos")
public class SpiDatos implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	//@Column(name = "idspi")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idspi;
	@ManyToOne
	@JoinColumn(name="idinstitucion")
	private Institucion idinstitucion;
	@ManyToOne
	@JoinColumn(name="idzona")
	@JsonIgnore
	private Zona idzona;
	private String nombre;
	private String daservicioa;
	private String direccion;
	private String telefono;
	private int numerodeoficina;
	private String convenio;
	private String observaciones;
	
	public SpiDatos() {
		super();
	}


	public SpiDatos(Long idspi, Institucion idinstitucion, Zona idzona, String nombre, String daservicioa,
			String direccion, String telefono, int numerodeoficina, String convenio, String observaciones) {
		super();
		this.idspi = idspi;
		this.idinstitucion = idinstitucion;
		this.idzona = idzona;
		this.nombre = nombre;
		this.daservicioa = daservicioa;
		this.direccion = direccion;
		this.telefono = telefono;
		this.numerodeoficina = numerodeoficina;
		this.convenio = convenio;
		this.observaciones = observaciones;
	}
	
	
	public Long getIdspi() {
		return idspi;
	}
	public void setIdspi(Long idspi) {
		this.idspi = idspi;
	}
	public Institucion getIdinstitucion() {
		return idinstitucion;
	}
	public void setIdinstitucion(Institucion idinstitucion) {
		this.idinstitucion = idinstitucion;
	}
	public Zona getIdzona() {
		return idzona;
	}
	public void setIdzona(Zona idzona) {
		this.idzona = idzona;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDaservicioa() {
		return daservicioa;
	}
	public void setDaservicioa(String daservicioa) {
		this.daservicioa = daservicioa;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public int getNumerodeoficina() {
		return numerodeoficina;
	}
	public void setNumerodeoficina(int numerodeoficina) {
		this.numerodeoficina = numerodeoficina;
	}
	public String getConvenio() {
		return convenio;
	}
	public void setConvenio(String convenio) {
		this.convenio = convenio;
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	
	@Override
	public String toString() {
		return "SpiDatos [idspi=" + idspi + ", idinstitucion=" + idinstitucion + ", idzona=" + idzona + ", nombre="
				+ nombre + ", daservicioa=" + daservicioa + ", direccion=" + direccion + ", telefono=" + telefono
				+ ", numerodeoficina=" + numerodeoficina + ", convenio=" + convenio + ", observaciones=" + observaciones
				+ "]";
	}
	
	
	
	
	
	

}
