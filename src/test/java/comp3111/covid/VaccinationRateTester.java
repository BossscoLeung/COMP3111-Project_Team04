package comp3111.covid;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

public class VaccinationRateTester {
    String country;
    VaccinationRate data;
    LocalDate date = LocalDate.parse("2021-04-28");
    String iDataset = "COVID_Dataset_v1.0.csv";

    @Before
    public void setUp() throws Exception {
        country = "Hong Kong";
        data = new VaccinationRate();
        data.update(iDataset, country, date);
    }

    @Test
    public void getCountryExist() {
        String test = data.getCountry();
        assertEquals(country, test);
    }

    @Test
    public void getPeopleVaccinatedWithCountryExist() {
        String test = data.getPeopleVaccinated();
        assertEquals("467576", test);
    }

    @Test
    public void getPeopleVaccinatedPer100WithCountryExist() {
        String test = data.getPeopleVaccinatedPer100();
        assertEquals("6.24", test);
    }

    @Test
    public void getPeopleVaccinatedWithCountryNotExist() {
        data.update(iDataset, "Foo", date);
        String test = data.getPeopleVaccinated();
        assertEquals("N/A", test);
    }

    @Test
    public void getPeopleVaccinatedWithNoData() {
        data.update(iDataset, "Afghanistan", date);
        String test = data.getPeopleVaccinated();
        assertEquals("N/A", test);
    }
}
