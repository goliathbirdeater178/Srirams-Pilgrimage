public class BoundingBox {
	private int x, y; //position of bounding box upper left
	private int x_ext, y_ext;
	
	public BoundingBox(Sprite s){
		this.x = s.x; //AABB will be slightly thinner than sprite, for collision detection fairness
		this.y = s.y;
		y_ext = s.getHeight();
		x_ext = s.getWidth();
	}
	
	public void moveTo(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public boolean overlapsWith(BoundingBox b){
		return checkVOverlap(b) && checkHOverlap(b);
	}
	
	public boolean checkVOverlap(BoundingBox b){
		return (((this.y >= b.y) && (this.y < b.y + b.y_ext)) ||
				((this.y + this.y_ext >= b.y) && (this.y + this.y_ext < b.y + b.y_ext)));
	}
	
	public boolean checkHOverlap(BoundingBox b){
		return (((this.x >= b.x) && (this.x < b.x + b.x_ext)) ||
				((this.x + this.x_ext >= b.x) && (this.x + this.x_ext < b.x + b.x_ext)));
	}

	@Override
	public String toString(){
		String s = "Bounding box x: " + x + ", y: " + getY() + ", x_ext: " + x_ext + ", y_ext: " + y_ext;
		return s;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
}
