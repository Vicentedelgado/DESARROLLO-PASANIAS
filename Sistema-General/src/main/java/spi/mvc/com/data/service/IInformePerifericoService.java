package spi.mvc.com.data.service;

import java.util.List;

import spi.mvc.com.data.model.InformePeriferico;



public interface IInformePerifericoService {

	public List<InformePeriferico> listarTodo();
	public void guardar (InformePeriferico informe);
	public InformePeriferico buscarPorId(Long idinforme);
	public void eliminar(Long idinforme);
	public List<InformePeriferico> filtronum(Long idinforme);
}
