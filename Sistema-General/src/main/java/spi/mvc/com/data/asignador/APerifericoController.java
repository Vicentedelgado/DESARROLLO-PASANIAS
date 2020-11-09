package spi.mvc.com.data.asignador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import spi.mvc.com.data.model.AsignacionPeriferico;

import spi.mvc.com.data.model.Periferico;
import spi.mvc.com.data.model.RRHH;
import spi.mvc.com.data.service.IAsignacionPeriferico;

import spi.mvc.com.data.service.IPerifericoService;
import spi.mvc.com.data.service.IRRHHService;


@Controller
@RequestMapping("/views/asignador/perifericoasignacion")
public class APerifericoController {

	@Autowired
	private IAsignacionPeriferico asignacionperifericoService;

	
	//ASIGNACION DE FUNCIONARIO ////
	
	@Autowired
	private IRRHHService rrhhService;
	
	
	//ASIGNACION DE PERIFERICO ///
	
	@Autowired
	private IPerifericoService perifericoService;
	
	
	@GetMapping ("/")
	
	public String listarFuncionario(Model model) {
		
		List<AsignacionPeriferico> listadoAsignacionPeriferico = asignacionperifericoService.listarTodo();
		
		model.addAttribute("asignacionperiferico", listadoAsignacionPeriferico);
		
		return "/views/asignador/perifericoasignacion/Listarasignacionperiferico";
	}
	/////////////////////////////////////
	public String listarDatosFuncionario(Model model) {
	
	List<AsignacionPeriferico> listadoAsignacionPe = asignacionperifericoService.listarTodo();
	
	model.addAttribute("asignacionpe", listadoAsignacionPe);
	
	return "/views/asignador/perifericoasignacion/Listarasignacionperiferico";
	}
	///////////////////////////
	@RequestMapping(value="/filtrar1/{idasignacion}", method = RequestMethod.GET)
	public String Filtrar1(@PathVariable("idasignacion") Long idasignacion, Model model) {
		
		List<AsignacionPeriferico> listadoAsignacionP= asignacionperifericoService.filtronum(idasignacion);
		
		model.addAttribute("asignacionperiferico", listadoAsignacionP);
		
		return "/views/asignador/perifericoasignacion/Listarasignacionperiferico";
		
	}
	
	@GetMapping("/create")
	public String crear( Model model) {
	
		AsignacionPeriferico asignacionperiferico = new AsignacionPeriferico();
		List<RRHH> listarFuncionario = rrhhService.listarrrhh();
		List<Periferico> listarPeriferico = perifericoService.listarTodo();
		
		
		model.addAttribute("asignacionperiferico", asignacionperiferico);
		model.addAttribute("funcionario", listarFuncionario);
		model.addAttribute("periferico", listarPeriferico);

		
		return "/views/asignador/perifericoasignacion/formularioasignacionperiferico";
	}
	
		
	
	//////////////////////////////////////////////////////////
	
	@PostMapping("/save") 
	public String guardar(@ModelAttribute AsignacionPeriferico asignacion) {
		 
		
		 asignacionperifericoService.guardar(asignacion);
		 
	return "redirect:/views/asignador/perifericoasignacion/"; }
	
	//////////////////////////////////////////////////////////////
	
	
	@GetMapping("/edit/{idasignacion}")
	public String editar(@PathVariable("idasignacion") Long idAsignacion,Model model) {
		
		AsignacionPeriferico asignacionperiferico = asignacionperifericoService.buscarPorId(idAsignacion);
		List<RRHH> listarFuncionario = rrhhService.listarrrhh();
		List<Periferico> listarPeriferico = perifericoService.listarTodo();
				
			model.addAttribute("asignacionperiferico", asignacionperiferico);
			model.addAttribute("funcionario", listarFuncionario);
			model.addAttribute("periferico", listarPeriferico);
			
	
		return "/views/asignador/perifericoasignacion/formularioasignacionperiferico";
	}
}
