package spi.mvc.com.data.consulta;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import spi.mvc.com.data.model.Institucion;
import spi.mvc.com.data.model.SpiDatos;
import spi.mvc.com.data.model.Zona;
import spi.mvc.com.data.service.IInstitucionService;
import spi.mvc.com.data.service.ISpiDatosService;
import spi.mvc.com.data.service.IZonaService;

@Controller
@RequestMapping("/views/Consulta/SpiDatos")
public class SpiDatosConsultaController {
	
	@Autowired
	private ISpiDatosService ISpiDatosService;
	@Autowired
	private IZonaService IZonaService;
	@Autowired
	private IInstitucionService IInstitucionService;
	
	@GetMapping("/")
	public String listarSpiDatos(Model model) {
		List<SpiDatos> listaspidatos= ISpiDatosService.listaspidatos();
		model.addAttribute("titulo","Lista de los SPI");
		model.addAttribute("listaspidatos",listaspidatos);
		//CREAR FORMULARIO REGISTRO DE VENTANA MODAL spidatos.html
		SpiDatos spidatos=new SpiDatos();
		List<Zona> listazona=IZonaService.listazona();
		List<Institucion> listainstitucion=IInstitucionService.listainstitucion();
		model.addAttribute("titulo1","Formulario: Nuevo Registro de SPI");
		model.addAttribute("titulo2","Formulario: Editar Registro de SPI");
		model.addAttribute("spidatos",spidatos);
		model.addAttribute("listazona",listazona);
		model.addAttribute("listainstitucion",listainstitucion);
		return "/views/Consulta/SpiDatos/spidatos";
	}
	
	//EDITAR Y DETALLE
	
	@GetMapping("/spidetl/{idspi}")
  
	public String Verdetalle(@PathVariable("idspi") Long idspi, Model model, RedirectAttributes attribute) { 
		List<Zona> listazona=IZonaService.listazona();
		List<Institucion> listainstitucion=IInstitucionService.listainstitucion();
		SpiDatos spidatos = null;
	  
		if(idspi>0) {
			spidatos= ISpiDatosService.buscarPorId(idspi);
		  
			if (spidatos==null) {
				attribute.addFlashAttribute("error","ATENCION: Este registro SPI no existe");
				return "/views/Consulta/SpiDatos/";
			}
		}else {
			attribute.addFlashAttribute("error","ATENCION: Error con el registro del SPI");
			return "/views/Consulta/SpiDatos/";
		}
		model.addAttribute("titulo","Ver Detalle del SPI: " + spidatos.getNombre());
		model.addAttribute("titulo1","Formulario: Editar Registro del SPI");
		model.addAttribute("listazona",listazona);
		model.addAttribute("listainstitucion",listainstitucion);
		model.addAttribute("spidatos", spidatos);
	  
		return "/views/Consulta/SpiDatos/detalle"; 
	}
	

}
