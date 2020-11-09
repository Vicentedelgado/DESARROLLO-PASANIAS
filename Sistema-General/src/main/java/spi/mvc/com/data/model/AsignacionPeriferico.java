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

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="asignacionperiferico")
public class AsignacionPeriferico implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	private Long idasignacion;
	
	@DateTimeFormat(pattern= "yyyy-MM-dd")
	private Date fechainicio;
	
	@DateTimeFormat(pattern= "yyyy-MM-dd")
	private Date fechafin;
	private String observaciones;
	

	@ManyToOne
	@JoinColumn(name="idusuario")
	private RRHH  idusuario;
	
	@ManyToOne
	@JoinColumn(name="idperiferico")
	private Periferico idperiferico;

	public Long getIdasignacion() {
		return idasignacion;
	}

	public void setIdasignacion(Long idasignacion) {
		this.idasignacion = idasignacion;
	}

	public Date getFechainicio() {
		return fechainicio;
	}

	public void setFechainicio(Date fechainicio) {
		this.fechainicio = fechainicio;
	}

	public Date getFechafin() {
		return fechafin;
	}

	public void setFechafin(Date fechafin) {
		this.fechafin = fechafin;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public RRHH getIdusuario() {
		return idusuario;
	}

	public void setIdusuario(RRHH idusuario) {
		this.idusuario = idusuario;
	}

	public Periferico getIdperiferico() {
		return idperiferico;
	}

	public void setIdperiferico(Periferico idperiferico) {
		this.idperiferico = idperiferico;
	}

	@Override
	public String toString() {
		return "AsignacionPeriferico [idasignacion=" + idasignacion + ", fechainicio=" + fechainicio + ", fechafin="
				+ fechafin + ", observaciones=" + observaciones + ", idusuario=" + idusuario
				+ ", idperiferico=" + idperiferico + "]";
	}
	
}
