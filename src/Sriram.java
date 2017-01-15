import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;

public class Sriram extends Sprite{
	private final int WALKING_SPEED = 6; //Moves 6 pixels when walking
	//private final int DASHING_SPEED = 12;
	
	private static int x_pos = 0;
	private static int y_pos = 0;
	
	public static final int HEIGHT = 64;
	public static final int WIDTH = 64;
	
	private final int DIR_LEFT = 0;
	private final int DIR_RIGHT = 1;
	private int facing_dir = DIR_RIGHT; //0 = left, 1 = right
	private static Image image;
	
	private BoundingBox AABB;
	
	public Sriram(){
		super(x_pos, y_pos, 32, 32);
	}
	
	public static void setImage(BufferedImage bi){
		image = bi.getScaledInstance(HEIGHT, WIDTH, 64);
	}
	
	public static Image getImage(){
		return image;
	}
	
	public void moveLeft(){
		if(facing_dir != DIR_LEFT){
			facing_dir = DIR_LEFT;
		}
		x_pos -= WALKING_SPEED;
		if(x_pos <= 0){
			x_pos = 0;
		}
		
	}
	
	public void moveRight(){
		if(facing_dir != DIR_RIGHT){
			facing_dir = DIR_RIGHT;
		}
		x_pos += WALKING_SPEED;
	}
	
	public int getX(){
		return Sriram.x_pos;
	}
	
	public int getY(){
		return Sriram.y_pos;
	}
	
	public void draw(Graphics g){
		g.drawImage(getImage(), this.getX(), this.getY(), null);
	}

	public void imposeGravity() {
		y_pos += 5;
	}
	
	public void jump(){
		y_pos -= 100;
	}
	
}
