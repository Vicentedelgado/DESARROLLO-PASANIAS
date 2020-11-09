package spi.mvc.com.data.service;

import java.util.List;

import spi.mvc.com.data.model.Software;

public interface ISoftwareService {
	public List<Software> listarTodo();
	public void guardar (Software software);
	public Software buscarPorId(Long idsoftware);
	public void eliminar(Long idsoftware);
}
