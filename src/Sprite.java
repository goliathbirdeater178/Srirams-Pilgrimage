import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

//Owner: Drooph Cansh Balani
public class Sprite {
	int x = 0;
	int y = 0;
	// measured from the top left corner not the center
	int x_extension = 0;
	int y_extension = 0;
	
	int weight;
	
	static Image image; //Image that represents sprite on screen

	ArrayList<BoundingBox> boxes = new ArrayList<>();

	public Sprite(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public Sprite(int a, int b, int width, int height) {
		this.x = a;
		this.y = b;
		this.x_extension = width;
		this.y_extension = height;
	}

	public void move(int dx, int dy) {
		this.x += dx;
		this.y += dy;
	}

	public void scale(int mx, int my) {
		this.x *= mx;
		this.y *= my;
	}

	// set it if it's already known
	public void setBoundingBoxesToKnown(ArrayList<BoundingBox> boxArray) {
		this.boxes = boxArray;
	}
	

	// but to get it, we need to know it
	public ArrayList<BoundingBox> getBoundingBoxes() {
		return this.boxes;
	}

	/*  NOTE: THE ADVANTAGE OF THIS METHOD IS THAT YOU ONLY HAVE TO RUN IT ONCE
            AND CAN SELECT BOUNDING BOXES THAT ARE ONLY ON THE EDGE OF TRANSPARENCY
            OR NOT. YOU HAVE TO SCAN EVERY PIXEL, BUT THIS IS ONLY ONCE PER SPRITE
            THAT IS USED. */
	public void createBoundingBoxes() {
		ArrayList<BoundingBox> boxes = new ArrayList<>();
		// add a new box, encompassing the entire rectangle of the sprite, to the object
		// (that needs to be implemented, wil find syntax)
		// scan the pixels

		int TREE_DEPTH = 6;

		/*for (int p = 0; p < TREE_DEPTH; p++) {
			for (int i:boxes ) { 
				boolean opaque = false;
				boolean transparent = false;

				for (/* a:pixelsSurroundedByBoundingBox ) {
					if /*( pixel is transparent ) {
						transparent = true;
					}
					if /*( pixel is opaque  ) {
						opaque = true;
					}
				}

				if (!(transparent && opaque)) {
					// if the array is monotone, then this piece is simply
					// tossed out. remember, edge detection (boundary of transparent and opaque) is the key.
					i = null;
				}

				if (transparent == true && opaque == true) {
					// don't want any sub pixel elements! those are worthless.
					if (((double)(i.height - i.y)/2) < 1. || ((double)(i.width - i.x)/2) < 1.) {
						break;
					}
					BoundingBox[] n = i.quadtree();
					for (item:n) {
						// append each item to this.boxes
					}

					i = null;
				}
			}
		}*/
	}





}