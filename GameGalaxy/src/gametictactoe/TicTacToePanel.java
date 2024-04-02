package gametictactoe;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class TicTacToePanel extends JPanel implements ActionListener{
	
	Random random = new Random();
    JPanel button_panel = new JPanel();
    JLabel textfield = new JLabel();
    JButton[] buttons = new JButton[9];
    JButton playAgain = new JButton("PLAYAGAIN");
    JButton saveandexit = new JButton("SAVE AND EXIT");
    JButton exit = new JButton("EXIT");
    boolean playerX_turn;
    private String playerX, player0;
    private boolean buttonClicked = false;
    int winner;
    
    
   
	
	TicTacToePanel(String playerX,String player0){
		
		this.playerX = playerX;
		this.player0 = player0;
		
		playAgain.setBounds(0, 40, 266, 80);
    	playAgain.setFont(new Font("Arial", Font.BOLD, 20));
    	playAgain.setBackground(new Color(25, 255, 0));
    	playAgain.setForeground(Color.white);
    	playAgain.setFocusable(false);
    	
    	saveandexit.setBounds(267, 40, 266, 80);
    	saveandexit.setFont(new Font("Arial", Font.BOLD, 20));
    	saveandexit.setBackground(new Color(25, 255, 0));
    	saveandexit.setForeground(Color.white);
    	saveandexit.setFocusable(false);
    	
    	exit.setBounds(534, 40, 266, 80);
    	exit.setFont(new Font("Arial", Font.BOLD, 20));
    	exit.setBackground(new Color(25, 255, 0));
    	exit.setForeground(Color.white);
    	exit.setFocusable(false);
		
		textfield.setBounds(0, 0, 800, 120);
		textfield.setBackground(new Color(25, 25, 25));
        textfield.setForeground(new Color(25, 255, 0));
        textfield.setFont(new Font("Ink Free",Font.BOLD,65));
        textfield.setHorizontalAlignment(JLabel.CENTER);
        textfield.setVerticalAlignment(JLabel.CENTER);
        textfield.setOpaque(true);
        
        button_panel.setBounds(0,120,800,680);
        button_panel.setLayout(new GridLayout(3, 3));
        button_panel.setBackground(new Color(150, 150, 150));
		
        for(int i=0;i<9;i++){
            buttons[i] = new JButton();
            button_panel.add(buttons[i]);
            buttons[i].setFont(new Font("MV Boli",Font.BOLD,120));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
        }
		
		this.setPreferredSize(new Dimension(800,800));
		this.setBackground(new Color(50,50,50));
		this.setFocusable(true);
		this.setLayout(null);
		
		//this.add(title_panel,BorderLayout.NORTH);
		this.add(textfield);
		this.add(button_panel);
		
		firstTurn();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		for(int i=0;i<9;i++){
            if(e.getSource() == buttons[i]){
                if(playerX_turn){
                    if(buttons[i].getText() == ""){
                        buttons[i].setForeground(Color.RED);
                        buttons[i].setText("X");
                        playerX_turn = false;
                        textfield.setText(player0 + " turn");
                        check();
                    }
                }
                else{
                    if(buttons[i].getText() == ""){
                        buttons[i].setForeground(Color.BLUE);
                        buttons[i].setText("O");
                        playerX_turn = true;
                        textfield.setText(playerX + " turn");
                        check();
                    }
                }
            }
        }
		
	}
	
	public void check(){

        //check X win Conditions 
        if
        (
            (buttons[0].getText()=="X") && 
            (buttons[1].getText()=="X") &&
            (buttons[2].getText()=="X")
        ){
            xWins(0,1,2);
        }

        if
        (
            (buttons[3].getText()=="X") && 
            (buttons[4].getText()=="X") &&
            (buttons[5].getText()=="X")
        ){
            xWins(3,4,5);
        }

        if
        (
            (buttons[6].getText()=="X") && 
            (buttons[7].getText()=="X") &&
            (buttons[8].getText()=="X")
        ){
            xWins(6,7,8);
        }

        if
        (
            (buttons[0].getText()=="X") && 
            (buttons[3].getText()=="X") &&
            (buttons[6].getText()=="X")
        ){
            xWins(0,3,6);
        }

        if
        (
            (buttons[1].getText()=="X") && 
            (buttons[4].getText()=="X") &&
            (buttons[7].getText()=="X")
        ){
            xWins(1,4,7);
        }

        if
        (
            (buttons[2].getText()=="X") && 
            (buttons[5].getText()=="X") &&
            (buttons[8].getText()=="X")
        ){
            xWins(2,5,8);
        }

        if
        (
            (buttons[0].getText()=="X") && 
            (buttons[4].getText()=="X") &&
            (buttons[8].getText()=="X")
        ){
            xWins(0,4,8);
        }
        if
        (
            (buttons[2].getText()=="X") && 
            (buttons[4].getText()=="X") &&
            (buttons[6].getText()=="X")
        ){
            xWins(2,4,6);
        }

        //checks if O wins 

        if
        (
            (buttons[0].getText()=="O") && 
            (buttons[1].getText()=="O") &&
            (buttons[2].getText()=="O")
        ){
            oWins(0,1,2);
        }

        if
        (
            (buttons[3].getText()=="O") && 
            (buttons[4].getText()=="O") &&
            (buttons[5].getText()=="O")
        ){
            oWins(3,4,5);
        }

        if
        (
            (buttons[6].getText()=="O") && 
            (buttons[7].getText()=="O") &&
            (buttons[8].getText()=="O")
        ){
            oWins(6,7,8);
        }

        if
        (
            (buttons[0].getText()=="O") && 
            (buttons[3].getText()=="O") &&
            (buttons[6].getText()=="O")
        ){
            oWins(0,3,6);
        }

        if
        (
            (buttons[1].getText()=="O") && 
            (buttons[4].getText()=="O") &&
            (buttons[7].getText()=="O")
        ){
            oWins(1,4,7);
        }

        if
        (
            (buttons[2].getText()=="O") && 
            (buttons[5].getText()=="O") &&
            (buttons[8].getText()=="O")
        ){
            oWins(2,5,8);
        }

        if
        (
            (buttons[0].getText()=="O") && 
            (buttons[4].getText()=="O") &&
            (buttons[8].getText()=="O")
        ){
            oWins(0,4,8);
        }
        if
        (
            (buttons[2].getText()=="O") && 
            (buttons[4].getText()=="O") &&
            (buttons[6].getText()=="O")
        ){
            oWins(2,4,6);
        }
    
    }
	
	public void firstTurn(){

        try {   //for delay of 3 sec before changing titlefield to turn alert
            Thread.sleep(500);
        } 
        catch (InterruptedException e) {
            e.printStackTrace();
        }

        
        if(random.nextInt(2) == 0)//will be either 0 or 1
        {
            playerX_turn = true;
            textfield.setText(playerX+ " turn");
        }
        else{
            {
            playerX_turn = false;
            textfield.setText(player0 + " turn");
        }
        }
    }
	
	public void oWins(int a, int b, int c){

        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);

        for(int i=0;i<9;i++){
            buttons[i].setEnabled(false);
        }
        //textfield.setText(player0+" Wins");
        optionPanel(player0,0);
        
    }
	
	public void xWins(int a, int b, int c){
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);

        for(int i=0;i<9;i++){
            buttons[i].setEnabled(false);
        }
        //textfield.setText(playerX+" Wins");
        optionPanel(playerX,1);
    }
	
	public void optionPanel(String name,int flag) {
		
		textfield.setBounds(0, 0, 800, 40);
		textfield.setFont(new Font("Ink Free",Font.BOLD,25));
		textfield.setText(name + " Wins");
		
		saveandexit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				winner = flag;
				buttonClicked = true;
				SwingUtilities.getWindowAncestor(saveandexit).dispose();
			}
			
		});
		
		exit.addActionListener(new ActionListener() {
    		@Override
    		public void actionPerformed(ActionEvent e) {
    			winner = -1;
    			buttonClicked = true;
    			SwingUtilities.getWindowAncestor(exit).dispose();
    		}
    	});
		
		this.add(playAgain);
		this.add(exit);
		this.add(saveandexit);
		
	}
	
	public boolean isButtonClicked() {
    	return buttonClicked;
    }
	
}
