package spi.mvc.com.data.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import spi.mvc.com.data.model.Equipo;
import spi.mvc.com.data.repository.EquipoRepository;
import spi.mvc.com.data.service.IEquipoService;

@Service
@Transactional
public class EquipoServiceImpl implements IEquipoService {
	
	@Autowired
	private EquipoRepository equipoRepository;
	
	@Override
	public List<Equipo> listarTodo() {
		
		return (List<Equipo>) equipoRepository.findAll();
	}

	@Override
	public void guardar(Equipo equipo) {
	
		equipoRepository.save(equipo);
		
	}

	@Override
	public Equipo buscarPorId(Long idequipo) {

		return equipoRepository.findById(idequipo).orElse(null);
		
	}

	@Override
	public void eliminar(Long idequipo) {
		equipoRepository.deleteById(idequipo);
		
	}

}
