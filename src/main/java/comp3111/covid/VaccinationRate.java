package comp3111.covid;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import edu.duke.FileResource;

/**
 * Represents a data recording the number of people fully vaccinated and people fully vaccinated per 100 of the interested country for generating Table C1
 * @author Matthew Lin
 */
public class VaccinationRate {
    private String country;
    private String peopleVaccinated;
    private String peopleVaccinatedPer100;
    private String formattedDate;

    /**
     * Construct the object and initialise attributes
     */
    public VaccinationRate() {
    	this.country = "N/A";
		this.peopleVaccinated = "N/A";
		this.peopleVaccinatedPer100 = "N/A";
		this.formattedDate = "";
	}

    /**
     *
     * @param dataset the filename of the dataset
     * @return the CSVParser of the dataset
     */
    public static CSVParser getFileParser(String dataset) {
        FileResource fr = new FileResource("dataset/" + dataset);
        return fr.getCSVParser(true);
    }

    /**
     * update attributes according to country and date of interest
     * @param dataset the filename of the dataset
     * @param location the country of interest
     * @param date the date of interest
     */
    public void update(String dataset, String location, LocalDate date) {
    	this.country = location;
        this.peopleVaccinated = "N/A";
        this.peopleVaccinatedPer100 = "N/A";
		this.formattedDate = date.format(DateTimeFormatter.ofPattern("M/d/yyyy"));
		
		for (CSVRecord rec : getFileParser(dataset)) {
			if (rec.get("location").equals(location) & (rec.get("date").equals(formattedDate))) {
				String s = rec.get("people_fully_vaccinated");
				if (!s.equals("")) {
					this.peopleVaccinated = s;
				}
                else this.peopleVaccinated = "N/A";
					
				s = rec.get("people_fully_vaccinated_per_hundred");
				if (!s.equals("")) {
					this.peopleVaccinatedPer100 = s;
				}
                else this.peopleVaccinatedPer100 = "N/A";

				break;
			}
		}
    }

    /**
     *
     * @return the name of the country of interest
     */
    public String getCountry() {
        return country;
    }

    /**
     *
     * @return the number of people fully vaccinated according to the dataset
     */
    public String getPeopleVaccinated() {
        return peopleVaccinated;
    }

    /**
     *
     * @return the number of people fully vaccinated per 100 according to the dataset
     */
    public String getPeopleVaccinatedPer100() {
        return peopleVaccinatedPer100;
    }

    /**
     *
     * @return the formatted date
     */
    public String getFormattedDate() {
    	return formattedDate;
    }
}
