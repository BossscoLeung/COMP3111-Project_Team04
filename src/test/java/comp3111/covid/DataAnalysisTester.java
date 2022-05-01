package comp3111.covid;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class DataAnalysisTester {
	String iso_code = "DEU";
	String iso_code2 = "OWID_INT";
	String iso_code3 = "OWID_CYN";
	String dataset = "COVID_Dataset_v1.0.csv";
	
	String oReport;
	DataAnalysis data = new DataAnalysis();
	String test;
	
	@Test
	public void getConfirmedCasesTest() {
		oReport = String.format("Dataset (%s): %,d Records\n\n", dataset, 103907);
		oReport += String.format("[Summary (%s)]\n", iso_code);
		oReport += String.format("Number of Confirmed Cases: %,d\n", 3754846);
		oReport += String.format("Number of Days Reported: %,d\n", 541);
		
		test = data.getConfirmedCases(dataset, iso_code);
		
		assertEquals(test, oReport);
	}
	
	@Test
	public void getConfirmedDeathsTest() {
		oReport = String.format("Dataset (%s): %,d Records\n\n", dataset, 103907);
		oReport += String.format("[Summary (%s)]\n", iso_code);
		oReport += String.format("Number of Deaths: %,d\n", 91423);
		oReport += String.format("Number of Days Reported: %,d\n", 499);
		
		test = data.getConfirmedDeaths(dataset, iso_code);
		
		assertEquals(test, oReport);
	}
	
	@Test
	public void getRateOfVaccinationTest() {
		oReport = String.format("Dataset (%s): %,d Records\n\n", dataset, 103907);
		oReport += String.format("[Summary (%s)]\n", iso_code);
		oReport += String.format("Number of People Fully Vaccinated: %,d\n", 39309478);
		oReport += String.format("Population: %,d\n", 83783945);
		oReport += String.format("Rate of Vaccination: %.2f%%\n", 46.92);
		oReport += String.format("Number of Days Reported: %,d\n", 206);
		
		test = data.getRateOfVaccination(dataset, iso_code);
		
		assertEquals(test, oReport);
	}
	
	@Test
	public void getRateOfVaccinationTestWithMissingData() {
		oReport = String.format("Dataset (%s): %,d Records\n\n", dataset, 103907);
		oReport += String.format("[Summary (%s)]\n", iso_code3);
		oReport += String.format("Number of People Fully Vaccinated: %,d\n", 0);
		oReport += String.format("Population: %,d\n", 0);
		oReport += String.format("Rate of Vaccination: %.2f%%\n", 0.0);
		oReport += String.format("Number of Days Reported: %,d\n", 0);
		
		test = data.getRateOfVaccination(dataset, iso_code3);
		
		assertEquals(test, oReport);
	}
	
	

}
