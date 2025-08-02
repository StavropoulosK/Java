package gui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;


import javax.swing.SwingConstants;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FinishScreen extends JPanel implements KeyListener{
	
		static JLabel screenLabel=new JLabel();
		static JLabel messageLabel=new JLabel();
		
		public  FinishScreen() {
			
			screenLabel.setLayout(new BorderLayout());
			messageLabel.setFont(new Font("Arcade Classic", Font.PLAIN, 40));
			messageLabel.setForeground(Color.white);
			messageLabel.setBackground(Color.black);
			messageLabel.setHorizontalAlignment(SwingConstants.CENTER); // set the horizontal alignement on the x axis 
			messageLabel.setVerticalAlignment(SwingConstants.CENTER); // set the vertical alignement on the y axis
			
			screenLabel.add(messageLabel, BorderLayout.CENTER);
			this.add(screenLabel);
			
			
			this.addKeyListener(this); 

			 
		}

		public void  updateFinsihScreen( BufferedImage image, String text) {
		
			screenLabel.setIcon(new ImageIcon(image));
			messageLabel.setText(text);
			
		}
			
		
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_ENTER)	{
			
			SpaceFrame.cardLayout.next(SpaceFrame.spaceFramePanel);
			SpaceFrame.spaceFramePanel.requestFocusInWindow();
		}
								
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}

