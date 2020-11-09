package spi.mvc.com.data.service;

import java.util.List;

import spi.mvc.com.data.model.AsignacionPeriferico;



public interface IAsignacionPeriferico {

	public List<AsignacionPeriferico> listarTodo();
	public void guardar (AsignacionPeriferico asignacion);
	public AsignacionPeriferico buscarPorId(Long idasignacion);
	public void eliminar(Long idasignacion);
	public List<AsignacionPeriferico> filtrarcedula(String cedula);
	public List<AsignacionPeriferico> filtronum(Long idasignacion);
}
