package spi.mvc.com.data.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import spi.mvc.com.data.model.Equipo;
import spi.mvc.com.data.model.Software;
import spi.mvc.com.data.service.IEquipoService;
import spi.mvc.com.data.service.ISoftwareService;

@Controller
@RequestMapping("/views/admin/software")
public class SoftwareController {
	
	@Autowired	
	private ISoftwareService softwareService;

	@Autowired	
	private IEquipoService equipoService;
	
	/////////////////////////////////////////////////////////////////
	
	
	@GetMapping ("/")
	public String listarSoftware(Model model) {
		
		List<Software> listadoSoftware = softwareService.listarTodo();
		
		model.addAttribute("software", listadoSoftware);
		
		return "/views/admin/software/Listarsoftware";
	}
	
	/////////////////////////////////////////////////////////////////////////////
	@GetMapping ("/create")
	public String crear(Model model) {
	
	Software software = new Software();
	List<Equipo>listarEquipo = equipoService.listarTodo();
	
	model.addAttribute("software", software);
	model.addAttribute("equipo", listarEquipo);
	
	return "/views/admin/software/formulariosoftware";
	}
	
	
	
	///////////////////////////////////////////////////////////////////////
	
	@PostMapping("/save") 
	public String guardar(@ModelAttribute Software software) {
	softwareService.guardar(software);
	return "redirect:/views/admin/software/";
	}
	
	
	////////////////////////////////////////////////////////////////////////
	
	@GetMapping("/edit/{idsoftware}")
	public String editar(@PathVariable("idsoftware") Long idSoftware,Model model) {
	
	Software software = softwareService.buscarPorId(idSoftware);
	List<Equipo>listarEquipo = equipoService.listarTodo();
	
	model.addAttribute("software", software);
	model.addAttribute("equipo", listarEquipo);
	
	return "/views/admin/software/formulariosoftware";
	}
	
	
	
	
	/////////////////////////////////////////////////////////////////////////
	
	
	@GetMapping("/delete/{idsoftware}")
	public String eliminar(@PathVariable("idsoftware") Long idSoftware) {
	
	softwareService.eliminar(idSoftware);
	
	return "redirect:/views/admin/software/";
	}

}
