package co.renegadeeagle.dodgeeagle;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageUtil {

	public static BufferedImage playerImage = null;
	public static BufferedImage background = null;

	public static void loadImages(){
		try {
			playerImage = ImageIO.read(new File("res/George.png"));
			background = ImageIO.read(new File("res/Background.png"));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static BufferedImage rotate(BufferedImage img, int rotation)  {
		int w = img.getWidth();  
		int h = img.getHeight();  
		BufferedImage newImage = new BufferedImage(w, h, img.getType());
		Graphics2D g2 = newImage.createGraphics();
		g2.rotate(Math.toRadians(rotation), w/2, h/2);  
		g2.drawImage(img,null,0,0);
		return newImage;  
	}
}
