package spi.mvc.com.data.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import spi.mvc.com.data.model.Institucion;
import spi.mvc.com.data.model.SpiDatos;
import spi.mvc.com.data.model.Zona;
import spi.mvc.com.data.service.IInstitucionService;
import spi.mvc.com.data.service.ISpiDatosService;
import spi.mvc.com.data.service.IZonaService;

@Controller
@RequestMapping("/views/SpiDatos")
public class SpiDatosController {
	
	@Autowired
	private ISpiDatosService ISpiDatosService;
	@Autowired
	private IZonaService IZonaService;
	@Autowired
	private IInstitucionService IInstitucionService;
	
	@GetMapping("/")
	public String listarSpiDatos(Model model) {
		List<SpiDatos> listaSpiDatos= ISpiDatosService.listaspidatos();
		model.addAttribute("titulo","Lista Spi Datos");
		model.addAttribute("listaspidatos",listaSpiDatos);
		//CREAR FORMULARIO REGISTRO DE VENTANA MODAL spidatos.html
		SpiDatos spidatos=new SpiDatos();
		List<Zona> listazona=IZonaService.listazona();
		List<Institucion> listainstitucion=IInstitucionService.listainstitucion();
		model.addAttribute("titulo1","Formulario: Nuevo Registro de Spi");
		model.addAttribute("titulo2","Formulario: Editar Registro de Spi");
		model.addAttribute("spidatos",spidatos);
		model.addAttribute("listazona",listazona);
		model.addAttribute("listainstitucion",listainstitucion);
		return "/views/SpiDatos/spidatos";
	}
	
	//GUARDAR
		@PostMapping("/save")
		public String guardar(@ModelAttribute SpiDatos spidatos) {
			ISpiDatosService.guardar(spidatos);
			System.out.print("REGISTRO GUARDADO");
			return "redirect:/views/SpiDatos/";
		}
		
	/*
	 * @GetMapping("/edit/{idspi}")
	 * 
	 * @ResponseBody public String editar(@PathVariable("idspi") Long idspi, Model
	 * model) { SpiDatos spidatos1= ISpiDatosService.buscarPorId(idspi);
	 * model.addAttribute("titulo8","Formulario: Editar Registro de Spi");
	 * model.addAttribute("spidatos1",spidatos1); return "/views/SpiDatos/spidatos";
	 * }
	 */
	
	//EDITAR MODAL
	@GetMapping("/edit")
	@ResponseBody
	public SpiDatos editar(Long idspi) {
		return ISpiDatosService.buscarPorId(idspi);
	}

}
