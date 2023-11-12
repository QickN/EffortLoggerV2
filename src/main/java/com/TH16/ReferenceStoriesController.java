/*****
Entire File Written by Ryan Leigh
*****/
package com.TH16;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import com.TH16.CSVScanner.ReferenceStory;
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
	private ArrayList<File> files = new ArrayList<File>();
	private File tempFile = new File("stories.csv");
	private ReferenceStory referenceStory;
	
	
	@FXML
	private Stage stage;
	
	//when the update button is pressed, this method will update all labels with the acquired information
	public void button(ActionEvent e) {
		int index = lifeCycleComboBox.getSelectionModel().getSelectedIndex();
		referenceStory = stories.getReferenceStoryList().get(index);
		descriptionLabel.setText(referenceStory.getDescription());
		effortLabel.setText(referenceStory.getEffort());
		nameLabel.setText(referenceStory.getName());
	}
	//when one selects the import button, it will run this method
	//this method will open a file dialog for the user to select a file, one selected it is read and parsed for information
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
		//on startup, it adds a predetermined file
		files.add(tempFile);
	}
	
	
}



