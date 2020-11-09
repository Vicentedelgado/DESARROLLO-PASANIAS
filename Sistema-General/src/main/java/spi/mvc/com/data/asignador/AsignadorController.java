package spi.mvc.com.data.asignador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AsignadorController {

	@GetMapping("/asignador")
	public String home() {
		
		
		return "asignador";
	}
}
