import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

public abstract class Platform extends Sprite{
	private static Image image;
	public static int HEIGHT = 64;
	public static int WIDTH = 64;
	public Platform(int x, int y){
		super(x, y);
	}
	
	public static void setImage(BufferedImage bi){
		image = bi.getScaledInstance(64, 64, 64);
	}
	
	public static Image getImage(){
		return image;
	}
	
	public int PLATFORM_ID;
	
	public abstract void run();
	
	public static void draw(Graphics g, int x, int y){
		g.drawImage(getImage(), x, y, null);
			
	}
	
	public int getX(){
		return this.x;
	}

	public int getY() {
		return this.y;
	}
	
}
