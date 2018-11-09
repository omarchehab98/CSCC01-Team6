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
	private String queryName;

	private String whereParam;
	private String sortParam;
	private String groupParam;
	private String selectParam;
	private String fromParam;
	
	public Query(String qName, String wP, String gP, String sP, String fP) {
		this.queryName = qName;
		this.whereParam = wP;
		this.groupParam = gP;
		this.selectParam = sP;
		this.fromParam = fP;
	}
	
	public void setName(String name) {
		this.queryName = name;
	}
	
	public String getQueryName() {
		return this.queryName;
	}
	
	public void setWhereParameter(String whereParam) {
		this.whereParam = whereParam;
	}

	public String getWhereParameter() {
		return this.whereParam;
	}
	
	public void setSortParameter(String sortParam) {
		this.sortParam = sortParam;
	}
	
	public String getSortParameter() {
		return this.sortParam;
	}
	
	public void setGroupParameter(String groupParam) {
		this.groupParam = groupParam;
	}
	
	public String getGroupParameter() {
		return this.groupParam;
	}
	
	public void setSelectParameter(String selectParam) {
		this.selectParam = selectParam;
	}
	
	public String getSelectParameter() {
		return this.selectParam;
	}
	
	public void setFromParameter(String fromParam) {
		this.fromParam = fromParam;
	}
	
	public String getFromParameter() {
		return this.fromParam;
	}
	
	@Override
	public String toString() {
		return String.format("The Query '%s': %s%s%s%s%s", this.queryName, 
				this.selectParam, this.fromParam, this.whereParam, this.groupParam, this.sortParam);
	}
}
