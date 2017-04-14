import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JPanel;

public class GameLoop extends JPanel implements KeyListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L; //K
	
	public GameLoop(){
		

	}

	public void checkForInput(){
		interruptsEnabled = true;
	}
	
	public void handleInput(){
		for(int i = 0; i < KeyQueue.size(); i++){
			switch(KeyQueue.get(i)){
			case KeyEvent.VK_RIGHT:
				sri.moveRight();
				break;
			case KeyEvent.VK_LEFT:
				sri.moveLeft();
				break;
			case KeyEvent.VK_S:
				if(!gravityEnabled) sri.jump();
				break;
			}
		}
		KeyQueue.clear();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(interruptsEnabled){
			interruptsEnabled = false;
			int keyCode = e.getKeyCode();
			switch(keyCode){
			case KeyEvent.VK_RIGHT:
				KeyQueue.add(keyCode);
				break;
			case KeyEvent.VK_LEFT:
				KeyQueue.add(keyCode);
				break;
			case KeyEvent.VK_S:
				KeyQueue.add(keyCode);
				break;
			case KeyEvent.VK_A:
				KeyQueue.add(keyCode);
				break;
			case KeyEvent.VK_ENTER:
				KeyQueue.add(keyCode);
			default:
				return;	
			}
		}
		else{
			return;
		}
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		return;
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		return;
		
	}
	
	private void update() {//impose gravity, move enemies, etc.
		if(gravityEnabled){
			sri.imposeGravity();
		}
		else{
			return;
		}
		
	}


	private void handleCollisions() {
		boolean onAPlatform = false;
		for(int i = 0; i < platformsOnScreen.size(); i++){
			Platform workPlatform = platformsOnScreen.get(i);
			if(sri.getY() + Sriram.HEIGHT >= workPlatform.getY() && sri.getY() <= workPlatform.getY() + workPlatform.HEIGHT
					&& sri.getX() <= workPlatform.getX() + Platform.WIDTH && sri.getX() >= workPlatform.getX()){
				onAPlatform = true;
				gravityEnabled = false;
			}
		}
		if(onAPlatform == false){
			gravityEnabled = true;
		}
	}

	@Override
	public void paintComponent(Graphics g){
		if(g == null){
			super.paintComponent(g);
			this.g = (Graphics2D) g;
			return;
		}
		else{
			g.drawImage(currentBackground, 0, 0, null);
			sri.draw(g);
			drawLevel(g, currentLevel);
		}
	}
	
	public void drawLevel(Graphics g, Level l){
		int[][] spritemap = l.getSpriteMap();
		for(int y = 0; y < spritemap.length; y++){
			for(int x = 0; x < spritemap[y].length; x++){
				int objectX = (camera_right_bound - camera_left_bound) /2 * (x + 1);
				int objectY = (y + 1) * 50;
				switch(spritemap[y][x]){
				case 0:
					break;
				case 1:
					GrassPlatform.draw(g, objectX, objectY);
					platformsOnScreen.add(new GrassPlatform(objectX, objectY));
					break;
				case 2:
					Kamar.draw(g, objectX, objectY);
					enemiesOnScreen.add(new Kamar(objectX, objectY));
				}
			}
		}
	}
	
	/*public void drawPlatform(Platform p){
		p.draw(g, p.getX(), p.getY());
		platformsOnScreen.add(p)
	}*/
	
	
}