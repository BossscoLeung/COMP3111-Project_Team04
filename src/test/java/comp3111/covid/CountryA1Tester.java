package comp3111.covid;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class CountryA1Tester {
	String country;
	CountryA1 data;
	String date = "4/28/2021";
	String iDataset = "COVID_Dataset_v1.0.csv";
	
	@Before
	public void setUp() throws Exception {
		country = "Hong Kong";
		data = new CountryA1(iDataset, country, date);
	}
	
	@Test
	public void getCountryExist() {
		String test = data.getLocation();
		assertEquals(test, "Hong Kong");
	}
	
	@Test
	public void TotalCasesWithCountryExist() {
		String total = data.getNoOfTotalCasesString();
		assertEquals(total, "11755");
	}
	
	@Test
	public void TotalCasesPer1MWithCountryExist() {
		String total = data.getNoOfTotalCasesPer1MString();
		assertEquals(total, "1567.963");
	}
	
	@Test
	public void TotalCasesWithCountryNotExist() {
		CountryA1 test = new CountryA1(iDataset, "No such country", date);
		String total = test.getNoOfTotalCasesString();
		assertEquals(total, "No Data");
	}
	
	@Test
	public void TotalCasesWithNoData() {
		CountryA1 test = new CountryA1(iDataset, "Aruba", date);
		String total = test.getNoOfTotalCasesString();
		assertEquals(total, "No Data");
	}
}
