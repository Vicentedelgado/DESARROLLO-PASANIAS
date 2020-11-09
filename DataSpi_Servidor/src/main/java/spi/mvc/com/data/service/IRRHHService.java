package spi.mvc.com.data.service;

import java.util.List;

import spi.mvc.com.data.model.RRHH;
import spi.mvc.com.data.model.SpiDatos;
public interface IRRHHService {
	
	public List<RRHH> listarrrhh();
	public void guardar(RRHH RRHH);
	public RRHH buscarPorId(Long id);
	public void eliminar(Long id);
	public List<RRHH> Listaporspirrhh(SpiDatos idspi);

}
