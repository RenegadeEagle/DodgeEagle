package co.renegadeeagle.dodgeeagle;

import java.awt.Graphics;

import javax.swing.JPanel;

public class GamePanel extends JPanel {

	@Override
	public void paint(Graphics g){
		DodgeEagle.paint(g, this.getWidth(), this.getHeight());
	}
}
