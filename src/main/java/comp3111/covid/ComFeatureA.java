package comp3111.covid;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.apache.commons.csv.CSVRecord;
import edu.duke.FileResource;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.XYChart;

/**
 * A program for generating Commandable feature for task A
 * @author Bosco Leung
 *
 */
public class ComFeatureA {
	ObservableList<XYChart.Data<Double, Double>> data = FXCollections.observableArrayList();
	double maxConfirmedPercentage = 0;
	double maxTestPercentage = 0;
	
	/**
	 * Instantiate for commendable feature which record the required information
	 * @param dataset The filename of dataset we want to use
	 * @param intersetedDate The interested date
	 */
	public ComFeatureA(String dataset, LocalDate intersetedDate){
		String formattedDate = intersetedDate.format(DateTimeFormatter.ofPattern("M/d/yyyy"));
		FileResource fr = new FileResource("dataset/" + dataset);
		for (CSVRecord rec : fr.getCSVParser(true)) {
			String s1 = rec.get("date");
			String s2 = rec.get("total_cases_per_million");
			String s3 = rec.get("total_tests_per_thousand");
				
			if (s1.equals(formattedDate) && !s2.equals("") && !s3.equals("")) {
				double precentage = Double.parseDouble(s2)/10000;
				data.add(new XYChart.Data<Double,Double>(Double.parseDouble(s3)/10, precentage));
				if(precentage > maxConfirmedPercentage){
					maxConfirmedPercentage = precentage;
				}
				if(Double.parseDouble(s3)/10>maxTestPercentage) {
					maxTestPercentage = Double.parseDouble(s3)/10;
				}
			}
		}
		System.out.print("no of data"+data.size()+"\n");
		for (int i =0; i<data.size();i++) {
			System.out.print(data.get(i).getXValue()+",");
		}
		System.out.print("\n");
		for (int i =0; i<data.size();i++) {
			System.out.print(data.get(i).getYValue()+",");
		}
		
	}
}
