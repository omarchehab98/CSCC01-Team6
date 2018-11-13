package team6.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Query {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private String query;
	private String path;

	
	public Query() {
		
	}
	
	public Query(String qName, String name, String query, String path) {
		this.name = qName;
		this.query = query;
		this.path = path;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id){
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setQuery(String query) {
		this.query = query;
	}
	
	public String getPath() {
		return this.path;
	}
	
	public void setPath(String path) {
		this.path = path;
	}
	@Override
	public String toString() {
		return String.format("The Query '%s': %s", this.name, 
				this.query);
	}
}
