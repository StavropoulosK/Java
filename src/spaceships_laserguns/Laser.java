package spaceships_laserguns;

import spaceships.SpaceShip;

public class Laser {

		public int x;
		public int y;
		
		
		Laser(int x, int y){
			this.x= x+ SpaceShip.spaceShipWidth/2 ;
			this.y=y;
		}
}
