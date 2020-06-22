package spi.mvc.com.data.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spi.mvc.com.data.model.Zona;
import spi.mvc.com.data.repository.ZonaRepository;

@Service
public class ZonaServiceImp implements IZonaService {
	
	@Autowired
	private ZonaRepository ZonaRepository;

	@Override
	public List<Zona> listazona() {
		// TODO Auto-generated method stub
		return (List<Zona>) ZonaRepository.findAll();
	}

	@Override
	public void guardar(Zona Zona) {
		// TODO Auto-generated method stub

	}

	@Override
	public Zona buscarPorId(Long idzona) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminar(Long idzona) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Zona> listaporzona(Long idzona) {
		// TODO Auto-generated method stub
		return (List<Zona>) ZonaRepository.findAllById(null);
	}

}
