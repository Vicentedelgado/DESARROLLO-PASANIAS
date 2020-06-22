package spi.mvc.com.data.service;

import java.util.List;

import spi.mvc.com.data.model.RegistrodelSpi;
import spi.mvc.com.data.model.SpiDatos;

public interface IRegistroDelSpiService {
	
	public List<RegistrodelSpi> listarregistro();
	public void guardar(RegistrodelSpi RegistrodelSpi);
	public void guardartodos(List<RegistrodelSpi> RegistrodelSpi);
	public RegistrodelSpi buscarPorId(Long idregistro);
	public void eliminar(Long idregistro);
	public List<RegistrodelSpi> Listaregistrodelspiinstalaciones(SpiDatos idspi);
	public List<RegistrodelSpi> Listaregistrodelspibienes(SpiDatos idspi);
	public List<RegistrodelSpi> Listaregistrodelspiequipos(SpiDatos idspi);
	public List<RegistrodelSpi> Listaregistrodelspiotros(SpiDatos idspi);
	public List<RegistrodelSpi> Listaregistrodelspimovilidad(SpiDatos idspi);
	public List<RegistrodelSpi> Listaregistrodelspiconectividad(SpiDatos idspi);

}
