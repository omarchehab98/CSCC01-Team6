package team6.models;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Chart {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private String type;
	@OneToMany(mappedBy = "chart", cascade = CascadeType.ALL)
	private Set<ChartQuery> chartQueries;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Set<ChartQuery> getChartQueries() {
		return chartQueries;
	}
	public void setChartQueries(Set<ChartQuery> chartQueries) {
		this.chartQueries = chartQueries;
	}

	@Override
	public String toString() {
		return String.format("chart [id=%d name=%s]", id, name);
	}
}
