package comp3111.covid;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import org.junit.Before;
import org.junit.Test;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.XYChart;

public class CountryA2Tester {
	String dataset = "COVID_Dataset_v1.0.csv";
	String location;
	LocalDate StartDate;
	LocalDate EndDate;
	int duration;
	ObservableList<XYChart.Data<String, Double>> testdata = FXCollections.observableArrayList();
	CountryA2 HK;
	CountryA2 empty;
	CountryA2 angola;
	CountryA2 EG;
	
	@Before
	public void setUp() throws Exception {
		location = "Hong Kong";
		StartDate = LocalDate.parse("2020-03-01");
		EndDate = LocalDate.parse("2020-03-18");
		duration = 18;
		String[] formdate = {"1 Mar, 2020","2 Mar, 2020","3 Mar, 2020","4 Mar, 2020","5 Mar, 2020","6 Mar, 2020","7 Mar, 2020","8 Mar, 2020","9 Mar, 2020","10 Mar, 2020","11 Mar, 2020",
								"12 Mar, 2020","13 Mar, 2020","14 Mar, 2020","15 Mar, 2020","16 Mar, 2020","17 Mar, 2020","18 Mar, 2020",}; 
		double[] fornumber = {12.805,
							13.339,
							13.339,
							14.006,
							14.006,
							14.272,
							14.406,
							15.206,
							15.339,
							16.006,
							16.807,
							17.207,
							17.874,
							18.674,
							19.341,
							20.675,
							21.609,
							24.143
		};
		
		for (int i = 0; i < duration; i++) {
			testdata.add(new XYChart.Data<String,Double>(formdate[i], fornumber[i]));
		}
		
		HK = new CountryA2(dataset, "Hong Kong", StartDate, EndDate, duration);
		EG = new CountryA2(dataset, "Equatorial Guinea", StartDate, EndDate, duration);
		empty = new CountryA2(dataset, "", StartDate, EndDate, duration);
		angola = new CountryA2(dataset, "Angola", StartDate, EndDate, duration);
		
	}

	@Test
	public void CountryHasDataInthePeriod() {
		assertEquals(HK.location, "Hong Kong");
	}
	
	@Test
	public void GenerateLineforinterset() {
		assertEquals(empty.location, "Period of interest");
	}
	
	@Test
	public void CountryWithAllDataInthePeriod() {
		assertEquals(testdata, HK.data);
	}
	
	@Test
	public void CountryWithSomeMissingDataInthePeriod() {
		ObservableList<XYChart.Data<String, Double>> testdata1 = FXCollections.observableArrayList();
		testdata1.add(new XYChart.Data<String,Double>("15 Mar, 2020", 0.713));
		testdata1.add(new XYChart.Data<String,Double>("16 Mar, 2020", 0.713));
		testdata1.add(new XYChart.Data<String,Double>("17 Mar, 2020", 0.713));
		testdata1.add(new XYChart.Data<String,Double>("18 Mar, 2020", 2.851));
		assertEquals(testdata1, EG.data);
	}
	
	@Test
	public void CountryHasNoDataInthePeriod() {
		assertEquals(angola.location, "Angola - No data in this period");
	}
	
}
