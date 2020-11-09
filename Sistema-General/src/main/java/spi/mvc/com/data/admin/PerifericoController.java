 package spi.mvc.com.data.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import spi.mvc.com.data.model.Periferico;
import spi.mvc.com.data.service.IPerifericoService;





@Controller
@RequestMapping("/views/admin/periferico")
public class PerifericoController {

	// LISTAR PERIFERICO//
	
	@Autowired
	private IPerifericoService perifericoService;
		
			@GetMapping ("/")
			public String listarPeriferico(Model model) {
				
				List<Periferico> listadoPeriferico = perifericoService.listarTodo();
				
				model.addAttribute("perifericos", listadoPeriferico);
				
				return "/views/admin/periferico/Listarperiferico";
			}
			
			/////////////////////ASIGNACION EN BUSQUEDA /////////////////////////////////
			@GetMapping ("/asignacion")
			public String listarPeri(Model model) {
				
				List<Periferico> listadoPeriferico = perifericoService.listarTodo();
				
				model.addAttribute("perifericos", listadoPeriferico);
				
				return "/views/admin/periferico/listarasignacion";
			}
		
			//////////////////////////////////////////////////////////////////////////////
			
			//// CREAR PERIFERICO //
			@GetMapping ("/create")
			public String crear(Model model) {
				
				Periferico periferico = new Periferico();
				model.addAttribute("periferico", periferico);
				
				return "/views/admin/periferico/formularioperiferico";
			}
			
			///GUARDAR//
			
			 @PostMapping("/save") 
			 public String guardar(@ModelAttribute Periferico periferico) {
				perifericoService.guardar(periferico);
				return "redirect:/views/admin/periferico/";
			}
			 
			 ///EDITAR//
			 
				@GetMapping("/edit/{idperiferico}")
				public String editar(@PathVariable("idperiferico") Long idPeriferico,Model model) {
					
					Periferico periferico = perifericoService.buscarPorId(idPeriferico);
					
					model.addAttribute("periferico", periferico);
					
					return "/views/admin/periferico/formularioperiferico";
				}
				
			//ELIMINAR//
				
				@GetMapping("/delete/{idperiferico}")
				public String eliminar(@PathVariable("idperiferico") Long idPeriferico) {
					
					perifericoService.eliminar(idPeriferico);
					
					return "redirect:/views/admin/periferico/";
					
				}
			

	
	
	}
