package pl.pjatk.jaz_s31324_nbp;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "NBP API", version = "0", description = "API do pobierania kursów walut poprzez filtrowanie tabel z NBP"))
public class JazS31324NbpApplication {

	public static void main(String[] args) {
		SpringApplication.run(JazS31324NbpApplication.class, args);
	}

}
