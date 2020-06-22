package spi.mvc.com.data.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spi.mvc.com.data.model.RRHH;
import spi.mvc.com.data.model.SpiDatos;
import spi.mvc.com.data.repository.RRHHRepository;

@Service
public class RRHHServiceImp implements IRRHHService {
	
	@Autowired
	private RRHHRepository RRHHRepository;

	@Override
	public List<RRHH> listarrrhh() {
		// TODO Auto-generated method stub
		return (List<RRHH>) RRHHRepository.findAll();
	}

	@Override
	public void guardar(RRHH RRHH) {
		// TODO Auto-generated method stub
		RRHHRepository.save(RRHH);

	}

	@Override
	public RRHH buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return RRHHRepository.findById(id).orElse(null);
	}

	@Override
	public void eliminar(Long id) {
		// TODO Auto-generated method stub
		RRHHRepository.deleteById(id);

	}

	@Override
	public List<RRHH> Listaporspirrhh(SpiDatos idspi) {
		// TODO Auto-generated method stub
		return RRHHRepository.Listaporspirrhh(idspi);
	}

}
