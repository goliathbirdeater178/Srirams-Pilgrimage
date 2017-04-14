import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class Resources{
	
	public static int NUM_LEVELS = 1; //TODO: Increment when add more levels
	//public ArrayList<Level> levelArray = new ArrayList<Level>(); 
	
	
	//TILEMAPS
	public static final int[][] LEVEL1MAP = {
		{0,0,0,0,0,0},
		{0,0,0,0,0,0},
		{0,0,0,0,0,0},
		{0,0,0,0,0,0},
		{0,0,0,0,0,0},
		{0,0,0,0,0,0},
		{2,0,0,0,0,0},
		{0,2,0,0,0,0},
		{0,0,2,0,0,0},
		{0,0,0,0,0,0},
		{0,0,0,0,0,0},
		{0,0,0,0,0,0},
		{0,0,0,0,0,0},
		{0,0,0,0,0,0},
		{0,0,0,0,0,0}
	};

	public static void loadAllResources(){
		
		try {
			img_Sri = loadImage("./res/sri walk.png").getScaledInstance(64, 64, 0);
			img_Background1 = loadImage("./res/Level-1-Background.png");
			img_Kamar = loadImage("./res/cummer1.png");
			img_Grass = loadImage("./res/Grass_Platform.png");
			
		} 
		catch (IOException e) {
			System.out.println("Could not load one or more resources. Please reinstall.");
			e.printStackTrace();
		}
		
		level_backgrounds.add(img_Background1);
		
	}


	//public static BufferedImage[] backgroundsArray;

	//public static BufferedImage[] sprites = {};


	

	public static BufferedImage loadImage(String path) throws IOException{
		try{
			File image = new File(path);
			BufferedImage bi = ImageIO.read(image);
			return bi;
		}
		catch(Exception ex){
			ex.printStackTrace();
			throw new IOException();
		}
	}

	public static Image img_Sri;
	private static BufferedImage img_Background1;
	public static BufferedImage img_Kamar;
	public static BufferedImage img_Grass;
	
	public static final int[][][] LEVEL_ARRAY = {LEVEL1MAP}; //Level sprite data
	
	public static ArrayList<BufferedImage> level_backgrounds = new ArrayList<BufferedImage>();

}