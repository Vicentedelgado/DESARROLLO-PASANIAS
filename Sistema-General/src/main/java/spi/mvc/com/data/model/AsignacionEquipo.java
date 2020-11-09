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
@Table(name="asignacionequipo")
public class AsignacionEquipo implements Serializable{

	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	private Long idasignacionequipo;
	
	@DateTimeFormat(pattern= "yyyy-MM-dd")
	private Date fechainicio;
	
	@DateTimeFormat(pattern= "yyyy-MM-dd")
	private Date fechafin;
	private String observaciones;
		

	@ManyToOne
	@JoinColumn(name="idusuario")
	private RRHH  idusuario;
	
	@ManyToOne
	@JoinColumn(name="idequipo")
	private Equipo idequipo;

	public Long getIdasignacionequipo() {
		return idasignacionequipo;
	}

	public void setIdasignacionequipo(Long idasignacionequipo) {
		this.idasignacionequipo = idasignacionequipo;
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

	public Equipo getIdequipo() {
		return idequipo;
	}

	public void setIdequipo(Equipo idequipo) {
		this.idequipo = idequipo;
	}

	@Override
	public String toString() {
		return "AsignacionEquipo [idasignacionequipo=" + idasignacionequipo + ", fechainicio=" + fechainicio
				+ ", fechafin=" + fechafin + ", observaciones=" + observaciones + ", idusuario=" + idusuario
				+ ", idequipo=" + idequipo + "]";
	}

	
	
}
