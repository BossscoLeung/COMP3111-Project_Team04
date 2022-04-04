package comp3111.covid;

import org.apache.commons.csv.CSVRecord;
import edu.duke.FileResource;
import javafx.collections.ObservableList;
import javafx.scene.chart.XYChart;

public class CountryA2 {
	String location, StartDate, EndDate;
	ObservableList<XYChart.Data<String,Double>> data;
	
	CountryA2(String dataset, String location, String StartFormattedDate, String EndFormattedDate){
		this.location = location;
		this.StartDate = StartFormattedDate;
		this.EndDate = EndFormattedDate;
		
		
	}
}
