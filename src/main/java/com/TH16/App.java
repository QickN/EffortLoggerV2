package com.TH16;

import javafx.application.Application;
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
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.geometry.Side;




public class App extends Application {

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
        Label clockStatus = new Label("Clock is stopped");
        clockStatus.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        clockStatus.setStyle("-fx-background-color: red; -fx-padding: 5px 250px; -fx-text-fill: white;");
        VBox topBox = new VBox(10, title, clockStatus);
        topBox.setAlignment(Pos.CENTER);
        topBox.setSpacing(10);
        root.setTop(topBox);
    
        // Center content
        Label instruction1 = new Label("1. When you start a new activity, press the \"Start an Activity\" button.");
        Button startActivityBtn = new Button("Start an Activity");
<<<<<<< Updated upstream
        Button defectLogConsoleBtn = new Button("Proceed to Defect Log Console");
        HBox buttonsHBox = new HBox(10, startActivityBtn, defectLogConsoleBtn); 
        buttonsHBox.setAlignment(Pos.CENTER); 
        VBox centerTopBox = new VBox(10, instruction1, buttonsHBox);

        Label instruction2 = new Label("2. Select the project, life cycle step, effort category, and deliverable from the following lists:");
=======
        Button defectLogButton = new Button("Proceed to Defect Log Console");

        //Add center content to screen and format
        HBox instructionAndButtonHBox = new HBox(10, instruction1);
        instructionAndButtonHBox.setPadding(new Insets(0, 0, 10, 10)); // Add padding as needed
        instructionAndButtonHBox.setAlignment(Pos.CENTER_LEFT);
        HBox instructionAndButtonHBox2 = new HBox(300, startActivityBtn, defectLogButton);
        instructionAndButtonHBox2.setPadding(new Insets(0, 0, 10, 10)); // Add padding as needed
        instructionAndButtonHBox2.setAlignment(Pos.CENTER);

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
            clockStatus.setStyle("-fx-background-color: green; -fx-padding: 5px 250px; -fx-text-fill: white;");
        });
        

        //Added more vboxes to change the layout
        VBox centerTopBox = new VBox(10, instructionAndButtonHBox, instructionAndButtonHBox2);
        Label instruction2 = new Label("2. Select the project, life cycle step, effort category, and deliverable from the following lists:");
        //Added some comboboxes for the middle of the screen
>>>>>>> Stashed changes
        ComboBox<String> projectCombo = new ComboBox<>();
        projectCombo.getItems().addAll("Business Project");
        Label projectLabel = new Label("Project:");
        
        // Adding more ComboBoxes for Life Cycle Step, Effort Category, etc.
        ComboBox<String> lifeCycleCombo = new ComboBox<>();
        lifeCycleCombo.getItems().addAll("Select Life Cycle Step...");
        Label lifeCycleLabel = new Label("Life Cycle Step:");
        HBox lifeCycleHBox = new HBox(10, projectLabel, projectCombo, lifeCycleLabel, lifeCycleCombo);
        lifeCycleHBox.setAlignment(Pos.CENTER);

        ComboBox<String> effortCategoryCombo = new ComboBox<>();
        effortCategoryCombo.getItems().addAll("Select Effort Category...");
        Label effortCategoryLabel = new Label("Effort Category:");
<<<<<<< Updated upstream
        HBox effortCategoryHBox = new HBox(10, effortCategoryLabel, effortCategoryCombo);
=======
        HBox effortCategoryHBox = new HBox(60, effortCategoryLabel, effortCategoryCombo, effortCategoryCombo2);
        effortCategoryHBox.setAlignment(Pos.CENTER);
>>>>>>> Stashed changes

        VBox comboBoxVBox = new VBox(10, lifeCycleHBox, effortCategoryHBox);
    
        Label instruction3 = new Label("3. Press the \"Stop this Activity\" to generate an effort log entry using the attributes above.");
        Button stopActivityBtn = new Button("Stop this Activity");
<<<<<<< Updated upstream
        Button effortLogEditorBtn = new Button("Proceed to Effort Log Editor");
        
        VBox centerBottomBox = new VBox(10, instruction3, stopActivityBtn, effortLogEditorBtn);
    
        // Bottom content
        Label instruction4 = new Label("4. Unless you are done for the day, it is best to perform steps 1 and 2 above before resuming work.");
        VBox bottomBox = new VBox(instruction4);
=======
        Button effortLogButton = new Button("Proceed to Effort Log Editor");
        stopActivityBtn.setOnAction(event -> {
            if (timeline != null) {
                timeline.stop();
            }
            clockStatus.setText("Clock is stopped");
            clockStatus.setStyle("-fx-background-color: red; -fx-padding: 5px 250px; -fx-text-fill: white;");
            // reset startTime
            startTime = null;
        });
        
        HBox stopActHbox = new HBox(300, stopActivityBtn, effortLogButton);
        stopActHbox.setAlignment(Pos.CENTER);

        VBox centerBottomBox = new VBox(10, instruction3, stopActHbox);
    
        // Bottom content
        Label instruction4 = new Label("4. Unless you are done for the day, it is best to perform steps 1 and 2 above before resuming work.");
        Label planningPokerLabel = new Label("5. Planning Poker Input");
        Label userStoryName = new Label("Name of user: ");

        var storyNameInput = new ValidatingTextField(input -> (input.matches("[a-zA-Z.,-/ ]+")) && (input.length() <= 50));
        
        
        Label userStoryText = new Label("User story: ");
//        TextField storyText = new TextField();
 
        var storyText = new ValidatingTextField(input -> (input.matches("[a-zA-Z.,-/ ]+")) && (input.length() <= 50));
        Button submitStory = new Button("Submit");
        submitStory.disableProperty().bind(storyText.isValidProperty.not());
        submitStory.setOnAction(event -> {
        	userStory = storyText.getText();
            name = storyNameInput.getText();
            String combinedString = name + ": " + userStory;
            userStories.add(combinedString);
            updatePlanningPokerBox();
            storyText.clear();
            storyNameInput.clear();
        });
        Label keyWordsText = new Label("Key Words: ");
//        TextField keyWordsInput = new TextField();
        var keyWordsInput = new ValidatingTextField(input -> (input.matches("[a-zA-Z.,-/ ]+")) && (input.length() <= 50));
        Button submitKeyWords = new Button("Submit");
        submitKeyWords.disableProperty().bind(keyWordsInput.isValidProperty.not());
        submitKeyWords.setOnAction(event -> {
        	keywords.add(keyWordsInput.getText());
        });
        Button validation = new Button("Validate Credentials");
        
        HBox bottomButtonsHBox2 = new HBox(10, userStoryName, storyNameInput, userStoryText, storyText, submitStory);
        bottomButtonsHBox2.setAlignment(Pos.CENTER);
        HBox bottomButtonsHBox3 = new HBox(47, keyWordsText, keyWordsInput, submitKeyWords, validation);
        bottomButtonsHBox3.setAlignment(Pos.CENTER);

        VBox bottomBox = new VBox(instruction4, planningPokerLabel, bottomButtonsHBox2);
>>>>>>> Stashed changes
        bottomBox.setSpacing(10);
        root.setBottom(bottomBox);

        VBox centerBox = new VBox(20, centerTopBox, instruction2, comboBoxVBox, centerBottomBox);
        centerBox.setSpacing(10);
        centerBox.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT))); // Add borders
        root.setCenter(centerBox);
    
    
        // Create tabs
        TabPane tabPane = new TabPane();
        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);
        tabPane.setSide(Side.BOTTOM);

        //Effort Logger Tab
        Tab tab1 = new Tab("Effort Logger");
        tab1.setContent(root);
        tabPane.getTabs().add(tab1);

        //Effort Log Editor Tab
        Tab tab2 = new Tab("EffortLogEditor");
        tab2.setContent(new Label("Content for Another Page"));
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
<<<<<<< Updated upstream
=======
        
        //Reference Stories Tab
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
        //VBox planningPokerContent = new VBox(10);
       // planningPokerContent.setPadding(new Insets(10, 10, 10, 10));
       // planningPokerContent.setAlignment(Pos.CENTER);
       // Label selectStoryLabel = new Label("Select a User Story:");
       // planningPokerContent.getChildren().addAll(selectStoryLabel, planningPokerComboBox);
        //tab8.setContent(planningPokerContent);
        try {
            FXMLLoader tab8_loader = new FXMLLoader(getClass().getResource("PlanningPoker.fxml"));
            Pane content = tab8_loader.load();
            tab8.setContent(content);
        } catch (Exception e) {
            e.printStackTrace();
        }
        tabPane.getTabs().add(tab8);

        //Change Between Scenes
        effortLogButton.setOnAction(event -> {
            tabPane.getSelectionModel().select(tab2); 
        });
        
        defectLogButton.setOnAction(event -> {
            tabPane.getSelectionModel().select(tab3); 
        });

        
        
>>>>>>> Stashed changes

        //Show scene on page
        Scene scene = new Scene(tabPane, 800, 600);
        primaryStage.setTitle("EffortLoggerV2.0");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
}
