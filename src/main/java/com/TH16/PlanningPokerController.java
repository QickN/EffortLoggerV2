package com.TH16;

import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.TH16.CSVScanner.ReferenceStory;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
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
	private ArrayList<Card> cardArr = new ArrayList<Card>();
	private int cardNum =0;
	private int cardIndex = 0;
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
	@FXML
	private Button genCardButton;
	@FXML
	private Button nextButton;
	@FXML
	private Button backButton;
	@FXML 
	private Label cardNumLabel;
	@FXML
	private Label cardTitleLabel;
	@FXML
	private Label averageLabel;
	@FXML
	private Line line1, line2, line3, line4;
	
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
		storyPointNumLabel.setText("[Story Point " + (currentIndex+1) +  "/" + localUserStories.size() + "]");
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
		int e = Integer.parseInt(storyPointWeightTextField.getText());
		if (!(currentIndex == localUserStories.size()-1))
			totalEstimateHours+=average * e;
		
		computedEstimation.setText(totalEstimateHours + "");
		if (currentIndex == localUserStories.size()) {
			nextStoryPointButton.setDisable(true);
			return;
		}
		if (currentIndex < localUserStories.size()-1)
			currentIndex++;
	}
	
	public void genCardAdd() {
		cardNum++;
		cardArr.add(new Card(totalEstimateHours, cardNum, getRandomColor(), localUserStories.get(currentIndex)));
		showCard(cardIndex);
	}
	
	
	private Color getRandomColor() {
        Random random = new Random();
        int red = random.nextInt(256);
        int green = random.nextInt(256);
        int blue = random.nextInt(256);

        return Color.rgb(red, green, blue);
    }

	public void showCard(int index) {
		cardNumLabel.setText("#" + cardArr.get(cardIndex).getCardNum());
		cardTitleLabel.setText(cardArr.get(cardIndex).getTitle());
		DecimalFormat decimalFormat = new DecimalFormat("#.###");
        String truncatedNumber = decimalFormat.format(cardArr.get(cardIndex).getSampleAverage());
		averageLabel.setText(truncatedNumber);
		line1.setStroke(cardArr.get(cardIndex).getColor());
		line2.setStroke(cardArr.get(cardIndex).getColor());
		line3.setStroke(cardArr.get(cardIndex).getColor());
		line4.setStroke(cardArr.get(cardIndex).getColor());
	}
	public void next() {
		if (cardIndex < cardArr.size()) {
			cardIndex++;
		}
		if (cardIndex >= cardArr.size()) {
			cardIndex = cardArr.size()-1;
			//nextButton.setDisable(true);
		}
		showCard(cardIndex);
		if (cardIndex >= 0 && cardIndex < cardArr.size()) {
			//nextButton.setDisable(false);
			//backButton.setDisable(false);
		}
	}
	public void back() {
		if (cardIndex > 0) {
			cardIndex--;
		}		
		if (cardIndex <= 0) {
			cardIndex = 0;
			//backButton.setDisable(true);
		}
		showCard(cardIndex);
		if (cardIndex >= 0 && cardIndex < cardArr.size()) {
			//nextButton.setDisable(false);
			//backButton.setDisable(false);
		}
	}
}

