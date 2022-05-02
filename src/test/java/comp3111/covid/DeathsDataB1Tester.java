package comp3111.covid;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;


public class DeathsDataB1Tester {
	String country;
	DeathsDataB1 data;
	LocalDate date = LocalDate.parse("2021-04-28");
	String iDataset = "COVID_Dataset_v1.0.csv";
	
	@Before
	public void setUp() throws Exception {
		country = "Hong Kong";
		data = new DeathsDataB1(iDataset, country, date);
	}
	
	@Test
	public void getCountryExist() {
		String test = data.getCountry();
		assertEquals(test, "Hong Kong");
	}
	
	@Test
	public void TotalDeathWithCountryExist() {
		String total = data.getTotalDeath();
		assertEquals(total, "209");
	}
	
	@Test
	public void TOtalDeathPer1MWithCountryExist() {
		String total = data.getTotalDeathPer1M();
		assertEquals(total, "27.878");
	}
	
	@Test
	public void TotalDeathWithCountryNotExist() {
		DeathsDataB1 test = new DeathsDataB1(iDataset, "No such country", date);
		String total = test.getTotalDeath();
		assertEquals(total, "N/A");
	}
	
	@Test
	public void TotalDeathWithNoData() {
		DeathsDataB1 test = new DeathsDataB1(iDataset, "Aruba", date);
		String total = test.getTotalDeath();
		assertEquals(total, "N/A");
	}
	
}
