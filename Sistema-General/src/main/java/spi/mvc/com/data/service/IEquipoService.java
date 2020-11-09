package spi.mvc.com.data.service;

import java.util.List;

import spi.mvc.com.data.model.Equipo;

public interface IEquipoService {
	public List<Equipo> listarTodo();
	public void guardar (Equipo equipo);
	public Equipo buscarPorId(Long idequipo);
	public void eliminar(Long idequipo);
}
