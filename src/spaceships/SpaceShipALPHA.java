package spaceships;
import java.awt.*;


import javax.swing.ImageIcon;
import java.awt.Color;


import mainPacket.*;


public class SpaceShipALPHA extends SpaceShip  {
	
	public static Image img;
	
	static{
	
		img= get_img("../images/spaceship4.png");
}
	
	
	public SpaceShipALPHA() {
		super(Color.cyan);
		step=10;
		life=25;
		SpaceShipName="ALPHA";
		xCoord=0;
		yCoord= MainClass.CosmosHeight-spaceShipHeight-yOffSet;	
		SpaceShipImageIcon= new ImageIcon(img);

		
	}


	
}
	

