package comp3111.covid;

import org.apache.commons.csv.CSVRecord;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import edu.duke.FileResource;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.XYChart;

/**
 * A program for generating chart A2, each instance records the location, 
 * the number of total cases per 1M in a period.
 * @author Bosco Leung
 *
 */
public class CountryA2 {
	String location, StartFormattedDate, EndFormattedDate;
	ObservableList<XYChart.Data<String, Double>> data = FXCollections.observableArrayList();
	
	/**
	 * Instantiate a country which record the required information
	 * @param dataset The filename of dataset we want to use
	 * @param location The location of the country
	 * @param StartDate The starting date of the period
	 * @param EndDate The ending date of the period
	 * @param duration The number of date in the period
	 */
	CountryA2(String dataset, String location, LocalDate StartDate, LocalDate EndDate, int duration){
		this.location = location;
		this.StartFormattedDate = StartDate.format(DateTimeFormatter.ofPattern("M/d/yyyy"));
		this.EndFormattedDate = EndDate.format(DateTimeFormatter.ofPattern("M/d/yyyy"));
		
		if(location!="") {
			FileResource fr = new FileResource("dataset/" + dataset);
			LocalDate date = StartDate;
			
			for (int i = 0; i < duration; i++) {
				String formattedDate = date.format(DateTimeFormatter.ofPattern("M/d/yyyy"));
				for (CSVRecord rec : fr.getCSVParser(true)) {
					double number = 0;
					int size = this.data.size();
					boolean log = false;
					
					if (rec.get("date").equals(formattedDate) && rec.get("location").equals(location)) {
						String s1 = rec.get("total_cases_per_million");
						if (s1 != "") {
							if(data.isEmpty()) {
								number = Double.parseDouble(s1);
								log = true;
							}
							else {
								double pre = data.get(size-1).getYValue();
								if(pre<=Double.parseDouble(s1)) {
									number = Double.parseDouble(s1);
									log = true;
								}
							}
						}
					}
					
					if(log) {
						data.add(new XYChart.Data<String,Double>(date.format(DateTimeFormatter.ofPattern("d MMM, yyyy",Locale.US)), number));
						break;
					}
				}
				date = date.plusDays(1);
			}
			if(data.isEmpty()) {
				data.add(new XYChart.Data<String,Double>(StartDate.format(DateTimeFormatter.ofPattern("d MMM, yyyy",Locale.US)), 0.0));
				this.location = this.location+" - No data in this period";
			}
		}
		else {
			LocalDate date = StartDate;
			for (int i = 0; i < duration; i++) {
				data.add(new XYChart.Data<String,Double>(date.format(DateTimeFormatter.ofPattern("d MMM, yyyy",Locale.US)), 0.0));
				date = date.plusDays(1);
			}
			this.location = "Period of interest";
		}
	}
}
