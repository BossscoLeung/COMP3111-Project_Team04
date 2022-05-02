package comp3111.covid;

import java.util.Iterator;

import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import edu.duke.FileResource;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.XYChart;

/**
 * 
 * A program to extract data from the dataset for generating the chart in commendable feature B
 * @author Ho Ka Shuen
 * 
 */
public class ComFeatureB {	
	private String oReport = "";

	/**
	 * Gets the data points corresponding to the interested countries and attribute
	 * @param iDataset The dataset to use
	 * @param countryList The list of interested countries
	 * @param attribute The interested attribute
	 * @return
	 */
	public ObservableList<XYChart.Series<Number, Number>> Data(String iDataset, ObservableList<String> countryList, String attribute){
		
		ObservableList<XYChart.Series<Number, Number>> series = FXCollections.observableArrayList();		
		
		for (String country : countryList) {
			FileResource fr = new FileResource("dataset/" + iDataset);
			CSVParser dataset = fr.getCSVParser(true);
			
			XYChart.Series<Number, Number> seriesItem = new XYChart.Series<Number, Number>();
			seriesItem.setName(country);
			boolean noData = true;
			
			
			Iterator<CSVRecord>recordIter = dataset.iterator();

	        while(recordIter.hasNext()){
	            CSVRecord rec = recordIter.next();
	            if (rec.get("location").equals(country)) {            	
	            	
	            	//add all data in the period
	            	while (rec.get("location").equals(country)) {
	            		if (!(rec.get(attribute) == "") && !(rec.get("total_deaths_per_million") == "")) {         			
	            			Double value = Double.valueOf(rec.get(attribute));
	            			Double num = Double.valueOf(rec.get("total_deaths_per_million"));
	            			XYChart.Data<Number, Number> node = new XYChart.Data<Number, Number>(num, value);

	            			seriesItem.getData().add(node);
	            			noData = false;
	            		}
	            		rec = recordIter.next();
	            		rec = recordIter.next();
	            	}
					break;
	            }
	        }
	        series.add(seriesItem); 
	        if (noData) oReport = oReport + country + " does not have any data in " + attribute + ".\n";
		}
		return series;
	}
	
	/**
	 * Gets the text to be shown in the Text Area Console
	 * @return the text message
	 */
	public String getText() {
		return oReport;
	}

}
