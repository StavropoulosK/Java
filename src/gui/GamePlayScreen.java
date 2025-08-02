package gui;

import javax.swing.*;
import java.util.TimerTask;
import java.util.Timer;
import java.awt.*;
import java.awt.event.*;
import java.awt.Color;
import spaceships.*;
import spaceships_laserguns.*;
import java.awt.image.BufferedImage;




public class GamePlayScreen extends JPanel implements KeyListener {
		
		private SpaceShip userSpaceShip;
		private SpaceShipENEMY enemySpaceShip;
		int delay=0;								// Kathisterisi. Otan delay=0 mpori o xristis na pirobolisi allios to oplo prepi na ksanafortisi.
		Timer timer;
	
		public GamePlayScreen(){
			

			addKeyListener(this);
			
			this.setVisible(true);
			this.setBackground(Color.black);
			createDaemon();
	}
		
		@Override
		
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			enemySpaceShip.huntUserSpaceship(userSpaceShip);
			userSpaceShip.getIcon().paintIcon(this,g,userSpaceShip.getX(),userSpaceShip.getY());
			enemySpaceShip.getIcon().paintIcon(this,g,enemySpaceShip.getX(),enemySpaceShip.getY());
			userSpaceShip.calculateLife(enemySpaceShip.gun.laserlinkedlist);
			enemySpaceShip.calculateLife(userSpaceShip.gun.laserlinkedlist);
			showLaserShootings(g);

			if( enemySpaceShip.getLife()<=0) {
				
				try {
					SpaceFrame.finishScreen.updateFinsihScreen(createScreenshot(this), "You saved the Universe!");
					SpaceFrame.cardLayout.next(SpaceFrame.spaceFramePanel);
					SpaceFrame.finishScreen.requestFocusInWindow();
					}
				catch(Exception e) {
						System.out.println(e);
					}

			}
			
			else if(userSpaceShip.getLife()<=0) {
				
				try {
					SpaceFrame.finishScreen.updateFinsihScreen(createScreenshot(this), "Game Over!");
					SpaceFrame.cardLayout.next(SpaceFrame.spaceFramePanel);
					SpaceFrame.finishScreen.requestFocusInWindow();
				}
				catch(Exception e) {
					System.out.println(e);
				}
			
			}
	
			
			if(delay!=0) delay++;			// To delay ginetai 1 otan piroboli.Meta apo 6 xronikes monades mpori na ksanapirobolisi
			if(delay==6) delay=0;
			
			
		}
		
	
			
		public static BufferedImage createScreenshot(JPanel panel) throws AWTException {     
		    Point p = panel.getLocationOnScreen();
		    Dimension dim = panel.getSize();
		    Rectangle rect = new Rectangle(p, dim);

		    Robot robot = new Robot();  
		    return robot.createScreenCapture(rect);
		}
			
		
		
		
		@Override
		
		public void keyPressed(KeyEvent e) {
			
			int key= e.getKeyCode();
			
			if(key== KeyEvent.VK_UP) {  userSpaceShip.moveUP();}
			
			if(key== KeyEvent.VK_DOWN) { userSpaceShip.moveDOWN();}
			
			if(key== KeyEvent.VK_RIGHT) { userSpaceShip.moveRIGHT();}
			
			if(key== KeyEvent.VK_LEFT) {  userSpaceShip.moveLEFT();}
			
			if(key== KeyEvent.VK_SPACE && delay==0 ) {
				
				delay=1;
				userSpaceShip.gun.fire(userSpaceShip.getX(),userSpaceShip.getY());}
			
			if(key==KeyEvent.VK_B)	{
				
				SpaceFrame.cardLayout.next(SpaceFrame.spaceFramePanel);
				SpaceFrame.spaceFramePanel.requestFocusInWindow();
			}
			
			
			this.repaint();
				
		}
		
		public void showLaserShootings(Graphics g) {
			
			 userSpaceShip.gun.laserlinkedlist.forEach( (laser) -> {
				g.setColor(userSpaceShip.gun.laserColor);
				g.drawLine(laser.x,laser.y,laser.x,laser.y-15);
				laser.y -= 15;
			});
			
			enemySpaceShip.gun.laserlinkedlist.forEach( (laser) -> {
				g.setColor(enemySpaceShip.gun.laserColor);
				g.drawLine(laser.x,laser.y,laser.x,laser.y+15);
				laser.y += 15;
			
			});
		}
		
		@Override
		public void keyReleased(KeyEvent e) {}
		@Override
		public void keyTyped(KeyEvent e) {}
		
		
		
		public void initializeGame(SpaceShip userSpaceShip) {
			
			this.userSpaceShip=userSpaceShip;
			this.enemySpaceShip= new SpaceShipENEMY(Color.yellow);
		}
		
		
		private void createDaemon() {
			
			timer = new Timer();
			
			TimerTask task= new monitorDeamonGame();
			
			timer.schedule(task, 100, 100);
			
		}
		
		
		class monitorDeamonGame extends TimerTask{
			
			public void run(){
				
				repaint();
			}
		}
		
	
		
}
