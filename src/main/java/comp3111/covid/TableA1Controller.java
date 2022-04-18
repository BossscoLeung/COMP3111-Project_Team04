package comp3111.covid;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class TableA1Controller implements Initializable{
	String FormattedDate;
	ObservableList<CountryA1> tableList;
	
    public TableA1Controller(String formattedDate, ObservableList<CountryA1> tableList) {
		FormattedDate = formattedDate;
		this.tableList = tableList;
	}

	@FXML
    private Label titleA1;
    
    @FXML
    private TableColumn<CountryA1, String> colCountry1A;

    @FXML
    private TableColumn<CountryA1, String> colTotalCases;

    @FXML
    private TableColumn<CountryA1, String> colTotalCases1M;
    
    @FXML
    private TableView<CountryA1> tableA1;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		this.titleA1.setText(String.format("Number of Confirmed COVID-19 Cases as of %s", FormattedDate));
		this.colCountry1A.setCellValueFactory(new PropertyValueFactory<CountryA1, String>("location"));
		this.colTotalCases.setCellValueFactory(new PropertyValueFactory<CountryA1, String>("noOfTotalCasesString"));
		this.colTotalCases1M.setCellValueFactory(new PropertyValueFactory<CountryA1, String>("noOfTotalCasesPer1MString"));
		tableA1.setItems(tableList);
	}
	
}
