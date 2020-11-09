package spi.mvc.com.data.consulta;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import spi.mvc.com.data.model.RRHH;
import spi.mvc.com.data.model.SpiDatos;
import spi.mvc.com.data.model.Zona;
import spi.mvc.com.data.service.IRRHHService;
import spi.mvc.com.data.service.ISpiDatosService;
import spi.mvc.com.data.service.IZonaService;

@Controller
@RequestMapping("/views/Consulta/RRHH")
public class RRHHConsultaController {
	
	@Autowired
	private IRRHHService IRRHHService;
	@Autowired
	private IZonaService IZonaService;
	@Autowired
	private ISpiDatosService ISpiDatosService;
	
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
		model.addAttribute("titulo1","Formulario: Nuevo Registro de funcionario");
		model.addAttribute("titulo2","Formulario: Editar Registro de funcionario");
		model.addAttribute("rrhh",rrhh);
		model.addAttribute("listazona",listazona);
		model.addAttribute("listaspi",listaspi);
		model.addAttribute("zona",zona);
		return "/views/Consulta/RRHH/rrhh";	
	}



}
