package gamepong;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;



public class ResultPanel extends JPanel{

	String red;
	String blue;
	int redscore ;
	int bluescore;
	int id;
	
	JButton exitButton = new JButton("EXIT");
	JTextField nameTextField = new JTextField();
	JTextField scoreTextField = new JTextField();
	JLabel winner = new JLabel();
	
	ResultPanel(ArrayList<Integer> data,String playerRed,String playerBlue){
		red = playerRed;
		blue = playerBlue;
		redscore = data.get(0);
		bluescore = data.get(1);
		id = data.get(2);
	
		nameTextField.setBounds(350,50,600,150);
		nameTextField.setBackground(new Color(25,25,25));
		nameTextField.setForeground(new Color(25,255,0));
		nameTextField.setFont(new Font("Ink Free",Font.BOLD,65));
		nameTextField.setBorder(BorderFactory.createBevelBorder(1));
		nameTextField.setHorizontalAlignment(JTextField.CENTER);
		nameTextField.setEditable(false); 
		
		
		scoreTextField.setBounds(350,200,600,125);
		scoreTextField.setBackground(new Color(25,25,25));
		scoreTextField.setForeground(new Color(25,255,0));
		scoreTextField.setFont(new Font("Ink Free",Font.BOLD,45));
		scoreTextField.setBorder(BorderFactory.createBevelBorder(1));
		scoreTextField.setHorizontalAlignment(JTextField.CENTER);
		scoreTextField.setEditable(false); 
		
		winner.setBounds(350,375,600,125);
		winner.setBackground(new Color(25,25,25));
		winner.setForeground(new Color(25,255,0));
		winner.setFont(new Font("Ink Free",Font.BOLD,25));
		winner.setHorizontalAlignment(JLabel.CENTER);
		
		
		exitButton.setBounds(525, 550, 250, 100);
		exitButton.setFont(new Font("Arial", Font.BOLD, 25));
		exitButton.setBackground(new Color(25,255,0));
		exitButton.setForeground(Color.white);
		exitButton.setFocusable(false);
		
		exitButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			//	result = -1;
			//	button_clicked = true;
				SwingUtilities.getWindowAncestor(exitButton).dispose();
			}
			
		});
		
		this.add(exitButton);
		this.add(winner);
		this.add(nameTextField);
		this.add(scoreTextField);
		
		this.setBackground(new Color(50,50,50));
		this.setLayout(null);
		this.setFocusable(true);
		
		displayResults();
	}
	
	public void displayResults() {
		
		nameTextField.setText(red + "   vs   " + blue);
		scoreTextField.setText(redscore + "   :   " + bluescore);
		
		if(id == 1) {
			winner.setText(red + " WINS"); 
		}
		else {
			winner.setText(blue + " WINS");
		}
		
	}
	
}
