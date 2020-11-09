package spi.mvc.com.data.service;

import java.util.List;

import spi.mvc.com.data.model.Tipo;

public interface ITipoService {
	
	public List<Tipo> listatipos();
	public void guardar (Tipo Tipo);
	public Tipo buscarporId(Long idtipo);
	public void eliminar(Long idtipo);

}
