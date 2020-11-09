package spi.mvc.com.data.service;

import java.util.List;

import spi.mvc.com.data.model.InformeEquipo;



public interface IInformeEquipoService {

	public List<InformeEquipo> listarTodo();
	public void guardar (InformeEquipo informeequipo);
	public InformeEquipo buscarPorId(Long idinformeequipo);
	public void eliminar(Long idinformeequipo);
	public List<InformeEquipo> filtronum(Long idinformeequipo);
}
