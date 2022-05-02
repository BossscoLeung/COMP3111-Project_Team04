package comp3111.covid;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import edu.duke.FileResource;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.XYChart;

public class VaccinationRateSeries {
	
	// fields
	private ObservableList<XYChart.Series<String, Double>> series;
	private String iDataset;
	private ObservableList<String> countryList;
	private LocalDate startDate;
	private LocalDate endDate;
	
	// constructor
	public VaccinationRateSeries(String iDataset, ObservableList<String> countries, LocalDate start, LocalDate end) {
		series = FXCollections.observableArrayList();
		this.iDataset = iDataset;
		countryList = FXCollections.observableArrayList(countries);
		startDate = start;
		endDate = end;
	}
	
	// operation
	public ObservableList<XYChart.Series<String, Double>> getSeries() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy");
		
		for (String location : countryList) {
			FileResource fr = new FileResource("dataset/" + iDataset);
			CSVParser dataset = fr.getCSVParser(true);
			XYChart.Series<String, Double> seriesItem = new XYChart.Series<String, Double>();
			LocalDate date = startDate;
			String temp = "0.0";
			seriesItem.setName(location);
			
			for (CSVRecord record : dataset) {
				if (record.get("location").equals(location)) {
					if (record.get("date").equals(date.format(DateTimeFormatter.ofPattern("M/d/yyyy")))) {
						if (!record.get("people_fully_vaccinated_per_hundred").isBlank()) {
							temp = record.get("people_fully_vaccinated_per_hundred");
						}
						seriesItem.getData().add(new XYChart.Data<String, Double>(date.format(formatter), Double.parseDouble(temp)));
						date = date.plusDays(1);
					}
					else if (date.isAfter(endDate))
						break;
				}
			}
			series.add(seriesItem);
		}
		
		return series;
	}
}
