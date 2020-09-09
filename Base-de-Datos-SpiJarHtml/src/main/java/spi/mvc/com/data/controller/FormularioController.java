package spi.mvc.com.data.controller;

import java.util.List;

//import javax.servlet.ServletContext;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import spi.mvc.com.data.model.Activo;
import spi.mvc.com.data.model.Institucion;
import spi.mvc.com.data.model.RRHH;
import spi.mvc.com.data.model.RegistrodelSpi;
import spi.mvc.com.data.model.SpiDatos;
import spi.mvc.com.data.model.Tipo;
import spi.mvc.com.data.model.Zona;
import spi.mvc.com.data.service.IActivoService;
import spi.mvc.com.data.service.IInstitucionService;
import spi.mvc.com.data.service.IRRHHService;
import spi.mvc.com.data.service.IRegistroDelSpiService;
import spi.mvc.com.data.service.ISpiDatosService;
import spi.mvc.com.data.service.IZonaService;
import spi.mvc.com.data.service.ITipoService;

@Controller
@RequestMapping("/views/Formulario")
public class FormularioController {
	
	@Autowired
	private IRRHHService IRRHHService;
	@Autowired
	private ISpiDatosService ISpiDatosService;
	@Autowired
	private IRegistroDelSpiService IRegistroDelSpiService;
	@Autowired
	private IZonaService IZonaService;
	@Autowired
	private IActivoService IActivoService;
	@Autowired
	private IInstitucionService IInstitucionService;
	@Autowired
	private ITipoService ITipoService; 
		
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String inicio(Model model, @ModelAttribute("idzona") Zona idzona, @ModelAttribute("idspi") SpiDatos idspi, @ModelAttribute("idtipo") Tipo idtipo) {
		//títulos cards
		model.addAttribute("titulo","Modelo de Gestión Administrativa SPI");
		model.addAttribute("titulo1","DATOS GENERALES");
		model.addAttribute("titulo2","RECURSO HUMANO");
		model.addAttribute("titulo3","CARACTERÍSTICAS DEL INMUEBLE");
		model.addAttribute("titulo4","REGISTRO DE BIENES");
		model.addAttribute("titulo5","CONECTIVIDAD");
		model.addAttribute("titulo6","RELACIONAMIENTO CON ACTORES");
		model.addAttribute("titulo7","-----");
		model.addAttribute("titulo8","BÚSQUEDA");
		model.addAttribute("titulo9","Formulario: Editar Registro");
		model.addAttribute("titulo10","Formulario: Nuevo Registro");
		//Llenar select filtrar spi
		Zona zona= new Zona();
		List<Zona> listazona=IZonaService.listazona();
		List<SpiDatos> listaspi= ISpiDatosService.listaspidatos();
		model.addAttribute("zona",zona);
		model.addAttribute("listazona",listazona);
		model.addAttribute("listaspi",listaspi);
		//Objeto Registo del Spi
		RegistrodelSpi registrodelspi=new RegistrodelSpi(); 
		model.addAttribute("registrodelspi",registrodelspi);
		//Llenar modal Editar y guardar
		Tipo tipo= new Tipo();
		List<Activo>listaactivo=IActivoService.listaactivo();
		List<Institucion>listainstitucion=IInstitucionService.listainstitucion();
		List<Tipo>listatipo= ITipoService.listatipos();
		model.addAttribute("tipo",tipo);
		model.addAttribute("listaactivo",listaactivo);
		model.addAttribute("listainstitucion",listainstitucion); 
		model.addAttribute("listatipo",listatipo);
		
		return "/views/Formulario/formulario";	
	}
	
	//LLENAR FORMULARIO
	@RequestMapping(value="/listaporspi/{idspi}", method=RequestMethod.GET)
	public String Listaporspi(@PathVariable("idspi") Long idspi,@PathVariable("idspi") SpiDatos idspi1, Model model, @ModelAttribute("idzona") Zona idzona, @ModelAttribute("idtipo") Tipo idtipo){
		//títulos cards
		model.addAttribute("titulo","Modelo de Gestión Administrativa SPI");
		model.addAttribute("titulo1","DATOS GENERALES");
		model.addAttribute("titulo2","RECURSO HUMANO");
		model.addAttribute("titulo3","CARACTERÍSTICAS DEL INMUEBLE");
		model.addAttribute("titulo4","REGISTRO DE BIENES");
		model.addAttribute("titulo5","CONECTIVIDAD");
		model.addAttribute("titulo6","RELACIONAMIENTO CON ACTORES");
		model.addAttribute("titulo7","-----");
		model.addAttribute("titulo8","BÚSQUEDA");
		model.addAttribute("titulo9","Formulario: Editar Registro");
		model.addAttribute("titulo10","Formulario: Nuevo Registro");
		//Objeto Registo del Spi
		RegistrodelSpi registrodelspi=new RegistrodelSpi(); 
		model.addAttribute("registrodelspi",registrodelspi);
		//Llenar select filtrar spi
		Zona zona= new Zona();
		List<Zona> listazona=IZonaService.listazona();
		List<SpiDatos> listaspi= ISpiDatosService.listaspidatos();
		model.addAttribute("zona",zona);
		model.addAttribute("listazona",listazona);
		model.addAttribute("listaspi",listaspi);
		//Llenar modal Editar y guardar
		Tipo tipo= new Tipo();
		List<Activo>listaactivo=IActivoService.listaactivo();
		List<Institucion>listainstitucion=IInstitucionService.listainstitucion();
		List<Tipo>listatipo= ITipoService.listatipos();
		model.addAttribute("tipo",tipo);
		model.addAttribute("listaactivo",listaactivo);
		model.addAttribute("listainstitucion",listainstitucion);
		model.addAttribute("listatipo",listatipo);
		//Tabla llenado de SpiDatos
		List<SpiDatos> listaspi1=ISpiDatosService.Listaporspi(idspi);
		model.addAttribute("listaspi1",listaspi1);
		//Tabla llenado de RRHH
		List<RRHH> listarrhh=IRRHHService.Listaporspirrhh(idspi1);
		model.addAttribute("listarrhh",listarrhh);
		//Tabla llenado de Registro del spi instalaciones
		List<RegistrodelSpi> listaregistrodelspiinstalaciones=IRegistroDelSpiService.Listaregistrodelspiinstalaciones(idspi1);
		model.addAttribute("listaregistrodelspiinstalaciones",listaregistrodelspiinstalaciones);
		//Tabla llenado de Registro del spi bienes
		List<RegistrodelSpi> listaregistrodelspibienes=IRegistroDelSpiService.Listaregistrodelspibienes(idspi1);
		model.addAttribute("listaregistrodelspibienes",listaregistrodelspibienes);
		//Tabla llenado de Registro del spi equipos
		List<RegistrodelSpi> listaregistrodelspiequipos=IRegistroDelSpiService.Listaregistrodelspiequipos(idspi1);
		model.addAttribute("listaregistrodelspiequipos",listaregistrodelspiequipos);
		//Tabla llenado de Registro del spi otros
		List<RegistrodelSpi> listaregistrodelspiotros=IRegistroDelSpiService.Listaregistrodelspiotros(idspi1);
		model.addAttribute("listaregistrodelspiotros",listaregistrodelspiotros);
		//Tabla llenado de Registro del spi movilidad
		List<RegistrodelSpi> listaregistrodelspimovilidad=IRegistroDelSpiService.Listaregistrodelspimovilidad(idspi1);
		model.addAttribute("listaregistrodelspimovilidad",listaregistrodelspimovilidad);
		//Tabla llenado de Registro del spi conectividad
		List<RegistrodelSpi> listaregistrodelspiconectividad=IRegistroDelSpiService.Listaregistrodelspiconectividad(idspi1);
		model.addAttribute("listaregistrodelspiconectividad",listaregistrodelspiconectividad);
		
		return "/views/Formulario/formulario";
	}
	
	//ELEGIR SPI POR ZONA (FILTRAR)
	@RequestMapping(value="/Elegirspi",method = RequestMethod.GET)
	public @ResponseBody List<SpiDatos> BuscarporZona(@RequestParam(value ="idzona", required = true) Zona idzona){
		return ISpiDatosService.FindByZona(idzona); 
	}
	
	//ELEGIR SPI POR TIPO (FILTRAR)
	@RequestMapping(value="/Elegiractivo",method = RequestMethod.GET)
	public @ResponseBody List<Activo> BuscarporTipo(@RequestParam(value ="idtipo", required = true) Tipo idtipo){
		return IActivoService.Buscarportipo(idtipo); 
	}
	
	//GUARDAR
	@PostMapping("listaporspi/save")
	public String guardar(@Valid @ModelAttribute RegistrodelSpi registrodelspi, BindingResult result, Model model, RedirectAttributes alerta) {
		
		Long spi=registrodelspi.getIdspi().getIdspi();
		
		if(result.hasErrors()) {
			System.out.print("Errores en el formulario por favor revice los campos");
			return "/views/Formulario/listaporspi/" +spi;
		}
		
		IRegistroDelSpiService.guardar(registrodelspi);
		System.out.print("REGISTRO GUARDADO CON EXITO");
		alerta.addFlashAttribute("success", "REGISTRO GUARDADO CON EXITO");
		
		System.out.print("IMPRIMIENDO VALOR " +spi);
		return "redirect:/views/Formulario/listaporspi/" + spi;
	}
	
	//EDITAR MODAL
	@GetMapping("listaporspi/edit/")
	@ResponseBody
	public RegistrodelSpi editar( Long idregistro) {
		RegistrodelSpi registrodelspi = IRegistroDelSpiService.buscarPorId(idregistro);
		return registrodelspi;
	}
			

}
