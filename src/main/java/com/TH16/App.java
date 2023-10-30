/*****
Worked On Collaboratively With The Entire Team. Nick Quam wrote the UI and most of this file. 
*****/

package com.TH16;

import java.time.LocalTime;
import java.util.ArrayList;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.geometry.Side;




public class App extends Application {

    private Label clockStatus;
    private Timeline timeline;
    private LocalTime startTime;
    public String userStory;
    public ArrayList<String> keywords;
    public String name;


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();
        root.setPadding(new Insets(20, 20, 20, 20));
        
    
        // Top content
        Label title = new Label("Effort Logger Console");
        title.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        clockStatus = new Label("Clock is stopped");
        clockStatus.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        clockStatus.setStyle("-fx-background-color: red; -fx-padding: 5px; -fx-text-fill: white;");
        VBox topBox = new VBox(10, title, clockStatus);
        topBox.setAlignment(Pos.CENTER);
        topBox.setSpacing(10);
        root.setTop(topBox);

        // Center content
        Label instruction1 = new Label("1. When you start a new activity, press the \"Start an Activity\" button.");
        Button startActivityBtn = new Button("Start an Activity");
        instruction1.setFont(Font.font("System", FontWeight.BOLD, 15));

        HBox instructionAndButtonHBox = new HBox(10, instruction1);
        instructionAndButtonHBox.setPadding(new Insets(0, 0, 10, 10)); // Add padding as needed
        instructionAndButtonHBox.setAlignment(Pos.CENTER_LEFT);
        HBox instructionAndButtonHBox2 = new HBox(10, startActivityBtn);
        instructionAndButtonHBox2.setPadding(new Insets(0, 0, 10, 10)); // Add padding as needed
        instructionAndButtonHBox2.setAlignment(Pos.CENTER_LEFT);

        //Start Activity Button
        startActivityBtn.setOnAction(event -> {
            // Update label and start the timer
            startTime = LocalTime.now();
            if (timeline != null) {
                timeline.stop();
            }
            timeline = new Timeline(new KeyFrame(javafx.util.Duration.seconds(1), e -> updateTimer()));
            timeline.setCycleCount(Timeline.INDEFINITE);
            timeline.play();
            clockStatus.setStyle("-fx-background-color: green; -fx-padding: 5px; -fx-text-fill: white;");
        });
        

        
        VBox centerTopBox = new VBox(10, instructionAndButtonHBox, instructionAndButtonHBox2);

        Label instruction2 = new Label("2. Select the project, life cycle step, effort category, and deliverable from the following lists:");
        ComboBox<String> projectCombo = new ComboBox<>();
        String[] projects = {"Business Project", "Development Project"};
        projectCombo.getItems().addAll(projects);
        Label projectLabel = new Label("Project:");
        HBox projectHBox = new HBox(10, projectLabel, projectCombo);
        
        // Adding more ComboBoxes for Life Cycle Step, Effort Category, etc.
        ComboBox<String> lifeCycleCombo = new ComboBox<>();
        String[] lifeCycleStep = {"Planning", "Information Gathering", "Information Understanding", "Verifying", "Outlining", "Drafting", "Finalizing", "Team Meeting", "Coach Meeting", "Stakeholder Meeting"};
        lifeCycleCombo.getItems().addAll(lifeCycleStep);
        Label lifeCycleLabel = new Label("Life Cycle Step:");
        HBox lifeCycleHBox = new HBox(10, lifeCycleLabel, lifeCycleCombo);

        ComboBox<String> effortCategoryCombo = new ComboBox<>();
        String[] EffortCategoryBox = {"Plans", "Deliverables", "Interuptions", "Defects", "Others"};
        effortCategoryCombo.getItems().addAll(EffortCategoryBox);
        ComboBox<String> effortCategoryCombo2 = new ComboBox<>();
        String[] EffortCategoryBox2 = {"Project Plan", "Risk Management Plan", "Conceptual Design Plan", "Detailed Design Plan", "Implementation Plan"};
        effortCategoryCombo2.getItems().addAll(EffortCategoryBox2);
        Label effortCategoryLabel = new Label("Effort Category:");
        HBox effortCategoryHBox = new HBox(10, effortCategoryLabel, effortCategoryCombo, effortCategoryCombo2);

        VBox comboBoxVBox = new VBox(10, projectHBox, lifeCycleHBox, effortCategoryHBox);
    
        Label instruction3 = new Label("3. Press the \"Stop this Activity\" to generate an effort log entry using the attributes above.");
        Button stopActivityBtn = new Button("Stop this Activity");
        stopActivityBtn.setOnAction(event -> {
            if (timeline != null) {
                timeline.stop();
            }
            clockStatus.setText("Clock is stopped");
            clockStatus.setStyle("-fx-background-color: red; -fx-padding: 5px; -fx-text-fill: white;");
            // reset startTime
            startTime = null;
        });
        
        
        VBox centerBottomBox = new VBox(10, instruction3, stopActivityBtn);
    
        // Bottom content
        Label instruction4 = new Label("4. Unless you are done for the day, it is best to perform steps 1 and 2 above before resuming work.");
        Button effortLogButton = new Button("Effort Log Editor");
        Button defectLogButton = new Button("Defect Log Console");
        Button DefinitionsButton = new Button("Definitions");
        Button effortAndDefectLogsConsole = new Button("Effort and Defect Logs Console");
        Label planningPokerLabel = new Label("5. Planning Poker Input");
        Label userStoryName = new Label("Name of user: ");
        TextField storyNameInput = new TextField();
        storyNameInput.setOnAction(event -> {
        	try {
                FXMLLoader input_loader = new FXMLLoader(getClass().getResource("InputValidation.fxml"));
                Pane content = input_loader.load();
                Stage newStage = new Stage();
                newStage.setTitle("New Window");
                Scene newScene = new Scene(content);
                newStage.setScene(newScene);
                newStage.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        Button submitUserStory = new Button("Submit");
        submitUserStory.setOnAction(event -> {
        	name = storyNameInput.getText();
        });
        Label userStoryText = new Label("User story: ");
        TextField storyText = new TextField();
        Button submitStory = new Button("Submit");
        submitStory.setOnAction(event -> {
        	userStory = storyText.getText();
        });
        Label keyWordsText = new Label("Key Words: ");
        TextField keyWordsInput = new TextField();
        Button submitKeyWords = new Button("Submit");
        submitKeyWords.setOnAction(event -> {
        	keywords.add(keyWordsInput.getText());
        });


        HBox bottomButtonsHBox = new HBox(10, effortLogButton, defectLogButton, DefinitionsButton, effortAndDefectLogsConsole);
        HBox bottomButtonsHBox2 = new HBox(10, userStoryName, storyNameInput,submitUserStory, userStoryText, storyText, submitStory);
        HBox bottomButtonsHBox3 = new HBox(10, keyWordsText, keyWordsInput, submitKeyWords);

        VBox bottomBox = new VBox(instruction4, bottomButtonsHBox, planningPokerLabel, bottomButtonsHBox2);
        bottomBox.setSpacing(10);
        root.setBottom(bottomBox);

        // This is your original centerBox with border:
        VBox centerBox = new VBox(20, topBox, centerTopBox, instruction2, comboBoxVBox, centerBottomBox, bottomBox, bottomButtonsHBox3);
        centerBox.setSpacing(10);
        centerBox.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(5), new BorderWidths(2)))); // Add the first inner border
        
        root.setCenter(centerBox);

    
    
        // Create tabs
        TabPane tabPane = new TabPane();
        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);
        tabPane.setSide(Side.BOTTOM);

        //Effort Logger Tab
        Tab tab1 = new Tab("Effort Logger");
        /*
        try {
            FXMLLoader tab1_loader = new FXMLLoader(getClass().getResource("EffortConsole.fxml"));
            Pane content = tab1_loader.load();
            tab1.setContent(content);
        } catch (Exception e) {
            e.printStackTrace();
        }
        */
        tab1.setContent(root);
        tabPane.getTabs().add(tab1);

        //Effort Log Editor Tab
        Tab tab2 = new Tab("EffortLogEditor");
        try {
            FXMLLoader tab2_loader = new FXMLLoader(getClass().getResource("EffortLogEditor.fxml"));
            Pane content = tab2_loader.load();
            tab2.setContent(content);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //tab2.setContent(new Label("Content for Another Page"));
        tabPane.getTabs().add(tab2);

        //Defect Console Tab
        Tab tab3 = new Tab("DefectConsole");
        tab3.setContent(new Label("Content for Another Page"));
        tabPane.getTabs().add(tab3);

        //Defect Log Editor Tab
        Tab tab4 = new Tab("Logs");
        tab4.setContent(new Label("Content for Another Page"));
        tabPane.getTabs().add(tab4);

        //Defect Log Editor Tab
        Tab tab5 = new Tab("Definitions");
        tab5.setContent(new Label("Content for Another Page"));
        tabPane.getTabs().add(tab5);

        //Defect Log Editor Tab
        Tab tab6 = new Tab("LogManager");
        tab6.setContent(new Label("Content for Another Page"));
        tabPane.getTabs().add(tab6);
        
        Tab tab7 = new Tab("Show Reference Stories");
        try {
            FXMLLoader tab7_loader = new FXMLLoader(getClass().getResource("ReferenceStories.fxml"));
            Pane content = tab7_loader.load();
            tab7.setContent(content);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //tab7.setContent(new Label("Content for Another Page"));
        tabPane.getTabs().add(tab7);

        //Planning Poker Tab
        Tab tab8 = new Tab("Planning Poker");
        tab8.setContent(new Label("Content for Another Page"));
        tabPane.getTabs().add(tab8);

        //Change Between Scenes
        effortLogButton.setOnAction(event -> {
            tabPane.getSelectionModel().select(tab2); 
        });
        
        defectLogButton.setOnAction(event -> {
            tabPane.getSelectionModel().select(tab3); 
        });
        
        DefinitionsButton.setOnAction(event -> {
            tabPane.getSelectionModel().select(tab5);
        });
        
        effortAndDefectLogsConsole.setOnAction(event -> {
            tabPane.getSelectionModel().select(tab4); 
        });
        
        

        //Show scene on page
        Scene scene = new Scene(tabPane, 800, 600);
        primaryStage.setTitle("EffortLoggerV2.0");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    private void updateTimer() {
        if (startTime != null) {
            java.time.Duration duration = java.time.Duration.between(startTime, LocalTime.now());
            long hours = duration.toHours();
            long minutes = duration.minusHours(hours).toMinutes();
            long seconds = duration.minusHours(hours).minusMinutes(minutes).toMillis() / 1000;
            clockStatus.setText(String.format("Clock is running | %02d:%02d:%02d", hours, minutes, seconds));
        }
    }
    
    
    
    
}