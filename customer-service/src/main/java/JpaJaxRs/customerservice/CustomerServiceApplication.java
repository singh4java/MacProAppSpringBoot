package JpaJaxRs.customerservice;

import java.util.stream.Stream;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
public class CustomerServiceApplication {
	@Bean
	ApplicationRunner data(CustomerRepository customerRepository) {
		return args -> Stream.of("A", "B", "C").forEach(x -> customerRepository.save(new Customer(null, x)));

	}

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}
}

@Configuration
class JerseyConfiguration {

	@Bean
	CustomerResource customerResource(CustomerRepository customerRepository) {
		return new CustomerResource(customerRepository);
	}

	@Bean
	ResourceConfig config(CustomerResource cr) {
		ResourceConfig rc = new ResourceConfig();
		rc.register(cr);
		return rc;
	}
}