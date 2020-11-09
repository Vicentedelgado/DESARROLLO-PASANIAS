package spi.mvc.com.data.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spi.mvc.com.data.model.Institucion;
import spi.mvc.com.data.repository.InstitucionRepository;

@Service
public class InstitucionServiceImp implements IInstitucionService {
	
	@Autowired
	private InstitucionRepository InstitucionRepository;

	@Override
	public List<Institucion> listainstitucion() {
		// TODO Auto-generated method stub
		return (List<Institucion>) InstitucionRepository.findAll();
	}

	@Override
	public void guardar(Institucion Institucion) {
		// TODO Auto-generated method stub

	}

	@Override
	public Institucion buscarPorId(Long idinstitucion) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminar(Long idinstitucion) {
		// TODO Auto-generated method stub

	}

}
