package comp3111.covid;

import javafx.fxml.FXML;
import javafx.collections.ObservableList;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.TextArea;
import javafx.scene.control.Label;

public class ComFeatureBController{
	
    @FXML
    private NumberAxis xAxis;

    @FXML
    private NumberAxis yAxis;
    
	@FXML
    private ScatterChart<Number, Number> FeatureB;
    
    @FXML
    private TextArea textAreaConsole;
    
    @FXML
    private Label titleB;
		
	
	

    public void showChart(ObservableList<XYChart.Series<Number, Number>> series, String text, String attribute) {
		
		FeatureB.getData().addAll(series);
		
        textAreaConsole.setText(text);
        textAreaConsole.setEditable(false);
        
        titleB.setText("Relation between confirmed deaths and " + attribute);
		
	}
}
