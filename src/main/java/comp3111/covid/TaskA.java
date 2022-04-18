package comp3111.covid;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import javafx.collections.ObservableList;


/**
 * A Program to display the input in the console 
 * @author Bosco Leung
 */

public class TaskA{
	
	/**
	 * @param dataset The filename of dataset we want to use
	 * @param countrtList The list of interested countries
	 * @param date The interested date
	 * @return The formatted output string that can show directly
	 */
	public static String generateTableA1(String dataset, ObservableList<String> countryList, LocalDate date) {
		String oReport = "";
		oReport += String.format("=========Task required=========\nGenerate data tables showing the number of confirmed COVID-19 cases by country\n");
		oReport += String.format("=========Dateset used=========\n%s\n", dataset);
		oReport += String.format("========Date of interest========\n%s\n", date.format(DateTimeFormatter.ofPattern("d MMM, yyyy",Locale.US)));
		oReport += String.format("=======Countries of interest======\n");
		
		for (String obj: countryList) {
    		oReport += String.format("%s\n", obj);
    		
    	}
    	
		return oReport;
	}
	
	/**
	 * @param dataset The filename of dataset we want to use
	 * @param countrtList The list of interested countries
	 * @param startDate The starting date of the period
	 * @param endDate The ending date of the period
	 * @return The formatted output string that can show directly
	 */
	public static String generateChartA2(String dataset, ObservableList<String> countrtList, LocalDate startDate, LocalDate endDate) {
		String oReport = "";
		oReport += String.format("=========Task required=========\nGenerate data charts showing the cumulative confirmed COVID-19 cases (per 1M) by country\n");
		oReport += String.format("=========Dateset used=========\n%s\n", dataset);
		oReport += String.format("========Date of interest========\n%s - %s\n", startDate.format(DateTimeFormatter.ofPattern("d MMM, yyyy",Locale.US)), endDate.format(DateTimeFormatter.ofPattern("d MMM, yyyy",Locale.US)));
		oReport += String.format("=======Countries of interest======\n");
		
    	for (Object obj: countrtList) {
    		oReport += String.format("%s\n", obj);
    	}
    	
		return oReport;
	}
	
	/**
	 * 
	 * @param dataset The filename of dataset we want to use
	 * @param intersetedDate The interested date to be analysis
	 * @return The formatted output string that can show directly
	 */
	public static String generateComFeatureA(String dataset, LocalDate intersetedDate) {
		String oReport = "";
		oReport += String.format("=========Task required=========\nCommendable Feature of Task A\n");
		oReport += String.format("This is aim to show whether COVID-19 test will have relation on the confirmed cases.\n");
		oReport += String.format("=========Dateset used=========\n%s\n", dataset);
		oReport += String.format("========Date of interest========\n%s\n", intersetedDate.format(DateTimeFormatter.ofPattern("d MMM, yyyy",Locale.US)));
    	
		return oReport;
	}
}
