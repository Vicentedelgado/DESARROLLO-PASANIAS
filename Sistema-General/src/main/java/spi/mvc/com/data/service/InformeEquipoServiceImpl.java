package spi.mvc.com.data.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import spi.mvc.com.data.model.InformeEquipo;
import spi.mvc.com.data.repository.InformeEquipoRepository;
import spi.mvc.com.data.service.IInformeEquipoService;
@Service
@Transactional
public class InformeEquipoServiceImpl implements IInformeEquipoService {

	@Autowired
	private InformeEquipoRepository informeequipoRepository;
	
	
	@Override
	public List<InformeEquipo> listarTodo() {
		
		return (List<InformeEquipo>) informeequipoRepository.findAll();
		
	}

	@Override
	public void guardar(InformeEquipo informeequipo) {
		
		informeequipoRepository.save(informeequipo);

	}

	@Override
	public InformeEquipo buscarPorId(Long idinformeequipo) {

		
		return informeequipoRepository.findById(idinformeequipo).orElse(null);
	
	}

	@Override
	public void eliminar(Long idinformeequipo) {

		informeequipoRepository.deleteById(idinformeequipo);
		}
	@Override
	public List<InformeEquipo> filtronum(Long idinformeequipo) {
		// TODO Auto-generated method stub
		return (List<InformeEquipo>)informeequipoRepository.filtrarnum(idinformeequipo);
	}

}
