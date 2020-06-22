package spi.mvc.com.data.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="registro_del_spi")
public class RegistrodelSpi implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	//@Column(name = "idregistro")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idregistro;
	@ManyToOne
	@JoinColumn(name="idactivo")
	private Activo idactivo;
	@ManyToOne
	@JoinColumn(name="idspi")
	private SpiDatos idspi;
	@ManyToOne
	@JoinColumn(name="idinstitucion")
	private Institucion idinstitucion;
	private String estado;
	private Short cantidad;
	private Short cantidadrequerida;
	private Short holguradecantidad;
	private String prioridad;
	private String accionrealizada;
	private String periodo;
	private Date fechaaccion;
	
	
	public Long getIdregistro() {
		return idregistro;
	}
	public void setIdregistro(Long idregistro) {
		this.idregistro = idregistro;
	}
	public Activo getIdactivo() {
		return idactivo;
	}
	public void setIdactivo(Activo idactivo) {
		this.idactivo = idactivo;
	}
	public SpiDatos getIdspi() {
		return idspi;
	}
	public void setIdspi(SpiDatos idspi) {
		this.idspi = idspi;
	}
	public Institucion getIdinstitucion() {
		return idinstitucion;
	}
	public void setIdinstitucion(Institucion idinstitucion) {
		this.idinstitucion = idinstitucion;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Short getCantidad() {
		return cantidad;
	}
	public void setCantidad(Short cantidad) {
		this.cantidad = cantidad;
	}
	public Short getCantidadrequerida() {
		return cantidadrequerida;
	}
	public void setCantidadrequerida(Short cantidadrequerida) {
		this.cantidadrequerida = cantidadrequerida;
	}
	public Short getHolguradecantidad() {
		return holguradecantidad;
	}
	public void setHolguradecantidad(Short holguradecantidad) {
		this.holguradecantidad = holguradecantidad;
	}
	public String getPrioridad() {
		return prioridad;
	}
	public void setPrioridad(String prioridad) {
		this.prioridad = prioridad;
	}
	public String getAccionrealizada() {
		return accionrealizada;
	}
	public void setAccionrealizada(String accionrealizada) {
		this.accionrealizada = accionrealizada;
	}
	public String getPeriodo() {
		return periodo;
	}
	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}
	public Date getFechaaccion() {
		return fechaaccion;
	}
	public void setFechaaccion(Date fechaaccion) {
		this.fechaaccion = fechaaccion;
	}
	
	
	@Override
	public String toString() {
		return "RegistrodelSpi [idregistro=" + idregistro + ", idactivo=" + idactivo + ", idspi=" + idspi
				+ ", idinstitucion=" + idinstitucion + ", estado=" + estado + ", cantidad=" + cantidad
				+ ", cantidadrequerida=" + cantidadrequerida + ", holguradecantidad=" + holguradecantidad
				+ ", prioridad=" + prioridad + ", accionrealizada=" + accionrealizada + ", periodo=" + periodo
				+ ", fechaaccion=" + fechaaccion + "]";
	}
	
	
					

}
