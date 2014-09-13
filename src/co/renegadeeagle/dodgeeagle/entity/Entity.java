package co.renegadeeagle.dodgeeagle.entity;

import java.awt.Image;
import java.awt.Point;

public interface Entity {

	boolean isAlive();
	
	void setAlive(boolean set);
	
	EntityType getEntityType();

	Point getPoint();
	
	void setPoint(int x, int y);
	Image getImage();
}
