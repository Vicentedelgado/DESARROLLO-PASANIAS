package spi.mvc.com.data.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import spi.mvc.com.data.model.RRHH;
import spi.mvc.com.data.model.SpiDatos;
import spi.mvc.com.data.model.Zona;
import spi.mvc.com.data.service.IRRHHService;
import spi.mvc.com.data.service.IZonaService;
import spi.mvc.com.data.service.ISpiDatosService;

@Controller
@RequestMapping("/views/RRHH")
public class RRHHController {
	
	@Autowired
	private IRRHHService IRRHHService;
	@Autowired
	private IZonaService IZonaService;
	@Autowired
	private ISpiDatosService ISpiDatosService;
	
	@GetMapping("/")
	public String listarCantones(Model model) {
		List<RRHH> listarrhh=IRRHHService.listarrrhh();
		model.addAttribute("titulo","Lista del Recurso Humano del Spi ");
		model.addAttribute("listarrhh",listarrhh);
		//CREAR FORMULARIO REGISTRO DE VENTANA MODAL spidatos.html
		RRHH rrhh=new RRHH();
		List<Zona> listazona=IZonaService.listazona();
		List<SpiDatos> listaspi=ISpiDatosService.listaspidatos();
		model.addAttribute("titulo1","Formulario: Nuevo Registro de funcionario");
		model.addAttribute("titulo2","Formulario: Editar Registro de funcionario");
		model.addAttribute("rrhh",rrhh);
		model.addAttribute("listazona",listazona);
		model.addAttribute("listaspi",listaspi);	
		return "/views/RRHH/rrhh";	
	}
	
	//GUARDAR
	@PostMapping("/save")
	public String guardar(@ModelAttribute RRHH rrhh) {
		IRRHHService.guardar(rrhh);
		System.out.print("REGISTRO GUARDADO");
		return "redirect:/views/RRHH/";
	}
	
	//EDITAR MODAL
	@GetMapping("/edit")
	@ResponseBody
	public RRHH editar(Long idusuario) {
		return IRRHHService.buscarPorId(idusuario);
	}
	

}
