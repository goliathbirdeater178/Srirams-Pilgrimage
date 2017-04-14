import java.awt.Image;
import java.util.ArrayList;

//Owner: Drooph Cansh Balani
public abstract class Sprite {
	protected int x, y;
	
	protected int vx, vy; //Velocities for both axes
	
	protected BoundingBox aabb;
	
	int weight; //TODO: Add weight functionality
	
	private Image image; //Image that represents sprite on screen
	
	private int width, height;
	
	private boolean stopped = false;
	public boolean collisionDetected = false;
	
	private static final int GRAVITY_ACCEL = 1; //Aceleration due to gravity = 5 pixels/frame^2

	ArrayList<BoundingBox> boxes = new ArrayList<>();
	
	public Sprite(Image img, int x, int y, int vx, int vy){
		this.x = x;
		this.y = y;
		this.image = img;
		this.width = img.getWidth(null);
		this.height = img.getHeight(null);
		this.aabb = new BoundingBox(this);
		this.vx = vx; this.vy = vy;
	}

	public Sprite(Image img, int x, int y) {
		this(img, x, y, 0, 0);
	}

	public void moveLeft(){
		this.x -= vx;
		aabb.moveTo(this.x, this.y);
		collisionDetected = false;
	}
	public void moveRight() { 
		//TODO: Add slope functionality
		this.x += vx;
		aabb.moveTo(this.x, this.y);
		collisionDetected = false;
	}
	
	public void moveVertically(){
		this.y += vy;
		aabb.moveTo(this.x, this.y);
	}
	
	public void imposeGravity(){ //TODO: Acceleration for dashing
		if(stopped) return;  
		moveVertically();
		this.vy += GRAVITY_ACCEL;
	}

	public void scale(int mx, int my) {
		this.x *= mx;
		this.y *= my;
	}
	
	public int getHeight(){
		return this.height;
	}
	
	public int getWidth(){
		return this.width;
	}

	public void stopVMovement(){
		stopped = true;
	}
	
	public void unstop(){
		stopped = false;
	}
	
	public void redraw(){
		GameScreen.addToDrawQueue(this);
	}

	public Image getImage() {
		return this.image;
	}
	
	protected abstract void run(Sprite target); //Used by enemies and platforms
	
	//protected abstract void run();
	//protected abstract void init();
	
}
