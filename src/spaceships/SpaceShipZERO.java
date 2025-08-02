package spaceships;

import java.awt.Image;

import javax.swing.ImageIcon;
import java.awt.Color;
import mainPacket.MainClass;

public class SpaceShipZERO extends SpaceShip {
	
	
	public static Image img;
	
	static{
	
	img=get_img("../images/spaceship6.png");
	
	}
	
	
	public SpaceShipZERO() {
		super(Color.white);
		step=5;
		life=28;

		SpaceShipName="ZERO";
		xCoord=0;
		yCoord= MainClass.CosmosHeight-spaceShipHeight-yOffSet;
		SpaceShipImageIcon= new ImageIcon(img);

	}
	
	
	}



