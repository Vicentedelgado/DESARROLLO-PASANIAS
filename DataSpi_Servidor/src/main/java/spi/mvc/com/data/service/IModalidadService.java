package spi.mvc.com.data.service;

import java.util.List;

import spi.mvc.com.data.model.Modalidad;

public interface IModalidadService {
	
	public List<Modalidad> listamodalidad();
	public void guardar (Modalidad Modalidad);
	public Modalidad buscarporId(Long idmodalidad);
	public void eliminar(Long idmodalidad);

}
