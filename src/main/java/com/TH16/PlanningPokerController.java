package com.TH16;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.TH16.CSVScanner.ReferenceStory;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class PlanningPokerController {
	private CSVScanner stories;
	private int numberOfTextFields;
	private ArrayList<String> localUserStories = App.getUserStories();
	private ArrayList<Integer> storyWeights = new ArrayList<Integer>();
	private int currentIndex = 0;
	private List<TextField> textFields = new ArrayList<>();
	private double totalEstimateHours = 0;
	@FXML
	private Stage stage;
	@FXML
	private TextField numOfMembersTextField;
	@FXML
	private Label storyPointNumLabel;
	@FXML
	private Label storyPointTextLabel;
	@FXML
	private TextField storyPointWeightTextField;
	@FXML
	private HBox hbox;
	@FXML
	private Label computedEstimation;
	@FXML
	private Button localStoryButton;
	@FXML
	private Button nextStoryPointButton;
	
	
	public void setNumberOfMembers() {
		textFields.clear();
		hbox.getChildren().clear();
		try {
            numberOfTextFields = Integer.parseInt(numOfMembersTextField.getText());
            
            for (int i = 0; i < numberOfTextFields; i++) {
                TextField textField = new TextField();
                textFields.add(textField);
                hbox.getChildren().add(textField);
            }
		} catch (NumberFormatException e) {
            System.out.println("Put In An Integer Please");
        }
	}
	
	public void useLocalStories() {
		storyPointNumLabel.setText("[Story Point 0/" + localUserStories.size() + "]");
		try {
		storyPointTextLabel.setText(localUserStories.get(currentIndex));
		} catch (IndexOutOfBoundsException e) {
			System.out.println("enter more user stories");
		}
	}
	
	public void setStoryPointWeight() {
		int tempWeight;
		try {
            tempWeight = Integer.parseInt(storyPointWeightTextField.getText());
            storyWeights.add(tempWeight);
		} catch (NumberFormatException e) {
            System.out.println("Put In An Integer Please");
        }
	}
	
	public void nextStoryPoint() {
		currentIndex++;
		if (currentIndex == localUserStories.size()) {
			nextStoryPointButton.setDisable(true);
			return;
		}
		useLocalStories();
		int tempEstimate;
		double average = 0;
		for (TextField tf : textFields) {
			try {
	            tempEstimate = Integer.parseInt(tf.getText());
	            average+=tempEstimate;
			} catch (NumberFormatException e) {
	            System.out.println("Put In An Integer Please");
	        }
		}
		average = average / (double) textFields.size();
		for (int e: storyWeights) {
			
		totalEstimateHours+=average * e;
		} 
		computedEstimation.setText(totalEstimateHours + "");
		
	}
	
	
	
}

