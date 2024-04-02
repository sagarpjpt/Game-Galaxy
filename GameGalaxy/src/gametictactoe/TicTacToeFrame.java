package gametictactoe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;

public class TicTacToeFrame extends JFrame {

	TicTacToePanel tictactoepanel;
	private String playerX,player0;
	
	public TicTacToeFrame(String playerX,String player0) {
		
		this.playerX = playerX;
		this.player0 = player0;
		tictactoepanel = createPanel();
		
		SwingUtilities.invokeLater(() -> {
			Border customBorder = new CustomBorder(5);
			this.getRootPane().setBorder(customBorder);
			this.add(tictactoepanel);
			this.setTitle("Tic Tac Toe");
			this.setUndecorated(true);
			this.setResizable(false);
			this.pack();
			this.setVisible(true);
			this.setLocationRelativeTo(null);
		});
		
		tictactoepanel.playAgain.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				playAgain();
			}
			
		});
			
	}
	
	private void playAgain() {
		this.getContentPane().removeAll();
		tictactoepanel = createPanel();
		this.getContentPane().add(tictactoepanel);
		this.revalidate();
		this.repaint();
		
		tictactoepanel.playAgain.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				playAgain();
			}
			
		});
		
	}

	private TicTacToePanel createPanel() {
		// TODO Auto-generated method stub
		return new TicTacToePanel(playerX,player0);
	}

	public int getWinner() {
		
		while(!tictactoepanel.isButtonClicked()) {
			try {
				Thread.sleep(100);	
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
		return tictactoepanel.winner;
		
	}
	
}
