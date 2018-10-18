package team6.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Organization {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String name;

	protected Organization() {}

	public Organization(String name) {
	
		this.name = name;
	
	}

	@Override
	public String toString() {
	
		return String.format("Organization [id=%d, name='%s']", id, name);

	}

}
