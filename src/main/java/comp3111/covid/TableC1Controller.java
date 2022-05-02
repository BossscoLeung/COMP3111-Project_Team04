package comp3111.covid;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;

public class TableC1Controller {

    @FXML
    private TableColumn<VaccinationRate, String> ColumnCountry;

    @FXML
    private TableColumn<VaccinationRate, String> ColumnVaccinated;

    @FXML
    private TableColumn<VaccinationRate, String> ColumnVaccinationRate;

    @FXML
    private TableView<VaccinationRate> TableC1;

    @FXML
    private Text TitleC1;

    public void showTable(ObservableList<VaccinationRate> DataList, String date) {
    	this.ColumnCountry.setCellValueFactory(new PropertyValueFactory<VaccinationRate, String>("country"));
    	this.ColumnVaccinated.setCellValueFactory(new PropertyValueFactory<VaccinationRate, String>("peopleVaccinated"));
    	this.ColumnVaccinationRate.setCellValueFactory(new PropertyValueFactory<VaccinationRate, String>("peopleVaccinatedPer100"));
    	
    	TableC1.setItems(DataList);
    	TitleC1.setText("Rate of Vaccination against COVID-19 as of " + date);
    }
}
