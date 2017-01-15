import java.awt.Graphics;

public class Kamar extends Enemy{

	public Kamar(int x, int y) {
		super(x, y);
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		this.x--;
	}

	public static void draw(Graphics g, int objectX, int objectY) {
		g.drawImage(getImage(), objectX, objectY, null);
		
	}

}
