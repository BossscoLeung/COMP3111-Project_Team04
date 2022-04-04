package comp3111.covid;

import org.apache.commons.csv.*;
import edu.duke.*;
import javafx.collections.ObservableList;


/**
 * 
 * Task A1
 * @author Bosco Leung
 * @version	1.0
 * 
 */

public class TaskA{

	public static CSVParser getFileParser(String dataset) {
	     FileResource fr = new FileResource("dataset/" + dataset);
	     return fr.getCSVParser(true);
	}
	
	public static String generateTableA1(String dataset, ObservableList<String> countrtList, String date) {
		String oReport = "";
		oReport += String.format("=========Dateset used=========\n%s\n", dataset);
		oReport += String.format("========Date of interest========\n%s\n", date);
		oReport += String.format("=======Countries of interest======\n");
		
		for (String obj: countrtList) {
    		oReport += String.format("%s\n", obj);
    		
    	}
    	
		return oReport;
	}
	
	public static String generateChartA2(String dataset, ObservableList<String> countrtList, String startDate, String endDate) {
		String oReport = "";
		oReport += String.format("=========Dateset used=========\n%s\n", dataset);
		oReport += String.format("========Date of interest========\n%s - %s\n", startDate, endDate);
		oReport += String.format("=======Countries of interest======\n");
		
    	for (Object obj: countrtList) {
    		oReport += String.format("%s\n", obj);
    	}
    	
		return oReport;
	}
}
