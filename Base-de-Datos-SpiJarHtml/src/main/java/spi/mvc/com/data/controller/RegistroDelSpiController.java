package spi.mvc.com.data.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import spi.mvc.com.data.model.Activo;
import spi.mvc.com.data.model.Institucion;
import spi.mvc.com.data.model.RegistrodelSpi;
import spi.mvc.com.data.model.SpiDatos;
import spi.mvc.com.data.service.IRegistroDelSpiService;
import spi.mvc.com.data.service.IActivoService;
import spi.mvc.com.data.service.ISpiDatosService;
import spi.mvc.com.data.service.IInstitucionService;

@Controller
@RequestMapping("/views/RegistroDelSpi")
public class RegistroDelSpiController {
	
	@Autowired
	private IRegistroDelSpiService IRegistroDelSpiService;
	@Autowired
	private IActivoService IActivoService;
	@Autowired
	private ISpiDatosService ISpiDatosService;
	@Autowired
	private IInstitucionService IInstitucionService;
	
	
	//LISTAR
	@GetMapping("/")
	public String listarCantones(Model model) {
		List<RegistrodelSpi> listaregistrodelspi=IRegistroDelSpiService.listarregistro();
		model.addAttribute("titulo","Lista de Bienes del Spi ");
		model.addAttribute("listaregistrodelspi",listaregistrodelspi);
		//CREAR FORMULARIO REGISTRO DE VENTANA MODAL registrodelspi.html
		  RegistrodelSpi registrodelspi=new RegistrodelSpi(); 
		  List<Activo>listaactivo=IActivoService.listaactivo(); 
		  List<SpiDatos>listaspi=ISpiDatosService.listaspidatos(); 
		  List<Institucion>listainstitucion=IInstitucionService.listainstitucion();
		  model.addAttribute("titulo1","Formulario: Nuevo Registro");
		  model.addAttribute("titulo2","Formulario: Editar Registro");
		  model.addAttribute("registrodelspi",registrodelspi);
		  model.addAttribute("listaactivo",listaactivo);
		  model.addAttribute("listaspi",listaspi);
		  model.addAttribute("listainstitucion",listainstitucion);  
		return "/views/RegistroDelSpi/registrodelspi";	
	}
	
	//CREAR FORMULARIO REGISTRO
	@GetMapping("/create")
	public String crear(Model model) {
		RegistrodelSpi registrodelspi=new RegistrodelSpi();
		List<Activo> listaactivo=IActivoService.listaactivo();
		List<SpiDatos> listaspi=ISpiDatosService.listaspidatos();
		List<Institucion> listainstitucion=IInstitucionService.listainstitucion();
		model.addAttribute("titulo","Formulario: Nuevo Registro");
		model.addAttribute("registrodelspi",registrodelspi);
		model.addAttribute("listaactivo",listaactivo);
		model.addAttribute("listaspi",listaspi);
		model.addAttribute("listainstitucion",listainstitucion);
		return "/views/RegistroDelSpi/frmRegistro";
	}
	
	
	//GUARDAR
	@PostMapping("/save")
	public String guardar(@ModelAttribute RegistrodelSpi registrodelspi) {
		IRegistroDelSpiService.guardar(registrodelspi);
		System.out.print("REGISTRO GUARDADO");
		return "redirect:/views/RegistroDelSpi/";
	}
	
	//EDITAR MODAL
	@GetMapping("/edit/")
	@ResponseBody
	public RegistrodelSpi editar( Long idregistro) {
		RegistrodelSpi registrodelspi = IRegistroDelSpiService.buscarPorId(idregistro);
		return registrodelspi;
	}
	
	//EDITAR
	/*
	 * @GetMapping("/editar/{idregistro}")
	 * 
	 * @ResponseBody public String editar(@PathVariable("idregistro") Long
	 * idregistro, Model model) { RegistrodelSpi registrodelspi =
	 * IRegistroDelSpiService.buscarPorId(idregistro); List<Activo> listaactivo =
	 * IActivoService.listaactivo(); List<SpiDatos> listaspi =
	 * ISpiDatosService.listaspidatos(); List<Institucion> listainstitucion =
	 * IInstitucionService.listainstitucion(); model.addAttribute("titulo",
	 * "Formulario: Editar Registro"); model.addAttribute("registrodelspi",
	 * registrodelspi); model.addAttribute("listaactivo", listaactivo);
	 * model.addAttribute("listaspi", listaspi);
	 * model.addAttribute("listainstitucion", listainstitucion); return
	 * "/views/RegistroDelSpi/"; }
	 */
 
	@GetMapping("/editar/{idregistro}")
	public String editar(@PathVariable("idregistro") Long idregistro, Model model) {
		RegistrodelSpi registrodelspi = IRegistroDelSpiService.buscarPorId(idregistro);
		model.addAttribute("registrodelspi", registrodelspi);
		return "/views/RegistroDelSpi/frmRegistro";
	} 
	
	
	
	
	

}
