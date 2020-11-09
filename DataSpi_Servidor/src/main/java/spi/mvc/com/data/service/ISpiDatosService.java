package spi.mvc.com.data.service;

import java.util.List;
import spi.mvc.com.data.model.SpiDatos;
import spi.mvc.com.data.model.Zona;

public interface ISpiDatosService {
	
	public List<SpiDatos> listaspidatos();
	public void guardar(SpiDatos SpiDatos);
	public SpiDatos buscarPorId(Long idspi);
	public void eliminar(Long idspi);
	public List<SpiDatos> Listaporspi(Long idspi);
	public List<SpiDatos>  FindByZona(Zona idzona);

}
