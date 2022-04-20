package comp3111.covid;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

/**
 * Building on the sample skeleton for 'ChartA1.fxml' Controller Class generated by SceneBuilder
 */
public class ChartA2Controller implements Initializable{
	ObservableList<CountryA2> chartList;
	int noOfDate;
	
	/**
	 * 
	 * @param chartList The ObservableList of CountryA2 type to show in the chart
	 * @param noOfDate The number of date in the period
	 */
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

    /**
     * Initialize the scene
     */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
	    
		// input the data into the chart
		double max = 1.0;
		for (CountryA2 country: chartList) {
			XYChart.Series<String, Double> countryData = new XYChart.Series<>(country.location, country.data);
			ChartA2.getData().add(countryData);
			
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