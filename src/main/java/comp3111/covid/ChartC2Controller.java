package comp3111.covid;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.TextArea;

public class ChartC2Controller {

    @FXML
    private LineChart<String, Double> ChartC2;

    @FXML
    private TextArea textAreaConsole;

    @FXML
    private CategoryAxis xAxis;

    @FXML
    private NumberAxis yAxis;

    public void showChart(ObservableList<XYChart.Series<String, Double>> series) {
    	ChartC2.getData().addAll(series);
    }
}
