import java.awt.Image;
import java.awt.image.BufferedImage;

public abstract class Enemy extends Sprite{
	protected int speed;
	protected int hp;
	public int ENEMY_ID;
	
	protected int x;
	protected int y;
	
	protected static Image image;
	
	public Enemy(int x, int y){
		super(x, y);
	}
	
	public static void setImage(BufferedImage bi){
		image = bi;
	}
	
	public static Image getImage(){
		return image;
	}
	public abstract void run(); //Function to run enemy
	
	
	public int getID(){
		return this.ENEMY_ID;
	}
}
