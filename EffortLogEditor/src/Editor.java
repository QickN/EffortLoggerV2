import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

public class Editor extends Application{

	public static void main(String[] args) {
		launch(args);
    }
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("Effort Log Editor.fxml"));
		Scene scene = new Scene(root, 800, 600);
		
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}


