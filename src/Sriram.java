import java.awt.event.KeyEvent;

public class Sriram extends Sprite{
	private final static int WALKING_SPEED = 6; //Moves 6 pixels when walking
	//private final int DASHING_SPEED = 12;
	
	public Sriram(int x, int y){
		super(Resources.img_Sri, x, y, WALKING_SPEED, 0);
	}
	
	public void controlRoutine(int key){
		switch(key){
		case KeyEvent.VK_RIGHT:
			moveRight(); break;
		case KeyEvent.VK_LEFT:
			moveLeft(); break;
		}
	}

	@Override
	protected void run(Sprite target) { return; }
	
	
	
}
