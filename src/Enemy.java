import java.awt.Image;
import java.awt.image.BufferedImage;

public abstract class Enemy extends Sprite{
	protected int speed;
	protected int hp;
	
	public Enemy(Image img, int x, int y, int speed, int hp){
		super(img.getScaledInstance(64, 64, 0), x, y);
		this.speed = speed;
		this.hp = hp;
	}
	
	public Enemy(Image img, int x, int y){
		this(img, x, y, 0, 0);
	}
	
	protected abstract void run(int target_x, int target_y);
}