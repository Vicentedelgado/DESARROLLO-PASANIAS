package spi.mvc.com.data.service;

import java.util.List;

import spi.mvc.com.data.model.AsignacionEquipo;
import spi.mvc.com.data.model.RRHH;



public interface IAsignacionEquipo {

	public List<AsignacionEquipo> listarTodo();
	public void guardar (AsignacionEquipo asignacionequipo);
	public AsignacionEquipo buscarPorId(Long idasignacionequipo);
	public void eliminar(Long idasignacionequipo);
	public List<AsignacionEquipo> filtrocedula(String cedula);
	public List<AsignacionEquipo> filtrousuario(RRHH idusuario);
	public List<AsignacionEquipo> filtronum(Long idasignacionequipo);
	
}
