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
    public void removeP1ELog(int index) {
    	for(int i = 0; i < p1ELogs.getItems().size(); i++) {
    		if((Integer.parseInt(p1ELogs.getItems().get(i).substring(0, 1))-1) == index) {
    			p1ELogs.getItems().remove(i);
    		}
    	}
    	p1ELogs.getItems().remove(0);
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
    
    public void addToP1DLogs(Defect DLog) {
    	p1DLogs.getItems().add(DLog.toString());    	
    }
    public void addToP2DLogs(Defect DLog) {
    	p2DLogs.getItems().add(DLog.toString());
    }
    public void addToP3DLogs(Defect DLog) {
    	p3DLogs.getItems().add(DLog.toString());
    }
    public void addToP4DLogs(Defect DLog) {
    	p4DLogs.getItems().add(DLog.toString());
    }
    public void addToP5DLogs(Defect DLog) {
    	p5DLogs.getItems().add(DLog.toString());
    }
    public void addToP6DLogs(Defect DLog) {
    	p6DLogs.getItems().add(DLog.toString());
    }
    public void addToP7DLogs(Defect DLog) {
    	p7DLogs.getItems().add(DLog.toString());
    }
    public void addToP8DLogs(Defect DLog) {
    	p8DLogs.getItems().add(DLog.toString());
    }
    public void addToP9DLogs(Defect DLog) {
    	p9DLogs.getItems().add(DLog.toString());
    }
    public void addToP10DLogs(Defect DLog) {
    	p10DLogs.getItems().add(DLog.toString());
    }
    
    public void setP1DLogs(ObservableList<Defect> DLogs) {
    	p1DLogs.getItems().clear();
    	for(int i = 0; i < DLogs.size(); i++) {
    		p1DLogs.getItems().add(DLogs.get(i).toString());
    	}
    }
    public void setP2DLogs(ObservableList<Defect> DLogs) {
    	p2DLogs.getItems().clear();
    	for(int i = 0; i < DLogs.size(); i++) {
    		p2DLogs.getItems().add(DLogs.get(i).toString());
    	}
    }
    public void setP3DLogs(ObservableList<Defect> DLogs) {
    	p3DLogs.getItems().clear();
    	for(int i = 0; i < DLogs.size(); i++) {
    		p3DLogs.getItems().add(DLogs.get(i).toString());
    	}
    }
    public void setP4DLogs(ObservableList<Defect> DLogs) {
    	p4DLogs.getItems().clear();
    	for(int i = 0; i < DLogs.size(); i++) {
    		p4DLogs.getItems().add(DLogs.get(i).toString());
    	}
    }
    public void setP5DLogs(ObservableList<Defect> DLogs) {
    	p5DLogs.getItems().clear();
    	for(int i = 0; i < DLogs.size(); i++) {
    		p5DLogs.getItems().add(DLogs.get(i).toString());
    	}
    }
    public void setP6DLogs(ObservableList<Defect> DLogs) {
    	p6DLogs.getItems().clear();
    	for(int i = 0; i < DLogs.size(); i++) {
    		p6DLogs.getItems().add(DLogs.get(i).toString());
    	}
    }
    public void setP7DLogs(ObservableList<Defect> DLogs) {
    	p7DLogs.getItems().clear();
    	for(int i = 0; i < DLogs.size(); i++) {
    		p7DLogs.getItems().add(DLogs.get(i).toString());
    	}
    }
    public void setP8DLogs(ObservableList<Defect> DLogs) {
    	p8DLogs.getItems().clear();
    	for(int i = 0; i < DLogs.size(); i++) {
    		p8DLogs.getItems().add(DLogs.get(i).toString());
    	}
    }
    public void setP9DLogs(ObservableList<Defect> DLogs) {
    	p9DLogs.getItems().clear();
    	for(int i = 0; i < DLogs.size(); i++) {
    		p9DLogs.getItems().add(DLogs.get(i).toString());
    	}
    }
    public void setP10DLogs(ObservableList<Defect> DLogs) {
    	p10DLogs.getItems().clear();
    	for(int i = 0; i < DLogs.size(); i++) {
    		p10DLogs.getItems().add(DLogs.get(i).toString());
    	}
    }
}
