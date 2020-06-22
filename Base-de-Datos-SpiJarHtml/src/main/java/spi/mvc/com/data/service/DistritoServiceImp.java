package spi.mvc.com.data.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spi.mvc.com.data.model.Distrito;
import spi.mvc.com.data.repository.DistritoRepository;


@Service
public class DistritoServiceImp implements IDistritoService {
	
	@Autowired
	private DistritoRepository DistritoRepository;

	@Override
	public List<Distrito> listadistrito() {
		// TODO Auto-generated method stub
		return (List<Distrito>) DistritoRepository.findAll();
	}

	@Override
	public void guardar(Distrito Distrito) {
		// TODO Auto-generated method stub

	}

	@Override
	public Distrito buscarPorId(Long iddistrito) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminar(Long iddistrito) {
		// TODO Auto-generated method stub

	}

}
