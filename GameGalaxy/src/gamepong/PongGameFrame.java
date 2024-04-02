package gamepong;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;

import gamesnake.SnakeGamePanel;

public class PongGameFrame extends JFrame {
	
	
	PongGamePanel ponggamepanel;
	ResultPanel resultpanel;
	private String playerRed,playerBlue;
	ArrayList<Integer> data = new ArrayList<>();
	
	public PongGameFrame(String playerRed,String playerBlue) {
		
		this.playerBlue = playerBlue;
		this.playerRed = playerRed;
		ponggamepanel = createPanel();
		
		SwingUtilities.invokeLater(() -> {
			
			Border customBorder = new CustomBorder(5);
			this.getRootPane().setBorder(customBorder);
			this.add(ponggamepanel);
			this.setUndecorated(true);
			this.setResizable(false);
			this.setBackground(Color.black);
			this.pack();	//adjusts the frame size to the preferred size of its content 
							//(here its panel).
			this.setVisible(true);
			this.setLocationRelativeTo(null);
			
		});
		
	}
	
	
	
	
	public ArrayList<Integer> getWinner() {
		
		while(ponggamepanel.score.playerRed < 5 && ponggamepanel.score.playerBlue < 5) {
			try {
				Thread.sleep(100);
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
		data.add(ponggamepanel.score.playerRed);
		data.add(ponggamepanel.score.playerBlue);
		if(ponggamepanel.score.playerRed == 5) {
			data.add(1);
		}
		else {
			data.add(0);
		}
		
		this.getContentPane().removeAll();
		ponggamepanel.stopGame();
		resultpanel = new ResultPanel(data,playerRed,playerBlue);
		this.getContentPane().add(resultpanel);
		resultpanel.requestFocusInWindow();
		this.revalidate();
		this.repaint();
		
		
		return data;
	}

	private PongGamePanel createPanel() {
		// TODO Auto-generated method stub
		return new PongGamePanel(playerBlue,playerRed);
	}
	
}
