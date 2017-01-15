public class BoundingBox {
	// position should be RELATIVE to the bottom corner of the object being bounded
	// or else, animation will become a nightmare

	int x;
	int y;
	int height;
	int width;

	public BoundingBox(int x, int y, int height, int width) {
		this.x = x;
		this.y = y;
		this.height = height;
		this.width = width;
	}

	public BoundingBox[] quadtree() {
		BoundingBox[] arr = new BoundingBox[4];
		arr[0] = new BoundingBox(x, y, height/2, width/2);
		arr[1] = new BoundingBox(x, y + height/2, height/2, width/2);
		arr[2] = new BoundingBox(x + height/2, y, height/2, width/2);
		arr[3] = new BoundingBox(x + height/2, y, height/2, width/2);


		return arr;
	}

}
