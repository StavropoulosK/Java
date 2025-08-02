package spaceships;

import java.awt.Image;


import javax.swing.ImageIcon;

import mainPacket.MainClass;
import java.awt.Color;



public class SpaceShipDELTA extends SpaceShip {
	
	
	public static Image img;
	
	static{
		
		img=get_img("../images/spaceship3.png");
		
		}
	
	
	
	public SpaceShipDELTA() {
		super(Color.magenta);
		SpaceShipName="DELTA";
		step=40;
		life=10;

		xCoord=0;
		yCoord= MainClass.CosmosHeight-spaceShipHeight-yOffSet;
		SpaceShipImageIcon= new ImageIcon(img);

		

	}
	
	
	
}
