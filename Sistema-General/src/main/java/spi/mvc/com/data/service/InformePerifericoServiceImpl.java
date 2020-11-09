package spi.mvc.com.data.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import spi.mvc.com.data.model.InformePeriferico;
import spi.mvc.com.data.repository.InformePerifericoRepository;
import spi.mvc.com.data.service.IInformePerifericoService;

@Service
@Transactional
public class InformePerifericoServiceImpl implements IInformePerifericoService {

	@Autowired
	private InformePerifericoRepository informeperifericoRepository;
	
	///////////////////////////////////////////////////////////////////////
	
	@Override
	public List<InformePeriferico> listarTodo() {
		
		return (List<InformePeriferico>) informeperifericoRepository.findAll();
	}

	/////////////////////////////////////////////////////////////////////////
	@Override
	public void guardar(InformePeriferico informe) {
	
		informeperifericoRepository.save(informe);

	}

	////////////////////////////////////////////////////////////////////////
	@Override
	public InformePeriferico buscarPorId(Long idinforme) {
		
		return informeperifericoRepository.findById(idinforme).orElse(null);
	}
 
	/////////////////////////////////////////////////////////////////////////
	@Override
	public void eliminar(Long idinforme) {
		
		informeperifericoRepository.deleteById(idinforme);

	}
	@Override
	public List<InformePeriferico> filtronum(Long idinfome) {
		// TODO Auto-generated method stub
		return (List<InformePeriferico>)informeperifericoRepository.filtrarnum(idinfome);
	}

}
