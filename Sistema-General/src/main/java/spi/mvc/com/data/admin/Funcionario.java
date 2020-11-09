package spi.mvc.com.data.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import spi.mvc.com.data.model.RRHH;
import spi.mvc.com.data.service.IEquipoService;
import spi.mvc.com.data.service.IRRHHService;
import spi.mvc.com.data.service.ISoftwareService;
import spi.mvc.com.data.service.IZonaService;

@Controller
@RequestMapping("/views/admin/funcionario")

public class Funcionario {
	@Autowired	
	private IRRHHService rrhhService;

	@Autowired	
	private IZonaService zonaService;
	
	/////////////////////////////////////////////////////////////////
	
	
	@GetMapping ("/")
	public String listarFuncionario(Model model) {
		
		List<RRHH> listadoFuncionario = rrhhService.listarrrhh();
		
		model.addAttribute("funcionario", listadoFuncionario);
		
		return "/views/admin/funcionario/ListarFuncionario";
	}
}
