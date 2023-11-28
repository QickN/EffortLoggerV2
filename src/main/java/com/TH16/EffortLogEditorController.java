package com.TH16;

import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

public class EffortLogEditorController implements Initializable{
//	FXMLLoader tab5_loader = new FXMLLoader(getClass().getResource("DefinitionsTab.fxml"));
	
	//ArrayLists for ComboBox selections
	ObservableList<String> projects = FXCollections.observableArrayList();
	ObservableList<Activity> effortLogsP1 = FXCollections.observableArrayList();
	ObservableList<Activity> effortLogsP2 = FXCollections.observableArrayList();
	ObservableList<Activity> effortLogsP3 = FXCollections.observableArrayList();
	ObservableList<Activity> effortLogsP4 = FXCollections.observableArrayList();
	ObservableList<Activity> effortLogsP5 = FXCollections.observableArrayList();
	ObservableList<Activity> effortLogsP6 = FXCollections.observableArrayList();
	ObservableList<Activity> effortLogsP7 = FXCollections.observableArrayList();
	ObservableList<Activity> effortLogsP8 = FXCollections.observableArrayList();
	ObservableList<Activity> effortLogsP9 = FXCollections.observableArrayList();
	ObservableList<Activity> effortLogsP10 = FXCollections.observableArrayList();
	public FXMLLoader definitionsLoader = new FXMLLoader();
	public FXMLLoader logsLoader = new FXMLLoader();
	public DefinitionsTabController dtc = new DefinitionsTabController(); 
	public LogsTabController ltc = new LogsTabController();
//	String[] projectsA = new String[10];

	ArrayList<Activity> activities = new ArrayList<>();
//	ArrayList<Activity> effortLogs0 = new ArrayList<>();
	ObservableList<String> lifeCycles = FXCollections.observableArrayList("Planning", "Information Gathering", "Information Understanding", "Verifying", "Outlining", "Drafting", "Finalizing", "Team Meeting", "Coach Meeting", "Stakeholder Meeting");
	ObservableList<String> effortCategories = FXCollections.observableArrayList("Plans", "Deliverables", "Interruptions", "Defects", "Others");
	ObservableList<String> plans = FXCollections.observableArrayList("Project Plan", "Risk Management Plan", "Conceptual Design Plan", "Detailed Design Plan", "Implementation Plan");
	ObservableList<String> deliverables = FXCollections.observableArrayList("Conceptual Design", "Details Design", "Test Cases", "Solution", "Reflection", "Outline", "Draft", "Reflection", "Outline", "Draft", "Report", "User Defined", "Other");
	ObservableList<String> interruptions = FXCollections.observableArrayList("Break", "Phone", "Teammate", "Visitor", "Other");
	
//	FXMLLoader tab5_loader = new FXMLLoader(getClass().getResource("DefinitionsTab.fxml"));
	
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
	private Button deleteEntryButton;
	@FXML
	private Label entryNumberLabel;
	@FXML
	private Button proceedToConsoleButton;
	
	public void setDefinitionsLoader(FXMLLoader loader) {
		this.definitionsLoader = loader;
	}
	
	public void setLogsLoader(FXMLLoader loader) {
		this.logsLoader = loader;
	}
	
	public void setDtc(DefinitionsTabController dtc) {
		this.dtc = dtc;
	}
	
	public void setLtc(LogsTabController ltc) {
		this.ltc = ltc;
	}
	
	@FXML
	public void setOnMouseClicked(MouseEvent event) {
//		FXMLLoader tab5_loader = new FXMLLoader(getClass().getResource("DefinitionsTab.fxml"));
//		DefinitionsTabController dtc = tab5_loader.getController(); //create controller object
//		projects.addAll(dtc.getProjects());
		effortLogSelectBox.setValue(null);
//
	}
	//event handler function that triggers whenever the user selects a project in ComboBox 1.
	@FXML
	void projectSelected(ActionEvent event) {	    
//		DefinitionsTabController dtc = tab5_loader.getController(); //create controller object
//		effortLogs.clear();
//		projects.addAll(dtc.getProjects());
		effortLogSelectBox.getItems().clear();
		int size = 0;
		if(getSelectedItem(projectSelectBox).equals(projects.get(0))) {
			for(int i = 0; i < effortLogsP1.size(); i++) {
				effortLogSelectBox.getItems().add(effortLogsP1.get(i).toString());
			}
			size = effortLogsP1.size();
//			effortLogSelectBox.setItems(effortLogsP1);
//			effortLogs.add("1. 2005-08-11 (10:44:14-11:44:54) Planning; Plans; Project Plan");
//			effortLogs.add("2. 2005-08-11 (12:20:39-12:21:08) Planning; Plans; Risk Management Plan");
//			effortLogs.add("3. 2023-11-10 (11:35:00-11:36:19) Information Gathering; Deliverables; Test Cases");
		}
		
		
		else if(getSelectedItem(projectSelectBox).equals(projects.get(1))) {
			for(int i = 0; i < effortLogsP2.size(); i++) {
				effortLogSelectBox.getItems().add(effortLogsP2.get(i).toString());
			}
			size = effortLogsP2.size();
//			effortLogs.add("1. 2023-11-10 (12:17:10-12:18-32) Outlining; Interruptions; Break");
		}
		else if(getSelectedItem(projectSelectBox).equals(projects.get(2))) {
			for(int i = 0; i < effortLogsP3.size(); i++) {
				effortLogSelectBox.getItems().add(effortLogsP3.get(i).toString());
			}
			size = effortLogsP3.size();
//			effortLogs.add("1. 2023-11-10 (12:17:10-12:18-32) Outlining; Interruptions; Break");
		}
		else if(getSelectedItem(projectSelectBox).equals(projects.get(3))) {
			for(int i = 0; i < effortLogsP4.size(); i++) {
				effortLogSelectBox.getItems().add(effortLogsP4.get(i).toString());
			}
			size = effortLogsP4.size();
//			effortLogs.add("1. 2023-11-10 (12:17:10-12:18-32) Outlining; Interruptions; Break");
		}
		else if(getSelectedItem(projectSelectBox).equals(projects.get(4))) {
			for(int i = 0; i < effortLogsP5.size(); i++) {
				effortLogSelectBox.getItems().add(effortLogsP5.get(i).toString());
			}
			size = effortLogsP5.size();
//			effortLogs.add("1. 2023-11-10 (12:17:10-12:18-32) Outlining; Interruptions; Break");
		}
		else if(getSelectedItem(projectSelectBox).equals(projects.get(5))) {
			for(int i = 0; i < effortLogsP6.size(); i++) {
				effortLogSelectBox.getItems().add(effortLogsP6.get(i).toString());
			}
			size = effortLogsP6.size();
//			effortLogs.add("1. 2023-11-10 (12:17:10-12:18-32) Outlining; Interruptions; Break");
		}
		else if(getSelectedItem(projectSelectBox).equals(projects.get(6))) {
			for(int i = 0; i < effortLogsP7.size(); i++) {
				effortLogSelectBox.getItems().add(effortLogsP7.get(i).toString());
			}
			size = effortLogsP7.size();
//			effortLogs.add("1. 2023-11-10 (12:17:10-12:18-32) Outlining; Interruptions; Break");
		}
		else if(getSelectedItem(projectSelectBox).equals(projects.get(7))) {
			for(int i = 0; i < effortLogsP8.size(); i++) {
				effortLogSelectBox.getItems().add(effortLogsP8.get(i).toString());
			}
			size = effortLogsP8.size();
//			effortLogs.add("1. 2023-11-10 (12:17:10-12:18-32) Outlining; Interruptions; Break");
		}
		else if(getSelectedItem(projectSelectBox).equals(projects.get(8))) {
			for(int i = 0; i < effortLogsP9.size(); i++) {
				effortLogSelectBox.getItems().add(effortLogsP9.get(i).toString());
			}
			size = effortLogsP9.size();
//			effortLogs.add("1. 2023-11-10 (12:17:10-12:18-32) Outlining; Interruptions; Break");
		}
		else if(getSelectedItem(projectSelectBox).equals(projects.get(9))) {
			for(int i = 0; i < effortLogsP10.size(); i++) {
				effortLogSelectBox.getItems().add(effortLogsP10.get(i).toString());
			}
			size = effortLogsP10.size();
//			effortLogs.add("1. 2023-11-10 (12:17:10-12:18-32) Outlining; Interruptions; Break");
		}
//		int size = effortLogsP1.size() + effortLogsP2.size() + effortLogsP3.size() + effortLogsP4.size() +
//				effortLogsP5.size() + effortLogsP6.size() + effortLogsP7.size() + effortLogsP8.size() +
//				effortLogsP9.size() + effortLogsP10.size();
		entryNumberLabel.setText(size + " effort log entries for this project.");
	}
	
	//event handler function that triggers whenever the user selects an effort log entry in ComboBox 2.b.
//	
	public void effortLogSelected(ActionEvent e) {
//		FXMLLoader loader = new FXMLLoader(getClass().getResource("DefinitionsTabController.fxml"));
		effortLogSelected = true;
		lock = true;
//		DefinitionsTabController dtc = loader.getController();
//		lifeCycleSelectBox.getItems().addAll(dtc.getP1LCS());
//		for(int i = 0; i < 25; i++) {
//			System.out.println(dtc.getP1LCS()[i]);	
//		}
		String[] projects = dtc.getProjects();
        String[] lifeCycleSteps = dtc.getLifeCycleSteps();
        String[] p1LCS = dtc.getP1LCS();
        String[] p2LCS = dtc.getP2LCS();
        String[] p3LCS = dtc.getP3LCS();
        String[] p4LCS = dtc.getP4LCS();
        String[] p5LCS = dtc.getP5LCS();
        String[] p6LCS = dtc.getP6LCS();
        String[] p7LCS = dtc.getP7LCS();
        String[] p8LCS = dtc.getP8LCS();
        String[] p9LCS = dtc.getP9LCS();
        String[] p10LCS = dtc.getP10LCS();
        lifeCycleSelectBox.getItems().clear();//clear before adding
        
        /* 
         * The following if else sequence captures the correct life cycle steps for the selected project
         */
        try {
        if(projectSelectBox.getValue().equals(projects[0])) {
        	int i = 0;
        	while((p1LCS[i]) != "") {
        		int j = Integer.parseInt(p1LCS[i]);
        		lifeCycleSelectBox.getItems().add(lifeCycleSteps[j-1]);
                i++;
        	}
        }
        else if(projectSelectBox.getValue().equals(projects[1])) {
        	int i = 0;
        	while((p2LCS[i]) != "") {
        		int j = Integer.parseInt(p2LCS[i]);
        		lifeCycleSelectBox.getItems().add(lifeCycleSteps[j-1]);
                i++;
        	}
        }
        else if(projectSelectBox.getValue().equals(projects[2])) {
        	int i = 0;
        	while((p3LCS[i]) != "") {
        		int j = Integer.parseInt(p3LCS[i]);
        		lifeCycleSelectBox.getItems().add(lifeCycleSteps[j-1]);
                i++;
        	}
        }
        else if(projectSelectBox.getValue().equals(projects[3])) {
        	int i = 0;
        	while((p4LCS[i]) != "") {
        		int j = Integer.parseInt(p4LCS[i]);
        		lifeCycleSelectBox.getItems().add(lifeCycleSteps[j-1]);
                i++;
        	}
        }
        else if(projectSelectBox.getValue().equals(projects[4])) {
        	int i = 0;
        	while((p5LCS[i]) != "") {
        		int j = Integer.parseInt(p5LCS[i]);
        		lifeCycleSelectBox.getItems().add(lifeCycleSteps[j-1]);
                i++;
        	}
        }
        else if(projectSelectBox.getValue().equals(projects[5])) {
        	int i = 0;
        	while((p6LCS[i]) != "") {
        		int j = Integer.parseInt(p6LCS[i]);
        		lifeCycleSelectBox.getItems().add(lifeCycleSteps[j-1]);
                i++;
        	}
        }
        else if(projectSelectBox.getValue().equals(projects[6])) {
        	int i = 0;
        	while((p7LCS[i]) != "") {
        		int j = Integer.parseInt(p7LCS[i]);
        		lifeCycleSelectBox.getItems().add(lifeCycleSteps[j-1]);
                i++;
        	}
        }
        else if(projectSelectBox.getValue().equals(projects[7])) {
        	int i = 0;
        	while((p8LCS[i]) != "") {
        		int j = Integer.parseInt(p8LCS[i]);
        		lifeCycleSelectBox.getItems().add(lifeCycleSteps[j-1]);
                i++;
        	}
        }
        else if(projectSelectBox.getValue().equals(projects[8])) {
        	int i = 0;
        	while((p9LCS[i]) != "") {
        		int j = Integer.parseInt(p9LCS[i]);
        		lifeCycleSelectBox.getItems().add(lifeCycleSteps[j-1]);
                i++;
        	}
        }
        else if(projectSelectBox.getValue().equals(projects[9])) {
        	int i = 0;
        	while((p10LCS[i]) != "") {
        		int j = Integer.parseInt(p10LCS[i]);
        		lifeCycleSelectBox.getItems().add(lifeCycleSteps[j-1]);
                i++;
        	}
        }
        }
        catch(Exception er) {
        	System.out.println("ERROR/n");
        }
        
        String selectedActivityID = getSelectedItem(effortLogSelectBox).substring(0, 1);
        Activity selectedActivity = activities.get(Integer.parseInt(selectedActivityID)-1);
        
        dateTextField.setText(selectedActivity.date);
		startTimeTextField.setText(selectedActivity.startTime);
		stopTimeTextField.setText(selectedActivity.endTime);
		lifeCycleSelectBox.setValue(selectedActivity.lifeCycleStep);
		effortCategorySelectBox.setValue(selectedActivity.effortCategory1);
		planSelectBox.setValue(selectedActivity.effortCategory2);
        
		
//		//splits the effort log entry so the data can be autofilled in their respective places
//		String selectedString = getSelectedItem(effortLogSelectBox);
//		String[] splitString = selectedString.split(" ");
//		String stopTime = splitString[2].substring(splitString[2].indexOf("-")+1, splitString[2].length()-1);
//		String startTime = splitString[2].substring(splitString[2].indexOf("(")+1, splitString[2].indexOf("-"));
//		String lifeCycleStep = "";
//		String effortCategory = "";
//		String plan = "";
//		
//		
//		if(splitString[3].indexOf(";") == splitString[3].length() -1) {
//			lifeCycleStep = splitString[3].substring(0, splitString[3].length()-1);
//			effortCategory = splitString[4].substring(0, splitString[4].length()-1);
//			if(splitString.length == 6) {
//				plan = splitString[5];
//			}
//			else if(splitString.length == 7) {
//				plan = splitString[5] + " " + splitString[6];
//			}
//			else {
//				plan = splitString[5] + " " + splitString[6] + " " + splitString[7];
//			}
//		}
//		else {
//			lifeCycleStep = splitString[3] + " " + splitString[4].substring(0, splitString[4].length() -1);
//			effortCategory = splitString[5].substring(0, splitString[5].length() - 1);
//			if(splitString.length == 7) {
//				plan = splitString[6];
//			}
//			else if(splitString.length == 8) {
//				plan = splitString[6] + " " + splitString[7];
//			}
//			else {
//				plan = splitString[6] + " " + splitString[7] + " " + splitString[8];
//			}
//		}
//	
//		if(effortCategory.equals("Deliverables")) {
//			planSelectBox.setItems(deliverables);
//			planLabel.setText("Deliverable");
//		}
//		else if(effortCategory.equals("Interruptions")) {
//			planSelectBox.setItems(interruptions);
//			planLabel.setText("Interruption");
//		}
//		else if(effortCategory.equals("Plans")) {
//			planSelectBox.setItems(plans);
//			planLabel.setText("Plan");
//		}
//		
//		//autofills data based on the effort log entry selected
//		dateTextField.setText(splitString[1]);
//		startTimeTextField.setText(startTime);
//		stopTimeTextField.setText(stopTime);
//		lifeCycleSelectBox.setValue(lifeCycleStep);
//		effortCategorySelectBox.setValue(effortCategory);
//		planSelectBox.setValue(plan);	
		
		lock = false;
	}
	
	//event handler function that triggers whenever the user changes the effort category CoboBox
	@FXML
	void effortCategoryChanged(ActionEvent e) {
//		String[] projects = dtc.getProjects();
		planSelectBox.getItems().clear();
//		String selectedEffortCetegory = getSelectedItem(effortCategorySelectBox);
		//changes the plan label and respective ComboBox based on what the user selects
		if(getSelectedItem(effortCategorySelectBox).equals("Deliverables")) {
			planSelectBox.getItems().addAll((dtc.getDeliverables()));
			planLabel.setText("Deliverable");
			planSelectBox.setValue("Conceptual Design");
		}
		else if(getSelectedItem(effortCategorySelectBox).equals("Interruptions")) {
			planSelectBox.getItems().addAll(dtc.getInterruptions());
			planLabel.setText("Interruption");
			planSelectBox.setValue("Break");
		}
		else if(getSelectedItem(effortCategorySelectBox).equals("Plans")) {
			planSelectBox.getItems().addAll(dtc.getPlans());
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
		
		String selectedActivityID = getSelectedItem(effortLogSelectBox).substring(0, 1);
        Activity selectedActivity = activities.get(Integer.parseInt(selectedActivityID)-1);
        String newDate = dateTextField.getText();
        String newStart = startTimeTextField.getText();
        String newStop = stopTimeTextField.getText();
        String newLifeCycleStep = getSelectedItem(lifeCycleSelectBox);
        String newEffortCategory1 = getSelectedItem(effortCategorySelectBox);
        String newEffortCategory2 = getSelectedItem(planSelectBox);
        
        
        ObservableList<Activity> loggedActivities = ltc.getActivities();
        Activity loggedSelectedActivity = loggedActivities.get(Integer.parseInt(selectedActivityID)-1);
        loggedSelectedActivity.setDate(newDate);
        loggedSelectedActivity.setStartTime(newStart);
        loggedSelectedActivity.setEndTime(newStop);
        loggedSelectedActivity.setLifeCycleStep(newLifeCycleStep);
        loggedSelectedActivity.setEffortCategory1(newEffortCategory1);
        loggedSelectedActivity.setEffortCategory2(newEffortCategory2);
        
        if(selectedActivity.getProject().equals(dtc.getProjects()[0])) {
        	ltc.addToP1ELogs(loggedActivities);
        }
        else if(selectedActivity.getProject().equals(dtc.getProjects()[1])) {
        	ltc.addToP2ELogs(loggedActivities);
        }
        else if(selectedActivity.getProject().equals(dtc.getProjects()[2])) {
        	ltc.addToP3ELogs(loggedActivities);
        }
        else if(selectedActivity.getProject().equals(dtc.getProjects()[3])) {
        	ltc.addToP4ELogs(loggedActivities);
        }
        else if(selectedActivity.getProject().equals(dtc.getProjects()[4])) {
        	ltc.addToP5ELogs(loggedActivities);
        }
        else if(selectedActivity.getProject().equals(dtc.getProjects()[5])) {
        	ltc.addToP6ELogs(loggedActivities);
        }
        else if(selectedActivity.getProject().equals(dtc.getProjects()[6])) {
        	ltc.addToP7ELogs(loggedActivities);
        }
        else if(selectedActivity.getProject().equals(dtc.getProjects()[7])) {
        	ltc.addToP8ELogs(loggedActivities);
        }
        else if(selectedActivity.getProject().equals(dtc.getProjects()[8])) {
        	ltc.addToP9ELogs(loggedActivities);
        }
        else if(selectedActivity.getProject().equals(dtc.getProjects()[9])) {
        	ltc.addToP10ELogs(loggedActivities);
        }
		
		String selectedString = getSelectedItem(effortLogSelectBox);
		
		String[] splitString = selectedString.split(" ");
		String number = splitString[0].substring(0, splitString[0].length() -1);
		String newLog = splitString[0] + " " + dateTextField.getText() + " " + "(" + startTimeTextField.getText() + "-" + stopTimeTextField.getText() + ") " + lifeCycleSelectBox.getValue() + "; " + effortCategorySelectBox.getValue() + "; " + planSelectBox.getValue();
		
//		effortLogs.set((Integer.parseInt(number)) -1, newLog);
		effortLogSelectBox.setValue(newLog);
	}
	
	@FXML
	void deleteEntry(ActionEvent e) {
		String selectedActivityID = getSelectedItem(effortLogSelectBox).substring(0, 1);
//        ltc.removeActivity(Integer.parseInt(selectedActivityID)-1);
        if(getSelectedItem(projectSelectBox).equals(projects.get(0))) {
			ltc.removeP1ELog(Integer.parseInt(selectedActivityID)-1);
			System.out.println("bruh");
		}
		
		
		else if(getSelectedItem(projectSelectBox).equals(projects.get(1))) {
			for(int i = 0; i < effortLogsP2.size(); i++) {
				effortLogSelectBox.getItems().add(effortLogsP2.get(i).toString());
			}

		}
		else if(getSelectedItem(projectSelectBox).equals(projects.get(2))) {
			for(int i = 0; i < effortLogsP3.size(); i++) {
				effortLogSelectBox.getItems().add(effortLogsP3.get(i).toString());
			}

		}
		else if(getSelectedItem(projectSelectBox).equals(projects.get(3))) {
			for(int i = 0; i < effortLogsP4.size(); i++) {
				effortLogSelectBox.getItems().add(effortLogsP4.get(i).toString());
			}

		}
		else if(getSelectedItem(projectSelectBox).equals(projects.get(4))) {
			for(int i = 0; i < effortLogsP5.size(); i++) {
				effortLogSelectBox.getItems().add(effortLogsP5.get(i).toString());
			}
		}
		else if(getSelectedItem(projectSelectBox).equals(projects.get(5))) {
			for(int i = 0; i < effortLogsP6.size(); i++) {
				effortLogSelectBox.getItems().add(effortLogsP6.get(i).toString());
			}
		}
		else if(getSelectedItem(projectSelectBox).equals(projects.get(6))) {
			for(int i = 0; i < effortLogsP7.size(); i++) {
				effortLogSelectBox.getItems().add(effortLogsP7.get(i).toString());
			}
		}
		else if(getSelectedItem(projectSelectBox).equals(projects.get(7))) {
			for(int i = 0; i < effortLogsP8.size(); i++) {
				effortLogSelectBox.getItems().add(effortLogsP8.get(i).toString());
			}
		}
		else if(getSelectedItem(projectSelectBox).equals(projects.get(8))) {
			for(int i = 0; i < effortLogsP9.size(); i++) {
				effortLogSelectBox.getItems().add(effortLogsP9.get(i).toString());
			}
		}
		else if(getSelectedItem(projectSelectBox).equals(projects.get(9))) {
			for(int i = 0; i < effortLogsP10.size(); i++) {
				effortLogSelectBox.getItems().add(effortLogsP10.get(i).toString());
			}
		}
        
//		ObservableList<Activity> loggedActivities = ltc.getActivities();
//        ltc.getActivities().remove(Integer.parseInt(id)-1);
		
	}
	
	//event handler function that triggers whenever the user clicks on the Proceed to the Effort Log Console Button
	@FXML
	void proceedToConsoleButtonClicked(ActionEvent e) {
		//code to switch scenes goes here
	}
	
	//initialize function that initializes all the elements
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
//		DefinitionsTabController dtc = tab5_loader.getController(); //create controller object

		//projects added to the projects ComboBox in 1.
//		projects.add("Business Project");
//		projects.add("Development Project");
//		projects.addAll(projectsA);
	
		
		//event handlers being set to their respective elements
		projectSelectBox.setOnAction(event -> projectSelected(null) );
		projectSelectBox.setOnMouseClicked(event -> projectSelected(null) );
		effortLogSelectBox.setOnAction(event -> effortLogSelected(null));
		effortLogSelectBox.setOnMouseClicked(event -> projectSelected(null) );
		dateTextField.textProperty().addListener((observable, oldValue, newValue) -> fieldChanged(null));
		startTimeTextField.textProperty().addListener((observable, oldValue, newValue) -> fieldChanged(null));
		stopTimeTextField.textProperty().addListener((observable, oldValue, newValue) -> fieldChanged(null));
		lifeCycleSelectBox.setOnAction(event -> fieldChanged(null));
		effortCategorySelectBox.setOnAction(event -> fieldChanged(null));
		effortCategorySelectBox.setOnAction(event -> effortCategoryChanged(null));
		planSelectBox.setOnAction(event -> fieldChanged(null));
		updateEntryButton.setOnAction(event -> updateEntryButtonClicked(null));
		proceedToConsoleButton.setOnAction(event -> proceedToConsoleButtonClicked(null));
		deleteEntryButton.setOnAction(event -> deleteEntry(null));
		
		//the elements that each ComboBox gets filled with
		projectSelectBox.setItems(projects);
//		effortLogSelectBox.setItems(effortLogs);
		lifeCycleSelectBox.setItems(lifeCycles);
		effortCategorySelectBox.setItems(effortCategories);
		planSelectBox.setItems(plans);
		
		//the default values being set when the user opens the Effort Log Editor
//		projectSelectBox.setValue(projects.get(0));
		effortLogsP1.addAll(effortLogsP1);
		effortLogsP2.addAll(effortLogsP2);
		effortLogsP3.addAll(effortLogsP3);
		effortLogsP4.addAll(effortLogsP4);
		effortLogsP5.addAll(effortLogsP5);
		effortLogsP6.addAll(effortLogsP6);
		effortLogsP7.addAll(effortLogsP7);
		effortLogsP8.addAll(effortLogsP8);
		effortLogsP9.addAll(effortLogsP9);
		effortLogsP10.addAll(effortLogsP10);
//		effortLogs.add("1. 2005-08-11 (10:44:14-11:44:54) Planning; Plans; Project Plan");
//		effortLogs.add("2. 2005-08-11 (12:20:39-12:21:08) Planning; Plans; Risk Management Plan");
//		effortLogs.add("3. 2023-11-10 (11:35:00-11:36:19) Information Gathering; Deliverables; Test Cases");
		int size = effortLogsP1.size() + effortLogsP2.size() + effortLogsP3.size() + effortLogsP4.size() +
				effortLogsP5.size() + effortLogsP6.size() + effortLogsP7.size() + effortLogsP8.size() +
				effortLogsP9.size() + effortLogsP10.size();
		entryNumberLabel.setText(size + " effort log entries for this project.");
	}
	
	//function that returns which item is currently selected in a ComboBox
	private String getSelectedItem(ComboBox box) {
		try {
			return box.getSelectionModel().getSelectedItem().toString();
		}
		catch(Exception e){
			return "ERROR";
		}
	}
	
	public void setProjects(String[] projects) {
//		this.projectsA = projects;
		this.projects.addAll(projects);
//		this.projects.get(0) = projectsA[0];
	}
	public void setActivities(ArrayList<Activity> activities) {
		this.activities = activities;
	}
	public void setLifeCycleSteps(String[] lifeCycleSteps) {
		this.lifeCycles.addAll(lifeCycleSteps);
	}
	public void setELogsP1(ObservableList<Activity> ELogs) {
		this.effortLogsP1 = ELogs;
	}
	public void setELogsP2(ObservableList<Activity> ELogs) {
		this.effortLogsP2 = ELogs;
	}
	public void setELogsP3(ObservableList<Activity> ELogs) {
		this.effortLogsP3 = ELogs;
	}
	public void setELogsP4(ObservableList<Activity> ELogs) {
		this.effortLogsP4 = ELogs;
	}
	public void setELogsP5(ObservableList<Activity> ELogs) {
		this.effortLogsP5 = ELogs;
	}
	public void setELogsP6(ObservableList<Activity> ELogs) {
		this.effortLogsP6 = ELogs;
	}
	public void setELogsP7(ObservableList<Activity> ELogs) {
		this.effortLogsP7 = ELogs;
	}
	public void setELogsP8(ObservableList<Activity> ELogs) {
		this.effortLogsP8 = ELogs;
	}
	public void setELogsP9(ObservableList<Activity> ELogs) {
		this.effortLogsP9 = ELogs;
	}
	public void setELogsP10(ObservableList<Activity> ELogs) {
		this.effortLogsP10 = ELogs;
	}
	public void setLifeCycleStep(ObservableList<Activity> ELogs) {
		this.effortLogsP10 = ELogs;
	}
	public void setEffortCategory1(ObservableList<Activity> ELogs) {
		this.effortLogsP10 = ELogs;
	}
	public void setEffortCategry2(ObservableList<Activity> ELogs) {
		this.effortLogsP10 = ELogs;
	}
}
