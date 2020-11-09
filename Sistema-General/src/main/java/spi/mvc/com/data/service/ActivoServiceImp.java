package spi.mvc.com.data.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import spi.mvc.com.data.model.Activo;
import spi.mvc.com.data.model.Tipo;
import spi.mvc.com.data.repository.ActivoRepository;

@Service
@Transactional
public class ActivoServiceImp implements IActivoService {
	
	@Autowired
	private ActivoRepository ActivoRepository;

	@Override
	public List<Activo> listaactivo() {
		// TODO Auto-generated method stub
		return (List<Activo>) ActivoRepository.findAll();
	}

	@Override
	public void guardar(Activo Activo) {
		// TODO Auto-generated method stub

	}

	@Override
	public Activo buscarPorId(Long idactivo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminar(Long idactivo) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Activo> Buscarportipo(Tipo idtipo) {
		// TODO Auto-generated method stub
		return ActivoRepository.Buscarportipo(idtipo);
	}
	

	
}
