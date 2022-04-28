package comp3111.covid;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Iterator;

import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import edu.duke.FileResource;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.XYChart;
import javafx.scene.text.Text;

public class DeathsDataB2 {	
	private String oReport = "";
	
	public ObservableList<XYChart.Series<String, Double>> Data(String iDataset, ObservableList<String> countryList, LocalDate StartDate, LocalDate EndDate){

		ObservableList<XYChart.Series<String, Double>> series = FXCollections.observableArrayList();
		long numOfDays = ChronoUnit.DAYS.between(StartDate, EndDate) + 1;		
			
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy");
		
		
		for (String country : countryList) {
			FileResource fr = new FileResource("dataset/" + iDataset);
			CSVParser dataset = fr.getCSVParser(true);
			
			XYChart.Series<String, Double> seriesItem = new XYChart.Series<String, Double>();
			seriesItem.setName(country);
			long numDays = numOfDays;
			boolean noData = false;
			
			
			Iterator<CSVRecord>recordIter = dataset.iterator();

	        while(recordIter.hasNext()){
	            CSVRecord rec = recordIter.next();
	            if (rec.get("location").equals(country)) {
	            	Double preValue = 0.0;		//Used for no data
	            	long i = 0;		//iterator for number of days	            	
	            	//finding startDate
	            	LocalDate recDate = LocalDate.parse(rec.get("date"), formatter);
					LocalDate startingDate = LocalDate.parse(StartDate.format(formatter), formatter);

					
	            	while (startingDate.isAfter(recDate)) {
	            		rec = recordIter.next();
	            		recDate = LocalDate.parse(rec.get("date"), formatter);
	            	}
            	
	            	while (startingDate.isBefore(recDate) && numDays > 0) {
	            		String date = startingDate.format(formatter);
	            		XYChart.Data<String, Double> node = new XYChart.Data<String, Double>(date, preValue);
	            		node.setYValue(preValue);
	            		node.setNode(new Text("x"));
	            		seriesItem.getData().add(node);
	            		noData = true;
	            		
	            		numDays--;
	            		startingDate = startingDate.plusDays(1);
	            	}
	            	
	            	//add all data in the period
	            	while (i < numDays) {
	            		String date = rec.get("date");
	            		if ((rec.get("location").equals(country)) & !(rec.get("total_deaths_per_million") == "")) {         			
	            			Double value = Double.valueOf(rec.get("total_deaths_per_million"));
	            			XYChart.Data<String, Double> node = new XYChart.Data<String, Double>(date, value);
	            			
	            			if (numOfDays > 30) node.setNode(new Text(""));
	            			seriesItem.getData().add(node);
	            			preValue = value;
	            		}
	            		else {
	            			XYChart.Data<String, Double> node = new XYChart.Data<String, Double>(date, preValue);
	            			node.setYValue(preValue);
	                        node.setNode(new Text("x"));
	                        seriesItem.getData().add(node);
	                        noData = true;
	            		}
	            		i++;
	            		rec = recordIter.next();
	            	}
					break;
	            }
	        }
	        series.add(seriesItem); 
	        if (noData) oReport = oReport + country + "\n";
		}
		return series;
	}
	
	
	
	public String getText() {
		if (oReport == "") return oReport;
		oReport = "Some data of the following countries is missing from the dataset and marked with \"x\":" + "\n" + oReport;
		return oReport;
	}

}
