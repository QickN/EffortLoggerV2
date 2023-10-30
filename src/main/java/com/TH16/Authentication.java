package com.TH16;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Authentication extends Application {
    private final String validUsername = "jhsing";
    private final String validPassword = "123";
    private final String securityQuestion = "What is your favorite color?";
    private final String expectedAnswer = "blue";

    private Stage primaryStage;
/*
    public static void main(String[] args) {
        launch(args);
    }
*/
    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("JavaFX Authentication");

        Label usernameLabel = new Label("Username:");
        TextField usernameTextField = new TextField();
        Label passwordLabel = new Label("Password:");
        PasswordField passwordField = new PasswordField();
        Button loginButton = new Button("Login");

        loginButton.setOnAction(event -> {
            String username = usernameTextField.getText();
            String password = passwordField.getText();

            if (isValidCredentials(username, password)) {
                showSecurityQuestionPrompt();
            } else {
                showAlert("Error", "Invalid username or password.");
            }
        });

        VBox vbox = new VBox(10);
        vbox.getChildren().addAll(usernameLabel, usernameTextField, passwordLabel, passwordField, loginButton);
        Scene scene = new Scene(vbox, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void showSecurityQuestionPrompt() {
        Label securityQuestionLabel = new Label(securityQuestion);
        TextField securityAnswerTextField = new TextField();
        Button verifyButton = new Button("Verify Answer");

        verifyButton.setOnAction(event -> {
            String securityAnswer = securityAnswerTextField.getText();

            if (isValidSecurityAnswer(securityAnswer)) {
                showAlert("Success", "Authentication successful.");
                // You can navigate to the next screen here.
            } else {
                showAlert("Error", "Invalid security answer.");
            }
        });

        VBox vbox = new VBox(10);
        vbox.getChildren().addAll(securityQuestionLabel, securityAnswerTextField, verifyButton);
        Scene scene = new Scene(vbox, 300, 150);
        primaryStage.setScene(scene);
    }

    private boolean isValidCredentials(String username, String password) {
        return username.equals(validUsername) && password.equals(validPassword);
    }

    private boolean isValidSecurityAnswer(String securityAnswer) {
        return securityAnswer.equalsIgnoreCase(expectedAnswer);
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}