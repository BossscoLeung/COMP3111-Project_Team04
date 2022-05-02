package comp3111.covid;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import org.junit.Before;
import org.junit.Test;

import javafx.collections.ObservableList;
import javafx.scene.chart.XYChart;

public class CountryA2Tester {
	String dataset = "COVID_Dataset_v1.0.csv";
	LocalDate StartDate = LocalDate.parse("2020-03-01");
	LocalDate EndDate = LocalDate.parse("2020-03-18");
	int duration = 18;

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testCountryHasDataInthePeriod() {
		CountryA2 HK = new CountryA2(dataset, "Hong Kong", StartDate, EndDate, duration);
		assertEquals(HK.location, "Hong Kong");
	}
	
	@Test
	public void testGenerateLineforinterset() {
		CountryA2 empty = new CountryA2(dataset, "", StartDate, EndDate, duration);
		assertEquals(empty.location, "Period of interest");
	}
	
	@Test
	public void testCountryWithAllDataInthePeriod() {
		String[] formdate = {"1 Mar, 2020","2 Mar, 2020","3 Mar, 2020","4 Mar, 2020","5 Mar, 2020","6 Mar, 2020","7 Mar, 2020","8 Mar, 2020","9 Mar, 2020","10 Mar, 2020","11 Mar, 2020",
				"12 Mar, 2020","13 Mar, 2020","14 Mar, 2020","15 Mar, 2020","16 Mar, 2020","17 Mar, 2020","18 Mar, 2020"}; 
		double[] fornumber = {12.805, 13.339, 13.339, 14.006, 14.006, 14.272, 14.406, 15.206, 15.339, 16.006, 16.807, 17.207, 17.874, 18.674, 19.341, 20.675, 21.609, 24.143};
		
		boolean allSame = false;
		
		CountryA2 HK = new CountryA2(dataset, "Hong Kong", StartDate, EndDate, duration);
		ObservableList<XYChart.Data<String, Double>> datalist = HK.data;
		
		if (datalist.size()==formdate.length) {
			allSame = true;
			for(int i = 0; i < formdate.length; i++) {
				if(datalist.get(i).getYValue() != fornumber[i]) {
					allSame = false;
					break;
				}
			}
		}
		
		assertTrue(allSame);
	}
	
	@Test
	public void testCountryWithSomeMissingDataInthePeriod() {
		String[] formdate = {"15 Mar, 2020","16 Mar, 2020","17 Mar, 2020","18 Mar, 2020"}; 
		double[] fornumber = {0.713,0.713,0.713,2.851};
		
		boolean allSame = false;
		
		CountryA2 EG = new CountryA2(dataset, "Equatorial Guinea", StartDate, EndDate, duration);
		ObservableList<XYChart.Data<String, Double>> datalist = EG.data;
		
		if (datalist.size()==formdate.length) {
			allSame = true;
			
			for(int i = 0; i < formdate.length; i++) {
				if(datalist.get(i).getYValue() != fornumber[i]) {
					allSame = false;
					break;
				}
			}
		}
		
		assertTrue(allSame);
	}
	
	@Test
	public void testCountryHasNoDataInthePeriod() {
		CountryA2 angola = new CountryA2(dataset, "Angola", StartDate, EndDate, duration);
		assertEquals(angola.location, "Angola - No data in this period");
	}
	
}
