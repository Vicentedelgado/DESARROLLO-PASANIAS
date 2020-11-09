package spi.mvc.com.data.admin;

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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import spi.mvc.com.data.model.Equipo;
import spi.mvc.com.data.model.InformeEquipo;
import spi.mvc.com.data.service.IEquipoService;
import spi.mvc.com.data.service.IInformeEquipoService;

@Controller
@RequestMapping("/views/admin/informeequipo")
public class InformeEquipoController {

	@Autowired
	private IInformeEquipoService informeequipoService;
	
	@Autowired
	private IEquipoService equipoService;
	
	
	@GetMapping ("/")

	public String listarInforme(Model model) {

		List<InformeEquipo> listadoInformeEquipo = informeequipoService.listarTodo();

		model.addAttribute("informeequipo", listadoInformeEquipo);

		return "/views/admin/informeequipo/ListarInformeequipo";
}
	
	@RequestMapping(value="/filtrar1/{idinformeequipo}", method = RequestMethod.GET)
	public String Filtrar1(@PathVariable("idinformeequipo") Long idinformeequipo, Model model) {
		
		List<InformeEquipo> listadoInfoE = informeequipoService.filtronum(idinformeequipo);
		
		model.addAttribute("informeequipo", listadoInfoE);
		
		return "/views/admin/informeequipo/ListarInformeequipo";
		
	}
	/////////////////////////////////////////////////////////////
	
	
	@GetMapping("/create/{idequipo}")
	public String crear(@PathVariable("idequipo") Long idequipo, Model model) {
	
		InformeEquipo informeequipo = new InformeEquipo();
		List<Equipo> listarEquipo = equipoService.listarTodo();
		
		
		model.addAttribute("informeequipo", informeequipo);
		model.addAttribute("equipo", listarEquipo);
		model.addAttribute("idequipo", idequipo);
		
		
		return "/views/admin/informeequipo/formularioinformeequipo";
	}

	
	/////////////////////////////////////////////////////////////////
	
	
	 @PostMapping("/save") 
	 public String guardar(@Valid @ModelAttribute InformeEquipo informeequipo, BindingResult result,  Model model, @RequestParam("file") MultipartFile archivos, 
			 RedirectAttributes alerta) {
		 
		 	if(result.hasErrors()) {
		 		model.addAttribute("informeequipo",informeequipo);
				System.out.print("Error");
				return "/views/admin/informeequipo/formularioinformeequipo";
			}
		 	
		 	if(!archivos.isEmpty()) {
				//Path directorioArchivos= Paths.get("src//main//resources//static/images");
				//String rutaAbsoluta= directorioArchivos.toFile().getAbsolutePath();
				String rutaAbsoluta="C://DATASDH//INVENTARIO//InformesEquipo";
				
				try {
					byte[] bytesArch= archivos.getBytes();
					Path rutaCompleta= Paths.get(rutaAbsoluta + "//" + archivos.getOriginalFilename());
					Files.write(rutaCompleta,bytesArch);
		
					informeequipo.setArchivos(archivos.getOriginalFilename());

				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		 	informeequipoService.guardar(informeequipo);
		 	System.out.print("INFORME GUARDADO CON EXITO");
			alerta.addFlashAttribute("success", "INFORME GUARDADO CON ÉXITO");
			return "redirect:/views/admin/informeequipo/"; 
		 }
	 
		
/////////////////////////////////////////////////////////////////////

		@GetMapping("/detalle/{idinformeequipo}")
		public String detalleinfoeq(@PathVariable("idinformeequipo") Long idinformeequipo,Model model, RedirectAttributes attribute) {
		InformeEquipo informeequipo = null;
		
		if(idinformeequipo>0) {
			informeequipo= informeequipoService.buscarPorId(idinformeequipo);
			if(informeequipo==null) {
				attribute.addFlashAttribute("error","ATENCION: Este informe no existe");
				return "/views/admin/informeequipo/";
			}
		}else {
			attribute.addFlashAttribute("error","ATENCION: Error con el informe");
			return "/views/admin/informeequipo/";
		}
		model.addAttribute("titulo","Detalle del informe del equipo: "+ informeequipo.getIdequipo().getNombreequipo());
		model.addAttribute("informeequipo", informeequipo);
		
		return "/views/admin/informeequipo/detalleinfoeq";
		}
		
}