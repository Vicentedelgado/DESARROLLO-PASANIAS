package spi.mvc.com.data.service;

import java.util.List;

import spi.mvc.com.data.model.Activo;
import spi.mvc.com.data.model.Tipo;

public interface IActivoService {
	
	public List<Activo> listaactivo();
	public void guardar(Activo Activo);
	public Activo buscarPorId(Long idactivo);
	public void eliminar(Long idactivo);
	public List<Activo> Buscarportipo(Tipo idtipo);
	

}
