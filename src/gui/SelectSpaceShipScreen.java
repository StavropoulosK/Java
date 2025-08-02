package gui;

import javax.swing.*;

import sounds.GameAudioPlayer;

import java.awt.event.*;
import java.awt.*;
import spaceships.*;


class SpaceShipSelectionHandler implements ActionListener{
	
	String buttonName;
	
	SpaceShipSelectionHandler(String buttonName){
		this.buttonName=buttonName;
	}
	
	public void actionPerformed(ActionEvent ev) {
		GameAudioPlayer audioPlayer= new GameAudioPlayer("../audio/spaceship_selection.wav",0);

		SpaceFrame.cardLayout.next(SpaceFrame.spaceFramePanel);
		SpaceFrame.gamePlayScreen.setFocusable(true);
		SpaceFrame.gamePlayScreen.requestFocus();

		
		if(buttonName.equalsIgnoreCase("bZERO")) SpaceFrame.gamePlayScreen.initializeGame(new SpaceShipZERO());
		if(buttonName.equalsIgnoreCase("bALPHA")) SpaceFrame.gamePlayScreen.initializeGame(new SpaceShipALPHA());
		if(buttonName.equalsIgnoreCase("bBETA")) SpaceFrame.gamePlayScreen.initializeGame(new SpaceShipBETA());
		if(buttonName.equalsIgnoreCase("bGAMA")) SpaceFrame.gamePlayScreen.initializeGame(new SpaceShipGAMA());
		if(buttonName.equalsIgnoreCase("bDELTA")) SpaceFrame.gamePlayScreen.initializeGame(new SpaceShipDELTA());

			
		
	}
	
}
public class SelectSpaceShipScreen extends JPanel {
	

	public SelectSpaceShipScreen(){
	
		this.setLayout(new BorderLayout());
	
		
		this.add(CreateNorthPanel(), BorderLayout.NORTH);
		this.add(CreateCenterPanel(), BorderLayout.CENTER);

	

		
	}
		
		private JPanel CreateNorthPanel() {
			
			JPanel panel = new JPanel();
			
			panel.setPreferredSize(new Dimension(100,150));
			
			JLabel label= new JLabel("Please Chose your SpaceShip");
			label.setFont(new Font("Arcade Classic", Font.PLAIN, 25));
			label.setForeground(Color.white);
			
			panel.setBackground(Color.black);
			panel.add(label);
			
			return panel;
		
	}
		
		private JPanel CreateCenterPanel() {
			
			JButton btnSpaceShipZero= new JButton(new ImageIcon(SpaceShipZERO.img));
			JButton btnSpaceShipAlpha= new JButton(new ImageIcon(SpaceShipALPHA.img));
			JButton btnSpaceShipBeta= new JButton(new ImageIcon(SpaceShipBETA.img));
			JButton btnSpaceShipGama= new JButton(new ImageIcon(SpaceShipGAMA.img));
			JButton btnSpaceShipDelta= new JButton(new ImageIcon(SpaceShipDELTA.img));
			
			makeBtnsTransparrent(btnSpaceShipZero);
			makeBtnsTransparrent(btnSpaceShipAlpha);
			makeBtnsTransparrent(btnSpaceShipBeta);
			makeBtnsTransparrent(btnSpaceShipGama);
			makeBtnsTransparrent(btnSpaceShipDelta);
			
			btnSpaceShipZero.addActionListener(new SpaceShipSelectionHandler("bZero"));
			btnSpaceShipAlpha.addActionListener(new SpaceShipSelectionHandler("bAlpha"));
			btnSpaceShipBeta.addActionListener(new SpaceShipSelectionHandler("bBeta"));
			btnSpaceShipGama.addActionListener(new SpaceShipSelectionHandler("bGama"));
			btnSpaceShipDelta.addActionListener(new SpaceShipSelectionHandler("bDelta"));


			JPanel panel = new JPanel();
			panel.setLayout(new GridLayout(1,5,10,10));
			panel.setBackground(Color.black);
			
			panel.add(btnSpaceShipZero);
			panel.add(btnSpaceShipAlpha);
			panel.add(btnSpaceShipBeta);
			panel.add(btnSpaceShipGama);
			panel.add(btnSpaceShipDelta);
			

			
			return panel;
		}
		
	
	private void makeBtnsTransparrent(JButton button) {
		button.setOpaque(false);
		button.setContentAreaFilled(false);
		button.setBorderPainted(false);
	}
	
	

}




