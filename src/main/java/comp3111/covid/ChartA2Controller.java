package comp3111.covid;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;


public class ChartA2Controller implements Initializable{
	ObservableList<CountryA2> chartList;
	
	
	public ChartA2Controller(ObservableList<CountryA2> chartList) {
		this.chartList = chartList;
	}

	@FXML
    private LineChart<String, Double> ChartA2;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		ChartA2.setCreateSymbols(false);
		for (CountryA2 country: chartList) {
			XYChart.Series<String,Double> countryData = new XYChart.Series<>(country.location, country.data);
			ChartA2.getData().add(countryData);
		}
	}
	
}
