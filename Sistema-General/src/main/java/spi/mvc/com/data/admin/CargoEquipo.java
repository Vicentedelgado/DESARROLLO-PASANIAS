package spi.mvc.com.data.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import spi.mvc.com.data.model.AsignacionEquipo;
import spi.mvc.com.data.model.RRHH;
import spi.mvc.com.data.service.IAsignacionEquipo;

@Controller
@RequestMapping("/views/admin/cargoequipo")
public class CargoEquipo {

	@Autowired
	private IAsignacionEquipo asignacionequipoService;
	
	
	@GetMapping("/")
	public String home() {
		
		return "/views/admin/cargoequipo/cargo";
	}
	
	@RequestMapping(value="/filtrar/{cedula}", method = RequestMethod.GET)
	public String Filtrar(@PathVariable("cedula") String cedula, Model model) {
		
		List<AsignacionEquipo> listadocedula = asignacionequipoService.filtrocedula(cedula);
		
		model.addAttribute("listadocedula", listadocedula);
		
		return  "/views/cargoequipo/cargo" ;
		
	}
	
	@RequestMapping(value="/filtrarpdf/{cedula}", method = RequestMethod.GET)
	public String FiltrarPdf(@PathVariable("cedula") String cedula, Model model) {
		
		List<AsignacionEquipo> listadocedulapdf = asignacionequipoService.filtrocedula(cedula);
		
		model.addAttribute("listadoc", listadocedulapdf);
		
		return  "/views/admin/cargoequipo/cargo" ;
		
	}
	
	@RequestMapping(value="/filtrar1/{idusuario}", method = RequestMethod.GET)
	public String Filtrar1(@PathVariable("idusuario") RRHH idusuario, Model model) {
		
		List<AsignacionEquipo> listausuario = asignacionequipoService.filtrousuario(idusuario);
		
		model.addAttribute("listadocedula", listausuario);
		
		return  "/views/admin/cargoequipo/cargo" ;
		
	}
	
	
	
	
}
