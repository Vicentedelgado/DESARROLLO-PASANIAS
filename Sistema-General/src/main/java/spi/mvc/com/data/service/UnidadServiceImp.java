package spi.mvc.com.data.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import spi.mvc.com.data.model.Unidad;
import spi.mvc.com.data.repository.UnidadRepository;

@Service
@Transactional
public class UnidadServiceImp implements IUnidadService {
	
	@Autowired
	private UnidadRepository UnidadRepository;

	@Override
	public List<Unidad> listaunidad() {
		// TODO Auto-generated method stub
		return (List<Unidad>) UnidadRepository.findAll();
	}

	@Override
	public void guardar(Unidad Unidad) {
		// TODO Auto-generated method stub

	}

	@Override
	public Unidad buscarporId(Long idunidad) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminar(Long idunidad) {
		// TODO Auto-generated method stub

	}

}
