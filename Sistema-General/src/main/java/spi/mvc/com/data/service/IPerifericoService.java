package spi.mvc.com.data.service;

import java.util.List;

import spi.mvc.com.data.model.Periferico;

public interface IPerifericoService {

	public List<Periferico> listarTodo();
	public void guardar (Periferico periferico);
	public Periferico buscarPorId(Long idperiferico);
	public void eliminar(Long idperiferico);
	
}
