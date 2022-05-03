package comp3111.covid;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.XYChart;

public class ComFeatureTester {
	ObservableList<String> CountryList = FXCollections.observableArrayList();
	String iDataset = "COVID_Dataset_v1.0.csv"; 
	
	ComFeatureB data = new ComFeatureB();
	
	ObservableList<XYChart.Series<Number, Number>> dataList;
	String attribute = "icu_patients_per_million";
	
	@Before
	public void setUp() throws Exception {
		CountryList.add("Denmark");
		dataList = data.Data(iDataset, CountryList, attribute);
		
	}

	@Test
	public void oReportEmpty() {
		assertEquals(data.getText(), "");
	}
	
	@Test
	public void oReportNotEmpty() {
		CountryList.add("Hong Kong");
		CountryList.add("Aruba");
		dataList = data.Data(iDataset, CountryList, attribute);
		
		
		String result = "Hong Kong does not have any data in icu_patients_per_million.\n"
				+ "Aruba does not have any data in icu_patients_per_million.\n";
		assertEquals(data.getText(), result);
	}
}
