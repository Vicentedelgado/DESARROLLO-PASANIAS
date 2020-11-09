package spi.mvc.com.data.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/views/admin/Vista")
public class VistaFuncionarioController {

	
	@GetMapping("/")
	public String home() {
		
		return "/views/admin/Vista/vista";
	}
	
}
