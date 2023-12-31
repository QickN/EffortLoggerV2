/*****
Worked On Collaboratively With The Entire Team. Nick Quam wrote the UI and most of this file. 
*****/

package com.TH16;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.function.Predicate;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import javafx.util.Duration;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.geometry.Side;


public class App extends Application {

    // Add all the variables here
    private Label clockStatus;
    private Timeline timeline;
    private LocalTime startTime;
    private LocalTime endTime;
    public String userStory;
    public ArrayList<String> keywords = new ArrayList<>();
    public String name;
    private static ArrayList<String> userStories = new ArrayList<>();
    public static int activityID = 0;

    public String[] availableKeyWords;
    public int j = 0;
    public boolean flag;
    FXMLLoader tab2_loader = new FXMLLoader(getClass().getResource("EffortLogEditor.fxml"));
    FXMLLoader tab5_loader = new FXMLLoader(getClass().getResource("DefinitionsTab.fxml"));
    FXMLLoader tab4_loader = new FXMLLoader(getClass().getResource("LogsTab.fxml"));
    FXMLLoader tab3_loader = new FXMLLoader(getClass().getResource("Defect.fxml"));
    public ArrayList<Activity> activities = new ArrayList<>();
    public static ObservableList<Activity> p1Activities = FXCollections.observableArrayList();
    public static ObservableList<Activity> p2Activities = FXCollections.observableArrayList();
    public static ObservableList<Activity> p3Activities = FXCollections.observableArrayList();
    public static ObservableList<Activity> p4Activities = FXCollections.observableArrayList();
    public static ObservableList<Activity> p5Activities = FXCollections.observableArrayList();
    public static ObservableList<Activity> p6Activities = FXCollections.observableArrayList();
    public static ObservableList<Activity> p7Activities = FXCollections.observableArrayList();
    public static ObservableList<Activity> p8Activities = FXCollections.observableArrayList();
    public static ObservableList<Activity> p9Activities = FXCollections.observableArrayList();
    public static ObservableList<Activity> p10Activities = FXCollections.observableArrayList();

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
        clockStatus.setStyle("-fx-background-color: red; -fx-padding: 5px 250px; -fx-text-fill: white;");
        VBox topBox = new VBox(10, title, clockStatus);
        topBox.setAlignment(Pos.CENTER);
        topBox.setSpacing(10);
        root.setTop(topBox);

        // Center content
        Label instruction1 = new Label("1. When you start a new activity, press the \"Start an Activity\" button.");
        Button startActivityBtn = new Button("Start an Activity");
        instruction1.setFont(Font.font("System", FontWeight.BOLD, 15));
        
        Button defectLogConsoleBtn = new Button("Proceed to Defect Log Console");
        //Change Between Scenes

        

        

     
        

        //Add center content to screen and format
        HBox instructionAndButtonHBox = new HBox(10, instruction1);
        instructionAndButtonHBox.setPadding(new Insets(0, 0, 10, 10));
        instructionAndButtonHBox.setAlignment(Pos.CENTER_LEFT);
        HBox instructionAndButtonHBox2 = new HBox(175, startActivityBtn, defectLogConsoleBtn);
        instructionAndButtonHBox2.setPadding(new Insets(0, 0, 10, 10));
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
        instruction2.setPadding(new Insets(0, 0, 10, 10));

        instruction2.setFont(Font.font("System", FontWeight.BOLD, 15));
        //Added some comboboxes for the middle of the screen
        ComboBox<String> projectCombo = new ComboBox<>();
/********************************************************************************
 *  						BEGIN AUSTIN'S CONTRIBUTION					    	*
 * 																				*
 ********************************************************************************/
        projectCombo.setMinWidth(200);
        projectCombo.setOnMouseClicked( event ->{
            DefinitionsTabController dtc = tab5_loader.getController(); //create controller object
          //use dtc to gather information from the definitions tab
            projectCombo.getItems().clear();//clear before adding
            projectCombo.getItems().addAll(dtc.getProjects());
        });
        
        Label projectLabel = new Label("Project:");
        HBox projectHBox = new HBox(10, projectLabel, projectCombo);
        projectHBox.setAlignment(Pos.CENTER);
        
        // Adding more ComboBoxes for Life Cycle Step, Effort Category, etc.
        ComboBox<String> lifeCycleCombo = new ComboBox<>();
        lifeCycleCombo.setMinWidth(200);
        lifeCycleCombo.setOnMouseClicked( event ->{
            DefinitionsTabController dtc = tab5_loader.getController(); //create controller object
            //use dtc to gather information from the definitions tab
            String[] projects = dtc.getProjects();
            String[] lifeCycleSteps = dtc.getLifeCycleSteps();
            String[] p1LCS = dtc.getP1LCS();
            String[] p2LCS = dtc.getP2LCS();
            String[] p3LCS = dtc.getP3LCS();
            String[] p4LCS = dtc.getP4LCS();
            String[] p5LCS = dtc.getP5LCS();
            String[] p6LCS = dtc.getP6LCS();
            String[] p7LCS = dtc.getP7LCS();
            String[] p8LCS = dtc.getP8LCS();
            String[] p9LCS = dtc.getP9LCS();
            String[] p10LCS = dtc.getP10LCS();
            lifeCycleCombo.getItems().clear();//clear before adding
            
            /* 
             * The following if else sequence captures the correct life cycle steps for the selected project
             */
            if(projectCombo.getValue().equals(projects[0])) {
            	int i = 0;
            	while((p1LCS[i]) != "") {
            		int j = Integer.parseInt(p1LCS[i]);
                    lifeCycleCombo.getItems().add(lifeCycleSteps[j-1]);
                    i++;
            	}
            }
            else if(projectCombo.getValue().equals(projects[1])) {
            	int i = 0;
            	while((p2LCS[i]) != "") {
            		int j = Integer.parseInt(p2LCS[i]);
                    lifeCycleCombo.getItems().add(lifeCycleSteps[j-1]);
                    i++;
            	}
            }
            else if(projectCombo.getValue().equals(projects[2])) {
            	int i = 0;
            	while((p3LCS[i]) != "") {
            		int j = Integer.parseInt(p3LCS[i]);
                    lifeCycleCombo.getItems().add(lifeCycleSteps[j-1]);
                    i++;
            	}
            }
            else if(projectCombo.getValue().equals(projects[3])) {
            	int i = 0;
            	while((p4LCS[i]) != "") {
            		int j = Integer.parseInt(p4LCS[i]);
                    lifeCycleCombo.getItems().add(lifeCycleSteps[j-1]);
                    i++;
            	}
            }
            else if(projectCombo.getValue().equals(projects[4])) {
            	int i = 0;
            	while((p5LCS[i]) != "") {
            		int j = Integer.parseInt(p5LCS[i]);
                    lifeCycleCombo.getItems().add(lifeCycleSteps[j-1]);
                    i++;
            	}
            }
            else if(projectCombo.getValue().equals(projects[5])) {
            	int i = 0;
            	while((p6LCS[i]) != "") {
            		int j = Integer.parseInt(p6LCS[i]);
                    lifeCycleCombo.getItems().add(lifeCycleSteps[j-1]);
                    i++;
            	}
            }
            else if(projectCombo.getValue().equals(projects[6])) {
            	int i = 0;
            	while((p7LCS[i]) != "") {
            		int j = Integer.parseInt(p7LCS[i]);
                    lifeCycleCombo.getItems().add(lifeCycleSteps[j-1]);
                    i++;
            	}
            }
            else if(projectCombo.getValue().equals(projects[7])) {
            	int i = 0;
            	while((p8LCS[i]) != "") {
            		int j = Integer.parseInt(p8LCS[i]);
                    lifeCycleCombo.getItems().add(lifeCycleSteps[j-1]);
                    i++;
            	}
            }
            else if(projectCombo.getValue().equals(projects[8])) {
            	int i = 0;
            	while((p9LCS[i]) != "") {
            		int j = Integer.parseInt(p9LCS[i]);
                    lifeCycleCombo.getItems().add(lifeCycleSteps[j-1]);
                    i++;
            	}
            }
            else if(projectCombo.getValue().equals(projects[9])) {
            	int i = 0;
            	while((p10LCS[i]) != "") {
            		int j = Integer.parseInt(p10LCS[i]);
                    lifeCycleCombo.getItems().add(lifeCycleSteps[j-1]);
                    i++;
            	}
            }
        });
        
        Label lifeCycleLabel = new Label("Life Cycle Step:");
        HBox lifeCycleHBox = new HBox(10, lifeCycleLabel, lifeCycleCombo);
        lifeCycleHBox.setAlignment(Pos.CENTER);


        //Adding more ComboBoxes for Effort Category
        ComboBox<String> effortCategoryCombo = new ComboBox<>();
        effortCategoryCombo.setMinWidth(200);
        effortCategoryCombo.setOnMouseClicked( event ->{
            DefinitionsTabController dtc = tab5_loader.getController(); //create controller object
            //use dtc to gather information from the definitions tab
            effortCategoryCombo.getItems().clear();//clear before adding
            effortCategoryCombo.getItems().addAll(dtc.getEffortCategories());
        });

        //Adding more ComboBoxes for Effort Category
        ComboBox<String> effortCategoryCombo2 = new ComboBox<>();
        effortCategoryCombo2.setMinWidth(200);
        effortCategoryCombo2.setOnMouseClicked( event ->{
            DefinitionsTabController dtc = tab5_loader.getController(); //create controller object
            DefectController dc = tab3_loader.getController();
            //use dtc to gather information from the definitions tab
            effortCategoryCombo2.getItems().clear();//clear before adding
            if(effortCategoryCombo.getValue().equals("Plans")) {
            	effortCategoryCombo2.getItems().addAll(dtc.getPlans());
            }
            else if(effortCategoryCombo.getValue().equals("Deliverables")) {
            	effortCategoryCombo2.getItems().addAll(dtc.getDeliverables());
            }
            else if(effortCategoryCombo.getValue().equals("Interruptions")) {
            	effortCategoryCombo2.getItems().addAll(dtc.getInterruptions());
            }
            else if(effortCategoryCombo.getValue().equals("Defects")) {
            	effortCategoryCombo2.getItems().addAll(dc.getDefects());
            }
        });
/********************************************************************************
 *  						END AUSTIN'S CONTRIBUTION					    	*
 * 																				*
 ********************************************************************************/
        Label effortCategoryLabel = new Label("Effort Category:");
        HBox effortCategoryHBox = new HBox(10, effortCategoryLabel, effortCategoryCombo, effortCategoryCombo2);
        effortCategoryHBox.setAlignment(Pos.CENTER);

        VBox comboBoxVBox = new VBox(10, projectHBox, lifeCycleHBox, effortCategoryHBox);

    
        //Added reliability 
        Label instruction3 = new Label("3. Press the \"Stop this Activity\" to generate an effort log entry using the attributes above.");
        instruction3.setPadding(new Insets(0, 0, 10, 10));

        instruction3.setFont(Font.font("System", FontWeight.BOLD, 15));
        Button stopActivityBtn = new Button("Stop this Activity");
        Button effortLogBtn = new Button("Procced to Effort Log Editor");
        stopActivityBtn.setOnAction(event -> {
            endTime = LocalTime.now();
            if (timeline != null) {
                timeline.stop();
            }
            LocalDate date = LocalDate.now();             
            DefinitionsTabController dtc = tab5_loader.getController(); //create controller object
            LogsTabController ltc = tab4_loader.getController();
            String project = projectCombo.getValue();
            String lifeCycleStep = lifeCycleCombo.getValue();
            String effortCategory1 = effortCategoryCombo.getValue();
            String effortCategory2 = effortCategoryCombo2.getValue();
            activityID++;
            Activity activity = new Activity(project, lifeCycleStep, effortCategory1, effortCategory2, startTime, endTime, date, activityID);
            System.out.println(activity.getProject() +  " " + activity.getLifeCycleStep() + " " 
            		+ activity.getEffortCategory1() + " " + activity.getEffortCategory2() + " "
            		+ activity.getStartTime() + " " + activity.getEndTime() + " " + activity.getDate() + " " + activity.getId());
            ltc.addActivity(activity);
            activities.add(activity);
            if(project.equals(dtc.getProjects()[0])) {
            	p1Activities.add(activity);
            }
            else if(project.equals(dtc.getProjects()[1])) {
            	p2Activities.add(activity);
            }
            else if(project.equals(dtc.getProjects()[2])) {
            	p3Activities.add(activity);
            }
            else if(project.equals(dtc.getProjects()[3])) {
            	p4Activities.add(activity);
            }
            else if(project.equals(dtc.getProjects()[4])) {
            	p5Activities.add(activity);
            }
            else if(project.equals(dtc.getProjects()[5])) {
            	p6Activities.add(activity);
            }
            else if(project.equals(dtc.getProjects()[6])) {
            	p7Activities.add(activity);
            }
            else if(project.equals(dtc.getProjects()[7])) {
            	p8Activities.add(activity);
            }
            else if(project.equals(dtc.getProjects()[8])) {
            	p9Activities.add(activity);
            }
            else if(project.equals(dtc.getProjects()[9])) {
            	p10Activities.add(activity);
            }
            else {
            	System.out.println("ERROR");
            }
            clockStatus.setText("Clock is stopped");
            clockStatus.setStyle("-fx-background-color: red; -fx-padding: 5px 250px; -fx-text-fill: white;");
            // reset startTime
            startTime = null;
        });
        
        HBox hboxSec3 = new HBox(175, stopActivityBtn, effortLogBtn);
        hboxSec3.setAlignment(Pos.CENTER);
        VBox centerBottomBox = new VBox(10, instruction3, hboxSec3);
    
        // Bottom content
        Label instruction4 = new Label("4. Unless you are done for the day, it is best to perform steps 1 and 2 above before resuming work.");
        instruction4.setPadding(new Insets(0, 0, 10, 10));

        instruction4.setFont(Font.font("System", FontWeight.BOLD, 15));

        Label planningPokerLabel = new Label("5. Planning Poker Input");
        planningPokerLabel.setPadding(new Insets(0, 0, 0, 10));

        planningPokerLabel.setFont(Font.font("System", FontWeight.BOLD, 15));
        Label userStoryName = new Label("Name of user: ");

        var storyNameInput = new ValidatingTextField(input -> (input.matches("[a-zA-Z.,-/ ]+")) && (input.length() <= 50));
        
        Button submitUserStory = new Button("Submit");
        submitUserStory.disableProperty().bind(storyNameInput.isValidProperty.not());
        submitUserStory.setOnAction(event -> {
        	name = storyNameInput.getText();
        });
        
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
        
        //when a keyword is inputed check if it is in the pool of available keywords from definitions tab
        submitKeyWords.setOnAction(event -> {
        	DefinitionsTabController dtc = tab5_loader.getController(); //create controller object
        	availableKeyWords = dtc.getKeyWords(); //get list of keywords
        	flag = false;
        	for(int i = 0; i < 20; i++) { //check keyword pool
        		if (keyWordsInput.getText().equals(availableKeyWords[i])) {
        			keywords.add(keyWordsInput.getText()); //add keyword to project's keywords
        			flag = true;
            		System.out.println("success");
        		}
        	}
        	if(flag == false) { //keyword not available
        		System.out.println("KeyWord not in available key word list specified in the Definitions tab. "
        				+ "Either add the desired Keyword to the available keywords list or use already available keywords.");
        	}
        	
        });
        Button validation = new Button("Validate Credentials");
        

        HBox bottomButtonsHBox2 = new HBox(10, userStoryName, storyNameInput, userStoryText, storyText, submitStory);
        bottomButtonsHBox2.setAlignment(Pos.CENTER);

        HBox bottomButtonsHBox3 = new HBox(10, keyWordsText, keyWordsInput, submitKeyWords, validation);
        bottomButtonsHBox3.setAlignment(Pos.CENTER);


        VBox bottomBox = new VBox(instruction4, planningPokerLabel, bottomButtonsHBox2);
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
        tab1.setContent(root);
        tabPane.getTabs().add(tab1);

        //Effort Log Editor Tab
        Tab tab2 = new Tab("EffortLogEditor");
        try {
//            FXMLLoader tab2_loader = new FXMLLoader(getClass().getResource("EffortLogEditor.fxml"));
            Pane content = tab2_loader.load();
            tab2.setContent(content);
        } catch (Exception e) {
            e.printStackTrace();
        }
        tab2.setOnSelectionChanged(event -> {
        	DefinitionsTabController dtc = tab5_loader.getController(); //create controller object
        	LogsTabController ltc = tab4_loader.getController();
        	EffortLogEditorController elec = tab2_loader.getController(); //create controller object
            elec.deleteEntryButton.setOnAction(e -> {
            	elec.deleteEntryButton.setOnMouseClicked(ev ->{
            		elec.projectSelected(null);
            	});
            	String selectedActivityID = elec.getSelectedItem(elec.effortLogSelectBox).substring(0, 1);
//              ltc.removeActivity(Integer.parseInt(selectedActivityID)-1);
            	int index = Integer.parseInt(selectedActivityID)-1;
            	if(elec.getSelectedItem(elec.projectSelectBox).equals(elec.projects.get(0))) {
            		elec.effortLogsP1.remove(activities.get(index));
      			}
            	else if(elec.getSelectedItem(elec.projectSelectBox).equals(elec.projects.get(1))) {
            		elec.effortLogsP2.remove(activities.get(index));
        		}
        		else if(elec.getSelectedItem(elec.projectSelectBox).equals(elec.projects.get(2))) {
        			elec.effortLogsP3.remove(activities.get(index));
        		}
        		else if(elec.getSelectedItem(elec.projectSelectBox).equals(elec.projects.get(3))) {
        			elec.effortLogsP4.remove(activities.get(index));
        		}
        		else if(elec.getSelectedItem(elec.projectSelectBox).equals(elec.projects.get(4))) {
        			elec.effortLogsP5.remove(activities.get(index));
        		}
        		else if(elec.getSelectedItem(elec.projectSelectBox).equals(elec.projects.get(5))) {
        			elec.effortLogsP6.remove(activities.get(index));
        		}
        		else if(elec.getSelectedItem(elec.projectSelectBox).equals(elec.projects.get(6))) {
        			elec.effortLogsP7.remove(activities.get(index));
        		}
        		else if(elec.getSelectedItem(elec.projectSelectBox).equals(elec.projects.get(7))) {
        			elec.effortLogsP8.remove(activities.get(index));
        		}
        		else if(elec.getSelectedItem(elec.projectSelectBox).equals(elec.projects.get(8))) {
        			elec.effortLogsP9.remove(activities.get(index));
        		}
        		else if(elec.getSelectedItem(elec.projectSelectBox).equals(elec.projects.get(9))) {
        			elec.effortLogsP10.remove(activities.get(index));
        		}
              else {
              	System.out.println("ERROR");
              }
//              activities.remove(index);
            String id = elec.getSelectedItem(elec.effortLogSelectBox).substring(0, 1);
      		for(int i = 0; i < activities.size(); i++) {
      			if(i > Integer.parseInt(id)-1)
      				activities.get(i).setId(activities.get(i).getId() - 1);
      		}
      		activities.remove(index);
      		activityID--;
            });
        	elec.setProjects(dtc.getProjects());
        	
        	elec.setELogsP1(p1Activities);
        	elec.setELogsP2(p2Activities);
        	elec.setELogsP3(p3Activities);
        	elec.setELogsP4(p4Activities);
        	elec.setELogsP5(p5Activities);
        	elec.setELogsP6(p6Activities);
        	elec.setELogsP7(p7Activities);
        	elec.setELogsP8(p8Activities);
        	elec.setELogsP9(p9Activities);
        	elec.setELogsP10(p10Activities);
        	elec.setActivities(activities);
        	elec.setDefinitionsLoader(tab5_loader);
        	elec.setLogsLoader(tab4_loader);
        	elec.setDtc(dtc);
        	elec.setLtc(ltc);
        	
        	
        });
        //tab2.setContent(new Label("Content for Another Page"));
        tabPane.getTabs().add(tab2);

        //Defect Console Tab
        Tab tab3 = new Tab("DefectConsole");
        try {
//            FXMLLoader tab3_loader = new FXMLLoader(getClass().getResource("Defect.fxml"));
            Pane content = tab3_loader.load();
            tab3.setContent(content);
        } catch (Exception e) {
            e.printStackTrace();
        }
        tabPane.getTabs().add(tab3);
        tab3.setOnSelectionChanged(event -> {
        	DefinitionsTabController dtc = tab5_loader.getController(); //create controller object
        	LogsTabController ltc = tab4_loader.getController();
        	DefectController dc = tab3_loader.getController();
        	dc.setProjects(dtc.getProjects());

        	dc.setDefinitionsLoader(tab5_loader);
        	dc.setLogsLoader(tab4_loader);
        	dc.setDtc(dtc);
        	dc.setLtc(ltc);
        	
        	
        });

        //Defect Log Editor Tab
        Tab tab4 = new Tab("Logs");  
        try {
            Pane content = tab4_loader.load();
            tab4.setContent(content);
        } catch (Exception e) {
            e.printStackTrace();
        }
//        tab4.setContent(new Label("Content for Another Page"));
        tabPane.getTabs().add(tab4);
        tab4.setOnSelectionChanged(event -> {
        	LogsTabController ltc = tab4_loader.getController(); //create controller object
        	DefinitionsTabController dtc = tab5_loader.getController(); //create controller object
        	DefectController dc = tab3_loader.getController();
        	
        	for(int i = 0; i < 10; i++) {
        		String p = dtc.getProjects()[i];
        		if(p.isBlank()) {
        			break;
        		}
        		else {
        			if(i == 0) {
        				ltc.setP1Label(p);
        			}
        			else if(i == 1) {
        				ltc.setP2Label(p);
        			}
        			else if(i == 2) {
        				ltc.setP3Label(p);
        			}
        			else if(i == 3) {
        				ltc.setP4Label(p);
        			}
        			else if(i == 4) {
        				ltc.setP5Label(p);
        			}
        			else if(i == 5) {
        				ltc.setP6Label(p);
        			}
        			else if(i == 6) {
        				ltc.setP7Label(p);
        			}
        			else if(i == 7) {
        				ltc.setP8Label(p);
        			}
        			else if(i == 8) {
        				ltc.setP9Label(p);
        			}
        			else {
        				ltc.setP10Label(p);
        			}
        		}
        	}
        	ltc.addToP1ELogs(p1Activities);
        	ltc.addToP2ELogs(p2Activities);
        	ltc.addToP3ELogs(p3Activities);
        	ltc.addToP4ELogs(p4Activities);
        	ltc.addToP5ELogs(p5Activities);
        	ltc.addToP6ELogs(p6Activities);
        	ltc.addToP7ELogs(p7Activities);
        	ltc.addToP8ELogs(p8Activities);
        	ltc.addToP9ELogs(p9Activities);
        	ltc.addToP10ELogs(p10Activities);        	
        });

        //Defect Log Editor Tab
        Tab tab5 = new Tab("Definitions");
        try {
            Pane content = tab5_loader.load();
            tab5.setContent(content);
        } catch (Exception e) {
            e.printStackTrace();
        }
//        tab5.setContent(new Label("Content for Another Page"));
        tabPane.getTabs().add(tab5);

        //Defect Log Editor Tab
        Tab tab6 = new Tab("LogManager");
        tab6.setContent(new Label("Content for Another Page"));
        tabPane.getTabs().add(tab6);
        
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
        
        defectLogConsoleBtn.setOnAction(event -> {
            tabPane.getSelectionModel().select(tab3); 
        });
        effortLogBtn.setOnAction(event -> {
            tabPane.getSelectionModel().select(tab2); 
        });
        

        //Show scene on page
        Scene scene = new Scene(tabPane, 800, 600);
        primaryStage.setTitle("EffortLoggerV2.0");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    //Function for the timer in the effort logger
    private void updateTimer() {
        if (startTime != null) {
            java.time.Duration duration = java.time.Duration.between(startTime, LocalTime.now());
            long hours = duration.toHours();
            long minutes = duration.minusHours(hours).toMinutes();
            long seconds = duration.minusHours(hours).minusMinutes(minutes).toMillis() / 1000;
            clockStatus.setText(String.format("Clock is running | %02d:%02d:%02d", hours, minutes, seconds));
        }
    }
    
private static class ValidatingTextField extends TextField {
	private final Predicate<String> validation;
	private final BooleanProperty isValidProperty;
	
	ValidatingTextField(Predicate<String> validation) {
		this.validation = validation;
		this.isValidProperty = new SimpleBooleanProperty();
		
		textProperty().addListener((o, oldV, newText) -> {
			isValidProperty.set(validation.test(newText));
		});

		isValidProperty.set(validation.test(""));
	}

	public boolean isValid() {
		return isValidProperty.get();
	}

	public BooleanProperty isValidProperty() {
		return isValidProperty;
	}
}

private ComboBox<String> planningPokerComboBox = new ComboBox<>();

	public void updatePlanningPokerBox() {
        planningPokerComboBox.getItems().clear();
        planningPokerComboBox.getItems().addAll(userStories);
    }
    
    public static ArrayList<String> getUserStories() {
    	return userStories;
    }  
}
