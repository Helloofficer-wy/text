package shootgame;

import javax.imageio.*;
import java.util.Random;
import javax.swing.*;

/*
 * 奖励类
 */
public class Bee extends FlyingObject implements Gift{
	private int xspeed = 1;
	private int yspeed = 2;	
	private int gift;
	public Bee(){
		image = Shootgame.bee;
		width = image.getWidth(null);
		height = image.getHeight(null);
		Random ran = new Random();
//		System.out.println(Shootgame.w_width-width);
		x=ran.nextInt(Shootgame.w_width-width);
		y = height;
		gift = ran.nextInt(2);
	}
	public void move(){
		if(x >= Shootgame.w_width-width){
			x -= xspeed;
		}else{
			x += xspeed;
		}
		y += yspeed;
	}
	
	public int gifttohero(){
		return gift; //GIFT 只有0 或者 1 0的时候双倍火力，1的时候 加一条命.
	}
	
	public int socretohero(){//这个给littlefly用的。
		return 0;
	}
}
