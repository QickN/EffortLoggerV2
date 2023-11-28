package com.TH16;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputControl;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class DefectController implements Initializable{
	@FXML 
	private Button validate;
	@FXML
	private AnchorPane scenePane;
	@FXML
	private Label selectTheProject;
	@FXML
	private ComboBox<String> selectProject;
	@FXML
	private Label createDefect;
	@FXML
	private ComboBox<String> selectDefect;
	@FXML
	private Label clearProjectLog;
	@FXML 
	private Button clearDefect;
	@FXML 
	private Button createNewDefect;
	@FXML
	private Label defectname;
	@FXML
	private TextField newDefectname;
	@FXML
	private TextField enterNum;
	@FXML
	private Label Num;
	@FXML
	private Button close;
	@FXML
	private Label status;
	@FXML
	private TextField update;
	@FXML
	private Button reopen;
	@FXML
	private Label defectSymptoms;
	@FXML
	private TextField symptoms;
	@FXML
	private Label fixName;
	@FXML
	private ComboBox<String> fixDefects;
	@FXML
	private Label defectNumLabel;
	@FXML
	private Label statusLabel;
	@FXML
	private Label savedLabel;
    @FXML
    private ComboBox<String> injectedComboBox;
    @FXML
    private ComboBox<String> removedComboBox;
    @FXML
    private ComboBox<String> defectCategoryComboBox;
    @FXML
    private Button updateButton;
    @FXML
    private Button deleteButton;
	@FXML
	void fieldChanged(ActionEvent e) {
		if(defectSelected && !lock) {
			savedLabel.setStyle("-fx-background-color: red;");
			savedLabel.setText("These attributes have not been saved!");
		}

	}
	private boolean defectSelected  = false;
	private boolean lock = false;
    
	int num1;
	int idCount = 0;
		
	public FXMLLoader definitionsLoader = new FXMLLoader();
	public FXMLLoader logsLoader = new FXMLLoader();
	public DefinitionsTabController dtc = new DefinitionsTabController(); 
	public LogsTabController ltc = new LogsTabController();
	
	private ObservableList<String> projects = FXCollections.observableArrayList();
	private ObservableList<String> defects = FXCollections.observableArrayList();
	private ObservableList<String> fix = FXCollections.observableArrayList();
	public ObservableList<Defect> defectsList = FXCollections.observableArrayList();
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		selectProject.setItems(projects);
//		selectDefect.setItems(defects);
		fixDefects.getItems().addAll(fix);
		selectProject.setOnAction(event -> projectSelected(null) );
		selectProject.setOnMouseClicked(event -> projectSelected(null) );
		statusLabel.setText("Open");
		newDefectname.textProperty().addListener((observable, oldValue, newValue) -> fieldChanged(null));
		symptoms.textProperty().addListener((observable, oldValue, newValue) -> fieldChanged(null));
		injectedComboBox.setOnAction(event -> fieldChanged(null));
		removedComboBox.setOnAction(event -> fieldChanged(null));
		defectCategoryComboBox.setOnAction(event -> fieldChanged(null));
		fixDefects.setOnAction(event -> fieldChanged(null));
//		defectCategoryComboBox.getItems().addAll(dtc.getDefectCategories());
		
	}
	private String getSelectedItem(ComboBox box) {
		try {
			return box.getSelectionModel().getSelectedItem().toString();
		}
		catch(Exception e){
			return "ERROR";
		}
	}
	public void submit(ActionEvent event) {
		try {
			num1 = Integer.parseInt(enterNum.getText());
			if(num1 >= 100) {
				Num.setText("Select a defect name.");
			} else {
				Num.setText("Eneter a valid number between 1-100");
			}
		}
		catch(NumberFormatException e) {
			Num.setText("Enter only Numbers please");
		}
		catch (Exception e) {
			Num.setText("Error");
		}
	}
	Stage stage;
	public void validate(ActionEvent event) {
		Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
		alert.setTitle("Validate");
		alert.setHeaderText("You are about to be validated!");
		alert.setContentText("Do you want to countinue?");
		
		if(alert.showAndWait().get()== ButtonType.OK) {
		stage = (Stage) scenePane.getScene().getWindow();
		System.out.print("you successfully validated");
		stage.close();
		}
	}
	public void ClearDefectButton(ActionEvent event) {
		//clear textfields
		newDefectname.clear();
        defectNumLabel.setText("");
        symptoms.clear();
        //clear choiceboxes
        selectProject.getSelectionModel().clearSelection();
        selectDefect.getSelectionModel().clearSelection();
        fixDefects.getSelectionModel().clearSelection();
        injectedComboBox.getSelectionModel().clearSelection();
        removedComboBox.getSelectionModel().clearSelection();
        defectCategoryComboBox.getSelectionModel().clearSelection();
        statusLabel.setText("");

        
	}
	public void projectSelected(ActionEvent event) {
		injectedComboBox.getItems().clear();
		removedComboBox.getItems().clear();
		defectCategoryComboBox.getItems().clear();
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
        defectCategoryComboBox.getItems().addAll(dtc.getDefectCategories());
		 /* 
         * The following if else sequence captures the correct life cycle steps for the selected project
         */
		try {
	        if(selectProject.getValue().equals(projects[0])) {
	        	int i = 0;
	        	while((p1LCS[i]) != "") {
	        		int j = Integer.parseInt(p1LCS[i]);
	        		injectedComboBox.getItems().add(lifeCycleSteps[j-1]);
	        		removedComboBox.getItems().add(lifeCycleSteps[j-1]);
	                i++;
	        	}
	        }
	        else if(selectProject.getValue().equals(projects[1])) {
	        	int i = 0;
	        	while((p2LCS[i]) != "") {
	        		int j = Integer.parseInt(p2LCS[i]);
	        		injectedComboBox.getItems().add(lifeCycleSteps[j-1]);
	        		removedComboBox.getItems().add(lifeCycleSteps[j-1]);
	                i++;
	        	}
	        }
	        else if(selectProject.getValue().equals(projects[2])) {
	        	int i = 0;
	        	while((p3LCS[i]) != "") {
	        		int j = Integer.parseInt(p3LCS[i]);
	        		injectedComboBox.getItems().add(lifeCycleSteps[j-1]);
	        		removedComboBox.getItems().add(lifeCycleSteps[j-1]);
	                i++;
	        	}
	        }
	        else if(selectProject.getValue().equals(projects[3])) {
	        	int i = 0;
	        	while((p4LCS[i]) != "") {
	        		int j = Integer.parseInt(p4LCS[i]);
	        		injectedComboBox.getItems().add(lifeCycleSteps[j-1]);
	        		removedComboBox.getItems().add(lifeCycleSteps[j-1]);
	                i++;
	        	}
	        }
	        else if(selectProject.getValue().equals(projects[4])) {
	        	int i = 0;
	        	while((p5LCS[i]) != "") {
	        		int j = Integer.parseInt(p5LCS[i]);
	        		injectedComboBox.getItems().add(lifeCycleSteps[j-1]);
	        		removedComboBox.getItems().add(lifeCycleSteps[j-1]);
	                i++;
	        	}
	        }
	        else if(selectProject.getValue().equals(projects[5])) {
	        	int i = 0;
	        	while((p6LCS[i]) != "") {
	        		int j = Integer.parseInt(p6LCS[i]);
	        		injectedComboBox.getItems().add(lifeCycleSteps[j-1]);
	        		removedComboBox.getItems().add(lifeCycleSteps[j-1]);
	                i++;
	        	}
	        }
	        else if(selectProject.getValue().equals(projects[6])) {
	        	int i = 0;
	        	while((p7LCS[i]) != "") {
	        		int j = Integer.parseInt(p7LCS[i]);
	        		injectedComboBox.getItems().add(lifeCycleSteps[j-1]);
	        		removedComboBox.getItems().add(lifeCycleSteps[j-1]);
	                i++;
	        	}
	        }
	        else if(selectProject.getValue().equals(projects[7])) {
	        	int i = 0;
	        	while((p8LCS[i]) != "") {
	        		int j = Integer.parseInt(p8LCS[i]);
	        		injectedComboBox.getItems().add(lifeCycleSteps[j-1]);
	        		removedComboBox.getItems().add(lifeCycleSteps[j-1]);
	                i++;
	        	}
	        }
	        else if(selectProject.getValue().equals(projects[8])) {
	        	int i = 0;
	        	while((p9LCS[i]) != "") {
	        		int j = Integer.parseInt(p9LCS[i]);
	        		injectedComboBox.getItems().add(lifeCycleSteps[j-1]);
	        		removedComboBox.getItems().add(lifeCycleSteps[j-1]);
	                i++;
	        	}
	        }
	        else if(selectProject.getValue().equals(projects[9])) {
	        	int i = 0;
	        	while((p10LCS[i]) != "") {
	        		int j = Integer.parseInt(p10LCS[i]);
	        		injectedComboBox.getItems().add(lifeCycleSteps[j-1]);
	        		removedComboBox.getItems().add(lifeCycleSteps[j-1]);
	                i++;
	        	}
	        }
	        }
	        catch(Exception er) {
	        	System.out.println("ERROR/n");
	        }
	}
	
	public void defectSelected(ActionEvent e) {
		defectSelected = true;
		lock = true;
		String defectId = getSelectedItem(selectDefect).substring(0, 1);
		Defect selectedDefect = defectsList.get(Integer.parseInt(defectId)-1);
		defectNumLabel.setText(defectId);
		newDefectname.setText(selectedDefect.getDefectName());
		statusLabel.setText(selectedDefect.getStatus());
		symptoms.setText(selectedDefect.getDescription());
		injectedComboBox.setValue(selectedDefect.getStepWhenInjected());
		removedComboBox.setValue(selectedDefect.getStepWhenRemoved());
		defectCategoryComboBox.setValue(selectedDefect.getDefectCategory());
		fixDefects.setValue(selectedDefect.getFix());
		lock = false;
	}
	
	public void newDefect(ActionEvent event) {
		Defect defect = new Defect();
		idCount++;
		defectNumLabel.setText(String.valueOf(idCount));
		defect.setId(idCount);
		defect.setDefectName("new defect");
		defect.setStatus("Open");
		defect.setProject(getSelectedItem(selectProject));
		defectsList.add(defect);
		String selectedProject = getSelectedItem(selectProject);
		
		if(selectedProject.equals(dtc.getProjects()[0]))
			ltc.addToP1DLogs(defect);
		else if(selectedProject.equals(dtc.getProjects()[1])) {
			ltc.addToP2DLogs(defect);
		}
		else if(selectedProject.equals(dtc.getProjects()[2])) {
			ltc.addToP3DLogs(defect);
		}
		else if(selectedProject.equals(dtc.getProjects()[3])) {
			ltc.addToP4DLogs(defect);
		}
		else if(selectedProject.equals(dtc.getProjects()[4])) {
			ltc.addToP5DLogs(defect);
		}
		else if(selectedProject.equals(dtc.getProjects()[5])) {
			ltc.addToP6DLogs(defect);
		}
		else if(selectedProject.equals(dtc.getProjects()[6])) {
			ltc.addToP7DLogs(defect);
		}
		else if(selectedProject.equals(dtc.getProjects()[7])) {
			ltc.addToP8DLogs(defect);
		}
		else if(selectedProject.equals(dtc.getProjects()[8])) {
			ltc.addToP9DLogs(defect);
		}
		else if(selectedProject.equals(dtc.getProjects()[9])) {
			ltc.addToP10DLogs(defect);
		}
//		ltc.addToP1DLogs(defect);
		String defectShort = defect.getId() + ". " + defect.getDefectName();
		defects.add(defectShort);
		System.out.println(defects.get(0));
		selectDefect.getItems().clear();
		for(int i = 0; i < idCount; i++) {
			selectDefect.getItems().add(defectsList.get(i).getId() + ". " + defectsList.get(i).getDefectName());
		}
//		selectDefect.setItems(defects);
		fixDefects.getItems().clear();
		for(int i = 0; i < idCount; i++) {
			fixDefects.getItems().add(defectsList.get(i).getId() + ". " + defectsList.get(i).getDefectName());
		}
			
	}
	
	public void updateDefect(ActionEvent event) {
		String defectId = getSelectedItem(selectDefect).substring(0, 1);
		Defect selectedDefect = defectsList.get(Integer.parseInt(defectId)-1);
		selectedDefect.setDefectName(newDefectname.getText());
		selectedDefect.setDescription(symptoms.getText());
		selectedDefect.setStepWhenInjected(getSelectedItem(injectedComboBox));
		selectedDefect.setStepWhenRemoved(getSelectedItem(removedComboBox));
		selectedDefect.setDefectCategory(getSelectedItem(defectCategoryComboBox));
		selectedDefect.setFix(getSelectedItem(fixDefects));
		savedLabel.setStyle("-fx-background-color: transparent;");
		savedLabel.setText("These attributes have been saved.");
		
		String selectedProject = getSelectedItem(selectProject);
		
		if(selectedProject.equals(dtc.getProjects()[0]))
			ltc.setP1DLogs(defectsList);
		else if(selectedProject.equals(dtc.getProjects()[1])) {
			ltc.setP2DLogs(defectsList);
		}
		else if(selectedProject.equals(dtc.getProjects()[2])) {
			ltc.setP3DLogs(defectsList);
		}
		else if(selectedProject.equals(dtc.getProjects()[3])) {
			ltc.setP4DLogs(defectsList);
		}
		else if(selectedProject.equals(dtc.getProjects()[4])) {
			ltc.setP5DLogs(defectsList);
		}
		else if(selectedProject.equals(dtc.getProjects()[5])) {
			ltc.setP6DLogs(defectsList);
		}
		else if(selectedProject.equals(dtc.getProjects()[6])) {
			ltc.setP7DLogs(defectsList);
		}
		else if(selectedProject.equals(dtc.getProjects()[7])) {
			ltc.setP8DLogs(defectsList);
		}
		else if(selectedProject.equals(dtc.getProjects()[8])) {
			ltc.setP9DLogs(defectsList);
		}
		else if(selectedProject.equals(dtc.getProjects()[9])) {
			ltc.setP10DLogs(defectsList);
		}
		
		selectDefect.getItems().clear();
		for(int i = 0; i < idCount; i++) {
			selectDefect.getItems().add(defectsList.get(i).getId() + ". " + defectsList.get(i).getDefectName());
		}
	
		fixDefects.getItems().clear();
		for(int i = 0; i < idCount; i++) {
			fixDefects.getItems().add(defectsList.get(i).getId() + ". " + defectsList.get(i).getDefectName());
		}
	}
	
	public void deleteDefect(ActionEvent e) {
		String id = getSelectedItem(selectDefect).substring(0, 1);
		for(int i = 0; i < defectsList.size(); i++) {
			if(i > Integer.parseInt(id)-1)
				defectsList.get(i).setId(defectsList.get(i).getId() - 1);
		}
		defectsList.remove(Integer.parseInt(id)-1);
		idCount--;
		
		String selectedProject = getSelectedItem(selectProject);
		if(selectedProject.equals(dtc.getProjects()[0]))
			ltc.setP1DLogs(defectsList);
		else if(selectedProject.equals(dtc.getProjects()[1])) {
			ltc.setP2DLogs(defectsList);
		}
		else if(selectedProject.equals(dtc.getProjects()[2])) {
			ltc.setP3DLogs(defectsList);
		}
		else if(selectedProject.equals(dtc.getProjects()[3])) {
			ltc.setP4DLogs(defectsList);
		}
		else if(selectedProject.equals(dtc.getProjects()[4])) {
			ltc.setP5DLogs(defectsList);
		}
		else if(selectedProject.equals(dtc.getProjects()[5])) {
			ltc.setP6DLogs(defectsList);
		}
		else if(selectedProject.equals(dtc.getProjects()[6])) {
			ltc.setP7DLogs(defectsList);
		}
		else if(selectedProject.equals(dtc.getProjects()[7])) {
			ltc.setP8DLogs(defectsList);
		}
		else if(selectedProject.equals(dtc.getProjects()[8])) {
			ltc.setP9DLogs(defectsList);
		}
		else if(selectedProject.equals(dtc.getProjects()[9])) {
			ltc.setP10DLogs(defectsList);
		}
		
		selectDefect.getItems().clear();
		for(int i = 0; i < idCount; i++) {
			selectDefect.getItems().add(defectsList.get(i).getId() + ". " + defectsList.get(i).getDefectName());
		}
	
		fixDefects.getItems().clear();
		for(int i = 0; i < idCount; i++) {
			fixDefects.getItems().add(defectsList.get(i).getId() + ". " + defectsList.get(i).getDefectName());
		}
	}
	
	public void closeStatus(ActionEvent e) {
		String id = getSelectedItem(selectDefect).substring(0, 1);
		defectsList.get(Integer.parseInt(id)-1).setStatus("Closed");
		statusLabel.setText("Closed");
		
		String selectedProject = getSelectedItem(selectProject);
		if(selectedProject.equals(dtc.getProjects()[0]))
			ltc.setP1DLogs(defectsList);
		else if(selectedProject.equals(dtc.getProjects()[1])) {
			ltc.setP2DLogs(defectsList);
		}
		else if(selectedProject.equals(dtc.getProjects()[2])) {
			ltc.setP3DLogs(defectsList);
		}
		else if(selectedProject.equals(dtc.getProjects()[3])) {
			ltc.setP4DLogs(defectsList);
		}
		else if(selectedProject.equals(dtc.getProjects()[4])) {
			ltc.setP5DLogs(defectsList);
		}
		else if(selectedProject.equals(dtc.getProjects()[5])) {
			ltc.setP6DLogs(defectsList);
		}
		else if(selectedProject.equals(dtc.getProjects()[6])) {
			ltc.setP7DLogs(defectsList);
		}
		else if(selectedProject.equals(dtc.getProjects()[7])) {
			ltc.setP8DLogs(defectsList);
		}
		else if(selectedProject.equals(dtc.getProjects()[8])) {
			ltc.setP9DLogs(defectsList);
		}
		else if(selectedProject.equals(dtc.getProjects()[9])) {
			ltc.setP10DLogs(defectsList);
		}
	}
	
	public void reopenStatus(ActionEvent e) {
		String id = getSelectedItem(selectDefect).substring(0, 1);
		defectsList.get(Integer.parseInt(id)-1).setStatus("Open");
		statusLabel.setText("Open");
		String selectedProject = getSelectedItem(selectProject);
		
		if(selectedProject.equals(dtc.getProjects()[0]))
			ltc.setP1DLogs(defectsList);
		else if(selectedProject.equals(dtc.getProjects()[1])) {
			ltc.setP2DLogs(defectsList);
		}
		else if(selectedProject.equals(dtc.getProjects()[2])) {
			ltc.setP3DLogs(defectsList);
		}
		else if(selectedProject.equals(dtc.getProjects()[3])) {
			ltc.setP4DLogs(defectsList);
		}
		else if(selectedProject.equals(dtc.getProjects()[4])) {
			ltc.setP5DLogs(defectsList);
		}
		else if(selectedProject.equals(dtc.getProjects()[5])) {
			ltc.setP6DLogs(defectsList);
		}
		else if(selectedProject.equals(dtc.getProjects()[6])) {
			ltc.setP7DLogs(defectsList);
		}
		else if(selectedProject.equals(dtc.getProjects()[7])) {
			ltc.setP8DLogs(defectsList);
		}
		else if(selectedProject.equals(dtc.getProjects()[8])) {
			ltc.setP9DLogs(defectsList);
		}
		else if(selectedProject.equals(dtc.getProjects()[9])) {
			ltc.setP10DLogs(defectsList);
		}
	}
	

	
	
	public void setProjects(String[] projects) {
		this.projects.addAll(projects);
	}
	
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
	public String[] getDefects() {
		String[] defects = new String[defectsList.size()];
		for(int i = 0; i < defectsList.size(); i++) {
			defects[i] = defectsList.get(i).getId() + ". " + defectsList.get(i).getDefectName();
		}
		return defects;
	}
	
}
