package comp3111.covid;

import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import edu.duke.FileResource;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.text.Text;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.ResourceBundle;

public class ChartB2Controller{
	
	@FXML
    private LineChart<String, Double> ChartB2;
	
    @FXML
    private CategoryAxis xAxis;

    @FXML
    private NumberAxis yAxis;
    
    @FXML
    private TextArea textAreaConsole;
		
	
	

    public void showChart(ObservableList<XYChart.Series<String, Double>> series, String text) {
		
		ChartB2.getData().addAll(series);
		//ChartB2.setCreateSymbols(false);
		
        textAreaConsole.setText(text);
        textAreaConsole.setEditable(false);
		
	}
}
