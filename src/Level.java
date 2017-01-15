import java.awt.image.BufferedImage;

public class Level{
	private BufferedImage bg;
	private int[][] spritemap;
	public Level(BufferedImage bg, int[][] spritemap){
		this.bg = bg;
		this.spritemap = spritemap;
	}

	public BufferedImage getBackground(){
		return this.bg;
	}

	public int[][] getSpriteMap(){
		return this.spritemap;
	}
}