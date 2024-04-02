package gamepong;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Score {
	
	static int GAME_WIDTH;
	static int GAME_HEIGHT;
	int playerRed;
	int playerBlue;
	
	Score(int GAME_WIDTH, int GAME_HEIGHT){
	
		Score.GAME_WIDTH = GAME_WIDTH;
		Score.GAME_HEIGHT = GAME_HEIGHT;	
	
	}
	
	public void draw(Graphics g) {
		
		g.setColor(Color.white);
		g.setFont(new Font("Consolas", Font.PLAIN, 60));
		
		g.drawLine(GAME_WIDTH/2, 0, GAME_WIDTH/2, GAME_HEIGHT);
	
		g.drawString(String.valueOf(playerRed/10)+String.valueOf(playerRed%10), (GAME_WIDTH/2) - 85,50);
	    g.drawString(String.valueOf(playerBlue/10)+String.valueOf(playerBlue%10),(GAME_WIDTH/2) + 20,50);
	
	}
	
}
