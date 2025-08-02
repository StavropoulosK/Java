package spaceships;

import java.awt.Image;

import javax.swing.ImageIcon;

import mainPacket.MainClass;
import java.awt.Color;


public class SpaceShipGAMA extends SpaceShip {
	
	
	public static Image img;
	
	
	static{
		
		img=get_img("../images/spaceship5.png");
		
		}
	
	
	
	public SpaceShipGAMA() {
		super(Color.green);
		step=30;
		life=15;

		SpaceShipName="GAMA";
		xCoord=0;
		yCoord= MainClass.CosmosHeight-spaceShipHeight-yOffSet;
		SpaceShipImageIcon= new ImageIcon(img);

	}

		
		
	}


