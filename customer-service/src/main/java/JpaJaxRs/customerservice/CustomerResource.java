package JpaJaxRs.customerservice;

import java.util.Collection;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;

@Path("/customer")
@Produces(MediaType.APPLICATION_JSON)
public class CustomerResource {

	private final CustomerRepository customerRepository;

	@Autowired
	public CustomerResource(CustomerRepository customerRepository) {

		this.customerRepository = customerRepository;
	}

	@GET
	public Collection<Customer> customers() {
		return customerRepository.findAll();
	}

	@GET
	@Path("/{id}")
	public Customer byId(@PathParam("id") Long id) {
		return customerRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("couid't find " + id + " !"));
	}

}
