import java.awt.Image;

public abstract class Platform extends Sprite{
	public Platform(Image img, int x, int y){
		super(img, x, y);
	}
	
	public void run(Sprite target){
		if(target.collisionDetected){
			act(target, false);
		}
		else if(target.aabb.overlapsWith(this.aabb)){
			System.out.println("Platform AABB: " + this.aabb);
			System.out.println("Target AABB: " + target.aabb);
			target.collisionDetected = true;
			target.stopVMovement();
			act(target, true);
		}
		else{
			target.unstop();
			act(target, false);
		}
	}
	
	protected abstract void act(Sprite target, boolean collision);
}
