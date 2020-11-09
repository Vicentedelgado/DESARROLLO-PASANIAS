package spi.mvc.com.data.service;

import java.util.List;

import spi.mvc.com.data.model.Institucion;

public interface IInstitucionService {
	
	public List<Institucion> listainstitucion();
	public void guardar(Institucion Institucion);
	public Institucion buscarPorId(Long idinstitucion);
	public void eliminar(Long idinstitucion);

}
