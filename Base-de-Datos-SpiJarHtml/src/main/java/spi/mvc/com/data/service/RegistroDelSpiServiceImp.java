package spi.mvc.com.data.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spi.mvc.com.data.model.RegistrodelSpi;
import spi.mvc.com.data.model.SpiDatos;
import spi.mvc.com.data.repository.RegistroDelSpiRepository;

@Service
public class RegistroDelSpiServiceImp implements IRegistroDelSpiService {
	
	@Autowired
	private RegistroDelSpiRepository  RegistroDelSpiRepository;

	@Override
	public List<RegistrodelSpi> listarregistro() {
		
		return (List<RegistrodelSpi>) RegistroDelSpiRepository.findAll();
	}

	@Override
	public void guardar(RegistrodelSpi RegistrodelSpi) {
		
		RegistroDelSpiRepository.save(RegistrodelSpi);

	}
	@Override
	public void guardartodos(List<RegistrodelSpi> RegistrodelSpi) {
		// TODO Auto-generated method stub
		RegistroDelSpiRepository.saveAll(RegistrodelSpi);
	}

	@Override
	public RegistrodelSpi buscarPorId(Long idregistro) {
		
		return RegistroDelSpiRepository.findById(idregistro).orElse(null);
	}
	
	
	@Override
	public void eliminar(Long idregistro) {
		
		RegistroDelSpiRepository.deleteById(idregistro);

	}

	@Override
	public List<RegistrodelSpi> Listaregistrodelspiinstalaciones(SpiDatos idspi) {
		// TODO Auto-generated method stub
		return (List<RegistrodelSpi>) RegistroDelSpiRepository.Listaregistrodelspiinstalaciones(idspi);
	}

	@Override
	public List<RegistrodelSpi> Listaregistrodelspibienes(SpiDatos idspi) {
		// TODO Auto-generated method stub
		return (List<RegistrodelSpi>) RegistroDelSpiRepository.Listaregistrodelspibienes(idspi);
	}

	@Override
	public List<RegistrodelSpi> Listaregistrodelspiequipos(SpiDatos idspi) {
		// TODO Auto-generated method stub
		return (List<RegistrodelSpi>) RegistroDelSpiRepository.Listaregistrodelspiequipos(idspi);
	}

	@Override
	public List<RegistrodelSpi> Listaregistrodelspiotros(SpiDatos idspi) {
		// TODO Auto-generated method stub
		return (List<RegistrodelSpi>) RegistroDelSpiRepository.Listaregistrodelspiotros(idspi);
	}

	@Override
	public List<RegistrodelSpi> Listaregistrodelspimovilidad(SpiDatos idspi) {
		// TODO Auto-generated method stub
		return (List<RegistrodelSpi>) RegistroDelSpiRepository.Listaregistrodelspimovilidad(idspi);
	}

	@Override
	public List<RegistrodelSpi> Listaregistrodelspiconectividad(SpiDatos idspi) {
		// TODO Auto-generated method stub
		return (List<RegistrodelSpi>) RegistroDelSpiRepository.Listaregistrodelspiconectividad(idspi);
	}
	

}
