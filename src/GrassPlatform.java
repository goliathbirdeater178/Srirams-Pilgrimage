public class GrassPlatform extends Platform{
	public GrassPlatform(int x, int y){
		super(Resources.img_Grass, x, y);
	}

	@Override
	protected void act(Sprite target, boolean collision) {
		return;
	}
	
}
