package comp3111.covid;

import org.apache.commons.csv.CSVRecord;

import edu.duke.FileResource;

public class countryA1 {
	String location, date;
	long noOfTotalCases;
	double noOfTotalCasesPer1M;
	
	countryA1(String dataset, String location, String date){
		this.location = location;
		this.date = date;
		this.noOfTotalCases = -1;
		this.noOfTotalCasesPer1M = -1;
		
		FileResource fr = new FileResource("dataset/" + dataset);
		for (CSVRecord rec : fr.getCSVParser(true)) {
			if (rec.get("location").equals(location) && rec.get("date").equals(date)) {
				
				String s1 = rec.get("total_cases");
				String s2 = rec.get("total_cases_per_million");
				if (!s1.equals("")) {
					this.noOfTotalCases = Long.parseLong(s1);
				}
				if (!s2.equals("")) {
					this.noOfTotalCasesPer1M = Double.parseDouble(s2);
				}
				break;
			}
		}
	}
}
