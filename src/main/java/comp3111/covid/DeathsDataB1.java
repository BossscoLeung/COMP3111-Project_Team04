package comp3111.covid;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import edu.duke.FileResource;

public class DeathsDataB1 {
	private String country;
	private String totalDeath;
	private String totalDeathPer1M;
	
	public DeathsDataB1(String dataset, String country, LocalDate date) {
		this.country = country;
		this.totalDeath = "N/A";
		this.totalDeathPer1M = "N/A";
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy");
		
		for (CSVRecord rec : getFileParser(dataset)) {
			
			if (rec.get("location").equals(country) & (rec.get("date").equals(formatter.format(date)))) {
				String s = rec.get("total_deaths");
				if (!s.equals("")) {
					this.totalDeath = s;
				}
					
				s = rec.get("total_deaths_per_million");
				if (!s.equals("")) {
					this.totalDeathPer1M = s;
				}
			}		
		}
	}
	
	public static CSVParser getFileParser(String dataset) {
	     FileResource fr = new FileResource("dataset/" + dataset);
	     return fr.getCSVParser(true);
	}
	
	public String getCountry() {
		return country;
	}

	public String getTotalDeath() {
		return totalDeath;
	}
	
	public String getTotalDeathPer1M() {
		return totalDeathPer1M;
	}

}
