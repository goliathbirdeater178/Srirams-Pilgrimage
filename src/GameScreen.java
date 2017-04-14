import java.awt.Graphics;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JPanel;

/**
 * class GameScreen: Handles drawing, screen routines, etc
 * @author chandan
 *
 */
@SuppressWarnings("serial")
public class GameScreen extends JPanel implements KeyListener, ComponentListener{
	private BufferedImage background;
	private static ArrayList<Sprite> spriteArray = new ArrayList<Sprite>();
	public ArrayList<Integer> keyQueue = new ArrayList<Integer>();
	
	public GameScreen(){
		this.setFocusable(true);
		this.addKeyListener(this);
		this.addComponentListener(this);
	}
	
	@Override
	public void paintComponent(Graphics g){
		g.drawImage(background, 0, 0, null);
		for(int i = 0; i < spriteArray.size(); i++){
			Sprite s = spriteArray.get(i);
			g.drawImage(s.getImage(), s.x, s.y, null);
			if(s != null)spriteArray.remove(i);
		}
	}
	public static void addToDrawQueue(Sprite e) {
		spriteArray.add(e);
	}
	
	public void changeBackground(BufferedImage bi){ //TODO: background scrolling
		this.background = bi;
	}

	//Key handling methods
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		keyQueue.add(e.getKeyCode());
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	public void componentResized(){
		
	}
	
	@Override
	public void componentHidden(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void componentMoved(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void componentResized(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void componentShown(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}
}
