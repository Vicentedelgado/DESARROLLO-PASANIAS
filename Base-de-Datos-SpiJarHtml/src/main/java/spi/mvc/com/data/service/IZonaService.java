package spi.mvc.com.data.service;

import java.util.List;

import spi.mvc.com.data.model.Zona;

public interface IZonaService {
	
	public List<Zona> listazona();
	public List<Zona> listaporzona(Long idzona);
	public void guardar(Zona Zona);
	public Zona buscarPorId(Long idzona);
	public void eliminar(Long idzona);

}
