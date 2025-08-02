package spaceships;

import java.awt.Image;

import javax.swing.ImageIcon;

import mainPacket.MainClass;

import java.util.Random;

import java.awt.Color;


public class SpaceShipENEMY extends SpaceShip  {
	
	public static Image img;
	private static Random random= new Random();
		
	
	static{
		
		img=get_img("../images/spaceship1.png");
		
		}
	
	
	public SpaceShipENEMY(Color clr) {
		super(clr);
		step=15;
		life=23;

		SpaceShipName= "ENEMY";
		xCoord=MainClass.CosmosWidth-spaceShipWidth;
		yCoord=yOffSet;
		SpaceShipImageIcon= new ImageIcon(img);

	}
	
	public void huntUserSpaceship(SpaceShip userSpaceShip) {
	
		int mv=random.nextInt(4);
		
		if(xCoord<userSpaceShip.xCoord+200 && xCoord>userSpaceShip.xCoord-200) {		// Pirobolai otan exei plisiasi
		
			if(mv==0) this.gun.fire(xCoord,yCoord);
		}
		

			if(userSpaceShip.xCoord>this.xCoord)  this.moveRIGHT();
			else this.moveLEFT();
			
			
			int res= random.nextInt(4);
			
			if(res==0) this.moveLEFT();
			if(res==1) this.moveRIGHT();
			if(res==2 && (yCoord+step)<MainClass.CosmosHeight/2) this.moveDOWN();
			if(res==3) this.moveUP();

			if(yCoord>userSpaceShip.yCoord) this.moveUP();
			}
	
	
}
