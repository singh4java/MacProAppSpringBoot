package JpaJaxRs.customerservice;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Customer {

	@Id
	@GeneratedValue
	private Long id;
	@SuppressWarnings("unused")
	private String name;

	public Customer(Long id, String name) {

		this.id = id;
		this.name = name;
	}

}
