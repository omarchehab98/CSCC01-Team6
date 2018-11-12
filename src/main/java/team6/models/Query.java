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
	private String queryName;
	private String whereParam;
	private String sortParam;
	private String groupParam;
	private String selectParam;
	private String fromParam;
	
	public Query() {
		
	}
	
	public Query(String qName, String wP, String gP, String sP, String fP) {
		this.queryName = qName;
		this.whereParam = wP;
		this.groupParam = gP;
		this.selectParam = sP;
		this.fromParam = fP;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id){
		this.id = id;
	}
	
	public void setQueryName(String name) {
		this.queryName = name;
	}
	
	public String getQueryName() {
		return this.queryName;
	}
	
	public void setWhereParam(String whereParam) {
		this.whereParam = whereParam;
	}

	public String getWhereParam() {
		return this.whereParam;
	}
	
	public void setSortParam(String sortParam) {
		this.sortParam = sortParam;
	}
	
	public String getSortParam() {
		return this.sortParam;
	}
	
	public void setGroupParam(String groupParam) {
		this.groupParam = groupParam;
	}
	
	public String getGroupParam() {
		return this.groupParam;
	}
	
	public void setSelectParam(String selectParam) {
		this.selectParam = selectParam;
	}
	
	public String getSelectParam() {
		return this.selectParam;
	}
	
	public void setFromParam(String fromParam) {
		this.fromParam = fromParam;
	}
	
	public String getFromParam() {
		return this.fromParam;
	}
	
	@Override
	public String toString() {
		return String.format("The Query '%s': %s%s%s%s%s", this.queryName, 
				this.selectParam, this.fromParam, this.whereParam, this.groupParam, this.sortParam);
	}
}
