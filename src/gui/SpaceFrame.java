package gui;

import javax.swing.*;
import java.awt.*;
import spaceships.Navigation;
import sounds.*;
import java.net.URL;

public class SpaceFrame extends JFrame {

	static GameAudioPlayer audioPlayer= new GameAudioPlayer("../audio/space_music.wav",1);
	static SelectSpaceShipScreen selectSpaceShipScreen=new SelectSpaceShipScreen();
	static GamePlayScreen gamePlayScreen= new GamePlayScreen();
	static CardLayout cardLayout= new CardLayout();
	static JPanel spaceFramePanel= new JPanel();
	static FinishScreen finishScreen= new FinishScreen();		

	
	
	public SpaceFrame(int width, int height) {
		
		this.setSize(width,height+Navigation.yOffSet);
		this.setTitle("Space Shooter");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setFocusable(true);
		this.setupMasterPanel();
		this.setResizable(false);
		this.setVisible(true);

		
		
	}
	
	void setupMasterPanel() {
		spaceFramePanel.setLayout(cardLayout);
		spaceFramePanel.add(selectSpaceShipScreen);
		spaceFramePanel.add(gamePlayScreen);
		spaceFramePanel.add(finishScreen);

		this.add(spaceFramePanel);
	}
	
	
	
	

}
