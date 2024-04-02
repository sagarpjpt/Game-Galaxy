package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TicTacToePageController {
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	public void switchToPlayTicTacToeGame(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("PlayTicTacToeGame.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();
	}
	
	public void displayTicTacToeGameScore(ActionEvent event) throws IOException {
		
		
	}
	
	public void switchToTwoPlayerPage(ActionEvent event) throws IOException {
		
		root = FXMLLoader.load(getClass().getResource("TwoPlayerGamePage.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();
		
	}
	
}
