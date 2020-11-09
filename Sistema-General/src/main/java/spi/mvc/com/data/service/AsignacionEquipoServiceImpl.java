package spi.mvc.com.data.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import spi.mvc.com.data.model.AsignacionEquipo;
import spi.mvc.com.data.model.RRHH;
import spi.mvc.com.data.repository.AsignacionEquipoRepository;
import spi.mvc.com.data.service.IAsignacionEquipo;
@Service
@Transactional
public class AsignacionEquipoServiceImpl implements IAsignacionEquipo {

	
	@Autowired
	private AsignacionEquipoRepository asignacionequipoRepository;
	
	
	@Override
	public List<AsignacionEquipo> listarTodo() {
		
		return (List<AsignacionEquipo>)asignacionequipoRepository.findAll();
	}

	@Override
	public void guardar(AsignacionEquipo asignacionequipo) {
		
		asignacionequipoRepository.save(asignacionequipo);
	}

	@Override
	public AsignacionEquipo buscarPorId(Long idasignacionequipo) {
		
		return asignacionequipoRepository.findById(idasignacionequipo).orElse(null);
	}

	@Override
	public void eliminar(Long idasignacionequipo) {
		
		asignacionequipoRepository.deleteById(idasignacionequipo);
	}

	@Override
	public List<AsignacionEquipo> filtrocedula(String cedula) {
		// TODO Auto-generated method stub
		return (List<AsignacionEquipo>)asignacionequipoRepository.filtrocedula(cedula);
	}

	@Override
	public List<AsignacionEquipo> filtrousuario(RRHH idusuario) {
		// TODO Auto-generated method stub
		return (List<AsignacionEquipo>)asignacionequipoRepository.filtrousuario(idusuario);
	}
	@Override
	public List<AsignacionEquipo> filtronum(Long idasignacionequipo) {
		// TODO Auto-generated method stub
		return (List<AsignacionEquipo>)asignacionequipoRepository.filtrarnum(idasignacionequipo);
	}

}
