package parva.demo.ems;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "parva.demo.ems")
public class EmsBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmsBackendApplication.class, args);
	}

}
