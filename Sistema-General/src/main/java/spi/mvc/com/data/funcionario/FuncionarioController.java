package spi.mvc.com.data.funcionario;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FuncionarioController {

	@GetMapping("/funcionario")
	public String home() {
		
		
		return "funcionario";
	}
}
