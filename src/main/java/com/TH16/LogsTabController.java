package com.TH16;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

public class LogsTabController {
    @FXML
    private ComboBox<String> p10DLogs;
    @FXML
    private ComboBox<String> p10ELogs;
    @FXML
    private ComboBox<String> p1DLogs;
    @FXML
    private ComboBox<String> p1ELogs;
    @FXML
    private ComboBox<String> p2DLogs;
    @FXML
    private ComboBox<String> p2ELogs;
    @FXML
    private ComboBox<String> p3DLogs;
    @FXML
    private ComboBox<String> p3ELogs;
    @FXML
    private ComboBox<String> p4DLogs;
    @FXML
    private ComboBox<String> p4ELogs;
    @FXML
    private ComboBox<String> p5DLogs;
    @FXML
    private ComboBox<String> p5ELogs;
    @FXML
    private ComboBox<String> p6DLogs;
    @FXML
    private ComboBox<String> p6ELogs;
    @FXML
    private ComboBox<String> p7DLogs;
    @FXML
    private ComboBox<String> p7ELogs;
    @FXML
    private ComboBox<String> p8DLogs;
    @FXML
    private ComboBox<String> p8ELogs;
    @FXML
    private ComboBox<String> p9DLogs;
    @FXML
    private ComboBox<String> p9ELogs;
    @FXML
    private Label project10Label;
    @FXML
    private Label project1Label;
    @FXML
    private Label project2Label;
    @FXML
    private Label project3Label;
    @FXML
    private Label project4Label;
    @FXML
    private Label project5Label;
    @FXML
    private Label project6Label;
    @FXML
    private Label project7Label;
    @FXML
    private Label project8Label;
    @FXML
    private Label project9Label;
    
    public ObservableList<Activity> activities = FXCollections.observableArrayList();
    
    public void addActivity(Activity a) {
    	this.activities.add(a);
    }
    
    public ObservableList<Activity> getActivities() {
    	return activities;
    }
    
    
    public void setP1Label(String project) {
    	project1Label.setText("Project 1: " + project);
    }
    public void setP2Label(String project) {
    	project2Label.setText("Project 2: " + project);
    }
    public void setP3Label(String project) {
    	project3Label.setText("Project 3: " + project);
    }
    public void setP4Label(String project) {
    	project4Label.setText("Project 4: " + project);
    }
    public void setP5Label(String project) {
    	project5Label.setText("Project 5: " + project);
    }
    public void setP6Label(String project) {
    	project6Label.setText("Project 6: " + project);
    }
    public void setP7Label(String project) {
    	project7Label.setText("Project 7: " + project);
    }
    public void setP8Label(String project) {
    	project8Label.setText("Project 8: " + project);
    }
    public void setP9Label(String project) {
    	project9Label.setText("Project 9: " + project);
    }
    public void setP10Label(String project) {
    	project10Label.setText("Project 10: " + project);
    }
    
    public void addToP1ELogs(ObservableList<Activity> ELogs) {
    	p1ELogs.getItems().clear();
    	for(int i = 0; i < ELogs.size(); i++) {
    		p1ELogs.getItems().add(ELogs.get(i).toString());
    	}
    }
    public void addToP2ELogs(ObservableList<Activity> ELogs) {
    	p2ELogs.getItems().clear();
    	for(int i = 0; i < ELogs.size(); i++) {
    		p2ELogs.getItems().add(ELogs.get(i).toString());
    	}
    }
    public void addToP3ELogs(ObservableList<Activity> ELogs) {
    	p3ELogs.getItems().clear();
    	for(int i = 0; i < ELogs.size(); i++) {
    		p3ELogs.getItems().add(ELogs.get(i).toString());
    	}
    }
    public void addToP4ELogs(ObservableList<Activity> ELogs) {
    	p4ELogs.getItems().clear();
    	for(int i = 0; i < ELogs.size(); i++) {
    		p4ELogs.getItems().add(ELogs.get(i).toString());
    	}
    }
    public void addToP5ELogs(ObservableList<Activity> ELogs) {
    	p5ELogs.getItems().clear();
    	for(int i = 0; i < ELogs.size(); i++) {
    		p5ELogs.getItems().add(ELogs.get(i).toString());
    	}
    }
    public void addToP6ELogs(ObservableList<Activity> ELogs) {
    	p6ELogs.getItems().clear();
    	for(int i = 0; i < ELogs.size(); i++) {
    		p6ELogs.getItems().add(ELogs.get(i).toString());
    	}
    }
    public void addToP7ELogs(ObservableList<Activity> ELogs) {
    	p7ELogs.getItems().clear();
    	for(int i = 0; i < ELogs.size(); i++) {
    		p7ELogs.getItems().add(ELogs.get(i).toString());
    	}
    }
    public void addToP8ELogs(ObservableList<Activity> ELogs) {
    	p8ELogs.getItems().clear();
    	for(int i = 0; i < ELogs.size(); i++) {
    		p8ELogs.getItems().add(ELogs.get(i).toString());
    	}
    }
    public void addToP9ELogs(ObservableList<Activity> ELogs) {
    	p9ELogs.getItems().clear();
    	for(int i = 0; i < ELogs.size(); i++) {
    		p9ELogs.getItems().add(ELogs.get(i).toString());
    	}
    }
    public void addToP10ELogs(ObservableList<Activity> ELogs) {
    	p10ELogs.getItems().clear();
    	for(int i = 0; i < ELogs.size(); i++) {
    		p10ELogs.getItems().add(ELogs.get(i).toString());
    	}
    }
    
    public void addToP1DLogs(ObservableList<String> DLogs) {
    	p1DLogs.setItems(DLogs);
    }
    public void addToP2DLogs(ObservableList<String> DLogs) {
    	p2DLogs.setItems(DLogs);
    }
    public void addToP3DLogs(ObservableList<String> DLogs) {
    	p3DLogs.setItems(DLogs);
    }
    public void addToP4DLogs(ObservableList<String> DLogs) {
    	p4DLogs.setItems(DLogs);
    }
    public void addToP5DLogs(ObservableList<String> DLogs) {
    	p5DLogs.setItems(DLogs);
    }
    public void addToP6DLogs(ObservableList<String> DLogs) {
    	p6DLogs.setItems(DLogs);
    }
    public void addToP7DLogs(ObservableList<String> DLogs) {
    	p7DLogs.setItems(DLogs);
    }
    public void addToP8DLogs(ObservableList<String> DLogs) {
    	p8DLogs.setItems(DLogs);
    }
    public void addToP9DLogs(ObservableList<String> DLogs) {
    	p9DLogs.setItems(DLogs);
    }
    public void addToP10DLogs(ObservableList<String> DLogs) {
    	p10DLogs.setItems(DLogs);
    }
}
