package spi.mvc.com.data.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="zona")
public class Zona implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	//@Column(name = "idregistro")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idzona;
	private String nombre;
	@OneToMany(mappedBy="idzona",cascade=CascadeType.MERGE, fetch=FetchType.LAZY)
	private List<SpiDatos> spidatoszona= new ArrayList<>();
	
	public Zona() {
		super();
	}
	
	

	public Zona(Long idzona, String nombre, List<SpiDatos> spidatoszona) {
		this.idzona = idzona;
		this.nombre = nombre;
		this.spidatoszona = spidatoszona;
	}



	public Long getIdzona() {
		return idzona;
	}

	public void setIdzona(Long idzona) {
		this.idzona = idzona;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<SpiDatos> getSpidatoszona() {
		return spidatoszona;
	}

	public void setSpidatoszona(List<SpiDatos> spidatoszona) {
		this.spidatoszona = spidatoszona;
	}

	@Override
	public String toString() {
		return "Zona [idzona=" + idzona + ", nombre=" + nombre + ", spidatoszona=" + spidatoszona + "]";
	}
	
	
	
	
	
	
	
	
	

}
