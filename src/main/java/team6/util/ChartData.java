package team6.util;

import java.util.ArrayList;

public class ChartData {
	private String[] labelList;
	private Integer[][] datasetList;
	private String[] sourceList;

	public ChartData() {}


	public ChartData(String[] labelList, Integer[][] datasetList, String[] sourceList) {
		this.labelList = labelList;
		this.datasetList = datasetList;
		this.sourceList = sourceList;
	}
}