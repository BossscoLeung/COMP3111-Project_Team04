package comp3111.covid;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import edu.duke.FileResource;

public class VaccinationRate {
    private String country;
    private String peopleVaccinated;
    private String peopleVaccinatedPer100;
    private String formattedDate;

    public VaccinationRate() {
    	this.country = "N/A";
		this.peopleVaccinated = "N/A";
		this.peopleVaccinatedPer100 = "N/A";
		this.formattedDate = "";
	}

    public static CSVParser getFileParser(String dataset) {
        FileResource fr = new FileResource("dataset/" + dataset);
        return fr.getCSVParser(true);
    }
    
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

    public String getCountry() {
        return country;
    }

    public String getPeopleVaccinated() {
        return peopleVaccinated;
    }

    public String getPeopleVaccinatedPer100() {
        return peopleVaccinatedPer100;
    }
    
    public String getFormattedDate() {
    	return formattedDate;
    }
}
