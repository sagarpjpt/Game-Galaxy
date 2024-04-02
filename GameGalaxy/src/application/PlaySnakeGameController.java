package application;

import java.io.IOException;
import java.sql.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import gamesnake.*;
import database.*;
public class PlaySnakeGameController {
	
	
	
	@FXML
	TextField SnakeGamePlayerNameTextField ;
	
	@FXML
	Label SnakeGameWarningLabel;
	
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	public void snakePlayButton(ActionEvent event) throws IOException{
		
		
		
		String username = SnakeGamePlayerNameTextField.getText();
		int score ;
		if(isValidName(username)) {
			SnakeGameFrame snakegameframe = new SnakeGameFrame();
			score = snakegameframe.getScore();
			System.out.println(username);
			System.out.println(score);
			
			if(score != -1) {
				try {
					InsertDataDB.insertToSnakeTable(username, score);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			root = FXMLLoader.load(getClass().getResource("SnakeGamePage.fxml"));
			stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.setResizable(false);
			stage.show();
			
			
		}
		else{
			SnakeGameWarningLabel.setText("Please Enter Valid Name!");
		}
	}
	
	
	
	private static boolean isValidName(String name) {
        //matches only alphabetic characters and spaces
        String regex = "^[a-zA-Z ]+$";
        
        // Create a Pattern object
        Pattern pattern = Pattern.compile(regex);

        // Create a Matcher object
        Matcher matcher = pattern.matcher(name);

        // Check if the string matches the pattern
        return matcher.matches();
    }
}
