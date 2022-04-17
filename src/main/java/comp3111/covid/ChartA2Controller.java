package comp3111.covid;

import java.net.URL;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.Iterator;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;


public class ChartA2Controller implements Initializable{
	ObservableList<CountryA2> chartList;
	int noOfDate;
	
	
	public ChartA2Controller(ObservableList<CountryA2> chartList, int noOfDate) {
		this.chartList = chartList;
		this.noOfDate = noOfDate;
		
	}

	@FXML
    private LineChart<String, Double> ChartA2;
	
    @FXML
    private NumberAxis yAxis;

    @FXML
    private CategoryAxis xAxis;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
	    
		// input the data into the chart
		double max = 1.0;
		boolean setted = false;
		for (CountryA2 country: chartList) {
			XYChart.Series<String, Double> countryData = new XYChart.Series<>(country.location, country.data);
			
			if(!setted && country.data.size() == noOfDate) {
				ChartA2.getData().set(0, countryData);
				setted = true;
			}
			else {
				ChartA2.getData().add(countryData);
			}
			
			if(!country.data.isEmpty()) {
				double a = country.data.get(country.data.size()-1).getYValue();
				if(a > max) {
					max = a;
				}
			}
		}

		// set y axis
		int len = String.valueOf((int)Math.ceil(max)).length() - 1;
        if (len == 0) len = 1;
        int d = (int) Math.pow((double) 10, (double) len);
        int setMax = ((int)Math.ceil(max) + (d - 1)) / d * d;
        yAxis.setAutoRanging(false);
        yAxis.setUpperBound(setMax);
        yAxis.setTickUnit(setMax/5);
		
        // set x axis
		xAxis.setTickLength(10);
		xAxis.setTickLabelGap(10/this.noOfDate);
		xAxis.setTickLabelRotation(-20);
	}
	
}
