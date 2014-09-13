package co.renegadeeagle.dodgeeagle;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFrame;

import co.renegadeeagle.dodgeeagle.entity.Player;

public class DodgeEagle {

	private static JFrame frame = new JFrame();

	private final static int WIDTH = 800;

	private final static int HEIGHT = 500;

	private final static String VERSION = "v.1.0 ALPHA";

	private static boolean running = false;

	public static GamePanel panel = new GamePanel();

	private static Logger logger = Logger.getLogger(DodgeEagle.class.getName());
	
	private static Player player = new Player(400, 360);
	
	public static Set<Integer> pressedKeys = new HashSet<Integer>();
	
	public final static int GROUND = 360;

	/**
	 * Calls the main methods to setup the frame and other important jazz.
	 */
	public static void init(){
		frame.setSize(WIDTH, HEIGHT);
		frame.setTitle("Dodge Eagle "+VERSION);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.add(panel);
		ImageUtil.loadImages();
	}

	private static Thread gameThread;
	public static void beginHeartbeat(){
		running = true;
		gameThread = new Thread(new Runnable(){
			@Override
			public void run() {
				while(running){
					tick();
					System.out.println("Player Y: "+ player.getY()+" Groud:"+ DodgeEagle.GROUND);

					try{
						Thread.sleep(28);
					}catch(Exception e){
						logger.log(Level.SEVERE, "An error has occured! Report this to RenegadeEagle.co/bugs");
						e.printStackTrace();
					}
				}
			}
		});
		gameThread.run();
	}
	public static void tick(){
		panel.repaint();
		player.tick();
		for(int i: pressedKeys){
			player.move(i);
			
		}
	}
	
	public static void main(String[] args){
		init();
		frame.addKeyListener(new KeyListener(){
			@Override
			public void keyPressed(KeyEvent arg0) {
				pressedKeys.add(arg0.getKeyCode());
				System.out.println(arg0.getKeyCode());
			}
			@Override
			public void keyReleased(KeyEvent arg0) {
				pressedKeys.remove(arg0.getKeyCode());

			}

			@Override
			public void keyTyped(KeyEvent arg0) {				
			
			}
			
		});
		frame.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent arg0) {
				
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		beginHeartbeat();

	}
	/**
	 * Global variable to repaint entire screen with values
	 * @param g
	 * @param width
	 * @param height
	 */
	public static void paint(Graphics g, int width, int height){
		g.setColor(Color.RED);
		g.fillRect(0, 0, width, height);
		g.drawImage(ImageUtil.background, 0, 0, panel);
		g.drawImage(player.getImage(), player.getX(), player.getY(), panel);
	}
}
