package team6;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persitence.Id;

@Entity
public class Organization {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTP)
	private Long id;
	private String name;

	protected Organization() {}

	public Organization(String name) {
	
		this.name = name;
	
	}

	@Overide
	public String toString() {
	
		return String.format("Organization [id=%d, name='%s']", id, name);

	}

}
