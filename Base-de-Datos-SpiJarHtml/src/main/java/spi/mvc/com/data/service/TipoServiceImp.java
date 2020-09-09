package spi.mvc.com.data.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import spi.mvc.com.data.model.Tipo;
import spi.mvc.com.data.repository.TipoRepository;

@Service
@Transactional
public class TipoServiceImp implements ITipoService {
	
	@Autowired
	private TipoRepository TipoRepository;

	@Override
	public List<Tipo> listatipos() {
		// TODO Auto-generated method stub
		return (List<Tipo>) TipoRepository.findAll();
	}

	@Override
	public void guardar(Tipo Tipo) {
		// TODO Auto-generated method stub

	}

	@Override
	public Tipo buscarporId(Long idtipo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminar(Long idtipo) {
		// TODO Auto-generated method stub

	}

}
