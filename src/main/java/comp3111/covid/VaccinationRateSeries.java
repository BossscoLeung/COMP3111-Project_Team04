package comp3111.covid;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import edu.duke.FileResource;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.XYChart;

/**
 * A program to extract data from the dataset for generating the Chart C2
 * @author Matthew Lin
 */
public class VaccinationRateSeries {
	
	// fields
	private final ObservableList<XYChart.Series<String, Double>> series;
	private final String iDataset;
	private final ObservableList<String> countryList;
	private final LocalDate startDate;
	private final LocalDate endDate;

	/**
	 * Construct the object and initialise attributes
	 * @param iDataset the filename of the dataset to be used
	 * @param countries a list of countries of interest
	 * @param start the starting date of interest
	 * @param end the ending date of interest
	 */
	public VaccinationRateSeries(String iDataset, ObservableList<String> countries, LocalDate start, LocalDate end) {
		series = FXCollections.observableArrayList();
		this.iDataset = iDataset;
		countryList = FXCollections.observableArrayList(countries);
		startDate = start;
		endDate = end;
	}

	/**
	 * Get the data points to be used to build a chart
	 * @return the series containing the data points to be shown in Chart C2
	 */
	public ObservableList<XYChart.Series<String, Double>> getSeries() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy");
		
		for (String location : countryList) {
			FileResource fr = new FileResource("dataset/" + iDataset);
			CSVParser dataset = fr.getCSVParser(true);
			XYChart.Series<String, Double> seriesItem = new XYChart.Series<>();
			LocalDate date = startDate;
			String temp = "0.0";
			seriesItem.setName(location);
			
			for (CSVRecord record : dataset) {
				if (record.get("location").equals(location)) {
					if (record.get("date").equals(date.format(DateTimeFormatter.ofPattern("M/d/yyyy")))) {
						if (!record.get("people_fully_vaccinated_per_hundred").isBlank()) {
							temp = record.get("people_fully_vaccinated_per_hundred");
						}
						seriesItem.getData().add(new XYChart.Data<>(date.format(formatter), Double.parseDouble(temp)));
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
