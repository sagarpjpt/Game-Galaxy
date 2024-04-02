package gamejavaquiz;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;

public class JavaQuizFrame extends JFrame {
	
	private JavaQuizPanel javaquizpanel;
	
	public JavaQuizFrame() {
		
		javaquizpanel = new JavaQuizPanel();
		
		SwingUtilities.invokeLater(() -> {
			Border customBorder = new CustomBorder(5);
			this.getRootPane().setBorder(customBorder);
			//this.setLayout(new BorderLayout());
			this.add(javaquizpanel);
			this.setTitle("Java Quiz Game");
			this.setUndecorated(true);
			this.setResizable(false);
			this.pack();
			this.setVisible(true);
			this.setLocationRelativeTo(null);
		});
		
	}
	
	
	public int getScore() {
		
		while(!javaquizpanel.isButtonClicked()){
			try {
				Thread.sleep(100);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return javaquizpanel.getScore();
		
	}
	
}
