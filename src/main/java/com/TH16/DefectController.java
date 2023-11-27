package com.TH16;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
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
	private ChoiceBox<String> selectProject;
	@FXML
	private Label createDefect;
	@FXML
	private ChoiceBox<String> selectDefect;
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
	private ChoiceBox<String> fixDefects;
	
	int num1;
	
	private String[] project = {"project 1", "project 2", "project 3", "project 4", "project 5"};
	private String[] defects = {"defect 1", "defect 2", "defect 3", "defect 4", "defect 5"};
	private String[] fix = {"project 1", "project 2", "project 3", "project 4", "project 5"};
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		selectProject.getItems().addAll(project);
		selectDefect.getItems().addAll(defects);
		fixDefects.getItems().addAll(fix);
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
		enterNum.clear();
        update.clear();
        symptoms.clear();
        //clear choiceboxes
        selectProject.getSelectionModel().clearSelection();
        selectDefect.getSelectionModel().clearSelection();
        fixDefects.getSelectionModel().clearSelection();
        clearProjectLog.setText("Defect log cleared successfully.");
	}
	
}
