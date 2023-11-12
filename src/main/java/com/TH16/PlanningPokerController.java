package com.TH16;

import java.io.File;

import com.TH16.CSVScanner.ReferenceStory;

import javafx.stage.FileChooser;

public class PlanningPokerController {

	
	
	
	
	
	public void selectFile() {
		FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("CSV Files", "*.csv"));
        File selectedFile = fileChooser.showOpenDialog(stage);
        files.add(selectedFile);
		stories = new CSVScanner(selectedFile);
		referenceStoryComboBox.getItems().addAll(selectedFile.getName());
		
		
	}
}
