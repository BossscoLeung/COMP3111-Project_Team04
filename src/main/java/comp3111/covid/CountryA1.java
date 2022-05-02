package comp3111.covid;

import org.apache.commons.csv.CSVRecord;
import edu.duke.FileResource;

/**
 * A program for generating table A1, each instance records the location, 
 * number of total cases and total cases per 1M on a date
 * @author Bosco Leung
 *
 */
public class CountryA1 {
	String location, date, noOfTotalCasesString, noOfTotalCasesPer1MString;
	
	/**
	 * Instantiate a country for Task A1 which record the required information
	 * @param dataset The filename of dataset we want to use
	 * @param location The location of the country
	 * @param date The interested date
	 */
	public CountryA1(String dataset, String location, String date){
		this.location = location;
		this.date = date;
		long noOfTotalCases = -1;
		double noOfTotalCasesPer1M = -1;
		
		FileResource fr = new FileResource("dataset/" + dataset);
		for (CSVRecord rec : fr.getCSVParser(true)) {
			if (rec.get("location").equals(location) && rec.get("date").equals(date)) {
				
				String s1 = rec.get("total_cases");
				String s2 = rec.get("total_cases_per_million");
				if (!s1.equals("")) {
					noOfTotalCases = Long.parseLong(s1);
				}
				if (!s2.equals("")) {
					noOfTotalCasesPer1M = Double.parseDouble(s2);
				}
				break;
			}
		}
		
		if(noOfTotalCases == -1) {
			this.noOfTotalCasesString = "No Data";
		}
		else {
			this.noOfTotalCasesString = Long.toString(noOfTotalCases);
		}
		
		if(noOfTotalCasesPer1M == -1) {
			this.noOfTotalCasesPer1MString = "No Data";
		}
		else {
			this.noOfTotalCasesPer1MString = Double.toString(noOfTotalCasesPer1M);
		}
	}
	
	/**
	 * 
	 * @return The location of the country
	 */
	public String getLocation() {
		return location;
	}
	
	/**
	 * <b>Note:</b> It may not return number in string!
	 * @return The number of total cases in string. If no data found, it will return "No Data"
	 */
	public String getNoOfTotalCasesString() {
		return noOfTotalCasesString;
	}
	
	/**
	 * <b>Note:</b> It may not return number in string!
	 * @return The number of total cases per 1M in string. If no data found, it will return "No Data"
	 */
	public String getNoOfTotalCasesPer1MString() {
		return noOfTotalCasesPer1MString;
	}
	
}
