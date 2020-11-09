package spi.mvc.com.data.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import spi.mvc.com.data.model.Institucion;
import spi.mvc.com.data.model.SpiDatos;
import spi.mvc.com.data.model.Zona;
import spi.mvc.com.data.service.IInstitucionService;
import spi.mvc.com.data.service.ISpiDatosService;
import spi.mvc.com.data.service.IZonaService;

@Controller
@RequestMapping("/views/DataSpi/SpiDatos")
public class SpiDatosController {
	
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
		return "/views/DataSpi/SpiDatos/spidatos";
	}
	
	//GUARDAR
	@PostMapping("/save")
	public String guardar(@Valid @ModelAttribute SpiDatos spidatos, BindingResult result, Model model, 
			@RequestParam("file") MultipartFile archivo, RedirectAttributes alerta) {
		
		if(result.hasErrors()) {
			System.out.print("HUBO ERRORES EN EL FORMULARIO SPI");
			return "redirect:/views/DataSpi/SpiDatos/";
		}
		
		if(!archivo.isEmpty()) {
			//Path directorioArchivos= Paths.get("src//main//resources//static/images");
			//String rutaAbsoluta= directorioArchivos.toFile().getAbsolutePath();
			String rutaAbsoluta="C://DATASDH//DATASPI//VerificableSPI";
			
			try {
				byte[] bytesArch= archivo.getBytes();
				Path rutaCompleta= Paths.get(rutaAbsoluta + "//" + archivo.getOriginalFilename());
				Files.write(rutaCompleta,bytesArch);
	
				spidatos.setArchivo(archivo.getOriginalFilename());
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		ISpiDatosService.guardar(spidatos);
		System.out.print("REGISTRO SPI GUARDADO CON ÉXITO");
		alerta.addFlashAttribute("success", "REGISTRO SPI GUARDADO CON ÉXITO");
		return "redirect:/views/DataSpi/SpiDatos/";
	}
	
	//GUARDAR
	@PostMapping("/saveedit")
	public String guardaredit(@Valid @ModelAttribute SpiDatos spidatos, BindingResult result, Model model, 
			@RequestParam("file") MultipartFile archivo, RedirectAttributes alerta) {
		List<Zona> listazona=IZonaService.listazona();
		List<Institucion> listainstitucion=IInstitucionService.listainstitucion();
		
		if(result.hasErrors()) {
			model.addAttribute("titulo","Ver Detalle del SPI: " + spidatos.getNombre());
			model.addAttribute("titulo1","Formulario: Editar Registro del SPI");
			model.addAttribute("listazona",listazona);
			model.addAttribute("listainstitucion",listainstitucion);
			model.addAttribute("spidatos", spidatos);
			System.out.print("HUBO ERRORES EN EL FORMULARIO SPI");
			return "views/DataSpi/SpiDatos/detalle";
		}
		
		if(!archivo.isEmpty()) {
			//Path directorioArchivos= Paths.get("src//main//resources//static/images");
			//String rutaAbsoluta= directorioArchivos.toFile().getAbsolutePath();
			String rutaAbsoluta="C://DATASDH//DATASPI//VerificableSPI";
			
			try {
				byte[] bytesArch= archivo.getBytes();
				Path rutaCompleta= Paths.get(rutaAbsoluta + "//" + archivo.getOriginalFilename());
				Files.write(rutaCompleta,bytesArch);
	
				spidatos.setArchivo(archivo.getOriginalFilename());
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		ISpiDatosService.guardar(spidatos);
		System.out.print("REGISTRO SPI GUARDADO CON ÉXITO");
		alerta.addFlashAttribute("success", "REGISTRO SPI EDITADO CON ÉXITO");
		return "redirect:/views/DataSpi/SpiDatos/spidetl/" + spidatos.getIdspi();
	}
		
	
	
	//EDITAR MODAL
	@GetMapping("/edit")
	@ResponseBody
	public SpiDatos editar(Long idspi) {
		return ISpiDatosService.buscarPorId(idspi);
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
				return "/views/DataSpi/SpiDatos/";
			}
		}else {
			attribute.addFlashAttribute("error","ATENCION: Error con el registro del SPI");
			return "/views/DataSpi/SpiDatos/";
		}
		model.addAttribute("titulo","Ver Detalle del SPI: " + spidatos.getNombre());
		model.addAttribute("titulo1","Formulario: Editar Registro del SPI");
		model.addAttribute("listazona",listazona);
		model.addAttribute("listainstitucion",listainstitucion);
		model.addAttribute("spidatos", spidatos);
	  
		return "/views/DataSpi/SpiDatos/detalle"; 
	}

}
