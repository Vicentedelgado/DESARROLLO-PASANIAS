package spi.mvc.com.data.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="distrito")
public class Distrito implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	//@Column(name = "idregistro")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long iddistrito;
	private String distrito;
	public Long getIddistrito() {
		return iddistrito;
	}
	public void setIddistrito(Long iddistrito) {
		this.iddistrito = iddistrito;
	}
	public String getDistrito() {
		return distrito;
	}
	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}
	
	@Override
	public String toString() {
		return "Distrito [iddistrito=" + iddistrito + ", distrito=" + distrito + "]";
	}
	
	

}
