package comp3111.covid;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import javafx.scene.shape.MoveTo;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.fxml.FXMLLoader;
import java.time.LocalDate;

import org.controlsfx.control.CheckComboBox;
import org.controlsfx.control.CheckListView;

import static org.junit.Assert.*;
import org.junit.Test;
import org.testfx.assertions.api.Assertions;
import org.testfx.framework.junit.ApplicationTest;
import org.testfx.util.WaitForAsyncUtils;

import java.io.IOException;

public class ControllerTester extends ApplicationTest{
	private Pane mainroot;
    private Stage mainstage;
    private Scene s;
    
    private TextArea t;
	
    @Override
    public void start(Stage stage) throws IOException {
        this.mainstage = stage;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/ui.fxml"));
        this.mainroot = loader.load();
        //this.controller = loader.getController();
        stage.setTitle("COMP3111 Team T-04: Data Explorer on COVID-19");
        this.s = new Scene(mainroot);
        stage.setScene(s);
        stage.show();
        stage.toFront();
        
        this.t = (TextArea)s.lookup("#textAreaConsole");
    }

    
    //Task 0
    @Test
    public void testConfirmedCases() {
    	clickOn("#buttonConfirmedCases");
    	String result = "Dataset (COVID_Dataset_v1.0.csv): 103,907 Records\n"
    					+ "\n"
    					+ "[Summary (HKG)]\n"
    					+ "Number of Confirmed Cases: 11,965\n"
    					+ "Number of Days Reported: 545\n";
    	String s1 = t.getText();
    	assertEquals(result,s1);
    }
    
    @Test
    public void testConfirmedDeaths() {
    	clickOn("#buttonConfirmedDeaths");
    	String result = "Dataset (COVID_Dataset_v1.0.csv): 103,907 Records\n"
    			+ "\n"
    			+ "[Summary (HKG)]\n"
    			+ "Number of Deaths: 212\n"
    			+ "Number of Days Reported: 533\n";
    	String s1 = t.getText();
    	assertEquals(result,s1);
    }
    
    @Test
    public void testRateOfVaccination() {
    	clickOn("#buttonRateOfVaccination");
    	String result = "Dataset (COVID_Dataset_v1.0.csv): 103,907 Records\n"
    			+ "\n"
    			+ "[Summary (HKG)]\n"
    			+ "Number of People Fully Vaccinated: 2,065,375\n"
    			+ "Population: 7,496,988\n"
    			+ "Rate of Vaccination: 27.55%\n"
    			+ "Number of Days Reported: 140\n";
    	String s1 = t.getText();
    	assertEquals(result,s1);
    }
    
    //Task A1
    @Test
    public void testPreviewSelectedCountriesA1() {
    	clickOn("#tabReport1");
    	sleep(100);
    	TextArea display = (TextArea)s.lookup("#PreviewSelectedCountriesBoxA1");
    	CheckComboBox<?> button = (CheckComboBox<?>)s.lookup("#checkComboBoxA1");
    	
    	clickOn(button);
    	sleep(200);

    	moveBy(0,25);
    	sleep(100);
    	clickOn();
    	
    	moveBy(0,25);
    	sleep(100);
    	clickOn();
    	
    	clickOn(button);
    	sleep(100);
    	
    	clickOn("#PreviewSelectedCountriesButtonA1");
    	sleep(100);
    	
    	String s1 = display.getText();
    	String result = "Afghanistan\nAfrica\n";
    	
    	assertEquals(result, s1);
    }
    
    @Test
    public void testPreviewSelectedCountriesA2() {
    	clickOn("#tabApp1");
    	sleep(100);
    	TextArea display = (TextArea)s.lookup("#PreviewSelectedCountriesBoxA2");

    	CheckComboBox<?> button = (CheckComboBox<?>)s.lookup("#checkComboBoxA2");
    	
    	clickOn(button);
    	sleep(200);

    	moveBy(0,25);
    	sleep(100);
    	clickOn();
    	
    	moveBy(0,25);
    	sleep(100);
    	clickOn();
    	
    	clickOn(button);
    	sleep(100);
    	
    	clickOn("#PreviewSelectedCountriesButtonA1");
    	sleep(100);
    	
    	String s1 = display.getText();
    	String result = "Afghanistan\nAfrica\n";
    	
    	assertEquals(result, s1);
    }
    
    @Test
    public void testConfirmedCaseTableWithNoInput() {
    	clickOn("#tabReport1");
    	sleep(100);
    	
    	clickOn("#buttonConfirmedCaseTable");
    	
    	String result = "Please select country of interest!";
    	String s1 = t.getText();
    	
    	assertEquals(result, s1);
    }
    
    @Test
    public void testConfirmedCaseTableWithInput() {
    	clickOn("#tabReport1");
    	sleep(100);
    	
    	CheckComboBox<?> button = (CheckComboBox<?>)s.lookup("#checkComboBoxA1");
    	clickOn(button);
    	sleep(100);
    	moveBy(0,25);
    	sleep(100);
    	clickOn();
    	moveBy(0,25);
    	sleep(100);
    	clickOn();
    	sleep(100);
    	clickOn(button);
    	sleep(100);
    	clickOn("#buttonConfirmedCaseTable");
    	WaitForAsyncUtils.waitForFxEvents();
    	
    	String result = "=========Task required=========\n"
    			+ "Generate data tables showing the number of confirmed COVID-19 cases by country\n"
    			+ "=========Dateset used=========\n"
    			+ "COVID_Dataset_v1.0.csv\n"
    			+ "========Date of interest========\n"
    			+ "1 Mar, 2020\n"
    			+ "=======Countries of interest======\n"
    			+ "Afghanistan\n"
    			+ "Africa\n";
    	String s1 = t.getText();
    	
    	assertEquals(result, s1);
    }
    
    @Test
    public void testConfirmedCaseChartWithNoInput() {
    	clickOn("#tabApp1");
    	sleep(100);
    	
    	clickOn("#buttonConfirmedCaseChart");
    	
    	String result = "Please select country of interest!";
    	String s1 = t.getText();
    	
    	assertEquals(result, s1);
    }
    
    @Test
    public void testConfirmedCaseChartWithInput() {
    	clickOn("#tabApp1");
    	sleep(100);
    	
    	CheckComboBox<?> button = (CheckComboBox<?>)s.lookup("#checkComboBoxA2");
    	clickOn(button);
    	
    	sleep(100);
    	moveBy(0,25);
    	sleep(100);
    	clickOn();
    	moveBy(0,25);
    	sleep(100);
    	clickOn();
    	sleep(100);
    	clickOn(button);
    	sleep(100);
    	clickOn("#buttonConfirmedCaseChart");
    	WaitForAsyncUtils.waitForFxEvents();
    	
    	String result = "=========Task required=========\n"
    			+ "Generate data charts showing the cumulative confirmed COVID-19 cases (per 1M) by country\n"
    			+ "=========Dateset used=========\n"
    			+ "COVID_Dataset_v1.0.csv\n"
    			+ "========Date of interest========\n"
    			+ "1 Mar, 2020 - 2 Mar, 2020\n"
    			+ "=======Countries of interest======\n"
    			+ "Afghanistan\n"
    			+ "Africa\n";
    	String s1 = t.getText();
    	
    	assertEquals(result, s1);
    }
    
    @Test
    public void testCommendableFeaturesA() {
    	clickOn("#tabReport1");
    	clickOn("#buttonCommendableFeaturesA");
    	WaitForAsyncUtils.waitForFxEvents();  
    	
    	String result = "=========Task required=========\n"
    			+ "Commendable Feature of Task A\n"
    			+ "This is aim to show whether COVID-19 test will have relation on the confirmed cases.\n"
    			+ "=========Dateset used=========\n"
    			+ "COVID_Dataset_v1.0.csv\n"
    			+ "========Date of interest========\n"
    			+ "1 Mar, 2020\n";
    	
    	String s1 = t.getText();
    	
    	assertEquals(result, s1);
    }
    
    
    
    //Task B1   
    @Test
    public void testContinentB1() {
    	clickOn("#tabReport2");
    	ComboBox<?> continent = (ComboBox<?>)s.lookup("#ContinentB1");
    	clickOn(continent);
    	sleep(500);
    	
    	//clickOn("Africa");
    	moveBy(0,50);
    	clickOn();
    	WaitForAsyncUtils.waitForFxEvents();
    	
    	String s1 = continent.getValue().toString();
    	String result = "Africa";
    	
    	assertEquals(result, s1);
    	
    }
    
    @Test
    public void testContinentB2() {
    	clickOn("#tabApp2");
    	ComboBox<?> continent = (ComboBox<?>)s.lookup("#ContinentB2");
    	clickOn(continent);
    	sleep(500);
    	
    	//clickOn("Africa");
    	moveBy(0,50);
    	clickOn();
    	WaitForAsyncUtils.waitForFxEvents();
    	
    	String s1 = continent.getValue().toString();
    	String result = "Africa";
    	
    	assertEquals(result, s1);
    	
    }
    
    @Test
    public void testTableB1WithNoInput() {
    	clickOn("#tabReport2");
    	sleep(100);
    	
    	clickOn("#GenerateTableB1");
    	
    	String result = "Please select a valid date and at least one country.";
    	String s1 = t.getText();
    	
    	assertEquals(result, s1);
    }
    
    @Test
    public void testTableB1WithMissingInput() {
    	clickOn("#tabReport2");
    	sleep(100);
    	
    	LocalDate date = LocalDate.parse("2021-04-28");
    	DatePicker datePicker = (DatePicker)s.lookup("#DatePickerB1");
    	datePicker.setValue(date);

    	clickOn("#GenerateTableB1");
    	
    	String result = "Please select a valid date and at least one country.";
    	String s1 = t.getText();
    	
    	assertEquals(result, s1);
    }
    
    @Test
    public void testTableB1WithInput() {
    	clickOn("#tabReport2");
    	sleep(100);
    	
    	LocalDate date = LocalDate.parse("2021-04-28");
    	DatePicker datePicker = (DatePicker)s.lookup("#DatePickerB1");
    	datePicker.setValue(date);
    	
    	Node  node = (Node)s.lookup("#SelectCountryB1");
    	CheckListView<?> selectCountry = (CheckListView<?>) node;
    
    	selectCountry.getCheckModel().check(2);
    	WaitForAsyncUtils.waitForFxEvents();
    	

    	clickOn("#GenerateTableB1");
    	
    	String result = "";
    	String s1 = t.getText();
    	
    	assertEquals(result, s1);
    }
    
    @Test
    public void testChartB2WithNoInput() {
    	clickOn("#tabApp2");
    	WaitForAsyncUtils.waitForFxEvents();    	

    	clickOn("#GenerateChartB2");
    	WaitForAsyncUtils.waitForFxEvents();   
    	
    	String result = "Please select a valid period and at least one country.";
    	String s1 = t.getText();
    	
    	assertEquals(result, s1);
    	
    }
    
    @Test
    public void testChartB2WithMissingInput() {
    	clickOn("#tabApp2");
    	WaitForAsyncUtils.waitForFxEvents();   
    	
    	LocalDate EndDate = LocalDate.parse("2021-04-28");
    	DatePicker EndDatePicker = (DatePicker)s.lookup("#DatePickerEndB2");
    	EndDatePicker.setValue(EndDate);

    	clickOn("#GenerateChartB2");
    	WaitForAsyncUtils.waitForFxEvents();
    	
    	
    	String result = "Please select a valid period and at least one country.";
    	String s1 = t.getText();
    	
    	assertEquals(result, s1);
    }
    
    @Test
    public void testChartB2WithInput() {
    	clickOn("#tabApp2");
    	WaitForAsyncUtils.waitForFxEvents();   
    	
    	LocalDate StartDate = LocalDate.parse("2021-04-28");
    	LocalDate EndDate = LocalDate.parse("2021-04-29");
    	DatePicker StartDatePicker = (DatePicker)s.lookup("#DatePickerStartB2");
    	DatePicker EndDatePicker = (DatePicker)s.lookup("#DatePickerEndB2");
    	StartDatePicker.setValue(StartDate);
    	EndDatePicker.setValue(EndDate);
    	
    	Node  node = (Node)s.lookup("#SelectCountryB2");
    	CheckListView<?> selectCountry = (CheckListView<?>) node;

    	selectCountry.getCheckModel().check(2);
    	WaitForAsyncUtils.waitForFxEvents();

    	clickOn("#GenerateChartB2");
    	WaitForAsyncUtils.waitForFxEvents();
    	
    	
    	String result = "";
    	String s1 = t.getText();
    	
    	assertEquals(result, s1);
    }
    
    @Test
    public void testCommendableFeaturesBWithNoInput() {
    	clickOn("#tabReport2");
    	WaitForAsyncUtils.waitForFxEvents();  
    	
    	clickOn("#GenerateRelationB");
    	WaitForAsyncUtils.waitForFxEvents(); 
    	String result = "Please select at least one country and an attribute.";
    	
    	String s1 = t.getText();
    	assertEquals(result, s1);
    }
    
    @Test
    public void testCommendableFeaturesBWithMissingInput() {
    	clickOn("#tabReport2");
    	WaitForAsyncUtils.waitForFxEvents();  
    	
    	clickOn("#AttributeB");
    	WaitForAsyncUtils.waitForFxEvents(); 
    	moveBy(0,25);
    	sleep(100);
    	clickOn();
    	
    	clickOn("#GenerateRelationB");
    	WaitForAsyncUtils.waitForFxEvents(); 
    	
    	String result = "Please select at least one country and an attribute.";
    	
    	String s1 = t.getText();
    	assertEquals(result, s1);
    }
    
    @Test
    public void testCommendableFeaturesBWithInput() {
    	clickOn("#tabReport2");
    	WaitForAsyncUtils.waitForFxEvents();  
    	
    	Node  node = (Node)s.lookup("#SelectCountryB1");
    	CheckListView<?> selectCountry = (CheckListView<?>) node;
    
    	selectCountry.getCheckModel().check(2);
    	WaitForAsyncUtils.waitForFxEvents();
    	
    	clickOn("#AttributeB");
    	WaitForAsyncUtils.waitForFxEvents(); 
    	moveBy(0,25);
    	sleep(100);
    	clickOn();
    	WaitForAsyncUtils.waitForFxEvents(); 
    	
    	clickOn("#GenerateRelationB");
    	WaitForAsyncUtils.waitForFxEvents(); 
    	
    	String result = "";
    	
    	String s1 = t.getText();
    	assertEquals(result, s1);
    }

	@Test
	public void testTableVaccinationWithNoInput() {
		clickOn("#tabReport3");
		sleep(100);

		clickOn("#GenerateTableC1");

		String result = "Please select a valid date and at least one country.";
		String s1 = t.getText();

		assertEquals(result, s1);
	}

	@Test
	public void testTableVaccinationWithMissingInputCountry() {
		clickOn("#tabReport3");
		sleep(100);

		LocalDate date = LocalDate.parse("2021-04-28");
		DatePicker datePicker = (DatePicker)s.lookup("#DatePickerC1");
		datePicker.setValue(date);

		clickOn("#GenerateTableC1");

		String result = "Please select a valid date and at least one country.";
		String s1 = t.getText();

		assertEquals(result, s1);
	}

	@Test
	public void testTableVaccinationWithMissingInputDate() {
		clickOn("#tabReport3");
		sleep(100);

		Node  node = (Node)s.lookup("#SelectCountryC1");
		CheckListView<?> selectCountry = (CheckListView<?>) node;

		selectCountry.getCheckModel().check(2);
		WaitForAsyncUtils.waitForFxEvents();

		clickOn("#GenerateTableC1");

		String result = "Please select a valid date and at least one country.";
		String s1 = t.getText();

		assertEquals(result, s1);
	}

	@Test
	public void testTableVaccinationWithInput() {
		clickOn("#tabReport3");
		sleep(100);

		LocalDate date = LocalDate.parse("2021-04-28");
		DatePicker datePicker = (DatePicker)s.lookup("#DatePickerC1");
		datePicker.setValue(date);

		Node  node = (Node)s.lookup("#SelectCountryC1");
		CheckListView<?> selectCountry = (CheckListView<?>) node;

		selectCountry.getCheckModel().check(2);
		WaitForAsyncUtils.waitForFxEvents();

		clickOn("#GenerateTableC1");

		String result = "";
		String s1 = t.getText();

		assertEquals(result, s1);
	}

	@Test
	public void testChartVaccinationWithNoInput() {
		clickOn("#tabApp3");
		WaitForAsyncUtils.waitForFxEvents();

		clickOn("#GenerateChartC2");
		WaitForAsyncUtils.waitForFxEvents();

		String result = "Please select a valid period and at least one country.";
		String s1 = t.getText();

		assertEquals(result, s1);

	}

	@Test
	public void testChartVaccinationWithMissingInputCountry() {
		clickOn("#tabApp3");
		WaitForAsyncUtils.waitForFxEvents();

		LocalDate StartDate = LocalDate.parse("2021-04-28");
		LocalDate EndDate = LocalDate.parse("2021-04-29");
		DatePicker StartDatePicker = (DatePicker)s.lookup("#DatePickerStartC2");
		DatePicker EndDatePicker = (DatePicker)s.lookup("#DatePickerEndC2");
		StartDatePicker.setValue(StartDate);
		EndDatePicker.setValue(EndDate);

		clickOn("#GenerateChartC2");
		WaitForAsyncUtils.waitForFxEvents();


		String result = "Please select a valid period and at least one country.";
		String s1 = t.getText();

		assertEquals(result, s1);
	}

	@Test
	public void testChartVaccinationWithMissingInputDate() {
		clickOn("#tabApp3");
		WaitForAsyncUtils.waitForFxEvents();

		Node  node = (Node)s.lookup("#SelectCountryC2");
		CheckListView<?> selectCountry = (CheckListView<?>) node;

		selectCountry.getCheckModel().check(2);
		WaitForAsyncUtils.waitForFxEvents();

		clickOn("#GenerateChartC2");
		WaitForAsyncUtils.waitForFxEvents();

		String result = "Please select a valid period and at least one country.";
		String s1 = t.getText();

		assertEquals(result, s1);
	}

	@Test
	public void testChartVaccinationWithInput() {
		clickOn("#tabApp3");
		WaitForAsyncUtils.waitForFxEvents();

		LocalDate StartDate = LocalDate.parse("2021-04-28");
		LocalDate EndDate = LocalDate.parse("2021-04-29");
		DatePicker StartDatePicker = (DatePicker)s.lookup("#DatePickerStartC2");
		DatePicker EndDatePicker = (DatePicker)s.lookup("#DatePickerEndC2");
		StartDatePicker.setValue(StartDate);
		EndDatePicker.setValue(EndDate);

		Node  node = (Node)s.lookup("#SelectCountryC2");
		CheckListView<?> selectCountry = (CheckListView<?>) node;

		selectCountry.getCheckModel().check(2);
		WaitForAsyncUtils.waitForFxEvents();

		clickOn("#GenerateChartC2");
		WaitForAsyncUtils.waitForFxEvents();


		String result = "";
		String s1 = t.getText();

		assertEquals(result, s1);
	}
}
