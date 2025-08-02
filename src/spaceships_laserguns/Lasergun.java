package spaceships_laserguns;

import java.awt.Color;

import java.util.*;


public class Lasergun {

		public Color laserColor;
		public LinkedList<Laser> laserlinkedlist= new LinkedList<>();
		
		public Lasergun(Color laserColor) {
			this.laserColor= laserColor;
		}
		
		public void fire( int x, int y) {
			laserlinkedlist.add(new Laser(x,y));
		}
		
		
	
}
