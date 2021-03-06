package spi.mvc.com.data.funcionario;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import spi.mvc.com.data.model.AsignacionPeriferico;
import spi.mvc.com.data.service.IAsignacionPeriferico;

@Controller
@RequestMapping("/views/funcionario/cargo")
public class FCargoController {

	@Autowired
	private IAsignacionPeriferico asignacionperifericoService;
	
	@GetMapping("/")
	public String home() {
		
		return "/views/funcionario/cargo/Cargoequipos";
	}
	
	
	
	@RequestMapping(value="/filtrar/{cedula}", method = RequestMethod.GET)
	public String Filtrar(@PathVariable("cedula") String cedula, Model model) {
		
		List<AsignacionPeriferico> listadocedula = asignacionperifericoService.filtrarcedula(cedula);
		
		model.addAttribute("listadocedula", listadocedula);
		
		return  "/views/funcionario/cargo/Cargoequipos" ;
	}
	
	@RequestMapping(value="/filtrarpdf/{cedula}", method = RequestMethod.GET)
	public String Filtrarpdf(@PathVariable("cedula") String cedula, Model model) {
		
		List<AsignacionPeriferico> listadocedulapdf = asignacionperifericoService.filtrarcedula(cedula);
		
		model.addAttribute("listadoc", listadocedulapdf);
		
		return  "/views/funcionario/cargo/Cargoequipos" ;
	}
	
	
}
