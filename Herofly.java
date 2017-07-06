package shootgame;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

public class Herofly extends FlyingObject implements KeyListener{
	public int life_hero=3;
	public int double_fire = 0;
	public int x_start;
	public BufferedImage[] images ;
//	BufferedImage[] image_hero = new BufferedImage[2];
	private Image[] image_hero2 = new Image[2];
	private int index;
	
	Herofly(){
		image = Shootgame.herofly;
		width = image.getWidth(null);
		height= image.getHeight(null);
		x     = (Shootgame.w_width -width)/2;
		y     =  2*(Shootgame.w_height)/3;
	 life_hero=3;
  double_fire = 0;
       images = new BufferedImage[]{Shootgame.herofly,Shootgame.bee};
	}
	public void move(){
		int num = index++/10%images.length;
			image = images[num]; 
	}

	@Override
	public void keyPressed(KeyEvent e){
		switch(e.getKeyCode()){
		case KeyEvent.VK_UP:
			System.out.println("VK_UP");
			y -=2;
//			this.repaint();
			break;
		case KeyEvent.VK_DOWN:
			System.out.println("VK_DOWN");
			y += 2;
//			this.repaint();
			break;
		case KeyEvent.VK_LEFT:
			System.out.println("VK_LEFT");
			x -= 2;
			
			break;
		case KeyEvent.VK_RIGHT:
			System.out.println("VK_RIGHT");
			x +=2;
			
			break;
		}
	}
	@Override
	public void keyTyped(KeyEvent e){
		
	}
	@Override
	public void keyReleased(KeyEvent e){

	}
}
