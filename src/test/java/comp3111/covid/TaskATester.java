package comp3111.covid;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import org.junit.Before;
import org.junit.Test;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class TaskATester {
	String dataset = "COVID_Dataset_v1.0.csv";
	ObservableList<String> countryList = FXCollections.observableArrayList();
	LocalDate date1;
	LocalDate date2;
	
	@Before
	public void setUp() throws Exception {
		date1 = LocalDate.parse("2020-05-05");
		date2 = LocalDate.parse("2020-06-06");
		countryList.add("Afghanistan");
		countryList.add("Hong Kong");
		countryList.add("Italy");
	}

	@Test
	public void testStringOutputOfTableA1(){
		String testResult = "";
		testResult += String.format("=========Task required=========\nGenerate data tables showing the number of confirmed COVID-19 cases by country\n");
		testResult += String.format("=========Dateset used=========\n%s\n", dataset);
		testResult += String.format("========Date of interest========\n%s\n", date1.format(DateTimeFormatter.ofPattern("d MMM, yyyy",Locale.US)));
		testResult += String.format("=======Countries of interest======\n");
		for (String obj: countryList) {
			testResult += String.format("%s\n", obj);
    		
    	}
		assertEquals(TaskA.generateTableA1(dataset, countryList, date1), testResult);
	}
	
	@Test
	public void testStringOutputOfTableA2(){
		String testResult = "";
		testResult += String.format("=========Task required=========\nGenerate data charts showing the cumulative confirmed COVID-19 cases (per 1M) by country\n");
		testResult += String.format("=========Dateset used=========\n%s\n", dataset);
		testResult += String.format("========Date of interest========\n%s - %s\n", date1.format(DateTimeFormatter.ofPattern("d MMM, yyyy",Locale.US)), date2.format(DateTimeFormatter.ofPattern("d MMM, yyyy",Locale.US)));
		testResult += String.format("=======Countries of interest======\n");
		
    	for (Object obj: countryList) {
    		testResult += String.format("%s\n", obj);
    	}
		assertEquals(TaskA.generateChartA2(dataset, countryList, date1, date2), testResult);
	}
	
	@Test
	public void testStringOutputOfComFeatureA(){
		String testResult = "";
		testResult += String.format("=========Task required=========\nCommendable Feature of Task A\n");
		testResult += String.format("This is aim to show whether COVID-19 test will have relation on the confirmed cases.\n");
		testResult += String.format("=========Dateset used=========\n%s\n", dataset);
		testResult += String.format("========Date of interest========\n%s\n", date1.format(DateTimeFormatter.ofPattern("d MMM, yyyy",Locale.US)));
		
		assertEquals(TaskA.generateComFeatureA(dataset, date1), testResult);
	}
}
