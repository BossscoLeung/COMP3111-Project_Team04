package comp3111.covid;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import edu.duke.FileResource;

/**
 * Represents a data recording the total death and total death per 1M of the interested country for generating Table B1
 * @author Ho Ka Shuen
 *
 */
public class DeathsDataB1 {
	private String country;
	private String totalDeath;
	private String totalDeathPer1M;
	
	/**
	 * Extracts data from the dataset corresponding to the country interested
	 * @param dataset The dataset to be used
	 * @param country The country interested
	 * @param date The date interested
	 */
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
	
	/**
	 * 
	 * @param dataset The filename of the dataset
	 * @return the CSVParser of the dataset
	 */
	public static CSVParser getFileParser(String dataset) {
	     FileResource fr = new FileResource("dataset/" + dataset);
	     return fr.getCSVParser(true);
	}
	
	/**
	 * 
	 * @return the country interested
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * 
	 * @return the number of total deaths
	 */
	public String getTotalDeath() {
		return totalDeath;
	}
	
	/**
	 * 
	 * @return the number of total deaths per 1M
	 */
	public String getTotalDeathPer1M() {
		return totalDeathPer1M;
	}

}
