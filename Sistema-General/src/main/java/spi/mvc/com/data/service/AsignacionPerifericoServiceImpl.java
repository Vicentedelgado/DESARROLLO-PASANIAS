/**
 * 
 */
package spi.mvc.com.data.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import spi.mvc.com.data.model.AsignacionPeriferico;
import spi.mvc.com.data.repository.AsignacionPerifericoRepository;
import spi.mvc.com.data.service.IAsignacionPeriferico;

/**
 * @author Vicente DElgado
 *
 */
@Service
@Transactional
public class AsignacionPerifericoServiceImpl implements IAsignacionPeriferico {

	
	@Autowired
	private AsignacionPerifericoRepository asignacionperifericoRepository;
	
	
	@Override
	public List<AsignacionPeriferico> listarTodo() {
		
		return (List<AsignacionPeriferico>)asignacionperifericoRepository.findAll();
	}

	@Override
	public void guardar(AsignacionPeriferico asignacion) {
		
		
		asignacionperifericoRepository.save(asignacion);
	}

	@Override
	public AsignacionPeriferico buscarPorId(Long idasignacion) {
		
		return asignacionperifericoRepository.findById(idasignacion).orElse(null);
	}

	@Override
	public void eliminar(Long idasignacion) {
		
		asignacionperifericoRepository.deleteById(idasignacion);

	}

	@Override
	public List<AsignacionPeriferico> filtrarcedula(String cedula) {
	
		return (List<AsignacionPeriferico>)asignacionperifericoRepository.filtrarcedula(cedula);
	}

	@Override
	public List<AsignacionPeriferico> filtronum(Long idasignacion) {
		// TODO Auto-generated method stub
		return (List<AsignacionPeriferico>)asignacionperifericoRepository.filtrarnum(idasignacion);
	}

}
