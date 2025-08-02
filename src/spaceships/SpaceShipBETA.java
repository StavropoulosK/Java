package spaceships;
import java.awt.Image;


import javax.swing.ImageIcon;

import mainPacket.MainClass;
import java.awt.Color;


public class SpaceShipBETA extends SpaceShip {
	
	public static Image img;
	
	static{
		
		img=get_img("../images/spaceship2.png");
		
		}
	
	public SpaceShipBETA() {
		super(Color.blue);
		SpaceShipName="BETA";
		step=20;
		life=20;
		xCoord=0;
		yCoord= MainClass.CosmosHeight-spaceShipHeight-yOffSet;
		SpaceShipImageIcon= new ImageIcon(img);

		
		


	}
	
}