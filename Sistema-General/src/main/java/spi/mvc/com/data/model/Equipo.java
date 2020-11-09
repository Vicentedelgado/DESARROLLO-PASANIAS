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
@Table(name="equipo")
public class Equipo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@ManyToOne
	@JoinColumn(name="idzona")
	private Zona idzona;
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	private Long idequipo;
	private String tipo ;
	private String nombreequipo ;
	private String fechaadquisicion ;
	private String marca;
	private String modelo ;
	private String serie ;
	private String codigoinstitucion ;
	private String estado ;
	private String observaciones ;
	private String ip ;
	private String codigoanydesk ;
	private String tipoconexion;
	private String ram ;
	private String mac0 ;
	private String mac1 ;
	private String seriesngp ;
	private String tipoprocesador;
	private String disco;
	
	public Long getIdequipo() {
		return idequipo;
	}
	public void setIdequipo(Long idequipo) {
		this.idequipo = idequipo;
	}
	public Zona getZona() {
		return idzona;
	}
	public void setIdzona(Zona idzona) {
		this.idzona = idzona;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getNombreequipo() {
		return nombreequipo;
	}
	public void setNombreequipo(String nombreequipo) {
		this.nombreequipo = nombreequipo;
	}
	public String getFechaadquisicion() {
		return fechaadquisicion;
	}
	public void setFechaadquisicion(String fechaadquisicion) {
		this.fechaadquisicion = fechaadquisicion;
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
	public String getCodigoinstitucion() {
		return codigoinstitucion;
	}
	public void setCodigoinstitucion(String codigoinstitucion) {
		this.codigoinstitucion = codigoinstitucion;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getCodigoanydesk() {
		return codigoanydesk;
	}
	public void setCodigoanydesk(String codigoanydesk) {
		this.codigoanydesk = codigoanydesk;
	}
	public String getTipoconexion() {
		return tipoconexion;
	}
	public void setTipoconexion(String tipoconexion) {
		this.tipoconexion = tipoconexion;
	}
	public String getRam() {
		return ram;
	}
	public void setRam(String ram) {
		this.ram = ram;
	}
	public String getMac0() {
		return mac0;
	}
	public void setMac0(String mac0) {
		this.mac0 = mac0;
	}
	public String getMac1() {
		return mac1;
	}
	public void setMac1(String mac1) {
		this.mac1 = mac1;
	}
	public String getSeriesngp() {
		return seriesngp;
	}
	public void setSeriesngp(String seriesngp) {
		this.seriesngp = seriesngp;
	}
	public String getTipoprocesador() {
		return tipoprocesador;
	}
	public void setTipoprocesador(String tipoprocesador) {
		this.tipoprocesador = tipoprocesador;
	}
	@Override
	public String toString() {
		return "Equipo [idequipo=" + idequipo + ", tipo=" + tipo + ", nombreequipo=" + nombreequipo
				+ ", fechaadquisicion=" + fechaadquisicion + ", marca=" + marca + ", modelo=" + modelo + ", serie="
				+ serie + ", codigoinstitucion=" + codigoinstitucion + ", estado=" + estado + ", observaciones="
				+ observaciones + ", ip=" + ip + ", codigoanydesk=" + codigoanydesk + ", tipoconexion=" + tipoconexion
				+ ", ram=" + ram + ", mac0=" + mac0 + ", mac1=" + mac1 + ", seriesngp=" + seriesngp
				+ ", tipoprocesador=" + tipoprocesador + ", disco=" + disco + "]";
	}
	public String getDisco() {
		return disco;
	}
	public void setDisco(String disco) {
		this.disco = disco;
	}
	
	
}
