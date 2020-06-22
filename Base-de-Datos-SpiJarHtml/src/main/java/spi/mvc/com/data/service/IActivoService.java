package spi.mvc.com.data.service;

import java.util.List;

import spi.mvc.com.data.model.Activo;

public interface IActivoService {
	
	public List<Activo> listaactivo();
	public void guardar(Activo Activo);
	public Activo buscarPorId(Long idactivo);
	public void eliminar(Long idactivo);
	

}
