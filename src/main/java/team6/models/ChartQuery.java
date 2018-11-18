package team6.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ChartQuery {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Long chartId;
	private Long queryId;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getChartId() {
		return chartId;
	}
	public void setChartId(Long chartId) {
		this.chartId = chartId;
	}
	public Long getQueryId() {
		return queryId;
	}
	public void setQueryId(Long queryId) {
		this.queryId = queryId;
	}
}
