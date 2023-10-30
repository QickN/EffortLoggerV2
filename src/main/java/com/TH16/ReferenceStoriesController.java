package com.TH16;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.TH16.CSVScanner.ReferenceStory;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class ReferenceStoriesController implements Initializable {
	@FXML
	private ComboBox<String> referenceStoryComboBox;
	@FXML
	private ComboBox<String> lifeCycleComboBox;
	@FXML
	private Label effortLabel;
	@FXML
	private Label descriptionLabel;
	@FXML
	private Label nameLabel;
	private CSVScanner stories;
	private String[] items;
	private ArrayList<File> files = new ArrayList<File>();
	private File tempFile = new File("stories.csv");
	private ReferenceStory referenceStory;
	
	
	@FXML
	private Stage stage;
	
	public void comboTouched(ActionEvent e) {
		
	}
	
	public void button(ActionEvent e) {
		int index = lifeCycleComboBox.getSelectionModel().getSelectedIndex();
		referenceStory = stories.getReferenceStoryList().get(index);
		descriptionLabel.setText(referenceStory.getDescription());
		effortLabel.setText(referenceStory.getEffort());
		nameLabel.setText(referenceStory.getName());
	}
	public void selectFile() {
		FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("CSV Files", "*.csv"));
        File selectedFile = fileChooser.showOpenDialog(stage);
        files.add(selectedFile);
		stories = new CSVScanner(selectedFile);
		referenceStoryComboBox.getItems().addAll(selectedFile.getName());
		
		for (ReferenceStory story : stories.getReferenceStoryList()) {
			lifeCycleComboBox.getItems().addAll(story.getName());
		}
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		//ObservableList<ReferenceStory> referenceStories = FXCollections.observableArrayList(stories.getReferenceStoryList());
		//referenceStoryComboBox.getItems().add("Tic Tac Toe");
		files.add(tempFile);
        // Set the items of the ComboBox
		/*
		for (ReferenceStory story : stories.getReferenceStoryList()) {
			lifeCycleComboBox.getItems().addAll(story.getName());
		}
		*/
		
        // You can also set an initial selection if needed
        //referenceStoryComboBox.getSelectionModel().selectFirst();
		
	}
	
	
}



