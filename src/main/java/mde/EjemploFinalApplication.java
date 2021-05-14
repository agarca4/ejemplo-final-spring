package mde;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@Import(ConfiguracionPorJava.class)
@ImportResource({ "classpath:config/jpa-config.xml" })
public class EjemploFinalApplication {

	public static void main(String[] args) {
		SpringApplication.run(EjemploFinalApplication.class, args);
	}

}
