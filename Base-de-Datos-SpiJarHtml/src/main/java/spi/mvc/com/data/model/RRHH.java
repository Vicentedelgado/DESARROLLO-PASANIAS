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
@Table(name="rrhh")
public class RRHH implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	//@Column(name = "idregistro")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idusuario;
	@ManyToOne
	@JoinColumn(name="idspi")
	private SpiDatos idspi;
	@ManyToOne
	@JoinColumn(name="idzona")
	private Zona idzona;
	private String nombres;
	private String apellidos;
	private String cedula;
	private String cargo;
	private String unidad;
	private String telefono;
	private String email;
	private String direccion;
    private String estado;
	
	
	public Long getIdusuario() {
		return idusuario;
	}
	public void setIdusuario(Long idusuario) {
		this.idusuario = idusuario;
	}
	public SpiDatos getIdspi() {
		return idspi;
	}
	public void setIdspi(SpiDatos idspi) {
		this.idspi = idspi;
	}
	public Zona getIdzona() {
		return idzona;
	}
	public void setIdzona(Zona idzona) {
		this.idzona = idzona;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public String getUnidad() {
		return unidad;
	}
	public void setUnidad(String unidad) {
		this.unidad = unidad;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	@Override
	public String toString() {
		return "RRHH [idusuario=" + idusuario + ", idspi=" + idspi + ", idzona=" + idzona + ", nombres=" + nombres
				+ ", apellidos=" + apellidos + ", cedula=" + cedula + ", cargo=" + cargo + ", unidad=" + unidad
				+ ", telefono=" + telefono + ", email=" + email + ", direccion=" + direccion + ", estado=" + estado
				+ "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
