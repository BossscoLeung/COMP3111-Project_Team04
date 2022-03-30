package comp3111.covid;

import org.apache.commons.csv.*;
import edu.duke.*;

/**
 * 
 * Task A1
 * @author Bosco Leung
 * @version	1.0
 * 
 */

public class TaskA {
	
	public static CSVParser getFileParser(String dataset) {
	     FileResource fr = new FileResource("dataset/" + dataset);
	     return fr.getCSVParser(true);
	}
	
	
}
