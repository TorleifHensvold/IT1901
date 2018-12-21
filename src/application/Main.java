package application;

import application.database.DB;
import application.scene.Home;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		DB.connect("[your database path]", "[your username]", "[your password]");
		Stage stage = primaryStage;
		stage.setFullScreen(true);
		stage.setFullScreenExitHint("");
		stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
			@Override
			public void handle(WindowEvent we) {
				DB.disconnect();
			}
		});
		Home.showHome(stage);
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
}
