package Service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@ComponentScan(basePackages = { "Service", "Pojos" })
@EnableScheduling
public class RestApi {

	public static void main(String[] args) {
		SpringApplication.run(RestApi.class, args);
	}

}
