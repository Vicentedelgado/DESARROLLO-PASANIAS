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

import spi.mvc.com.data.model.InformePeriferico;
import spi.mvc.com.data.model.Periferico;
import spi.mvc.com.data.service.IInformePerifericoService;
import spi.mvc.com.data.service.IPerifericoService;

@Controller
@RequestMapping("/views/admin/informeperiferico")
public class InformePerifericoController {

	@Autowired
	private IInformePerifericoService informeperifericoService;
	
	@Autowired
	private IPerifericoService perifericoService;
	
	
@GetMapping ("/")
	
	public String listarInforme(Model model) {
		
		List<InformePeriferico> listadoInformes = informeperifericoService.listarTodo();
		
		model.addAttribute("informe", listadoInformes);
		
		return "/views/admin/informeperiferico/Listarinforme";
	}

		@RequestMapping(value="/filtrar1/{idinforme}", method = RequestMethod.GET)
		public String Filtrar1(@PathVariable("idinforme") Long idinforme, Model model) {
			
			List<InformePeriferico> listadoInfoP = informeperifericoService.filtronum(idinforme);
			
			model.addAttribute("informe", listadoInfoP);
			
			return "/views/admin/informeperiferico/Listarinforme";
			
		}
	
		@GetMapping("/create/{idperiferico}")
		public String crear(@PathVariable("idperiferico") Long idperiferico, Model model) {
		
			InformePeriferico informe = new InformePeriferico();
			List<Periferico> listarPeriferico = perifericoService.listarTodo();
			
			
			model.addAttribute("informe", informe);
			model.addAttribute("periferico", listarPeriferico);
			model.addAttribute("idperiferico", idperiferico);
			
			
			return "/views/admin/informeperiferico/formularioinforme";
		}

	
		@PostMapping("/save") 
		public String guardar(@Valid @ModelAttribute InformePeriferico informe, BindingResult result,  Model model, @RequestParam("file") MultipartFile archivos, 
				 RedirectAttributes alerta) {
			 
			if(result.hasErrors()) {
		 		model.addAttribute("informe",informe);
				System.out.print("Error");
				return "/views/admin/informeperiferico/formularioinforme";
			}
		 	
		 	if(!archivos.isEmpty()) {
				//Path directorioArchivos= Paths.get("src//main//resources//static/images");
				//String rutaAbsoluta= directorioArchivos.toFile().getAbsolutePath();
				String rutaAbsoluta="C://DATASDH//INVENTARIO//InformesPeriferico";
				
				try {
					byte[] bytesArch= archivos.getBytes();
					Path rutaCompleta= Paths.get(rutaAbsoluta + "//" + archivos.getOriginalFilename());
					Files.write(rutaCompleta,bytesArch);
		
					informe.setArchivos(archivos.getOriginalFilename());

				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			 informeperifericoService.guardar(informe);
			 System.out.print("INFORME GUARDADO CON EXITO");
			 alerta.addFlashAttribute("success", "INFORME GUARDADO CON ÉXITO");
		return "redirect:/views/admin/informeperiferico/"; }
	
/////////////////////////////////////////////////////////////////////

		@GetMapping("/detalle/{idinforme}")
		public String detalleinfoper(@PathVariable("idinforme") Long idinforme,Model model, RedirectAttributes attribute) {
		InformePeriferico informe = null;
		
		if(idinforme>0) {
		informe= informeperifericoService.buscarPorId(idinforme);
		if(informe==null) {
		attribute.addFlashAttribute("error","ATENCION: Este informe no existe");
		return "/views/admin/informeperiferico/";
		}
		}else {
		attribute.addFlashAttribute("error","ATENCION: Error con el informe");
		return "/views/admin/informeperiferico/";
		}
		model.addAttribute("titulo","Detalle del informe del periférico: "+ informe.getIdperiferico().getNombreperiferico());
		model.addAttribute("informe", informe);
		
		return "/views/admin/informeperiferico/detalleinfoper";
		}
	
}
