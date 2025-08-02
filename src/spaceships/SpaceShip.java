package spaceships;

import mainPacket.*;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.awt.Image;
import java.util.LinkedList;
import java.awt.Color;
import java.util.*;

import spaceships_laserguns.*;





public abstract class SpaceShip implements Navigation {
	
	protected  ImageIcon SpaceShipImageIcon;
	protected String SpaceShipName;
	protected int xCoord,yCoord;
	public static int spaceShipWidth=100,spaceShipHeight=100;
	protected int step;
	protected int life=10;					//      step+2*life=60
	
	
	public Lasergun gun;
	
	
	
	
	static Image get_img(String relative_path) {
		
		Image img=null, resized_img;
			try{
			img= ImageIO.read(MainClass.class.getResource(relative_path));
			}
			catch (Exception ex) {
			
			System.out.println(ex);
			}
			
			resized_img= img.getScaledInstance(spaceShipWidth,spaceShipHeight, 0);
			
			return resized_img;		
	}
	
	public SpaceShip(Color color) {
		
		gun= new Lasergun(color);
	}
	
	
	
	public void moveUP() {
		
		if((yCoord - step)>=yOffSet) {
			yCoord -= step;
			
		}
		
		else yCoord= yOffSet;
		
	 
			
	}
	public void moveDOWN() {
		int limit= MainClass.CosmosHeight-spaceShipHeight-yOffSet;
		
		if((yCoord + step)<= limit) {
			yCoord += step;
			
			
		}
		
		else {
			yCoord= limit;
		}
		
		
	}
	public void moveLEFT() {
		
		if((xCoord - step)>=0) {
			xCoord -= step;
		
		}
		
		
	}
	public void moveRIGHT() {
		
		if((xCoord +spaceShipWidth+step)<=MainClass.CosmosWidth) {
			xCoord += step;
			
		}
		
	
	}
	
	public void printCoords() {
		System.out.println("Spaceship " +SpaceShipName+" Xcoords:"+xCoord+" Ycoords:"+yCoord);
	}
	
	public ImageIcon getIcon() {return SpaceShipImageIcon;}
	
	public int getX() {return xCoord;}

	public int getY() {return yCoord;}
	
	public void calculateLife(LinkedList<Laser> laserlinkedlist) {
		
		Iterator<Laser> itr= laserlinkedlist.iterator();
		
		while(itr.hasNext()) {
			
			Laser laser= itr.next();
			
			if(laser.x>=xCoord && laser.x<=xCoord+spaceShipWidth && laser.y<=yCoord+spaceShipHeight  && laser.y>=yCoord ) {
				itr.remove();
				life --;
				System.out.println(SpaceShipName+": Life is"+life);
			}
		}
		
	}

	public int getLife() {return life;}
	

}
