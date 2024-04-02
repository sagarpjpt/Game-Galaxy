package application;

import java.io.IOException;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import database.InsertDataDB;
import gamejavaquiz.JavaQuizFrame;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class PlayJavaQuizGameController {
	
	@FXML
	TextField JavaQuizGamePlayerNameTextField ;
	
	@FXML
	Label JavaQuizGameWarningLabel;
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	public void javaQuizPlayButton(ActionEvent event) throws IOException{
		
		
		
		String username = JavaQuizGamePlayerNameTextField.getText();
		int score;
		if(isValidName(username)) {
			
			JavaQuizFrame javaquizframe = new JavaQuizFrame();
			score = javaquizframe.getScore();
			System.out.println(score);
			
			try {
				InsertDataDB.insertToJavaQuizTable(username, score);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			root = FXMLLoader.load(getClass().getResource("JavaQuizGamePage.fxml"));
			stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.setResizable(false);
			stage.show();
			
		}
		else{
			JavaQuizGameWarningLabel.setText("Please Enter Valid Name!");
		}
	}
	
	
	
	private static boolean isValidName(String name) {
        // Regular expression to match only alphabetic characters and spaces
        String regex = "^[a-zA-Z ]+$";
        
        // Create a Pattern object
        Pattern pattern = Pattern.compile(regex);

        // Create a Matcher object
        Matcher matcher = pattern.matcher(name);

        // Check if the string matches the pattern
        return matcher.matches();
    }
	
}
