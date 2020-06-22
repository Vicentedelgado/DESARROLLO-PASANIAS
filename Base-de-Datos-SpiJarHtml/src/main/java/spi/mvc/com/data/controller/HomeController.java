package spi.mvc.com.data.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import spi.mvc.com.data.model.Zona;
import spi.mvc.com.data.model.SpiDatos;
import spi.mvc.com.data.service.IZonaService;
import spi.mvc.com.data.service.ISpiDatosService;

@Controller
@RequestMapping(value="/home")
public class HomeController {
	
	@Autowired
	private IZonaService IZonaService;
	@Autowired
	private ISpiDatosService ISpiDatosService;
	
	
	//@GetMapping("/home")
	//@RequestMapping({"/home","/index","/"})
	@RequestMapping(method=RequestMethod.GET)
	public String index(Model model, @ModelAttribute("idzona") Zona idzona) {
		Zona zona= new Zona();
		List<Zona> listaZona=IZonaService.listazona();
		model.addAttribute("zona",zona);
		model.addAttribute("listazona",listaZona);
		return "home";
	}
	
	//ELEGIR SPI POR ZONA (FILTRAR)
	@RequestMapping(value="/Elegirspi",method = RequestMethod.GET)
	public @ResponseBody List<SpiDatos> BuscarporZona(@RequestParam(value ="idzona", required = true) Zona idzona){
		return ISpiDatosService.FindByZona(idzona); 
	}
	
	
	
}
