package leverger.application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Console extends Application {
	
	public void start(Stage primaryStage) {
		GridPane root = new GridPane();
		Scene scene = new Scene(root, 700, 300);
		primaryStage.setScene(scene);
		primaryStage.show();
	}


    public static void main(String[] args) {
        launch(args);
    }
}
