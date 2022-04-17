package comp3111.covid;

import org.apache.commons.csv.CSVRecord;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import edu.duke.FileResource;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.XYChart;

public class CountryA2 {
	String location, StartFormattedDate, EndFormattedDate;
	ObservableList<XYChart.Data<String, Double>> data = FXCollections.observableArrayList();
	
	CountryA2(String dataset, String location, LocalDate StartDate, LocalDate EndDate, int duration){
		this.location = location;
		this.StartFormattedDate = StartDate.format(DateTimeFormatter.ofPattern("M/d/yyyy"));
		this.EndFormattedDate = EndDate.format(DateTimeFormatter.ofPattern("M/d/yyyy"));
		
		FileResource fr = new FileResource("dataset/" + dataset);
		LocalDate date = StartDate;
		
		for (int i = 0; i < duration; i++) {
			String formattedDate = date.format(DateTimeFormatter.ofPattern("M/d/yyyy"));
			for (CSVRecord rec : fr.getCSVParser(true)) {
				double number = 0;
				int size = this.data.size();
				boolean log = false;
				
				if (rec.get("location").equals(location) && rec.get("date").equals(formattedDate)) {
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
					data.add(new XYChart.Data<String,Double>(formattedDate, number));
					break;
				}
			}
			date = date.plusDays(1);
		}
	}
}
/*
if (rec.get("location").equals(location) && rec.get("date").equals(formattedDate)) {
	String s1 = rec.get("total_cases_per_million");
	if (s1 != "") {
		double pre = data.get(size-1).getYValue();
		if(Double.parseDouble(s1)>=pre) {
			number = Double.parseDouble(s1);
		}
		else {
			number = data.get(size-1).getYValue();
		}
	}
	else {
		number = data.get(size-1).getYValue();
	}

}

else {
	if(!data.isEmpty()) {
		number = data.get(size-1).getYValue();
	}
}

data.add(new XYChart.Data<String,Double>(formattedDate, number));
date = date.plusDays(1);
break;
*/
