package sounds;

import javax.sound.sampled.*;

import mainPacket.*;



public class GameAudioPlayer {
	
	private AudioInputStream audioInputStream;
	
	Clip clip;
	
	public GameAudioPlayer(String relative_path,int sound) {
			loadSpaceAmbient(relative_path,sound);
	}
	
	void loadSpaceAmbient(String relative_path,int sound) {
			
		try {
			audioInputStream= AudioSystem.getAudioInputStream(MainClass.class.getResource(relative_path));
			clip= AudioSystem.getClip();
			clip.open(audioInputStream);
			
			if(sound==1) {
			clip.loop(Clip.LOOP_CONTINUOUSLY);
			}
			else{
				clip.loop(0);
			}
			
			FloatControl gainControl= (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
			gainControl.setValue(-15);

			clip.start();
		}
		
		catch(Exception ex) {
			System.out.println(ex);
		}
	}

}
