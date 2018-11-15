package team6.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Query {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private String path;
	private String query;

	public Query() {}
	
	public Query(String name, String query, String path) {
		this.name = name;
		this.path = path;
		this.query = query;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id){
		this.id = id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getQuery() {
		return this.query;
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

	public String getRoute() {
		return this.path + '?' + this.query;
	}

	@Override
	public String toString() {
		return String.format("Query[id=%d,name=%s]%n", this.id, this.name);
	}
}
