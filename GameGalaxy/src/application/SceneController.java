package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.*;

public class SceneController {
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	public void switchToSinglePlayerPage(ActionEvent event) throws IOException {
		
		root = FXMLLoader.load(getClass().getResource("SinglePlayerGamePage.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();
	}
	
	public void switchToTwoPlayerPage(ActionEvent event) throws IOException {
		
		root = FXMLLoader.load(getClass().getResource("TwoPlayerGamePage.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();
		
	}
	
	public void switchToSnakeGamePage(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("SnakeGamePage.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();
	}

	public void switchToTicTacToeGamePage(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("TicTacToePage.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();
	}
	
	public void switchToPongGamePage(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("PongGamePage.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();
	}

	public void switchToJavaQuizGamePage(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("JavaQuizGamePage.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();
	}
	
	public void switchToGameGalaxyMainPage(ActionEvent event) throws IOException{
		root = FXMLLoader.load(getClass().getResource("GameGalaxyMainPage.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();
	}
	
	public void exitGame(ActionEvent event) throws IOException {
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.close();
	}
}
