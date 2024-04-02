package gamepong;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

import javax.swing.JPanel;


public class PongGamePanel extends JPanel implements Runnable{
	
	String playerRed,playerBlue;
	
//	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();;
//	int GAME_WIDTH ;
//	int GAME_HEIGHT ;
	
	static final int GAME_WIDTH = 1300;
	static final int GAME_HEIGHT = (int)(GAME_WIDTH * (0.5555));//5/9 turns it 0 so used the .5555
	static final Dimension SCREEN_SIZE = new Dimension(GAME_WIDTH,GAME_HEIGHT);
	
	static final int BALL_DIAMETER = 20;
	static final int PADDLE_WIDTH = 25;
	static final int PADDLE_HEIGHT = 100;
	
	private volatile boolean running = true;
	
	Thread gameThread;
	Image image;
	Graphics graphics;
	Random random;
	Paddle paddleRed;	//1
	Paddle paddleBlue;	//0
	Ball ball;
	Score score;
	
	
	
	PongGamePanel(String playerRed, String playerBlue)  {
		
		newPaddles();
		newBall();
		
		this.playerBlue = playerBlue;
		this.playerRed = playerRed;
		
		score = new Score(GAME_WIDTH,GAME_HEIGHT);
		
		
		//to set the panel size to the size of the screen 
		this.setPreferredSize(SCREEN_SIZE);
		
//		GAME_WIDTH = getWidth();
//		GAME_HEIGHT = getHeight();
		
		
		
		this.setFocusable(true);
		this.addKeyListener(new AL());
		this.setLayout(null);
		
		gameThread = new Thread(this);
		gameThread.start();
	}
	
	public void stopGame() {
        running = false;
    }
	
	public void newBall() {
		
		random = new Random();
		ball = new Ball((GAME_WIDTH/2)-(BALL_DIAMETER/2),random.nextInt(GAME_HEIGHT - BALL_DIAMETER),BALL_DIAMETER,BALL_DIAMETER);
		
	}
	
	public void newPaddles() {
		
		paddleRed = new Paddle(0,(GAME_HEIGHT/2)-(PADDLE_HEIGHT/2),PADDLE_WIDTH,PADDLE_HEIGHT,1);
		paddleBlue = new Paddle(GAME_WIDTH-PADDLE_WIDTH,(GAME_HEIGHT/2)-(PADDLE_HEIGHT/2),PADDLE_WIDTH,PADDLE_HEIGHT,0);
	}
	
	public void paint(Graphics g) {
		
		image = createImage(getWidth(),getHeight());
		graphics = image.getGraphics();
		draw(graphics);
		g.drawImage(image, 0, 0, this);
		
	}
	
	public void draw(Graphics g) {
		
		paddleRed.draw(g);
		paddleBlue.draw(g);
		ball.draw(g);
		score.draw(g);
		
	}
	
	public void checkCollision() {
		
		//bounce ball of top and bottom window edges 
		if(ball.y <= 0){
            ball.setYDirection(-ball.yVelocity);    //- to get to opposite velocity
        }
        if(ball.y >= GAME_HEIGHT-BALL_DIAMETER){
            ball.setYDirection(-ball.yVelocity);
        }
		
      //to bounce the ball of the paddle red
        if(ball.intersects(paddleRed)){
            ball.xVelocity = Math.abs(ball.xVelocity);
            ball.xVelocity++;//optional this is just inc ball sppeed every time it collide with paddle
            if(ball.yVelocity>0){
                ball.yVelocity++;//optional for more difficulty
            }
            else{
                ball.yVelocity--;
            }
            ball.setXDirection(ball.xVelocity);
            ball.setYDirection(ball.yVelocity);
        }
        
      //to bounce the ball of the paddle blue
        if(ball.intersects(paddleBlue)){
            ball.xVelocity = Math.abs(ball.xVelocity);
            ball.xVelocity++;//option this is just inc ball sppeed every time it collide with paddle
            if(ball.yVelocity>0){
                ball.yVelocity++;//optional
            }
            else{
                ball.yVelocity--;
            }
            ball.setXDirection(-ball.xVelocity);
            ball.setYDirection(ball.yVelocity);
        }
        
		//stop padddles to window edges 
		if(paddleRed.y <= 0) {
			paddleRed.y = 0;
		}
		if(paddleRed.y >= (GAME_HEIGHT - PADDLE_HEIGHT)) {
			paddleRed.y = GAME_HEIGHT - PADDLE_HEIGHT;
		}
		
		if(paddleBlue.y <= 0) {
			paddleBlue.y = 0;
		}
		if(paddleBlue.y >= (GAME_HEIGHT - PADDLE_HEIGHT)) {
			paddleBlue.y = GAME_HEIGHT - PADDLE_HEIGHT;
		}
		
		//give a playerRed  point and creates new Paddle & ball
		if(ball.x <= 0) {
			score.playerBlue++;
			newPaddles();
			newBall();
			System.out.println("Player Blue : "+ score.playerBlue);
		}
		
		if(ball.x >= GAME_WIDTH-BALL_DIAMETER){
            score.playerRed++;
            newPaddles();
            newBall();
            System.out.println("player Red: "+ score.playerRed);
        }
		
	}
	
	public void move() {
		
		paddleRed.move();
		paddleBlue.move();
		ball.move();
		
	}
	
	public void run() {
		
		//game loop 
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks ;	// 1 Billion divided by amount of ticks 
		double delta = 0;
		while(running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			if(delta >= 1) {
				move();	//move all components
				checkCollision();
				repaint();
				delta--;
			}
		}
		
	}
	
	//inner class
	public class AL extends KeyAdapter{
		
		@Override
		public void keyPressed(KeyEvent e) {
			
			paddleRed.keyPressed(e);
			paddleBlue.keyPressed(e);
			
		}
		
		@Override
		public void keyReleased(KeyEvent e) {
			
			paddleRed.keyReleased(e);
			paddleBlue.keyReleased(e);
			
		}
		
	}
	
}
