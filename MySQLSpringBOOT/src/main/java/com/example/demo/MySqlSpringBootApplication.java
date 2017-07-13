package com.example.demo;

import java.util.stream.Stream;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@SpringBootApplication
public class MySqlSpringBootApplication implements CommandLineRunner {

	private EmployeeRepostory employeeRepostory;

	@Autowired
	public MySqlSpringBootApplication(EmployeeRepostory employeeRepostory) {
		super();
		this.employeeRepostory = employeeRepostory;
	}

	public static void main(String[] args) {
		SpringApplication.run(MySqlSpringBootApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {

		Stream.of("AAA", "BBB", "CCC", "DDD", "EEE", "FFF").forEach(a -> employeeRepostory.save(new Employee(a)));
		employeeRepostory.findAll().forEach(a -> System.out.println(a.toString()));
	}
}

@RepositoryRestResource
interface EmployeeRepostory extends JpaRepository<Employee, Long> {

}

@Entity
class Employee {

	@Id
	@GeneratedValue
	private long id;
	private String name;

	public Employee(String name) {
		super();
		this.name = name;
	}

	public Employee() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + "]";
	}

}
