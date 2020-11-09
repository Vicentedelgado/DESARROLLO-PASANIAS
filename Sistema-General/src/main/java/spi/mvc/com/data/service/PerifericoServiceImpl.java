package spi.mvc.com.data.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import spi.mvc.com.data.model.Periferico;
import spi.mvc.com.data.repository.PerifericoRepository;
import spi.mvc.com.data.service.IPerifericoService;

@Service
@Transactional
public class PerifericoServiceImpl implements IPerifericoService {

	@Autowired
	private PerifericoRepository perifericoRepository;
	
	@Override
	public List<Periferico> listarTodo() {
		return (List<Periferico>) perifericoRepository.findAll();
	}

	@Override
	public void guardar(Periferico periferico) {
		perifericoRepository.save(periferico);

	}

	@Override
	public Periferico buscarPorId(Long idperiferico) {
		return perifericoRepository.findById(idperiferico).orElse(null);
	}

	@Override
	public void eliminar(Long idperiferico) {
		perifericoRepository.deleteById(idperiferico);
	}

}
