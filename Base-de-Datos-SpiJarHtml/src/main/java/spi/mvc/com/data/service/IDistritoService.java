package spi.mvc.com.data.service;

import java.util.List;

import spi.mvc.com.data.model.Distrito;

public interface IDistritoService {
	
	public List<Distrito> listadistrito();
	public void guardar(Distrito Distrito);
	public Distrito buscarPorId(Long iddistrito);
	public void eliminar(Long iddistrito);

}
