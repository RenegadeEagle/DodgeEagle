package co.renegadeeagle.dodgeeagle.entity;

import java.awt.Image;
import java.awt.Point;

import co.renegadeeagle.dodgeeagle.DodgeEagle;
import co.renegadeeagle.dodgeeagle.ImageUtil;

public class Player implements Entity {

	private int x;
	private int y;
	private boolean jumping = false;

	private static int jumpPower = 20;

	private boolean alive = true;
	public Player(int x, int y){
		this.x = x;
		this.y = y;
	}

	public boolean isAlive() {
		return alive;
	}

	public void setAlive(boolean set) {
		this.alive = set;
	}

	public EntityType getEntityType() {
		return EntityType.PLAYER;
	}

	@Override
	public Point getPoint() {
		return new Point(x, y);
	}

	@Override
	public void setPoint(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public Image getImage() {
		return ImageUtil.playerImage;
	}

	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}

	/**
	 * @param x the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}

	/**
	 * @param y the y to set
	 */
	public void setY(int y) {
		this.y = y;
	}
	public boolean isSafeX(int x){
		if(x > 0 && x <= DodgeEagle.panel.getWidth()-this.getImage().getWidth(null)){
			return true;
		}
		return false;
	}
	
	public void jump(){
		System.out.println("Player Y: "+ y+" Groud:"+ DodgeEagle.GROUND);
		if(!jumping){
			jumping = true;
			jumpPower = 20;
			
		}	

	}
	
	public void move(int key){
		switch(key){
		case 39:
			if(isSafeX(this.x+6)){
				this.x+=6;
			}
			break;
		case 37:
			if(isSafeX(this.x-6)){
				this.x-=6;
				break;
			}
		case 38:
			if(y >= DodgeEagle.GROUND){
				this.jump();
			}
			break;
		}
	}

	public void tick(){
		if(jumping){
			if(jumpPower <= 0){
				jumping = false;
			}else{
				jumpPower--;
				y-=5;
			}
		}else{
			if(y <= DodgeEagle.GROUND){
				y+=5;
				
			}
		}
	}
	/**
	 * @return the jumping
	 */
	public boolean isJumping() {
		return jumping;
	}

	/**
	 * @param jumping the jumping to set
	 */
	public void setJumping(boolean jumping) {
		this.jumping = jumping;
	}

}