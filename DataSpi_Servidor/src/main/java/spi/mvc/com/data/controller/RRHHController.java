package spi.mvc.com.data.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import spi.mvc.com.data.model.RRHH;
import spi.mvc.com.data.model.SpiDatos;
import spi.mvc.com.data.model.Zona;
import spi.mvc.com.data.model.Unidad;
import spi.mvc.com.data.model.Modalidad;
import spi.mvc.com.data.service.IRRHHService;
import spi.mvc.com.data.service.IZonaService;
import spi.mvc.com.data.service.ISpiDatosService;
import spi.mvc.com.data.service.IUnidadService;
import spi.mvc.com.data.service.IModalidadService;

@Controller
@RequestMapping("/views/DataSpi/RRHH")
public class RRHHController {
	
	@Autowired
	private IRRHHService IRRHHService;
	@Autowired
	private IZonaService IZonaService;
	@Autowired
	private ISpiDatosService ISpiDatosService;
	@Autowired
	private IUnidadService IUnidadService;
	@Autowired
	private IModalidadService IModalidadService;
	
	@GetMapping("/")
	public String listarCantones(Model model,@ModelAttribute("idzona") Zona idzona) {
		List<RRHH> listarrhh=IRRHHService.listarrrhh();
		model.addAttribute("titulo","Lista del Recurso Humano de los SPI ");
		model.addAttribute("listarrhh",listarrhh);
		//CREAR FORMULARIO REGISTRO DE VENTANA MODAL spidatos.html
		Zona zona= new Zona();
		RRHH rrhh=new RRHH();
		List<Zona> listazona=IZonaService.listazona();
		List<SpiDatos> listaspi=ISpiDatosService.listaspidatos();
		List<Unidad> listaunidad=IUnidadService.listaunidad();
		List<Modalidad> listamodalidad=IModalidadService.listamodalidad();
		model.addAttribute("titulo1","Formulario: Nuevo Registro de funcionario");
		model.addAttribute("titulo2","Formulario: Editar Registro de funcionario");
		model.addAttribute("rrhh",rrhh);
		model.addAttribute("listazona",listazona);
		model.addAttribute("listaspi",listaspi);
		model.addAttribute("zona",zona);
		model.addAttribute("listaunidad",listaunidad);
		model.addAttribute("listamodalidad",listamodalidad);
		return "/views/DataSpi/RRHH/rrhh";	
	}
	
	//GUARDAR
	@PostMapping("/save")
	public String guardar(@Valid @ModelAttribute RRHH rrhh, BindingResult result, RedirectAttributes alerta) {
		
		if(result.hasErrors()) {
			System.out.print("HUBO ERRORES EN EL FORMULARIO RRHH");
			return "views/DataSpi/RRHH/rrhh";
		}
		IRRHHService.guardar(rrhh);
		System.out.print("REGISTRO RRHH GUARDADO CON ÉXITO");
		alerta.addFlashAttribute("success", "REGISTRO RRHH GUARDADO CON ÉXITO");
		return "redirect:/views/DataSpi/RRHH/";
	}
	
	//EDITAR MODAL
	@GetMapping("/edit")
	@ResponseBody
	public RRHH editar(Long idusuario) {
		return IRRHHService.buscarPorId(idusuario);
	}
	
	//ELEGIR SPI POR ZONA (FILTRAR)
	@RequestMapping(value="/Elegirspi",method = RequestMethod.GET)
	public @ResponseBody List<SpiDatos> BuscarporZona(@RequestParam(value ="idzona", required = true) Zona idzona){
		return ISpiDatosService.FindByZona(idzona); 
	}
	

}
