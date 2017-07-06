package shootgame;

import java.util.Random;

public class Littlefly extends FlyingObject implements Gift{
	Random rand = new Random();
	private int speed = 2;//√ø¥Œ“∆∂Øæ‡¿Î°£
	Littlefly(){
		image = Shootgame.littlefly;
		width = image.getWidth(null);
		height= image.getHeight(null);
		x     = rand.nextInt(Shootgame.w_width-width+1);
		y     = -height;
		
	}
	public void move(){
		y += speed;
	}
	
	public int gifttohero(){	
		return 0;
	}
	public int socretohero(){
		
		
		return scorce;
	}
}
