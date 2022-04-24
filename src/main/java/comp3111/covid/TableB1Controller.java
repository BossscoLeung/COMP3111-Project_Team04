package comp3111.covid;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;


public class TableB1Controller{

    @FXML
    private TableColumn<DeathsDataB1, String> ColumnCountry;

    @FXML
    private TableColumn<DeathsDataB1, String> ColumnDeaths;

    @FXML
    private TableColumn<DeathsDataB1, String> ColumnDeaths1M;

    @FXML
    private TableView<DeathsDataB1> TableB1;
    
    @FXML
    private Text TitleB1;
    
    
    public void showTable(ObservableList<DeathsDataB1> DataList) {
    	
    	this.ColumnCountry.setCellValueFactory(new PropertyValueFactory<DeathsDataB1, String>("country"));
    	this.ColumnDeaths.setCellValueFactory(new PropertyValueFactory<DeathsDataB1, String>("totalDeath"));
    	this.ColumnDeaths1M.setCellValueFactory(new PropertyValueFactory<DeathsDataB1, String>("totalDeathPer1M"));
    	
    	TableB1.setItems(DataList);
    }

}


