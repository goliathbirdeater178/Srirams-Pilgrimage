import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JFrame;

public class Main{
	private static JFrame window;
	private static GameScreen screen;
	
	public enum GameState{
		GAME_OVER, GAME_PAUSED, GAME_PLAYING
	};
	public static final int REFRESH_RATE = 60; //Run at 60 FPS
	
	private static ArrayList<Sprite> spritesOnScreen = new ArrayList<Sprite>();
	
	//private GameState gamestate;
	//private int numLevelsCompleted = 0;
	
	
	
	//private static boolean levelCompleted = false;
	//private static Level currentLevel;
	
	
	//private BufferedImage currentBackground; 
	//private boolean interruptsEnabled;
	//private boolean gravityEnabled = true;; //Turned off when Sri collides with a platform

	private static int camera_x = 0; //Measured in tiles, used for scrolling
	private static int camera_y = 0;
	private static final int CAMERA_WIDTH = 16;
	private static final int CAMERA_HEIGHT = 8;
	private static final int TILE_SIZE = 32;
	
	public static void main(String[] args){
		prepareWindow();
		Resources.loadAllResources();
		gameLoop();
		System.exit(0);
		
	}
	//Draw main game window
	public static void prepareWindow(){
		window = new JFrame("Sriram's Pilgrimage");
		window.setSize(1080,720);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		screen = new GameScreen();
		window.setContentPane(screen);
		window.setVisible(true);
		//GameFrame frame = new GameFrame();
	}
	
	private static void gameLoop(){
		for(int i = 0; i < Resources.NUM_LEVELS; i++){
			BufferedImage currentBackground = Resources.level_backgrounds.get(i);
			screen.changeBackground(currentBackground); 
			scanInfoPlane(Resources.LEVEL_ARRAY[i]); //Update sprite ArrayList with level spr data
			Sriram sri = new Sriram(0,0); //TODO: Implement level origins
			while(true){
				updatePlayer(sri);
				refreshScreen();
				sleep(); //To avoid the try-catch ugliness
			}
			
					//while(true){
					/*if(levelCompleted) break;
					checkForInput();
					handleInput();
					update();
					handleCollisions();

					repaint();*/

		}
	}
	
	private static void scanInfoPlane(int[][] levelMap){ //Scan level, spawn enemies and platforms accordingly
		for(int i = camera_x; i < levelMap[0].length && i < camera_x + CAMERA_WIDTH; i++){
			for(int j = camera_y; j < levelMap.length && j < camera_y + CAMERA_HEIGHT; j++){
				Sprite s = null;
				int x = (i - camera_x) * TILE_SIZE, y = (j - camera_x) * TILE_SIZE;
				//System.out.println(x);
				switch(levelMap[j][i]){
					case 1: s = new Kamar(x, y); break;
					case 2: s = new GrassPlatform(x, y); break;
					default: continue;
				}
				
				//s.init(); 
				spritesOnScreen.add(s); 
			}
		}
	}
	
	private static void refreshScreen(){
		for(Sprite s: spritesOnScreen){
			s.redraw();
		}
		screen.repaint();
	}
	
	private static void updatePlayer(Sriram s){
		for(int key: screen.keyQueue){
			s.controlRoutine(key);
		}
		screen.keyQueue.clear();
		for(Sprite spr: spritesOnScreen){
			spr.run(s);
		}
		s.imposeGravity();
		s.redraw();
	}
	
	private static void sleep(){
		try {
			Thread.sleep(1000/REFRESH_RATE);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
}