package gamesnake;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.Border;

public class SnakeGameFrame extends JFrame {
	private SnakeGamePanel snakegamepanel;
	
	public SnakeGameFrame(){
		snakegamepanel = createPanel();
		
		SwingUtilities.invokeLater(() -> {				
			Border customBorder = new CustomBorder(5);		//adds border to the game 
			this.getRootPane().setBorder(customBorder);
			//this.setLayout(new BorderLayout());
			this.add(snakegamepanel);
	        this.setTitle("Snake Game");
	        //this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	        this.setUndecorated(true);	//to remove windows default title baar 
	        this.setResizable(false);
	        this.pack();
	        this.setVisible(true);
	        this.setLocationRelativeTo(null);
	   });
		snakegamepanel.playAgain.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				playAgain();
			}
			
		});
	}
	
	public int getScore() {
		
		while(!snakegamepanel.isButtonClicked()) {
			try {
				Thread.sleep(100);	
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
		return snakegamepanel.getScore();
	}
	
	public void playAgain() {
		
		this.getContentPane().removeAll();
		snakegamepanel = createPanel();
		this.getContentPane().add(snakegamepanel);
		snakegamepanel.requestFocusInWindow();
		this.revalidate();
		this.repaint();
		
		snakegamepanel.playAgain.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playAgain();
            }
        });
		
	}
	
	private SnakeGamePanel createPanel() {
		return new SnakeGamePanel();
	}
}
