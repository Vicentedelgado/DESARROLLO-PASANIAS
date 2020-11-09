package spi.mvc.com.data.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import spi.mvc.com.data.model.Software;
import spi.mvc.com.data.repository.SoftwareRepository;
import spi.mvc.com.data.service.ISoftwareService;
@Service
@Transactional
public class SoftwareServiceImpl implements ISoftwareService {

	@Autowired
	private SoftwareRepository softwareRepository;
	
	
	@Override
	public List<Software> listarTodo() {
	
		return (List<Software>) softwareRepository.findAll();
		
	}

	@Override
	public void guardar(Software software) {
	
		 softwareRepository.save(software);
			
	}

	@Override
	public Software buscarPorId(Long idsoftware) {

		return softwareRepository.findById(idsoftware).orElse(null);
		}

	@Override
	public void eliminar(Long idsoftware) {
		softwareRepository.deleteById(idsoftware);
		}

}
