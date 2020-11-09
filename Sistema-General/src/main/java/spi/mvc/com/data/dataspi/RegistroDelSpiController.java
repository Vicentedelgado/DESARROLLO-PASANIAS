package spi.mvc.com.data.dataspi;

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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import spi.mvc.com.data.model.Activo;
import spi.mvc.com.data.model.Institucion;
import spi.mvc.com.data.model.RegistrodelSpi;
import spi.mvc.com.data.model.SpiDatos;
import spi.mvc.com.data.model.Tipo;
import spi.mvc.com.data.model.Zona;
import spi.mvc.com.data.service.IRegistroDelSpiService;
import spi.mvc.com.data.service.IActivoService;
import spi.mvc.com.data.service.ISpiDatosService;
import spi.mvc.com.data.service.ITipoService;
import spi.mvc.com.data.service.IZonaService;
import spi.mvc.com.data.service.IInstitucionService;

@Controller
@RequestMapping("/views/DataSpi/RegistroDelSpi")
public class RegistroDelSpiController {
	
	@Autowired
	private IRegistroDelSpiService IRegistroDelSpiService;
	@Autowired
	private IActivoService IActivoService;
	@Autowired
	private ISpiDatosService ISpiDatosService;
	@Autowired
	private IInstitucionService IInstitucionService;
	@Autowired
	private ITipoService ITipoService;
	@Autowired
	private IZonaService IZonaService;
	/*
	 * @Autowired private ServletContext context;
	 */
	
	
	//LISTAR
	@GetMapping("/")
	public String listarCantones(Model model,@ModelAttribute("idtipo") Tipo idtipo,@ModelAttribute("idzona") Zona idzona) {
		List<RegistrodelSpi> listaregistrodelspi=IRegistroDelSpiService.listarregistro();
		model.addAttribute("titulo","Lista de Bienes y Servicios de los SPI");
		model.addAttribute("listaregistrodelspi",listaregistrodelspi);
	    //CREAR FORMULARIO REGISTRO DE VENTANA MODAL registrodelspi.html
		Tipo tipo= new Tipo();
		Zona zona= new Zona();
		RegistrodelSpi registrodelspi=new RegistrodelSpi();
		List<Zona> listazona=IZonaService.listazona(); 
		List<Activo>listaactivo=IActivoService.listaactivo(); 
		List<SpiDatos>listaspi=ISpiDatosService.listaspidatos(); 
		List<Institucion>listainstitucion=IInstitucionService.listainstitucion();
		List<Tipo>listatipo= ITipoService.listatipos();
		model.addAttribute("tipo",tipo);
		model.addAttribute("titulo1","Formulario: Nuevo Registro");
		model.addAttribute("titulo2","Formulario: Editar Registro");
		model.addAttribute("registrodelspi",registrodelspi);
		model.addAttribute("listaactivo",listaactivo);
	    model.addAttribute("listaspi",listaspi);
		model.addAttribute("listainstitucion",listainstitucion);
		model.addAttribute("listatipo",listatipo);
		model.addAttribute("zona",zona);
		model.addAttribute("listazona",listazona);
		return "/views/DataSpi/RegistroDelSpi/registrosdelspi";	
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
		return "/views/DataSpi/RegistroDelSpi/frmRegistro";
	}
	
	//ELEGIR ACTIVO POR TIPO (FILTRAR)
	@RequestMapping(value="/Elegiractivo",method = RequestMethod.GET)
	public @ResponseBody List<Activo> BuscarporTipo(@RequestParam(value ="idtipo", required = true) Tipo idtipo){
		return IActivoService.Buscarportipo(idtipo); 
	}
	
	//ELEGIR SPI POR ZONA (FILTRAR)
	@RequestMapping(value="/Elegirspi",method = RequestMethod.GET)
	public @ResponseBody List<SpiDatos> BuscarporZona(@RequestParam(value ="idzona", required = true) Zona idzona){
		return ISpiDatosService.FindByZona(idzona); 
	}
	
	//GUARDAR
	@PostMapping("/save")
	public String guardar(@Valid @ModelAttribute("registrodelspi") RegistrodelSpi registrodelspi, BindingResult result, Model model, 
			@RequestParam("file") MultipartFile archivo, RedirectAttributes alerta) {
		
		if(result.hasErrors()) {
			System.out.print("Errores en el formulario por favor revice los campos");
			return "redirect:/views/DataSpi/RegistroDelSpi/";
		}
		
		if(!archivo.isEmpty()) {
			//Path directorioArchivos= Paths.get("src//main//resources//static/images");
			//String rutaAbsoluta= directorioArchivos.toFile().getAbsolutePath();
			String rutaAbsoluta="C://DATASDH//DATASPI//VerificableBienes";
			
			try {
				byte[] bytesArch= archivo.getBytes();
				Path rutaCompleta= Paths.get(rutaAbsoluta + "//" + archivo.getOriginalFilename());
				Files.write(rutaCompleta,bytesArch);
	
				registrodelspi.setArchivo(archivo.getOriginalFilename());
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		IRegistroDelSpiService.guardar(registrodelspi);
		System.out.print("REGISTRO GUARDADO CON EXITO");
		alerta.addFlashAttribute("success", "REGISTRO GUARDADO CON ÉXITO");
		return "redirect:/views/DataSpi/RegistroDelSpi/";
	}
	
	//GUARDAR EDITAR
	@PostMapping("/saveedit")
	public String guardaredit(@Valid @ModelAttribute("registrodelspi") RegistrodelSpi registrodelspi, BindingResult result, Model model, 
			@RequestParam("file") MultipartFile archivo, RedirectAttributes alerta) {
		
		List<Activo> listaactivo=IActivoService.listaactivo();
		List<SpiDatos> listaspi=ISpiDatosService.listaspidatos();
		List<Institucion> listainstitucion=IInstitucionService.listainstitucion();
		
		if(result.hasErrors()) {
			model.addAttribute("titulo","Ver Detalle: " + registrodelspi.getIdactivo().getNombre()+ " del SPI "+registrodelspi.getIdspi().getNombre());
			model.addAttribute("titulo1","Formulario: Editar Registro");
			model.addAttribute("registrodelspi",registrodelspi);
			model.addAttribute("listaactivo",listaactivo);
			model.addAttribute("listaspi",listaspi);
			model.addAttribute("listainstitucion",listainstitucion);
			System.out.print("Errores en el formulario por favor revice los campos");
			return "/views/DataSpi/RegistroDelSpi/detalle";
		}
		
		if(!archivo.isEmpty()) {
			//Path directorioArchivos= Paths.get("src//main//resources//static/images");
			//String rutaAbsoluta= directorioArchivos.toFile().getAbsolutePath();
			String rutaAbsoluta="C://DATASDH//DATASPI//VerificableBienes";
			
			try {
				byte[] bytesArch= archivo.getBytes();
				Path rutaCompleta= Paths.get(rutaAbsoluta + "//" + archivo.getOriginalFilename());
				Files.write(rutaCompleta,bytesArch);
	
				registrodelspi.setArchivo(archivo.getOriginalFilename());
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		IRegistroDelSpiService.guardar(registrodelspi);
		System.out.print("REGISTRO GUARDADO CON EXITO");
		alerta.addFlashAttribute("success", "REGISTRO EDITADO CON ÉXITO");
		return "redirect:/views/DataSpi/RegistroDelSpi/spidetl/" + registrodelspi.getIdregistro();
	}
	
	//EDITAR MODAL
	@GetMapping("/edit")
	@ResponseBody
	public RegistrodelSpi editar( Long idregistro) {
		RegistrodelSpi registrodelspi = IRegistroDelSpiService.buscarPorId(idregistro);
		return registrodelspi;
	}
	
	//EDITAR Y DETALLE
	@GetMapping("/spidetl/{idregistro}")
	public String Verdetalle(@PathVariable("idregistro") Long idregistro, Model model, RedirectAttributes attribute) { 
		List<Institucion> listainstitucion=IInstitucionService.listainstitucion();
		RegistrodelSpi registrodelspi = null;
	  
		if(idregistro>0) {
			registrodelspi= IRegistroDelSpiService.buscarPorId(idregistro);
		  
			if (registrodelspi==null) {
				attribute.addFlashAttribute("error","ATENCION: Este registro no existe");
				return "/views/DataSpi/RegistroDelSpi/";
			}
		}else {
			attribute.addFlashAttribute("error","ATENCION: Error con el registro");
			return "/views/DataSpi/RegistroDelSpi/";
		}
		model.addAttribute("titulo","Ver Detalle: " + registrodelspi.getIdactivo().getNombre()+ " del SPI "+registrodelspi.getIdspi().getNombre());
		model.addAttribute("titulo1","Formulario: Editar Registro");
		model.addAttribute("listainstitucion",listainstitucion);
		model.addAttribute("registrodelspi", registrodelspi);
	  
		return "/views/DataSpi/RegistroDelSpi/detalle"; 
	}
	 
 
	@GetMapping("/editar/{idregistro}")
	public String editar(@PathVariable("idregistro") Long idregistro, Model model) {
		RegistrodelSpi registrodelspi = IRegistroDelSpiService.buscarPorId(idregistro);
		List<Activo> listaactivo=IActivoService.listaactivo();
		List<SpiDatos> listaspi=ISpiDatosService.listaspidatos();
		List<Institucion> listainstitucion=IInstitucionService.listainstitucion();
		model.addAttribute("titulo","Formulario: Editar Registro");
		model.addAttribute("listaactivo",listaactivo);
		model.addAttribute("listaspi",listaspi);
		model.addAttribute("listainstitucion",listainstitucion);
		model.addAttribute("registrodelspi", registrodelspi);
		return "/views/DataSpi/RegistroDelSpi/frmRegistro";
	}  
	
	
	
	
	

}
