package Jax.Jersey.Jersey;

import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Person {
	
	private int id;
	private String name;
	private Date dob;
	
	public Person() {
		super();
	}

	public Person(int id, String name, Date dob) {
		super();
		this.id = id;
		this.name = name;
		this.dob = dob;
	}

	@XmlElement
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	public String getName() {
		return name;
	}
	@XmlElement
	public void setName(String name) {
		this.name = name;
	}

	public Date getDob() {
		return dob;
	}

	@XmlElement
	public void setDob(Date dob) {
		this.dob = dob;
	}
	
	
	

}
