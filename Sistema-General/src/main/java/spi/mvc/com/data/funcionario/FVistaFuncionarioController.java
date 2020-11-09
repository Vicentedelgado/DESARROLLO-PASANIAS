package spi.mvc.com.data.funcionario;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/views/funcionario/Vista")
public class FVistaFuncionarioController {

	
	@GetMapping("/")
	public String home() {
		
		return "/views/funcionario/Vista/vista";
	}
	
}
