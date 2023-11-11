import javafx.scene.control.TextField;
import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

public class Controller implements Initializable{
	
	//ArrayLists for ComboBox selections
	ObservableList<String> projects = FXCollections.observableArrayList();
	ObservableList<String> effortLogs = FXCollections.observableArrayList();
	ObservableList<String> lifeCycles = FXCollections.observableArrayList("Planning", "Information Gathering", "Information Understanding", "Verifying", "Outlining", "Drafting", "Finalizing", "Team Meeting", "Coach Meeting", "Stakeholder Meeting");
	ObservableList<String> effortCategories = FXCollections.observableArrayList("Plans", "Deliverables", "Interruptions", "Defects", "Others");
	ObservableList<String> plans = FXCollections.observableArrayList("Project Plan", "Risk Management Plan", "Conceptual Design Plan", "Detailed Design Plan", "Implementation Plan");
	ObservableList<String> deliverables = FXCollections.observableArrayList("Conceptual Design", "Details Design", "Test Cases", "Solution", "Reflection", "Outline", "Draft", "Reflection", "Outline", "Draft", "Report", "User Defined", "Other");
	ObservableList<String> interruptions = FXCollections.observableArrayList("Break", "Phone", "Teammate", "Visitor", "Other");
	
	//variables used in the program
	private boolean effortLogSelected  = false;
	private boolean lock = false;
	private boolean effortLogChanged = false;
	
	//variables related to elements in the UI
	@FXML
	private ComboBox<String> projectSelectBox;
	@FXML
	private ComboBox<String> effortLogSelectBox;
	@FXML
	private TextField dateTextField;
	@FXML
	private TextField startTimeTextField;
	@FXML
	private TextField stopTimeTextField;
	@FXML
	private ComboBox<String> lifeCycleSelectBox;
	@FXML
	private ComboBox<String> effortCategorySelectBox;
	@FXML
	private ComboBox<String> planSelectBox;
	@FXML
	private Label planLabel;
	@FXML
	private Label savedLabel;
	@FXML
	private Button updateEntryButton;
	@FXML
	private Label entryNumberLabel;
	@FXML
	private Button proceedToConsoleButton;
	
	
	//event handler function that triggers whenever the user selects a project in ComboBox 1.
	@FXML
	void projectSelected(ActionEvent event) {
		effortLogs.clear();
		
		if(getSelectedItem(projectSelectBox).equals(projects.get(0))) {
			effortLogs.add("1. 2005-08-11 (10:44:14-11:44:54) Planning; Plans; Project Plan");
			effortLogs.add("2. 2005-08-11 (12:20:39-12:21:08) Planning; Plans; Risk Management Plan");
			effortLogs.add("3. 2023-11-10 (11:35:00-11:36:19) Information Gathering; Deliverables; Test Cases");
		}
		
		else if(getSelectedItem(projectSelectBox).equals(projects.get(1))) {
			effortLogs.add("1. 2023-11-10 (12:17:10-12:18-32) Outlining; Interruptions; Break");
		}
		
		entryNumberLabel.setText(effortLogs.size() + " effort log entries for this project.");
	}
	
	//event handler function that triggers whenever the user selects an effort log entry in ComboBox 2.b.
	@FXML
	void effortLogSelected(ActionEvent e) {
		effortLogSelected = true;
		lock = true;
		
		//splits the effort log entry so the data can be autofilled in their respective places
		String selectedString = getSelectedItem(effortLogSelectBox);
		String[] splitString = selectedString.split(" ");
		String stopTime = splitString[2].substring(splitString[2].indexOf("-")+1, splitString[2].length()-1);
		String startTime = splitString[2].substring(splitString[2].indexOf("(")+1, splitString[2].indexOf("-"));
		String lifeCycleStep = "";
		String effortCategory = "";
		String plan = "";
		
		
		if(splitString[3].indexOf(";") == splitString[3].length() -1) {
			lifeCycleStep = splitString[3].substring(0, splitString[3].length()-1);
			effortCategory = splitString[4].substring(0, splitString[4].length()-1);
			if(splitString.length == 6) {
				plan = splitString[5];
			}
			else if(splitString.length == 7) {
				plan = splitString[5] + " " + splitString[6];
			}
			else {
				plan = splitString[5] + " " + splitString[6] + " " + splitString[7];
			}
		}
		else {
			lifeCycleStep = splitString[3] + " " + splitString[4].substring(0, splitString[4].length() -1);
			effortCategory = splitString[5].substring(0, splitString[5].length() - 1);
			if(splitString.length == 7) {
				plan = splitString[6];
			}
			else if(splitString.length == 8) {
				plan = splitString[6] + " " + splitString[7];
			}
			else {
				plan = splitString[6] + " " + splitString[7] + " " + splitString[8];
			}
		}
	
		if(effortCategory.equals("Deliverables")) {
			planSelectBox.setItems(deliverables);
			planLabel.setText("Deliverable");
		}
		else if(effortCategory.equals("Interruptions")) {
			planSelectBox.setItems(interruptions);
			planLabel.setText("Interruption");
		}
		else if(effortCategory.equals("Plans")) {
			planSelectBox.setItems(plans);
			planLabel.setText("Plan");
		}
		
		//autofills data based on the effort log entry selected
		dateTextField.setText(splitString[1]);
		startTimeTextField.setText(startTime);
		stopTimeTextField.setText(stopTime);
		lifeCycleSelectBox.setValue(lifeCycleStep);
		effortCategorySelectBox.setValue(effortCategory);
		planSelectBox.setValue(plan);	
		
		lock = false;
	}
	
	//event handler function that triggers whenever the user changes the effort category CoboBox
	@FXML
	void effortCategoryChanged(ActionEvent e) {
		
		//changes the plan label and respective ComboBox based on what the user selects
		if(getSelectedItem(effortCategorySelectBox).equals("Deliverables")) {
			planSelectBox.setItems(deliverables);
			planLabel.setText("Deliverable");
			planSelectBox.setValue("Conceptual Design");
		}
		else if(getSelectedItem(effortCategorySelectBox).equals("Interruptions")) {
			planSelectBox.setItems(interruptions);
			planLabel.setText("Interruption");
			planSelectBox.setValue("Break");
		}
		else if(getSelectedItem(effortCategorySelectBox).equals("Plans")) {
			planSelectBox.setItems(plans);
			planLabel.setText("Plan");
			planSelectBox.setValue("Project Plan");
		}
	}
	
	//event handler function that triggers whenever the user edits an effort log
	@FXML
	void fieldChanged(ActionEvent e) {
		if(effortLogSelected && !lock) {
			effortLogChanged = true;
			savedLabel.setStyle("-fx-background-color: red;");
			savedLabel.setText("These attributes have not been saved!");
		}
	}
	
	//event handler function that triggers whenever the user edits an effort log
	@FXML
	void updateEntryButtonClicked(ActionEvent e){
		if(getSelectedItem(effortLogSelectBox) == null) {
			return;
		}
		
		savedLabel.setStyle("-fx-background-color: transparent;");
		savedLabel.setText("These attributes have been saved.");
		
		String selectedString = getSelectedItem(effortLogSelectBox);
		String[] splitString = selectedString.split(" ");
		String number = splitString[0].substring(0, splitString[0].length() -1);
		String newLog = splitString[0] + " " + dateTextField.getText() + " " + "(" + startTimeTextField.getText() + "-" + stopTimeTextField.getText() + ") " + lifeCycleSelectBox.getValue() + "; " + effortCategorySelectBox.getValue() + "; " + planSelectBox.getValue();
		
		effortLogs.set((Integer.parseInt(number)) -1, newLog);
		effortLogSelectBox.setValue(newLog);
	}
	
	//event handler function that triggers whenever the user clicks on the Proceed to the Effort Log Console Button
	@FXML
	void proceedToConsoleButtonClicked(ActionEvent e) {
		//code to switch scenes goes here
	}
	
	//initialize function that initializes all the elements
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		//projects added to the projects ComboBox in 1.
		projects.add("Business Project");
		projects.add("Development Project");
		
		//event handlers being set to their respective elements
		projectSelectBox.setOnAction(event -> projectSelected(null) );
		effortLogSelectBox.setOnAction(event -> effortLogSelected(null));
		dateTextField.textProperty().addListener((observable, oldValue, newValue) -> fieldChanged(null));
		startTimeTextField.textProperty().addListener((observable, oldValue, newValue) -> fieldChanged(null));
		stopTimeTextField.textProperty().addListener((observable, oldValue, newValue) -> fieldChanged(null));
		lifeCycleSelectBox.setOnAction(event -> fieldChanged(null));
		effortCategorySelectBox.setOnAction(event -> fieldChanged(null));
		effortCategorySelectBox.setOnAction(event -> effortCategoryChanged(null));
		planSelectBox.setOnAction(event -> fieldChanged(null));
		updateEntryButton.setOnAction(event -> updateEntryButtonClicked(null));
		proceedToConsoleButton.setOnAction(event -> proceedToConsoleButtonClicked(null));
		
		//the elements that each ComboBox gets filled with
		projectSelectBox.setItems(projects);
		effortLogSelectBox.setItems(effortLogs);
		lifeCycleSelectBox.setItems(lifeCycles);
		effortCategorySelectBox.setItems(effortCategories);
		planSelectBox.setItems(plans);
		
		//the default values being set when the user opens the Effort Log Editor
		projectSelectBox.setValue(projects.get(0));
		effortLogs.add("1. 2005-08-11 (10:44:14-11:44:54) Planning; Plans; Project Plan");
		effortLogs.add("2. 2005-08-11 (12:20:39-12:21:08) Planning; Plans; Risk Management Plan");
		effortLogs.add("3. 2023-11-10 (11:35:00-11:36:19) Information Gathering; Deliverables; Test Cases");
		entryNumberLabel.setText(effortLogs.size() + " effort log entries for this project.");
	}
	
	//function that returns which item is currently selected in a ComboBox
	private String getSelectedItem(ComboBox box) {
		return box.getSelectionModel().getSelectedItem().toString();
	}
	
	
	
}
