package comp3111.covid;


import javafx.fxml.FXML;
import javafx.collections.ObservableList;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.TextArea;

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
