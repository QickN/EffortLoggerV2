package com.TH16;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
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
        clockStatus.setStyle("-fx-background-color: red; -fx-padding: 5px; -fx-text-fill: white;");
        VBox topBox = new VBox(10, title, clockStatus);
        topBox.setAlignment(Pos.CENTER);
        topBox.setSpacing(10);
        root.setTop(topBox);
    
        // Center content
        Label instruction1 = new Label("1. When you start a new activity, press the \"Start an Activity\" button.");
        Button startActivityBtn = new Button("Start an Activity");
        Button defectLogConsoleBtn = new Button("Proceed to Defect Log Console");
        VBox centerTopBox = new VBox(10, instruction1, startActivityBtn, defectLogConsoleBtn);
    
        Label instruction2 = new Label("2. Select the project, life cycle step, effort category, and deliverable from the following lists:");
        ComboBox<String> projectCombo = new ComboBox<>();
        projectCombo.getItems().addAll("Business Project");
        Label projectLabel = new Label("Project:");
        HBox projectHBox = new HBox(10, projectLabel, projectCombo);
    
        // You can add more ComboBoxes for Life Cycle Step, Effort Category, etc., just like projectCombo above
    
        Label instruction3 = new Label("3. Press the \"Stop this Activity\" to generate an effort log entry using the attributes above.");
        Button stopActivityBtn = new Button("Stop this Activity");
        Button effortLogEditorBtn = new Button("Proceed to Effort Log Editor");
        VBox centerBottomBox = new VBox(10, instruction2, projectHBox, instruction3, stopActivityBtn, effortLogEditorBtn);
    
        VBox centerBox = new VBox(20, centerTopBox, centerBottomBox);
        centerBox.setSpacing(10);
        root.setCenter(centerBox);
    
        // Bottom content
        Label instruction4 = new Label("4. Unless you are done for the day, it is best to perform steps 1 and 2 above before resuming work.");
        VBox bottomBox = new VBox(instruction4);
        bottomBox.setSpacing(10);
        root.setBottom(bottomBox);
    
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
    
}
