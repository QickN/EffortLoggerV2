package com.TH16;


import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;


public class EffortLogEditorController {
		String selectedProject;
		
		@FXML
		private ChoiceBox projectSelectBox;
		@FXML
		private ChoiceBox effortLogEntryBox;
		
		
		ObservableList<String> projects = FXCollections.observableArrayList("Buisiness Project", "Develoopment Project");
		ObservableList<String> entries = FXCollections.observableArrayList("1. 2023-10-29 (10:44:14-11:44:54) Planning; Plans; Project Plan");
		
		
		@FXML
		private void initialize() {
			projectSelectBox.setItems(projects);
			projectSelectBox.setOnAction(event -> {
	            selectedProject = (String) projectSelectBox.getValue();
	            populateEntryBox();
	        });
			
			effortLogEntryBox.setItems(entries);
		}
		
		
		
		private void populateEntryBox() {
			if(selectedProject.compareTo("Buisiness Project") == 0) {
				//entries = FXCollections.observableArrayList("1", "2", "3");
			}
			else {
				//entries = null;
			}
		}
		
		
	}

