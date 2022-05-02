package comp3111.covid;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.XYChart;

public class DeathsDataB2Tester {
	ObservableList<String> CountryList = FXCollections.observableArrayList();
	ObservableList<String> CountryList2 = FXCollections.observableArrayList();
	String iDataset = "COVID_Dataset_v1.0.csv"; 
	LocalDate StartDate = LocalDate.parse("2020-03-01");
	LocalDate EndDate = LocalDate.parse("2021-02-28");
	LocalDate ShortPeriodEndDate = LocalDate.parse("2020-03-02");
	
	DeathsDataB2 data1 = new DeathsDataB2();
	DeathsDataB2 data2 = new DeathsDataB2();
	
	ObservableList<XYChart.Series<String, Double>> dataList1;
	ObservableList<XYChart.Series<String, Double>> dataList2;
	
	@Before
	public void setUp() throws Exception {
		CountryList.add("Hong Kong");
		dataList1 = data1.Data(iDataset, CountryList, StartDate, ShortPeriodEndDate);
		
		CountryList2.add("Hong Kong");
		CountryList2.add("Jersey");
		CountryList2.add("Vietnam");
		dataList2 = data2.Data(iDataset, CountryList2, StartDate, EndDate);
	}

	@Test
	public void oReportEmpty() {
		assertEquals(data1.getText(), "");
	}
	
	@Test
	public void oReportNotEmpty() {
		String testResult = "Some data of the following countries is missing from the dataset and marked with \"x\":" + "\n" + "Jersey" + "\n" + "Vietnam" + "\n";
		assertEquals(data2.getText(), testResult);
	}
	
	@Test
	public void CountryNotExist() {
		CountryList.add("No such country");
		dataList1 = data1.Data(iDataset, CountryList, StartDate, ShortPeriodEndDate);
		
		assertEquals(data1.getText(), "");
	}
}
