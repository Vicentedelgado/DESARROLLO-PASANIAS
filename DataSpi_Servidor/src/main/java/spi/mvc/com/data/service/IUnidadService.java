package spi.mvc.com.data.service;

import java.util.List;

import spi.mvc.com.data.model.Unidad;

public interface IUnidadService{
	
	public List<Unidad> listaunidad();
	public void guardar (Unidad Unidad);
	public Unidad buscarporId(Long idunidad);
	public void eliminar(Long idunidad);

}
