package spi.mvc.com.data.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import spi.mvc.com.data.model.Modalidad;
import spi.mvc.com.data.repository.ModalidadRepository;

@Service
@Transactional
public class ModalidadServiceImp implements IModalidadService {
	
	@Autowired
	private ModalidadRepository ModalidadRepository;

	@Override
	public List<Modalidad> listamodalidad() {
		// TODO Auto-generated method stub
		return (List<Modalidad>) ModalidadRepository.findAll();
	}

	@Override
	public void guardar(Modalidad Modalidad) {
		// TODO Auto-generated method stub

	}

	@Override
	public Modalidad buscarporId(Long idmodalidad) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminar(Long idmodalidad) {
		// TODO Auto-generated method stub

	}

}
