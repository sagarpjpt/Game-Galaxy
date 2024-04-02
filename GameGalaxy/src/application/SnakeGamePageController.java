package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SnakeGamePageController {
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	public void switchToPlaySnakeGame(ActionEvent event) throws IOException {
		
		root = FXMLLoader.load(getClass().getResource("PlaySnakeGame.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();
		
	}
	
	public void displaySnakeGameScore(ActionEvent event) throws IOException {
		
	}
	
	public void switchToSinglePlayerPage(ActionEvent event) throws IOException {
		
		root = FXMLLoader.load(getClass().getResource("SinglePlayerGamePage.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();
	}
	
}
