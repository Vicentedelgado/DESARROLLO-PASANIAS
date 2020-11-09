package spi.mvc.com.data;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SistemaGeneralApplication {

	public static void main(String[] args) {
		SpringApplication.run(SistemaGeneralApplication.class, args);
	}
	
	@RequestMapping("/")
	public String printStartUpMessage() {
		return "App Sistema General iniciada";
	}


}
