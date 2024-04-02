package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;


public class Main extends Application  {
	@Override
	public void start(Stage primaryStage) {
		try {
			
			Parent root = FXMLLoader.load(getClass().getResource("GameGalaxyMainPage.fxml"));
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			Image icon = new Image(getClass().getResourceAsStream("gameicon2.jpg"));
			primaryStage.getIcons().add(icon);
			
			primaryStage.setTitle("Game Galaxy");
			
			primaryStage.setResizable(false);
			primaryStage.setScene(new Scene(root));
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
