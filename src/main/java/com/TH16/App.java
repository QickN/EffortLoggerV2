package com.TH16;

import java.time.LocalTime;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
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

    private Label clockStatus;
    private Timeline timeline;
    private LocalTime startTime;


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
        

        HBox buttonsHBox = new HBox(10, startActivityBtn); 
        buttonsHBox.setAlignment(Pos.CENTER); 
        VBox centerTopBox = new VBox(10, instruction1, buttonsHBox);

        Label instruction2 = new Label("2. Select the project, life cycle step, effort category, and deliverable from the following lists:");
        ComboBox<String> projectCombo = new ComboBox<>();
        projectCombo.getItems().addAll("Business Project");
        Label projectLabel = new Label("Project:");
        HBox projectHBox = new HBox(10, projectLabel, projectCombo);
        
        // Adding more ComboBoxes for Life Cycle Step, Effort Category, etc.
        ComboBox<String> lifeCycleCombo = new ComboBox<>();
        lifeCycleCombo.getItems().addAll("Select Life Cycle Step...");
        Label lifeCycleLabel = new Label("Life Cycle Step:");
        HBox lifeCycleHBox = new HBox(10, lifeCycleLabel, lifeCycleCombo);

        ComboBox<String> effortCategoryCombo = new ComboBox<>();
        effortCategoryCombo.getItems().addAll("Select Effort Category...");
        Label effortCategoryLabel = new Label("Effort Category:");
        HBox effortCategoryHBox = new HBox(10, effortCategoryLabel, effortCategoryCombo);

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
        HBox bottomButtonsHBox = new HBox(10, effortLogButton, defectLogButton, DefinitionsButton, effortAndDefectLogsConsole);

        VBox bottomBox = new VBox(instruction4, bottomButtonsHBox);
        bottomBox.setSpacing(10);
        root.setBottom(bottomBox);

        // This is your original centerBox with border:
        VBox centerBox = new VBox(20, topBox, centerTopBox, instruction2, comboBoxVBox, centerBottomBox, bottomBox);
        centerBox.setSpacing(10);
        centerBox.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(5), new BorderWidths(2)))); // Add the first inner border
        
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
