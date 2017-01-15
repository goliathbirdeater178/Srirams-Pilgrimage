import javax.swing.JFrame;

public class GameFrame extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public GameFrame(){
		super("Sriram's Pilgrimage");
		setSize(1080,720);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(new GameLoop());
		setVisible(true);
	}
	
}