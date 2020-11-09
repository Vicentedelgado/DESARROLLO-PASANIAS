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

import spi.mvc.com.data.model.AsignacionEquipo;
import spi.mvc.com.data.model.Equipo;
import spi.mvc.com.data.model.RRHH;
import spi.mvc.com.data.service.IAsignacionEquipo;
import spi.mvc.com.data.service.IEquipoService;

import spi.mvc.com.data.service.IRRHHService;

@Controller
@RequestMapping("/views/asignador/equipoasignacion")
public class AEquipoController{

	@Autowired
	private IAsignacionEquipo asignacionequipoService;
	
	//ASIGNACION DE FUNCIONARIO ////
	
		@Autowired
		private IRRHHService rrhhService;
		
		
		//ASIGNACION DE EQUIPO ///
		
		@Autowired
		private IEquipoService equipoService;
		
		//////////////////////////////////////////////////////////}
		
		@GetMapping ("/")
		
		public String listarFuncionario(Model model) {
			
			List<AsignacionEquipo> listadoAsignacionEquipo = asignacionequipoService.listarTodo();
			
			model.addAttribute("asignacionequipo", listadoAsignacionEquipo);
			
			return "/views/asignador/equipoasignacion/Listarasignacionequipo";
		}
		////////////////////
		public String listarDatosFuncionario(Model model) {
					
					List<AsignacionEquipo> listadoAsignacionEq = asignacionequipoService.listarTodo();
					
					model.addAttribute("asignacioneq", listadoAsignacionEq);
					
					return "/views/asignador/equipoasignacion/Listarasignacionequipo";
				}
		////////////////
		
		@RequestMapping(value="/filtrar1/{idasignacion}", method = RequestMethod.GET)
		public String Filtrar1(@PathVariable("idasignacion") Long idasignacionequipo, Model model) {
			
			List<AsignacionEquipo> listadoAsignacionE= asignacionequipoService.filtronum(idasignacionequipo);
			
			model.addAttribute("asignacionequipo", listadoAsignacionE);
			
			return "/views/asignador/equipoasignacion/Listarasignacionequipo";
			
		}
	////////////////////////////////////////////////////////
			
	@GetMapping("/create")
	public String crear(Model model) {
	
	AsignacionEquipo asignacionequipo = new AsignacionEquipo();
	List<RRHH> listarFuncionario = rrhhService.listarrrhh();
	List<Equipo> listarEquipo = equipoService.listarTodo();
	
	
	model.addAttribute("asignacionequipo", asignacionequipo);
	model.addAttribute("funcionario", listarFuncionario);
	model.addAttribute("equipo", listarEquipo);
	
	
	return "/views/asignador/equipoasignacion/formularioasignacionequipo";
	}
	
	///////////////////////////////////////////////////////////////
	@PostMapping("/save") 
	public String guardar(@ModelAttribute AsignacionEquipo asignacionequipo) {
		 
		
		 asignacionequipoService.guardar(asignacionequipo);
		 
	return "redirect:/views/asignador/equipoasignacion/"; }
	
	//////////////////////////////////////////////////////////////
	

	@GetMapping("/edit/{idasignacion}")
	public String editar(@PathVariable("idasignacion") Long idAsignacion,Model model) {
		
		AsignacionEquipo asignacionequipo = asignacionequipoService.buscarPorId(idAsignacion);
		List<RRHH> listarFuncionario = rrhhService.listarrrhh();
		List<Equipo> listarEquipo = equipoService.listarTodo();		
			
		
		model.addAttribute("asignacionequipo", asignacionequipo);
		model.addAttribute("funcionario", listarFuncionario);
		model.addAttribute("equipo", listarEquipo);
	
		return "/views/asignador/equipoasignacion/formularioasignacionequipo";
	}
	
}
